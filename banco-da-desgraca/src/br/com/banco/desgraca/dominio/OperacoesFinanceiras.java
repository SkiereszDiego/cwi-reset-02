package br.com.banco.desgraca.dominio;

import br.com.banco.desgraca.dominio.conta.ContaBancaria;
import br.com.banco.desgraca.dominio.enumerador.TaxasTransacoes;
import br.com.banco.desgraca.dominio.enumerador.TipoTransacao;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;
import br.com.banco.desgraca.exception.ValorInvalidoException;

import java.text.DecimalFormat;

public class OperacoesFinanceiras {
    private static final TaxasTransacoes CONTA_CORRENTE = TaxasTransacoes.CC;
    private static final TaxasTransacoes CONTA_POUPANCA = TaxasTransacoes.CP;
    private static final TaxasTransacoes CONTA_DIGITAL = TaxasTransacoes.CD;

    private static final TipoTransacao SAQUE = TipoTransacao.SAQUE;
    private static final TipoTransacao DEPOSITO = TipoTransacao.DEPOSITO;
    private static final TipoTransacao TRANFERENCIA = TipoTransacao.TRANFERENCIA;

    public static Double depositarNaConta(Double valor, ContaBancaria contaOrigem){
        mensagemOperacao(DEPOSITO, valor, contaOrigem);
        return valor;
    }

    public static Double sacarDinheiro(Double valor, TaxasTransacoes tipoDeConta, ContaBancaria contaOrigem){
        if ((valor * (1 + tipoDeConta.getTaxaSaque())) > contaOrigem.consultarSaldo()){
            throw new SaldoInsuficienteException("Saldo Insuficiente.");
        }
        if(regrasDeSaque(tipoDeConta, valor)){
            throw new ValorInvalidoException(valorInvalidoMensagem(tipoDeConta));
        }
        mensagemOperacao(TipoTransacao.SAQUE, valor, contaOrigem);
        return (valor * (1 + tipoDeConta.getTaxaSaque()));
    }

    private static boolean regrasDeSaque(TaxasTransacoes tipoDeConta, Double valor){
        if (tipoDeConta == TaxasTransacoes.CC){
            return (valor % 5 == 0);
        } else if (tipoDeConta == TaxasTransacoes.CD){
            return (valor >= 10.0);
        } else if (tipoDeConta == TaxasTransacoes.CP) {
            return (valor >= 50.0);
        } else {
            return false;
        }
    }

    private static String valorInvalidoMensagem(TaxasTransacoes tipoDeConta){
        if(tipoDeConta == TaxasTransacoes.CC){
            return String.format("\nO valor Solicitado é inválido!\n" +
                    "Notas disponíveis: \nR$ 5,00 - R$ 10,00 - R$ 20,00 - R$ 50,00 - R$ 100,00 - R$ 200,00\n");
        } else if (tipoDeConta == TaxasTransacoes.CD) {
            return String.format("\nO menor valor disponível para saque é de R$ 10,00\n");
        } else if (tipoDeConta == TaxasTransacoes.CP) {
            return String.format("\nO menor valor disponível para saque é de R$ 50,00\n");
        } else {
            return String.format("\nValor Inválido!!!\n");
        }
    }

    public static Double transferenciaEntreContas(TaxasTransacoes tipoDeConta, Double valor,
                                                  ContaBancaria contaOrigem, ContaBancaria contaDestino) {

        if(contaOrigem.getInstituicaoBancaria() != contaDestino.getInstituicaoBancaria()){
            if((valor * (1 + tipoDeConta.getTaxaTranferenciaOutrasInstituicoes())) > contaOrigem.consultarSaldo()){
                throw new SaldoInsuficienteException("Você não Possui Saldo para Saque!!");
            }
            mensagemOperacao(TipoTransacao.TRANFERENCIA, valor, contaOrigem, contaDestino);
            contaDestino.depositar(valor);
            return (valor * (1 + tipoDeConta.getTaxaTranferenciaOutrasInstituicoes()));
        } else {
            if(valor > contaOrigem.consultarSaldo()){
                throw new SaldoInsuficienteException("Saldo insuficiente!!");
            }
            mensagemOperacao(TipoTransacao.TRANFERENCIA, valor, contaOrigem, contaDestino);
            contaDestino.depositar(valor);
            return valor;
        }
    }

    private static void mensagemOperacao(TipoTransacao tipoTransacao, Double valor, ContaBancaria contaOrigem) {
        if(tipoTransacao == TipoTransacao.DEPOSITO){
            System.out.printf("Depositando valor %s na %s\n",
                    DecimalFormat.getCurrencyInstance().format(valor),
                    contaOrigem.toString());
        } else if (tipoTransacao == TipoTransacao.SAQUE) {
            System.out.printf("Sacando valor %s da %s\n",
                    DecimalFormat.getCurrencyInstance().format(valor),
                    contaOrigem.toString());
        }
    }

    private static void mensagemOperacao(TipoTransacao tipoTransacao, Double valor,
                                         ContaBancaria contaOrigem, ContaBancaria contaDestino) {
        if (tipoTransacao == TipoTransacao.TRANFERENCIA) {
            System.out.printf("Tranferindo valor %s da %s para %s\n",
                    DecimalFormat.getCurrencyInstance().format(valor),
                    contaOrigem.toString(),
                    contaDestino.toString());
        }
    }
}
