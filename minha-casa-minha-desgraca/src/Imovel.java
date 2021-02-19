public abstract class Imovel {
    private Endereco endereco;
    private double valor;

    public Imovel(Endereco endereco, double valor) {
        this.endereco = endereco;
        this.valor = valor;
    }
    public abstract String apresentacao();

    public Endereco getEndereco() {
        return endereco;
    }

    public double getValor() {
        return valor;
    }
}