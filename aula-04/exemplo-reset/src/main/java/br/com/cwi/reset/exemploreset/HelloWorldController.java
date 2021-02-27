package br.com.cwi.reset.exemploreset;

import javax.xml.ws.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.RepositoryType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private static String mensagem = "Hello World";

    @GetMapping("/hello-world")
    public String helloWorld(){
        return mensagem;
    }

    @PutMapping("/hello-world/{novaMensagem}")
    public String mudarMensagem(@PathVariable String novaMensagem){
        this.mensagem = novaMensagem;
        return this.mensagem;
    }

}
