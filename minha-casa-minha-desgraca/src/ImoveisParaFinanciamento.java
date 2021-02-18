import java.util.ArrayList;
import java.util.List;

public class ImoveisParaFinanciamento {

    private List<Imovel> imoveis;

    public ImoveisParaFinanciamento() {
        imoveis = new ArrayList<>();
    }

    public void registrarImovel(Imovel imovel) {
        if (imovel.getValor() >= 50000 && imovel.getValor() <= 1000000){
            imoveis.add(imovel);
        }else{
            System.out.println("Atenção, problema de registro! Imóveis com valor R$ "+imovel.getValor()+" não são aceitos no programa.");
        }
    }

    public List<Imovel> buscarOpcoes(double valorLimite) {

        List<Imovel> opcoes = new ArrayList<>();

        for (Imovel imovel : imoveis) {

            if(imovel.getValor() <= valorLimite){
                opcoes.add(imovel);
            }
        }

        return opcoes;
    }
}

