package com.grupoalemao.restaurante.Models;

/**
 * Classe Menu, responsável por armazenar e exibir os produtos do cardápio do restaurante.
 */
public class Menu {
     
    // #region atributos

    protected Produto[] produtos;

    // #endregion
    
    // #region métodos

    // #region Construtor

    /**
     * Construtor simples: popula o array de produtos.
     */
    public Menu() {
        produtos = new Produto[12];
        for(int i=1; i<=11;i++)
            gerarProduto(i);

            
    }

    // #endregion

    /**
     * Método para recuperar um produto de determinada posição do array de produtos.
     * @param pos 
     * @return Produto, caso tenha sido encontrado, null, caso não.
     */
    public Produto getProduto(int pos){
        if(pos>=1 && pos<produtos.length)
            return produtos[pos];
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
        for(int i = 1; i < produtos.length; i++) {
            if(produtos[i] != null) {
                resultado += i + "-" + produtos[i].getNome() + "\n";
            }    
       }
       return resultado;
    }
    // #endregion
}
