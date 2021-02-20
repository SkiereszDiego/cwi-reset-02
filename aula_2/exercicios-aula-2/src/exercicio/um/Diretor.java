package exercicio.um;

public class Diretor extends Pessoa {
    private Integer filmesDirigidos;



    public Diretor(String nome, Integer idade, Integer filmesDirigidos, Genero genero) {
        super(nome, idade, genero);
        this.filmesDirigidos = filmesDirigidos;

    }

    public void imprimeDados() {
        super.imprimeDados();
        System.out.println("Quantidade de filmes dirigidos: " + this.filmesDirigidos);
    }


}
