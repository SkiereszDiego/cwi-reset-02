package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.InstituicaoBancariaException;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;
import br.com.banco.desgraca.exception.SaqueException;
import br.com.banco.desgraca.exception.ValorNegativoException;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ContaDigital implements ContaBancaria{

    private Integer numeroContaDigital;
    private InstituicaoBancaria instituicaoBancaria;
    private Double saldo;
    private static final Double VALOR_MINIMO_SAQUE = 10.0;
    private List<Transacao> transacoes = new ArrayList<>();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    Locale brasil = new Locale( "pt", "BR" );

    public ContaDigital(Integer numeroContaDigital ,InstituicaoBancaria instituicaoBancaria) {
        this.numeroContaDigital = numeroContaDigital;
        verificaInstituicaoBancaria(instituicaoBancaria);
        this.saldo = 0.0;
    }

    private void verificaInstituicaoBancaria(InstituicaoBancaria instituicaoBancaria) {
        if((instituicaoBancaria == InstituicaoBancaria.NUBANK) || (instituicaoBancaria == InstituicaoBancaria.ITAU)){
            this.instituicaoBancaria = instituicaoBancaria;
        }else {
            throw new InstituicaoBancariaException("\n\nSomente as instituições bancárias " + InstituicaoBancaria.NUBANK.getNome() +
                    " e " + InstituicaoBancaria.ITAU.getNome() + " permitem contas digitais.\n");

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
            System.out.println(deposito.exibeInformacoesTransacaoSemData() + " " + toString());
        }
    }

    public void sacar(Double valor) {
        if(valor < 0){
            throw new ValorNegativoException();

        }else if (saldo < valor) {
            throw new SaldoInsuficienteException();

        }else if(valor <= VALOR_MINIMO_SAQUE){
            throw new SaqueException("\n\nO valor mínimo para solicitação de saque é de " +
                    DecimalFormat.getCurrencyInstance(brasil).format(VALOR_MINIMO_SAQUE) + "\n");

        }else{
            Transacao saque = new Transacao(TipoTransacao.SAQUE, valor);
            transacoes.add(saque);
            saldo -= valor;
            System.out.println(saque.exibeInformacoesTransacaoSemData() + " da " + toString());
        }
    }

    public void transferir(Double valor, ContaBancaria contaDestino) {
        if(valor < 0){
            throw new ValorNegativoException();
        }else {
            saldo -= valor;
            Transacao transferencia = new Transacao(TipoTransacao.TRANSFERENCIA, valor);
            transacoes.add(transferencia);
            contaDestino.depositar(valor);
            System.out.println(transferencia.exibeInformacoesTransacaoSemData() + " da " + toString() + " para " + contaDestino.toString());
        }

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
        return "Conta Digital " + this.instituicaoBancaria.getNome() + " " + this.numeroContaDigital;
    }
}
