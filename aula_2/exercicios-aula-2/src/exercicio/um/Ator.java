package exercicio.um;

public class Ator extends Pessoa {
    private Integer numeroOscars;


    public Ator(String nome, Integer idade, Integer numeroOscars, Genero genero) {
        super(nome, idade, genero);
        this.numeroOscars = numeroOscars;

    }

    public void imprimeDados() {
        super.imprimeDados();
        System.out.println("Quantidade de Oscars Vencidos: " + this.numeroOscars);
    }

}
