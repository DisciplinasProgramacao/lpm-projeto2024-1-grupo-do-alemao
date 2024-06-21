package com.grupoalemao.restaurante.Models;

public class CopoDeSuco extends Produto {

    public CopoDeSuco(String nome, double preco) {
        super(nome, preco, false);
    }

    /**
     * Método para identificar o tipo do produto.
     * 
     * @return True se for do tipo copo de suco, false caso contrário.
     */
    @Override
    public boolean isCopoDeSuco() {
        return true;
    }
}
