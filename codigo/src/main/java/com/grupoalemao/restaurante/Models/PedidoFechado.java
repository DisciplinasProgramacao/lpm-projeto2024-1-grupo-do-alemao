package com.grupoalemao.restaurante.Models;

/**
 * Classe PedidoFechado responsável por gerenciar pedidos restritos a
 * determinados tipos de produtos.
 */

public class PedidoFechado extends Pedido {

    // #region atributos

    private int quantidadePessoas;
    private int contComida;
    private int contBebida;
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
        contComida = 0;
        contBebida = 0;
    }

    // #endregion

    /**
     * Método para adicionar um produto na lista produtos da superclasse Pedido,
     * lança
     * exceções caso os requisitos não sejam obedecidos.
     * 
     * @param produto representa o produto a ser adicionado.
     */
    @Override
    public void addProduto(Produto produto) throws IllegalArgumentException {
        if (!verificaProduto(produto)) {
            throw new IllegalArgumentException("Produto não permitido neste tipo de pedido.");
        }

        if (contComida > quantidadePessoas) {
            throw new IllegalArgumentException("Cada pessoa pode escolher apenas uma comida.");
        }

        if (contBebida >= 2 * quantidadePessoas) {
            throw new IllegalArgumentException("Cada pessoa pode escolher apenas duas bebidas ");
        }

        if (produto.isComida()) {
            contComida++;
        } else {
            contBebida++;
        }

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
        return MenuFechado.contemProdutoNoMenuFechado(produto);
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
