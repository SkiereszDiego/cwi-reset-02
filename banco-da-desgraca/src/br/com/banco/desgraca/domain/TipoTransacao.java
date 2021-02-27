package br.com.banco.desgraca.domain;

public enum TipoTransacao {

    SAQUE("Saque", '-'),
    TRANSFERENCIA("Transferência", '-'),
    DEPOSITO("Depósito", '+');

    private String nome;
    private char simbolo;

    TipoTransacao(String nome, char simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public String getNome() {
        return nome;
    }

    public char getSimbolo() {
        return simbolo;
    }
}
