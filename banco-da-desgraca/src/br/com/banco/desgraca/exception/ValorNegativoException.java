package br.com.banco.desgraca.exception;

public class ValorNegativoException extends RuntimeException{
    public ValorNegativoException() {
        super("\n\nEssa operação não aceita valores negativos.\n");
    }
}
