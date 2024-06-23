// MenuFechado.java
package com.grupoalemao.restaurante.Models;

public class MenuFechado extends Menu {
    private final double precoFixo = 32;

    /**
     * Construtor simples: popula o array de produtos com os produtos selecionados.
     */
    public MenuFechado() {
        produtos = new Produto[6];
        for (int i = 1; i <= 5; i++) {
            gerarProduto(i);
        }
    }

    /**
     * Método que retorna o preço total da categoria Menu Fechado.
     * 
     * @return Um número real que é o preço total do menu.
     */
    public double getPrecoFixo() {
        return precoFixo;
    }

    /**
     * Método para alocar um produto no array de produtos.
     * 
     * @param posicao A posição do array de produtos na qual se quer alocar o
     *                produto.
     */
    @Override
    public void gerarProduto(int posicao) {
        switch (posicao) {
            case 1:
                produtos[posicao] = new FalafelAssado("Falafel Assado", 20);
                break;
            case 2:
                produtos[posicao] = new CacarolaLegumes("Caçarola de Legumes", 22);
                break;
            case 3:
                produtos[posicao] = new CopoDeSuco("Copo de Suco", 7);
                break;
            case 4:
                produtos[posicao] = new RefrigeranteOrganico("Refrigerante Orgânico", 7);
                break;
            case 5:
                produtos[posicao] = new CervejaVegana("Cerveja Vegana", 9);
                break;
        }
    }

    /**
     * Método para exibir os produtos do array de produtos.
     * 
     * @return Os produtos do array de produtos do menu fechado.
     */
    @Override
    public String mostrarMenu() {
        String resultado = super.mostrarMenu();
        return resultado + "Menu Fechado\n --Preço Fixo por pessoa: R$" + getPrecoFixo() + "\n";
    }

    /**
     * Método para verificar se o produto solicitado no pedido fechado é um dos produtos disponíveis
     * para a modalidade Menu Fechado.
     * @param produto Produto escolhido no pedido fechado.
     * @return True se o produto é dos tipos disponíveis, False caso contrário.
     */
    public static boolean contemProdutoNoMenuFechado(Produto produto){
        return ("Falafel Assado".equals(produto.getCategoria()) || 
                "Caçarola de Legumes".equals(produto.getCategoria()) ||
                "Copo de suco".equals(produto.getCategoria()) || 
                "Refrigerante Orgânico".equals(produto.getCategoria()) || 
                "Cerveja Vegana".equals(produto.getCategoria()));
    }
}
