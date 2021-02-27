package br.com.cwi.reset.exemploreset;

import org.springframework.web.bind.annotation.*;

@RestController
public class NomeController {

    private static String nome = "nome";

    @GetMapping("/nome")
    public String getNome(){
        return nome;
    }

    @PutMapping("/nome/{novoNome}")
    public String mudarNome(@PathVariable String novoNome){
        this.nome = novoNome;
        return this.nome;
    }

    @DeleteMapping("/nome")
    public void apagarNome(){
        this.nome = null;
    }

}
