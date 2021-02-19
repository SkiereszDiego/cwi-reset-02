public class Endereco {

    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private UnidadeFederativa estado;

    public Endereco(String logradouro, Integer numero, String complemento, String bairro, String cidade,
                    UnidadeFederativa estado) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
    public String enderecoCompleto(){
        return this.logradouro+", "+this.numero+" "+this.complemento+", Bairro "+this.bairro+", "
                +this.cidade+", "+this.estado.getDescricao();
    }

    public UnidadeFederativa getEstado() {
        return estado;
    }
}
