public class Apartamento extends Imovel{

    private int andar;

    public Apartamento(Endereco endereco, double valor, int andar) {
        super(endereco, valor);
        this.andar = andar;
    }

    @Override
    public String apresentacao() {
        return "Imóvel do tipo apartameto no "+this.andar+" andar, localizado no endereço: "+
                " \nValor: "+this.getValor();
    }
}