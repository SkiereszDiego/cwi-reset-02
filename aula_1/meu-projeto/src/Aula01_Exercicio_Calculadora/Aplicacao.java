package Aula01_Exercicio_Calculadora;

public class Aplicacao {
    public static void main(String[] args) {
            Calculadora calculadora = new Calculadora();
            int resultadoSomar = calculadora.somar(1, 2);
            int resultadoSubtrair = calculadora.subtrair(4, 3);
            int resultadoMultiplicar = calculadora.multiplicar(5, 2);
            int resultadoDividir = calculadora.dividir(6, 2);

            System.out.println(resultadoSomar);
            System.out.println(resultadoSubtrair);
            System.out.println(resultadoMultiplicar);
            System.out.println(resultadoDividir);
        }
}
