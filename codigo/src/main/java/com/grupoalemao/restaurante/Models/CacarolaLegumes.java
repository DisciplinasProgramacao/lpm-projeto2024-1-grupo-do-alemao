package com.grupoalemao.restaurante.Models;

public class CacarolaLegumes extends Produto {

    public CacarolaLegumes(String nome, double preco) {
        super(nome, preco, true);
    }

    /**
     * Método para identificar o tipo do produto.
     * 
     * @return O tipo do produto.
     */
    @Override
    public String getCategoria() {
        return "Caçarola de Legumes";
    }
}
