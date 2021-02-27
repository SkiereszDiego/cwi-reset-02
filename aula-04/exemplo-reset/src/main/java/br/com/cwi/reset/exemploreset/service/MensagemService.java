package br.com.cwi.reset.exemploreset.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.reset.exemploreset.domain.Mensagem;
import br.com.cwi.reset.exemploreset.exception.BadRequestException;
import br.com.cwi.reset.exemploreset.repository.MensagemRepository;

@Service
public class MensagemService {

    @Autowired
    private MensagemRepository repository;

    public List<Mensagem> obterMensagens(){
        return repository.getMensagens();
    }

    public Mensagem criarMensagem(Mensagem mensagem){
        if(mensagem == null || mensagem.getEscritor() == null || mensagem.getMensagem() == null){
            throw new BadRequestException();
        }
        return repository.addMensagem(mensagem);
    }

}
