package br.com.cwi.reset.exemploreset;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.reset.exemploreset.domain.Mensagem;
import br.com.cwi.reset.exemploreset.service.MensagemService;

@RequestMapping("/chat")
@RestController
public class ChatController {

    @Autowired
    private MensagemService mensagemService;

    @GetMapping
    public List<Mensagem> getMensagens(){
        return mensagemService.obterMensagens();
    }

    @PostMapping
    public Mensagem criarMensagem(@RequestBody Mensagem mensagem){
        return mensagemService.criarMensagem(mensagem);
    }

}
