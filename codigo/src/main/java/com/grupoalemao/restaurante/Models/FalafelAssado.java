package com.grupoalemao.restaurante.Models;

public class FalafelAssado extends Produto {

    public FalafelAssado(String nome, double preco) {
        super(nome, preco, true);
    }

    /**
     * Método para identificar o tipo do produto.
     * 
     * @return True se for do tipo falafel, false caso contrário.
     */
    @Override
    public boolean isFalafelAssado() {
        return true;
    }
}
