package exercicio.um;

import java.util.List;

public class Filme {

    private String nome;
    private String descricao;
    private Integer duracao;
    private Integer ano;
    private Integer avaliacao;
    //Filme possui um diretor. A classe filme esta ligada a um diretor
    private Diretor diretor;
    private List<Pessoa> elenco;



    public Filme(String nome, String descricao, Integer duracao, Integer ano, Integer avaliacao, Diretor diretor) {
        defineAvaliacao(avaliacao);
        validaNomeEDefineAvaliacao(nome);
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.ano = ano;
        this.diretor = diretor;
        this.elenco = elenco;

    }

    public void reproduzir() {
        System.out.println("Filme: " + this.nome + " Duração: " + this.duracao + " minutos.");
        System.out.println("Nome do Diretor: " + this.diretor.getNome());
        System.out.println("Descrição: " + this.descricao);
    }

    private void defineAvaliacao(Integer avaliacao){

        if (avaliacao < 1 || avaliacao > 5) {
            this.avaliacao = 3;
        } else {
            this.avaliacao = avaliacao;
        }
    }

    private void validaNomeEDefineAvaliacao(String nome) {
        if ("Batman vs Superman".equals(nome)) {
            this.avaliacao = 1;
        } else if ("Clube da luta".equals(nome)) {
            this.avaliacao = 5;
        }
    }

    public void creditos() {
        System.out.println(("---------------" + this.nome + "---------------" ));
        System.out.println("Elenco: ");
        for (Pessoa pessoa : elenco) {
            pessoa.imprimeDados();
        }
    }

}


