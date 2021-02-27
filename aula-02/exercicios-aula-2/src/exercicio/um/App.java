package exercicio.um;

public class App {
    public static void main(String[] args) {
        //new chama um construtor de uma classe
        Diretor diretor1 = new Diretor("Lana Wachowski", 30, 20, Genero.FEMININO);
        Diretor diretor2 = new Diretor("Stanley Kubrick", 50, 50, Genero.MASCULINO);

        Filme matrix = new Filme("Matrix","Thomas Anderson," +
                " a computer programmer, is led to fight an underground war" +
                " against powerful computers who have constructed his entire" +
                " reality with a system called the Matrix.",150,1999,5, diretor1);
        Filme theShining = new Filme("The Shining","Jack and his family" +
                " move into an isolated hotel with a violent past. Living in isolation," +
                " Jack begins to lose his sanity, which affects his family members.",150,
                1980,10, diretor2);
        Filme matrix4 = new Filme("Matrix 4","Matrix is an upcoming American" +
                " science fiction action film and the fourth installment in The Matrix franchise.",
                150,1980,5, diretor1);

        Ator pessoa1 = new Ator("Keanu Reaves", 56,2, Genero.MASCULINO);

        matrix.reproduzir();
        matrix4.reproduzir();
        theShining.reproduzir();

        pessoa1.imprimeDados();
        diretor1.imprimeDados();


    }
}
