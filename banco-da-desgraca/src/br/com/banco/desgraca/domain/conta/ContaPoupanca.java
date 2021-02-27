package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.*;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ContaPoupanca implements ContaBancaria{

    private Integer numeroContaPoupanca;
    private InstituicaoBancaria instituicaoBancaria;
    private Double saldo;
    private List<Transacao> transacoes = new ArrayList<>();
    private static final Double VALOR_MINIMO_SAQUE = 50.0;
    private static final Double TAXA_SAQUE = 0.02;
    private static final Double TAXA_TRANSFERENCIA_MESMA_INSTITUICAO = 0.005;
    private static final Double TAXA_TRANSFERENCIA_OUTRAS_INSTITUICOES = 0.01;


    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    Locale brasil = new Locale( "pt", "BR" );

    public ContaPoupanca(Integer numeroContaPoupanca, InstituicaoBancaria instituicaoBancaria) {
        this.numeroContaPoupanca = numeroContaPoupanca;
        verificaInstituicaoBancaria(instituicaoBancaria);
        this.saldo = 0.0;
    }

    private void verificaInstituicaoBancaria(InstituicaoBancaria instituicaoBancaria) {
        if(instituicaoBancaria == InstituicaoBancaria.NUBANK){
            throw new InstituicaoBancariaException("\n\nA instituição bancária " + InstituicaoBancaria.NUBANK.getNome() +
                    " não permite conta poupança.\n");
        }else{
            this.instituicaoBancaria = instituicaoBancaria;
        }
    }

    public InstituicaoBancaria getInstituicaoBancaria() {
        return instituicaoBancaria;
    }

    public Double consultarSaldo() {
        return saldo;
    }

    public void depositar(Double valor) {
        if(valor < 0){
            throw new ValorNegativoException();

        }else{
            Transacao deposito = new Transacao(TipoTransacao.DEPOSITO, valor);
            transacoes.add(deposito);
            this.saldo += valor;
            System.out.println(deposito.exibeInformacoesTransacaoSemData() + " na " + toString());
        }
    }

    public void sacar(Double valor) {
        if (valor < 0) {
            throw new ValorNegativoException();

        } else if (saldo < valor) {
            throw new SaldoInsuficienteException();

        } else if (valor < VALOR_MINIMO_SAQUE) {
            throw new SaqueException("\n\nO valor mínimo para solicitação de saque é de " +
                    DecimalFormat.getCurrencyInstance(brasil).format(VALOR_MINIMO_SAQUE) + "\n");
        } else {
            Transacao saque = new Transacao(TipoTransacao.SAQUE, valor);
            transacoes.add(saque);
            saldo = saldo - valor * (1 + TAXA_SAQUE); // taxa de 2% para saques
            System.out.println(saque.exibeInformacoesTransacaoSemData() + " da " + toString());
        }
    }

    public void transferir(Double valor, ContaBancaria contaDestino) {
        if(valor < 0){
            throw new ValorNegativoException();

        }else if(saldo < valor){
            throw new SaldoInsuficienteException();

        } else if(contaDestino.getInstituicaoBancaria() == this.instituicaoBancaria){
            saldo = saldo - valor*(1 + TAXA_TRANSFERENCIA_MESMA_INSTITUICAO); //taxa de 0.5% para transferências entre contas da mesma instituição bancária

        } else {
            saldo = saldo - valor*(1 + TAXA_TRANSFERENCIA_OUTRAS_INSTITUICOES); //taxa de 1% para transferências entre contas de instituições diferentes
        }

        Transacao transferencia = new Transacao(TipoTransacao.TRANSFERENCIA, valor);
        transacoes.add(transferencia);
        contaDestino.depositar(valor);
        System.out.println(transferencia.exibeInformacoesTransacaoSemData() + " da " + toString() + " para " + contaDestino.toString());
    }

    public void exibirExtrato(LocalDate inicio, LocalDate fim) {

        System.out.println("----EXTRATO " + toString().toUpperCase());

        for(Transacao transacao : transacoes){
            if((inicio == null && fim == null) ||
                    ((inicio == null || transacao.getDataTransacao().isAfter(inicio)) && fim == null) ||
                    ((inicio == null || transacao.getDataTransacao().isAfter(inicio)) && transacao.getDataTransacao().isBefore(fim))) {

                System.out.printf("%-2s %-15s %-1s\n", transacao.getTipoTransacao().getSimbolo(),
                        DecimalFormat.getCurrencyInstance(brasil).format(transacao.getValorTransacao()),
                        transacao.getDataTransacao().format(formatter));
            }
        }
        System.out.println("----");
    }

    public String toString(){
        return "Conta Poupança " + this.instituicaoBancaria.getNome() + " " + this.numeroContaPoupanca;
    }

}