package exercicio.um;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private Genero genero;

    public Pessoa(String nome, LocalDate dataNascimento, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }

    public String getNome() {
        return this.nome;
    }

    public void imprimeDados() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + Period.between(this.dataNascimento, LocalDate.now()).getYears());
        System.out.println("Genero: " + this.genero.getDescricao());
    }
}
