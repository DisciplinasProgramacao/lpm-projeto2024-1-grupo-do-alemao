package com.grupoalemao.restaurante.Models;

public class CervejaVegana extends Produto {

    public CervejaVegana(String nome, double preco) {
        super(nome, preco, false);
    }

    /**
     * Método para identificar o tipo do produto.
     * 
     * @return O tipo do produto.
     */
    @Override
    public String getCategoria() {
        return "Cerveja Vegana";
    }
}
