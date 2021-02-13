package exercicio.um;

public class Diretor {

    private String nome;
    private Integer idade;
    private Integer filmesDirigidos;


    public Diretor(String nome, Integer idade, Integer filmesDirigidos) {
        this.nome = nome;
        this.idade = idade;
        this.filmesDirigidos = filmesDirigidos;
    }
    Diretor(String nome) {
        this.nome = nome;
    }

    public String getDiretor() {
        return nome;
    }
}
