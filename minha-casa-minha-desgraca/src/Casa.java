public class Casa extends Imovel{

    private boolean patio;

    public Casa(Endereco endereco, double valor, boolean patio) {
        super(endereco, valor);
        this.patio = patio;
    }

    @Override
    public String apresentacao() {

        String possuiPatio = (patio) ? "com":"sem";
        return ("[CASA] "+possuiPatio+" pátio, "+ super.apresentacao());
    }
}