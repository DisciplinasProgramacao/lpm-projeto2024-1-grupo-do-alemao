package com.grupoalemao.restaurante.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pedido_id")
    private List<Produto> produtos = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "mesa_id")
    private Mesa mesa;

    /**
     * Construtor da classe Pedido.
     * Inicializa a lista de produtos do pedido.
     */
    public Pedido() {
    }

    /**
     * Obtém o ID do pedido.
     * 
     * @return O ID do pedido.
     */
    public Long getId() {
        return id;
    }

    /**
     * Adiciona um produto ao pedido.
     * 
     * @param produto O produto a ser adicionado ao pedido.
     */
    public void addProduto(Produto produto) {
        this.produtos.add(produto);
    }

    /**
     * Remove um produto do pedido.
     * 
     * @param produto O produto a ser removido do pedido.
     */
    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
    }

    /**
     * Obtém a lista de produtos no pedido.
     * 
     * @return A lista de produtos no pedido.
     */
    public List<Produto> getProdutos() {
        return this.produtos;
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
        for (Produto produto : this.produtos) {
            totalSemTaxa += produto.getPreco();
        }

        double taxaServico = totalSemTaxa * 0.10;
        double totalComTaxa = totalSemTaxa + taxaServico;

        double valorPorPessoa = totalComTaxa / pessoas;

        return new double[] { totalComTaxa, valorPorPessoa };
    }

    public void removerProduto(Integer produtoId) {

        throw new UnsupportedOperationException("Unimplemented method 'removerProduto'");
    }
}