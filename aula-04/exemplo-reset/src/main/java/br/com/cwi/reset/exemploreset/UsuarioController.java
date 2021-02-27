package br.com.cwi.reset.exemploreset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nome")
public class UsuarioController {

    @Autowired
    private HelloWorldController helloWorldController;

    private static String nome = "Robson";

    @GetMapping
    public String getNome(){
        return nome;
    }

    @PutMapping("/{nome}")
    public String putNome(@PathVariable("nome") String novoNome){
        this.nome = novoNome;
        return this.nome;
    }

    @DeleteMapping
    public void deleteNome(){
        this.nome = null;
    }
}
