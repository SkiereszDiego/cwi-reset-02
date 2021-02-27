package br.com.banco.desgraca.exception;

public class SaldoInsuficienteException extends RuntimeException{

        public SaldoInsuficienteException() {
        super("\n\nO seu saldo é insuficiente para realizar essa operação.\n");
    }
}
