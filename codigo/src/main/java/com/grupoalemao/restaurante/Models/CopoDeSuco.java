package com.grupoalemao.restaurante.Models;

public class CopoDeSuco extends Produto {

    public CopoDeSuco(String nome, double preco) {
        super(nome, preco, false);
    }

    /**
     * Método para identificar o tipo do produto.
     * 
     * @return O tipo do produto.
     */
    @Override
    public String getCategoria() {
        return "Copo de suco";
    }
}
