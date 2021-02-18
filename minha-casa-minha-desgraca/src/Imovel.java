public abstract class Imovel {
    private Endereco endereco;
    private double valor;

    public Imovel(Endereco endereco, double valor) {
        this.endereco = endereco;
        this.valor = valor;
    }
    public String apresentacao(){

        return ("Localizado(a) no endereço: "+endereco.getLogradouro()+", Nº: "
                +endereco.getNumero()+", Compl.: "
                +endereco.getComplemento()+", Bairro: "
                +endereco.getBairro()+", Cidade: "
                +endereco.getCidade()+", UF: "
                +endereco.getEstado().getDescricao()+".\nValor: R$ " +getValor() +".");
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public double getValor() {
        return valor;
    }
}