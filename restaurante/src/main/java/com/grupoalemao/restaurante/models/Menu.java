package com.grupoalemao.restaurante.models;

/**
 * Classe Menu, responsável por armazenar e exibir os produtos do cardápio do restaurante.
 */
public class Menu {
     
    // #region atributos

    private Produto[] produtos = new Produto[12];

    // #endregion
    
    // #region métodos

    // #region Construtor

    /**
     * Construtor simples: popula o array de produtos.
     */
    public Menu(){
        for(int i=1; i<=11;i++)
            gerarProduto(i);
    }

    // #endregion

    /**
     * Método para recuperar um produto de determinada posição do array de produtos.
     * @param pos A posição da qual se quer obter o produto.
     * @return Produto, caso tenha sido encontrado, null, caso não.
     */
    public String getProduto(int pos){
        if(pos>=1 && pos<produtos.length)
            return produtos[pos].getNome();
        else
            return null;
    }

   /**
    * Método para alocar um produto no array de produtos.
    * @param posicao A posição do array de produtos na qual se quer alocar o produto.
    */
    public void gerarProduto(int posicao) {
            switch (posicao) {
                case 1:
                    produtos[posicao] = new MoquecaDePalmito("Moqueca de Palmito", 32);
                    break;
                case 2:
                    produtos[posicao] = new FalafelAssado("Falafel Assado", 20);
                    break;
                case 3:
                    produtos[posicao] = new SaladaMacarrao("Salada Primavera com Macarrão Konjac", 25);
                    break;
                case 4:
                    produtos[posicao] = new EscondidinhoInhame("Escondidinho de Inhame", 18);
                    break;
                case 5:
                    produtos[posicao] = new StrogonoffeCogumelos("Strogonoffe de Cogumelos", 35);
                    break;
                case 6:
                    produtos[posicao] = new CacarolaLegumes("Caçarola de Legumes", 22);
                    break;
                case 7:
                    produtos[posicao] = new Agua("água", 3);
                    break;
                case 8:
                    produtos[posicao] = new CopoDeSuco("Copo de Suco", 7);
                    break;
                case 9:
                    produtos[posicao] = new RefrigeranteOrganico("Refrigerante Orgânico", 7);
                    break;
                case 10:
                    produtos[posicao] = new CervejaVegana("Cerveja Vegana", 9);
                    break;
                case 11:
                    produtos[posicao] = new VinhoVegano("Taça de vinho vegano", 18);
                    break;
            }
    }

    /**
     * Método para exibir os produtos do array de produtos.
     * @return Os produtos do array de produtos.
     */
    public String mostrarMenu() {
       String resultado = " ";
        for(int i = 0; i < produtos.length; i++) {
            if(produtos[i] != null) {
                resultado += i + "-" + produtos[i].getNome() + "\n";
            }    
       }
       return resultado;
    }
    // #endregion
}
