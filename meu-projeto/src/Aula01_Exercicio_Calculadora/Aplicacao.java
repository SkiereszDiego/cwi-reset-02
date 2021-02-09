package Aula01_Exercicio_Calculadora;

import oo.Calculadora;

public class Aplicacao {
    Aula01_Exercicio_Calculadora.Calculadora calculadora = new Calculadora();
    int resultadoSoma1 = calculadora.soma(1, 2);
    int resultadoSoma2 = calculadora.subtrai(4, 3);
    int resultadoSoma3 = calculadora.soma(5, 2);
        System.out.println(resultadoSoma1);
        System.out.println(resultadoSoma2);
        System.out.println(resultadoSoma3);
}
