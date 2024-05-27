package com.grupoalemao.restaurante.models;

/**
 * Esta classe tem a responsabilidade de armazenar os dados relacionados
 * aos produtos ofertados pelo restaurante.
 */
public abstract class Produto {
    private String nome;
    private double preco;

    /**
     * Construtor da classe Produto.
     * 
     * @param nome  Representa o nome do produto.
     * @param preco Representa o preço do produto.
     */
    public Produto(String nome, double preco) {
        if(nome.length()>3){
            this.nome = nome;
        }
        if(preco>=0){
            this.preco = preco;
        }
    }

    /**
     * Método que retorna o nome do produto.
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
}

