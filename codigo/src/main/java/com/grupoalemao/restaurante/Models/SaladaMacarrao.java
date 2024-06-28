package com.grupoalemao.restaurante.Models;

public class SaladaMacarrao extends Produto {
    
    public SaladaMacarrao(String nome, double preco){
        super(nome,preco,true);
    }

    /**
     * Método para identificar o tipo do produto.
     * 
     * @return O tipo do produto.
     */
    @Override
    public String getCategoria() {
        return "Salada de Macarrão";
    }
}
