public class Main {
    public static void main(String[] args) {
       int idade = 35;
       // Se for uma integral muito grande use 'long'
       long salarioGiseleBundchen = 5000000;
       double altura = 1.88;
       String meunome = "Diego";

        double a = 0.7;
        a += 0.1;
        System.out.println(a);

        System.out.println("Meu nome: " + meunome);
        System.out.println("Minha idade: " + idade + " anos");
        System.out.println("Minha altura: " + altura + " metros");


        int idadeDoMeuCachorro = 4;
        System.out.println("Idade do meu cachorro em 2020: " + idadeDoMeuCachorro + " anos");

        idadeDoMeuCachorro++;
        System.out.println("Idade do meu cachorro em 2021: " + idadeDoMeuCachorro + " anos");


        //Exercicio 01

        int multiplicar = (3 * 6);
        System.out.println("Exercicio01: 3 multiplicado por 6 é igual a " + multiplicar);

        //Exercicio 02
        int resto = 0;
        resto = (6 % 3);

        System.out.println("Exercicio02: O resto da divisão de 3 por 6 é " + resto);

        //Exercicio 03
        int b = 6;
        int c = 3;

        System.out.println("Exercicio03:" + b + " é maior que " + c + "? " + (b > c));




    }
}
