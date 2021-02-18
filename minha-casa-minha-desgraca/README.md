# Projeto MINHA CASA - MINHA DESGRAÇA

Você deve criar o projeto `minha-casa-minha-desgraca`. O projeto terá opções de imóveis para financiamento e avaliará propostas de possíveis beneficiários do programa.

Sua tarefa é ler todo detalhamento abaixo e fazer tudo o que for solicitado, complementando algumas classes já existentes e criando novas classes para que o projeto funcione de forma adequada.


## Classes que precisam ser criadas

Para o projeto funcionar, você deve criar quatro classes/enums:
1. `Beneficiario`: representa a pessoa que está querendo fazer o financiamento. Deve ter um nome e um salário;
2. `UnidadeFederativa`: representa as Unidades Federativas do Brasil. Deve ser representado como um enum;
3. `Endereco`: representa endereços genéricos. Deve ter o logradouro, número, complemento, bairro, cidade e estado _(unidade federativa)_;
4. `Imovel`: representa os imóveis que estarão cadastrados no sistema. Deve ter somente o endereço e valor. Como comportamento, é necessário que o imóvel tenha um método `apresentacao` que retorne uma String com todas as informações do imóvel _(ex.: "Imóvel localizado no endereço X. Valor: R$ Y")_.

Atente-se para a criação dos construtores e dos getters de cada atributo, além da utilização dos tipos apropriados _(Endereco para representar um endereço, Double para representar um valor, etc)_.


## Classes já existentes

`ImoveisParaFinanciamento`: esta classe serve como a "base de dados" de todos os imóveis disponíveis para financiamento. Repare que você precisará implementar a lógica do método "registrarImovel", conforme sua documentação, bem como complementar a lógica do método "buscarOpcoes". **Não é necessário criar nenhum método novo.**

`PropostaFinanciamento`: esta classe representa uma proposta de financiamento que deve ser avaliada. Ela precisará ter um beneficiário, um imóvel e um prazo de pagamento _(expresso em meses)_. Você precisará implementar a lógica do método `validarProposta` conforme sua documentação, atentando para **não modificar** sua assinatura _(ou seja: nada de adicionar argumentos neste método)_. Você também precisará criar dois métodos internos:
* `imprimirPropostaAprovada`: deve exibir todas as informações da proposta _(beneficiário, imóvel, prazo)_ e parabenizar o beneficiário pois a proposta dele foi aceita;
* `imprimirPropostaNegada`: deve exibir todas as informações da proposta (beneficiário, imóvel, prazo) e xingar o beneficiário pois a proposta não foi aceita.

> _Obs.: os dois métodos de impressão não podem ser chamados fora da classe._

`MinhaCasaMinhaDesgraca`: é a classe principal _(que possui o método main)_ e roda o programa. A classe só pode ser modificada entre os comentários. Tudo que está fora dos comentários **não pode ser alterado**.

Lembre-se de rodar a aplicação várias vezes para entenderr como ela funciona e "responder" às perguntas no terminal com diferentes valores. Também é importante que você registre as casas dentro da classe principal, utilizando valores diferentes entre si.


## Desafio

Torne abstrata a classe `Imovel`. Crie duas novas classes que estendem `Imovel`: `Apartamento` e `Casa`.

A classe `Apartamento` precisa ter um atributo `andar` _(auto explicativo)_, enquanto `Casa` precisa ter um atributo `patio` _(para indicar se ela possui patio ou não)_.
Estas duas informações precisam ser exibidas no método de apresentação para facilitar a escolha do beneficiário, bem como a indicação se o imóvel é uma casa ou um apartamento.

Perceba que será necessário modificar o trecho de código onde antes eram instanciados os objetos do tipo `Imovel` _(na classe principal)_. Isso acontece pois agora você precisa instanciar diretamente uma `Casa` ou um `Apartamento`. 