public class Apartamento extends Imovel{

    private int andar;

    public Apartamento(Endereco endereco, double valor, int andar) {
        super(endereco, valor);
        this.andar = andar;
    }

    @Override
    public String apresentacao() {
        return ("Imóvel do tipo APARTAMENTO no "+this.andar+" andar, localizado no endereço: "+
                this.getEndereco().enderecoCompleto()+" \nValor: "+this.getValor());
    }
}