package exercicio.um;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> elenco = new ArrayList<Pessoa>();

        elenco.add(new Diretor("Lana Wachowski", 30, 20, Genero.FEMININO);
        elenco.add(diretor);
        elenco.add(new Ator("Keanu Reaves", 56,2, Genero.MASCULINO));
        elenco.add(new Ator("Leonardo DiCaprio", 46,1, Genero.MASCULINO));
        elenco.add(new Ator("Julia Roberts", 53,2, Genero.FEMININO));
        Filme matrix4 = new Filme("Matrix 4","Matrix is an upcoming American" +
                " science fiction action film and the fourth installment in The Matrix franchise.",
                150,1980,5, diretor, elenco);
        matrix4.creditos();
    }
}
