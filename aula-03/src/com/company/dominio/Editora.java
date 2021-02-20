package com.company.dominio;

import com.company.exceptions.EditoraException;

public class Editora {
    private String nome;
    private String localizacao;

    public Editora(final String nome, final String localizacao) {
        validarNome(nome);
        this.nome = nome;
        this.localizacao = localizacao;
    }

    private void validarNome(String nome) {
        if (nome.equals("DC Comics")) {
            throw new EditoraException("Só Mulher Maravilha não salva os filmes da DC Comics.");
        }
}

public String getNome() {
    return ;
}