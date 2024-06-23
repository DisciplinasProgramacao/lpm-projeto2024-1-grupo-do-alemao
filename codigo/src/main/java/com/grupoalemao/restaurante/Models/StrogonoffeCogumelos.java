package com.grupoalemao.restaurante.Models;

public class StrogonoffeCogumelos extends Produto {
    
    public StrogonoffeCogumelos(String nome, double preco){
        super(nome,preco,true);
    }

    /**
     * Método para identificar o tipo do produto.
     * 
     * @return O tipo do produto.
     */
    @Override
    public String getCategoria() {
        return "Strogonoffe de Cogumelos";
    }
}
