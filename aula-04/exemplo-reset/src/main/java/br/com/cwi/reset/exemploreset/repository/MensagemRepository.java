package br.com.cwi.reset.exemploreset.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.reset.exemploreset.domain.Mensagem;

@Repository
public class MensagemRepository {

    static List<Mensagem> mensagens = new ArrayList<>();

    public List<Mensagem> getMensagens(){
        return mensagens;
    }

    public Mensagem addMensagem(Mensagem mensagem){
        mensagens.add(mensagem);
        return mensagem;
    }
}
