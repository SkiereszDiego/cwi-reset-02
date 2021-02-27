package br.com.cwi.reset.exemploreset.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.reset.exemploreset.domain.Usuario;
import br.com.cwi.reset.exemploreset.exception.BadRequestException;
import br.com.cwi.reset.exemploreset.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.listarUsuarios();
    }

    public Usuario criarUsuario(Usuario usuario) {
        if(usuario == null){
            throw new BadRequestException();
        }

        if(usuario.getId() != null){
            throw new BadRequestException();
        }
        return usuarioRepository.salvarUsuario(usuario);
    }

    public void deletarUsuario(final String idDeletar) {
        usuarioRepository.deletarUsuario(idDeletar);
    }
}
