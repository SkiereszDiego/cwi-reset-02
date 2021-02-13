package exercicio.um;

public class Ator extends Pessoa {
    private Integer numeroOscars;


    public Ator(String nome, Integer idade, Integer numeroOscars, Genero genero) {
        super(nome, idade, genero);
        this.numeroOscars = numeroOscars;

    }

}
