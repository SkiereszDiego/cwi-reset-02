public class PropostaFinanciamento {

    private Beneficiario beneficiario;
    private Imovel imovel;
    private int prazoPagamento;

    public PropostaFinanciamento(Beneficiario beneficiario, Imovel imovel, int prazoPagamento) {
        this.beneficiario = beneficiario;
        this.imovel = imovel;
        this.prazoPagamento = prazoPagamento;
    }

    /**
     * Valida a proposta de financiamento e apresenta o resultado para o cliente.
     *
     * A proposta de financiamento é aceita somente se o salário do beneficiário multiplicado pelo prazo de pagamento
     *   for equivalente a pelo menos 50% do valor do imóvel.
     *
     *   Esta regra possui duas exceções: se o imóvel se localiza no estado SP ou RJ,
     *      o salário multiplicado pelo prazo deve ser equivalente a 65% e 60% do valor imóvel (respectivamente).
     */

    public void validarProposta() {
        if((this.beneficiario.getSalario()*this.prazoPagamento)<(this.imovel.getValor()*0.5)){
            this.imprimirPropostaNegada();
        }else if((this.imovel.getEndereco().getEstado().equals(UnidadeFederativa.SP))
                && ((this.beneficiario.getSalario()*this.prazoPagamento)>=(this.imovel.getValor()*0.65))){
            this.imprimirPropostaAprovada();
        }else if((this.imovel.getEndereco().getEstado().equals(UnidadeFederativa.RJ))
                && ((this.beneficiario.getSalario()*this.prazoPagamento)>=(this.imovel.getValor()*0.6))){
            this.imprimirPropostaAprovada();
        }else{
            this.imprimirPropostaAprovada();
        }
    }

    private void imprimirPropostaAprovada(){
        System.out.println("Nome do beneficiário: "+ beneficiario.getNome());
        System.out.println("Imóvel: " +imovel.apresentacao());
        System.out.println("Prazo: " +prazoPagamento + " meses.");
        System.out.println("--------------STATUS PROPOSTA---------------------");
        System.out.println("Sua proposta foi APROVADA!! Parabéns e boa sorte para pagar essa bagaça!");
    }

    private void imprimirPropostaNegada(){
        System.out.println("Nome do beneficiário: "+ beneficiario.getNome());
        System.out.println("Imóvel: "+imovel.apresentacao());
        System.out.println("Prazo: " + prazoPagamento + " meses.");
        System.out.println("--------------STATUS PROPOSTA---------------------");
        System.out.println("Sua proposta foi NEGADA, não fique triste, pois tua mãe vai adorar passar mais alguns anos" +
                " juntinho de você.");
    }
}
