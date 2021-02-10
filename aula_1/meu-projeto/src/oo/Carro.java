package oo;

public class Carro {

    private String marca;

    private String modelo;

    private int ano;

    private int portas;

    private float quantidadeCombustivel;

    private boolean estacionado;

    private int velocidadeAtual;

    public Carro(String marca, String modelo, int ano, int portas) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.portas = portas;

        System.out.println("Carro de marca " + marca + " de modelo " + modelo + " foi instanciado.");
    }

    void abastecer(float quantidadeCombustivel) {
        this.quantidadeCombustivel = quantidadeCombustivel;
    }

    void acelerar(int velocidadeDesejada) {
        System.out.println("Acelerando veículo até " + velocidadeDesejada);

        this.estacionado = false;
        velocidadeAtual = velocidadeDesejada;
        this.quantidadeCombustivel -= velocidadeDesejada * 0.02;
    }

    public void estacionar() {
        System.out.println("Estacionando o " + modelo);

        this.estacionado = true;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public int getPortas() {
        return portas;
    }

    public boolean isEstacionado() {
        return estacionado;
    }

    public float getQuantidadeCombustivel() {
        return quantidadeCombustivel;
    }
}
