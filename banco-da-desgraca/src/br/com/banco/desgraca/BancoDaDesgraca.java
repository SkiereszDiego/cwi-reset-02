package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.conta.ContaCorrente;
import br.com.banco.desgraca.domain.conta.ContaDigital;
import br.com.banco.desgraca.domain.conta.ContaPoupanca;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Locale;

public class BancoDaDesgraca {

    public static void main(String[] args) throws Exception {

        Locale brasil = new Locale( "pt", "BR" );
        /*
        ContaCorrente contaCorrenteBradesco = new ContaCorrente(7777, InstituicaoBancaria.BRADESCO);

        ContaPoupanca conta = new ContaPoupanca(123, contaCorrenteBradesco);

        ContaPoupanca conta2 = new ContaPoupanca(456,444, InstituicaoBancaria.BANCO_DO_BRASIL);

        ContaCorrente contaCorrenteItau = new ContaCorrente(555, InstituicaoBancaria.ITAU);
        ContaDigital contaDigitalItau = new ContaDigital(556, contaCorrenteItau);

        //ContaDigital testeBradesco = new ContaDigital(149, contaCorrenteBradesco);


        conta.depositar(100.00);
        conta.sacar(50.00);
        conta.depositar(1000.00);
        conta.transferir(250.00, conta2);
        conta.transferir(500.00, contaCorrenteBradesco);
        contaCorrenteBradesco.sacar(50.00);
        contaCorrenteBradesco.transferir(400.00, contaDigitalItau);
        contaDigitalItau.transferir(100.00, conta2);

        LocalDate data1 = null; //LocalDate.of(2020, 7, 1);
        LocalDate data2 = LocalDate.of(2020, 9, 7);

        conta.exibirExtrato(data1, data2);
        conta2.exibirExtrato(data1, data2);
        contaCorrenteBradesco.exibirExtrato(data1, data2);
        contaCorrenteItau.exibirExtrato(data1,data2);
        contaDigitalItau.exibirExtrato(data1,data2);

        System.out.println(DecimalFormat.getCurrencyInstance(brasil).format(conta.consultarSaldo()));

         */

    }

}
