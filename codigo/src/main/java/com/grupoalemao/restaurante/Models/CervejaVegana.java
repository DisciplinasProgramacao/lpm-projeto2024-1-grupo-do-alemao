package com.grupoalemao.restaurante.Models;

public class CervejaVegana extends Produto {

    public CervejaVegana(String nome, double preco) {
        super(nome, preco, false);
    }

    /**
     * Método para identificar o tipo do produto.
     * 
     * @return True se for do tipo cerveja, false caso contrário.
     */
    @Override
    public boolean isCervejaVegana() {
        return true;
    }
}
