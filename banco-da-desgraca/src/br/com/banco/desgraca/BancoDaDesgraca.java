package br.com.banco.desgraca;

import br.com.banco.desgraca.dominio.enumerador.InstituicaoBancaria;
import br.com.banco.desgraca.dominio.conta.ContaBancaria;
import br.com.banco.desgraca.dominio.conta.ContaCorrente;
import br.com.banco.desgraca.dominio.conta.ContaDigital;
import br.com.banco.desgraca.dominio.conta.ContaPoupanca;

import java.time.LocalDate;

public class BancoDaDesgraca {

    public static void main(String[] args)  {

        LocalDate incio = LocalDate.of(2020, 5, 10);
        LocalDate fim = LocalDate.of(2020, 5, 17);

        ContaBancaria teste1 = new ContaDigital(102, InstituicaoBancaria.BRADESCO);
        ContaBancaria teste2 = new ContaCorrente(304, InstituicaoBancaria.NUBANK);
        ContaBancaria teste3 = new ContaPoupanca(506, InstituicaoBancaria.BANCO_DO_BRASIL);
        ContaBancaria teste4 = new ContaPoupanca(708, InstituicaoBancaria.CAIXA);
        ContaBancaria teste5 = new ContaDigital(910, InstituicaoBancaria.ITAU);

        teste1.depositar(400.0);
        teste2.depositar(150.0);
        teste3.depositar(200.0);
        teste4.depositar(400.0);
        teste5.depositar(300.0);
        teste1.sacar(50.0);
        teste2.sacar(100.0);
        teste3.sacar(30.0);
        teste4.sacar(55.0);
        teste5.sacar(20.0);

        teste3.transferir(80.0, teste1);

        teste2.transferir(30.0, teste2);

        teste1.transferir(40.0, teste3);


        System.out.println("teste1 " + teste1.consultarSaldo());
        System.out.println("teste2 " + teste2.consultarSaldo());
        System.out.println("teste3 " + teste3.consultarSaldo());
        System.out.println("teste4 " + teste3.consultarSaldo());
        System.out.println("teste5 " + teste3.consultarSaldo());

    }

}
