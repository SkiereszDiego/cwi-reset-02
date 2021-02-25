package br.com.banco.desgraca.dominio.enumerador;

public enum TipoTransacao {

    SAQUE("-"),
    DEPOSITO("+"),
    TRANFERENCIA("-");

    private String charReferencia;

    TipoTransacao(String charReferencia) {
        this.charReferencia = charReferencia;
    }

    public String getCharReferencia() {
        return charReferencia;
    }
}
