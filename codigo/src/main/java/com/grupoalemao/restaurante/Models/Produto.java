package com.grupoalemao.restaurante.Models;

/**
 * Esta classe tem a responsabilidade de armazenar os dados relacionados
 * aos produtos ofertados pelo restaurante.
 */
public abstract class Produto {
    private String nome;
    private double preco;
    private boolean ehComida;

    /**
     * Construtor da classe Produto.
     * 
     * @param nome     Representa o nome do produto.
     * @param preco    Representa o preço do produto.
     * @param ehComida Representa o tipo do produto.
     */
    public Produto(String nome, double preco, boolean ehComida) {
        if (nome.length() > 3) {
            this.nome = nome;
        }
        if (preco >= 0) {
            this.preco = preco;
        }
        this.ehComida = ehComida;
    }

    /**
     * Método que retorna o nome do produtos.
     * 
     * @return Uma string que é o nome do produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método que retorna o preço do produto.
     * 
     * @return Um número real que é o preço do produto.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Método que retorna se o produto é comida ou não.
     * 
     * @return True se for comida, false caso contrário.
     */
    public boolean isComida() {
        return ehComida;
    }

    /**
     * Método para identificar o tipo do produto.
     * 
     * @return True se for do tipo falafel, false caso contrário.
     */
    public boolean isFalafelAssado() {
        return false;
    }

    /**
     * Método para identificar o tipo do produto.
     * 
     * @return True se for do tipo caçarola de legumes, false caso contrário.
     */
    public boolean isCacarolaLegumes() {
        return false;
    }

    /**
     * Método para identificar o tipo do produto.
     * 
     * @return True se for do tipo copo de suco, false caso contrário.
     */
    public boolean isCopoDeSuco() {
        return false;
    }

    /**
     * Método para identificar o tipo do produto.
     * 
     * @return True se for do tipo refrigerante, false caso contrário.
     */
    public boolean isRefrigeranteOrganico() {
        return false;
    }

    /**
     * Método para identificar o tipo do produto.
     * 
     * @return True se for do tipo cerveja, false caso contrário.
     */
    public boolean isCervejaVegana() {
        return false;
    }
}
