package com.grupoalemao.restaurante.models;

import java.util.ArrayList;
import java.util.List;

/**
 * A classe Pedido representa um pedido de produtos.
 */
public class Pedido {
    private List<Produto> pedido;

    /**
     * Construtor da classe Pedido.
     * Inicializa a lista de produtos do pedido.
     */
    public Pedido() {
        this.pedido = new ArrayList<Produto>();
    }

    /**
     * Adiciona um produto ao pedido.
     * 
     * @param produto O produto a ser adicionado ao pedido.
     */
    public void addProduto(Produto produto) {
        this.pedido.add(produto);
    }

    /**
     * Remove um produto do pedido.
     * 
     * @param produto O produto a ser removido do pedido.
     */
    public void removerProduto(Produto produto) {
        this.pedido.remove(produto);
    }

    /**
     * Obtém o pedido completo.
     * 
     * @return A lista de produtos no pedido.
     */
    public List<Produto> getPedido() {
        return this.pedido;
    }

    /**
     * Fecha o pedido, incluindo uma taxa de serviço de 10%.
     * 
     * @param pessoas O número de pessoas para dividir o valor total.
     * @return Um array contendo o valor total do pedido e o valor a ser dividido
     *         igualmente entre os ocupantes.
     */
    public double[] fecharPedido(int pessoas) {
        double totalSemTaxa = 0.0;
        for (Produto produto : this.pedido) {
            totalSemTaxa += produto.getPreco();
        }

        double taxaServico = totalSemTaxa * 0.10;
        double totalComTaxa = totalSemTaxa + taxaServico;

        double valorPorPessoa = totalComTaxa / pessoas;

        totalComTaxa = Math.round(totalComTaxa * 100.0) / 100.0;
        valorPorPessoa = Math.round(valorPorPessoa * 100.0) / 100.0;

        return new double[] { totalComTaxa, valorPorPessoa };
    }
}