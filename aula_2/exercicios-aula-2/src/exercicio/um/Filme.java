package exercicio.um;

public class Filme {
    private String nome;
    private String descricao;
    private Integer duracao;
    private Integer ano;
    private Integer avaliacao;
    private String diretor;


    public Filme(String nome, String descricao, Integer duracao, Integer ano, Integer avaliacao, String diretor) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.ano = ano;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public String getDiretor() {
        return diretor;
    }
    public void reproduzir() {
        System.out.println("Filme: " + nome + "Duração: " + duracao + "Diretor: " + getDiretor());
        System.out.println("Descrição: " + descricao);
    }

}


