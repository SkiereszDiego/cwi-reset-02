package br.com.cwi.reset.exemploreset.domain;

public class Mensagem {

    private String escritor;
    private String mensagem;

    public Mensagem(String escritor, String mensagem){
        this.escritor = escritor;
        this.mensagem = mensagem;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(final String escritor) {
        this.escritor = escritor;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(final String mensagem) {
        this.mensagem = mensagem;
    }
}
