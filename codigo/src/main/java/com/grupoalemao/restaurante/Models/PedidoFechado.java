package com.grupoalemao.restaurante.Models;

/**
 * Classe PedidoFechado responsável por gerenciar pedidos restritos a
 * determinados tipos de produtos.
 */

public class PedidoFechado extends Pedido {

    // #region atributos

    private int quantidadePessoas;
    private static final double VALOR_POR_PESSOA = 32.0;

    // #endregion

    // #region métodos

    // #region Construtor

    /**
     * Contrutor da Classe PedidoFechado.
     * 
     * @param quantidadePessoas representa a quantidade de pessoas de um pedido.
     */
    public PedidoFechado(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    // #endregion

    /**
     * Método para adicionar um produto na lista produtos da superclasse Pedido, lança
     * exceções caso os requisitos não sejam obedecidos.
     * 
     * @param produto representa o produto a ser adicionado.
     */
    @Override
    public void addProduto(Produto produto) throws IllegalArgumentException {
        if (!verificaProduto(produto)) {
            throw new IllegalArgumentException("Produto não permitido neste tipo de pedido.");
        }

        // long countComida = getProdutos().stream()
        //         .filter(p -> p instanceof FalafelAssado || p instanceof CacarolaLegumes)
        //         .count();

        // long countBebida = getProdutos().stream()
        //         .filter(p -> p instanceof CopoDeSuco || p instanceof RefrigeranteOrganico || p instanceof CervejaVegana)
        //         .count();

        if (countComida > quantidadePessoas) {
            throw new IllegalArgumentException("Cada pessoa pode escolher apenas uma comida.");
        }

        if (countBebida >= 2 * quantidadePessoas) {
            throw new IllegalArgumentException("Cada pessoa pode escolher apenas duas bebidas ");
        }
        //antes de adicionar, aumentar contador comida ou contador bebida
        if(produto.ehComida()) countComida++
        else countBebida++;

        super.addProduto(produto);
    }

    /**
     * Método para verificar se o produto é uma instância das classes permitidas.
     * 
     * @param produto produto a ser verificado.
     * @return true, caso o produto seja uma instância das classes permitidas,
     *         false, caso não.
     */
    public boolean verificaProduto(Produto produto) {
        if(MenuFechado.contem(produto))
         //adicionar 
            ;
        else
            //recusar
                return false;
    }

    /**
     * Método para fechar o pedido com o seu valor.
     * 
     * @param pessoas quantidade de pessoas do pedido.
     */
    @Override
    public double[] fecharPedido(int pessoas) throws IllegalArgumentException {
        if (pessoas != quantidadePessoas) {
            throw new IllegalArgumentException("O número de pessoas não corresponde ao especificado no pedido.");
        }

        double totalSemTaxa = VALOR_POR_PESSOA * quantidadePessoas;
        double totalComTaxa = totalSemTaxa + 0.10 * totalSemTaxa;

        double valorPorPessoa = totalComTaxa / quantidadePessoas;

        return new double[] { totalComTaxa, valorPorPessoa };
    }

    // #endregion
}
