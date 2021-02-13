package exercicio.um;

public class Diretor extends Pessoa {
    private Integer filmesDirigidos;



    public Diretor(String nome, Integer idade, Integer filmesDirigidos, Genero genero) {
        super(nome, idade, genero);
        this.filmesDirigidos = filmesDirigidos;

    }




}
