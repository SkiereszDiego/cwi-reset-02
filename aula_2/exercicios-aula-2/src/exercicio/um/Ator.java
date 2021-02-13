package exercicio.um;

public class Ator {
    private String nome;
    private Integer idade;
    private Integer numeroOscars;
    private Genero genero;

    public Ator(String nome, Integer idade, Integer numeroOscars, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.numeroOscars = numeroOscars;
        this.genero = genero;
    }

    public void imprimeAtor() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Genero: " + this.genero.getDescricao());
    }
}
