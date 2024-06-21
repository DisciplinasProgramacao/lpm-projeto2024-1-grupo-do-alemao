package com.grupoalemao.restaurante.Models;

public class CacarolaLegumes extends Produto {

    public CacarolaLegumes(String nome, double preco) {
        super(nome, preco, true);
    }

    /**
     * Método para identificar o tipo do produto.
     * 
     * @return True se for do tipo caçarola de legumes, false caso contrário.
     */
    @Override
    public boolean isCacarolaLegumes() {
        return true;
    }
}
