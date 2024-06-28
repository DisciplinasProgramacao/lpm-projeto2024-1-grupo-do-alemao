package com.grupoalemao.restaurante.Models;

public class RefrigeranteOrganico extends Produto {

    public RefrigeranteOrganico(String nome, double preco) {
        super(nome, preco, false);
    }

    /**
     * Método para identificar o tipo do produto.
     * 
     * @return O tipo do produto.
     */
    @Override
    public String getCategoria() {
        return "Refrigerante Orgânico";
    }
}
