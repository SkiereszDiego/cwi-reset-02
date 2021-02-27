
import org.springframework.stereotype.Repository;
import br.com.cwi.reset.exemploreset.domain.Mensagem;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    static List<Mensagem> mensagens = new ArrayList<>();

    public List<Mensagem> getMensagens(){
        return mensagens;
    }

    public Mensagem addMensagem(Mensagem mensagem){
        mensagens.add(mensagem);
        return mensagem;
    }
}
