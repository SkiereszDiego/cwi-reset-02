package com.company.domain;

public class Editora {
    private String nome;
    private String localizacao;

    public Editora(String nome, String localizacao) {
        this.nome = nome;
        this.localizacao = localizacao;
        filtroFilmesRuins(nome);
    }

    private void filtroFilmesRuins(String nome) {
        if ("DC Comics".equals(nome)) {
            throw new RuntimeException("Só Mulher Maravilha não salva os filmes da DC Comics.");
        }
}
