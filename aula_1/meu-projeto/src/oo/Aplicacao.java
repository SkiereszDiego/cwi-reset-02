
package oo;

public class Aplicacao {

    public static void main(String[] args) {

        Carro carroVeio = new Carro("Chevrolet", "Chevette", 1990, 4);
        carroVeio.estacionar();
        carroVeio.abastecer( 40);

        System.out.println("O veículo está estacionado ? " + carroVeio.isEstacionado());

        carroVeio.acelerar(30);

        System.out.println("O veículo está estacionado ? " + carroVeio.isEstacionado());
        System.out.println("O veiculo ficou com " + carroVeio.getQuantidadeCombustivel() + " litros de combustível");

        Calculadora calculadora = new Calculadora();
        int resultadoSoma1 = calculadora.soma(1, 2);
        int resultadoSoma2 = calculadora.subtrai(4, 3);
        int resultadoSoma3 = calculadora.soma(5, 2);
        System.out.println(resultadoSoma1);
        System.out.println(resultadoSoma2);
        System.out.println(resultadoSoma3);


    }

}
