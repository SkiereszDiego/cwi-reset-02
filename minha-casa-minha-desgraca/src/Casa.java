public class Casa extends Imovel{

    private boolean patio;

    public Casa(Endereco endereco, double valor, boolean patio) {
        super(endereco, valor);
        this.patio = patio;
    }

    @Override
    public String apresentacao() {

        String possuiPatio = (patio) ? "com":"sem";
        return ("Imóvel do tipo CASA "+possuiPatio+" pátio, "+"Localizada no endereço: "+
                this.getEndereco().enderecoCompleto()+" \nValor: "+this.getValor());
    }
}