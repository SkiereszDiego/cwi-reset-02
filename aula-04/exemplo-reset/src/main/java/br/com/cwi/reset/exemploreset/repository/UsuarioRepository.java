package br.com.cwi.reset.exemploreset.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.cwi.reset.exemploreset.domain.Usuario;
import br.com.cwi.reset.exemploreset.exception.NotFoundException;

@Repository
public class UsuarioRepository {

    private static List<Usuario> usuarios = new ArrayList<>();
    private static Long nextId = 1l;

    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    public Usuario salvarUsuario(final Usuario usuario) {
        usuario.setId(String.valueOf(nextId));
        nextId++;
        usuarios.add(usuario);
        return usuario;
    }

    public void deletarUsuario(final String idDeletar) {
        Usuario deletar = null;

        for(Usuario usuario : usuarios){
            if(usuario.getId().equals(idDeletar)){
                deletar = usuario;
            }
        }

        if(deletar == null){
            throw new NotFoundException();
        }

        usuarios.remove(deletar);
    }
}
