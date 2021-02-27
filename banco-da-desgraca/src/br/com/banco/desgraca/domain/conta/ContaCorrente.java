package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;
import br.com.banco.desgraca.exception.SaqueException;
import br.com.banco.desgraca.exception.ValorNegativoException;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ContaCorrente implements ContaBancaria{

    private Integer numeroContaCorrente;
    private InstituicaoBancaria instituicaoBancaria;
    private Double saldo;
    private List<Transacao> transacoes = new ArrayList<>();
    private static final Double TAXA_TRANSFERENCIA_OUTRAS_INSTITUICOES = 0.01;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    Locale brasil = new Locale( "pt", "BR" );

    public ContaCorrente(Integer numeroContaCorrente, InstituicaoBancaria instituicaoBancaria) {
        this.numeroContaCorrente = numeroContaCorrente;
        this.instituicaoBancaria = instituicaoBancaria;
        this.saldo = 0.0;
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
            System.out.println(deposito.exibeInformacoesTransacaoSemData() + " " + toString());
        }
    }

    public void sacar(Double valor) {
        if(valor < 0){
            throw new ValorNegativoException();

        }else if(saldo < valor){
            throw new SaldoInsuficienteException();

        }else if(valor%5 != 0){
            throw new SaqueException("\n\nO saque só pode ser feito para valores divisíveis por 5." +
                    "\nOu seja, notas de R$ 5,00, R$ 10,00, R$ 20,00, R$ 50,00, R$ 100,00 e R$ 200,00");

        }else {
            Transacao saque = new Transacao(TipoTransacao.SAQUE, valor);
            transacoes.add(saque);
            saldo -= valor;
            System.out.println(saque.exibeInformacoesTransacaoSemData() + " da " + toString());
        }
    }

    public void transferir(Double valor, ContaBancaria contaDestino) {
        if(valor < 0){
            throw new ValorNegativoException();

        }else if(saldo < valor){
            throw new SaldoInsuficienteException();

        } else if(contaDestino.getInstituicaoBancaria() != this.instituicaoBancaria){
            saldo = saldo - valor*(1 + TAXA_TRANSFERENCIA_OUTRAS_INSTITUICOES);

        } else {
            saldo -= valor;
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
        return "Conta Corrente " + this.instituicaoBancaria.getNome() + " " + this.numeroContaCorrente;
    }
}
