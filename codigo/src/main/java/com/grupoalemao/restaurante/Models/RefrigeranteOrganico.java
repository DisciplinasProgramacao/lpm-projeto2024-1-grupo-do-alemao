package com.grupoalemao.restaurante.Models;

public class RefrigeranteOrganico extends Produto {

    public RefrigeranteOrganico(String nome, double preco) {
        super(nome, preco, false);
    }

    /**
     * Método para identificar o tipo do produto.
     * 
     * @return True se for do tipo refrigerante, false caso contrário.
     */
    @Override
    public boolean isRefrigeranteOrganico() {
        return true;
    }
}
