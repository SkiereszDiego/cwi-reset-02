package exercicio.um;


public class Filme {

    private String nome;
    private String descricao;
    private Integer duracao;
    private Integer ano;
    private Integer avaliacao;
    //Filme possui um diretor. A classe filme esta ligada a um diretor
    private Diretor diretor;


    public Filme(String nome, String descricao, Integer duracao, Integer ano, Integer avaliacao, Diretor diretor) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.ano = ano;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }

    public void reproduzir() {
        System.out.println("Filme: " + this.nome + "Duração: " + this.duracao);
        System.out.println("Nome do Diretor: " + this.diretor.getNome());
        System.out.println("Descrição: " + this.descricao);
    }

}


