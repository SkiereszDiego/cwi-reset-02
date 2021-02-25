package br.com.banco.desgraca.dominio.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.dominio.enumerador.InstituicaoBancaria;
import br.com.banco.desgraca.dominio.enumerador.TipoTransacao;
import br.com.banco.desgraca.dominio.Transacao;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements ContaBancaria {

    private Integer numeroDaConta;
    private InstituicaoBancaria banco;
    private Double saldo;
    private List<Transacao> transacoes;
    private ArrayList<Transacao> extrato = new ArrayList<>();


    public Conta(Integer numeroDaConta, InstituicaoBancaria banco) {
        this.numeroDaConta = numeroDaConta;
        this.banco = banco;
        this.saldo = 0.0;
        transacoes = new ArrayList<>();
    }

    public Conta(Integer numeroDaConta, InstituicaoBancaria banco, Double saldo) {
        this.numeroDaConta = numeroDaConta;
        this.banco = banco;
        this.saldo = saldo;
        transacoes = new ArrayList<>();

    }

    public Integer getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setBanco(InstituicaoBancaria banco) {
        this.banco = banco;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    private List<Transacao> getTransacoes() {
        return transacoes;
    }

    private void registraTransacao(Transacao novaTransacao) {
        this.transacoes.add(novaTransacao);
    }

    @Override
    public Double consultarSaldo() {
        return this.saldo;
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return this.banco;
    }

    @Override
    public void depositar(Double valor) {
        registraTransacao(new Transacao(valor, Data.getDataTransacao(), TipoTransacao.DEPOSITO));
        setSaldo(this.saldo + valor);
    }

    @Override
    public void sacar(Double valor) {
        if (this.saldo >= valor) {
            registraTransacao(new Transacao(valor, Data.getDataTransacao(), TipoTransacao.SAQUE));
            setSaldo(this.saldo - valor);
        } else {
            throw new SaldoInsuficienteException("Saldo Insufuciente");
        }
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        registraTransacao(new Transacao(valor, Data.getDataTransacao(), TipoTransacao.TRANFERENCIA));
        setSaldo(this.saldo - valor);
    }

    private void historicoTransacao(LocalDate inicio, LocalDate fim) {
        if (inicio != null && fim == null) {
            for (Transacao transacao : getTransacoes()) {
                if (transacao.getDataTransacao().isEqual(inicio) || transacao.getDataTransacao().isAfter(inicio)) {
                    System.out.println(transacao);
                }
            }
        } else if (inicio == null && fim != null) {
            for (Transacao transacao : getTransacoes()) {
                if (transacao.getDataTransacao().isEqual(fim) || transacao.getDataTransacao().isBefore(fim)) {
                    System.out.println(transacao);
                }
            }
        } else if (inicio != null && fim != null) {
            for (Transacao transacao : getTransacoes()) {
                if ((transacao.getDataTransacao().isEqual(inicio) || transacao.getDataTransacao().isAfter(inicio)) &&
                        (transacao.getDataTransacao().isEqual(fim) || transacao.getDataTransacao().isBefore(fim))) {
                    System.out.println(transacao);
                }
            }
        } else {
            for (Transacao transacao : getTransacoes()) {
                System.out.println(transacao);
            }
        }
    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {
        if((inicio != null) && (fim != null)){
            for (Transacao transacao : getTransacoes()) {
                if ((transacao.getDataTransacao().isBefore(fim)) &&
                        (transacao.getDataTransacao().isAfter(inicio))) {
                    extrato.add(transacao);
                }
            }
        }else if(inicio != null){
            for (Transacao transacao : getTransacoes()) {
                if (transacao.getDataTransacao().isAfter(inicio)) {
                    extrato.add(transacao);
                }
            }
        }else if(fim != null){
            for (Transacao transacao : getTransacoes()) {
                if (transacao.getDataTransacao().isBefore(fim)) {
                    extrato.add(transacao);
                }
            }
        }
        if (extrato.isEmpty()) {
            System.out.println("Sem lançamentos");
        } else {
            System.out.println("-----"+this.toString()+"\n"+
                    extrato.toString()+"\n" +
                    "Saldo: "+DecimalFormat.getCurrencyInstance().format(this.consultarSaldo())+
                    "\nFim");
        }
    }

}
