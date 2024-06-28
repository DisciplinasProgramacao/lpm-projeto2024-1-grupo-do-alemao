package com.grupoalemao.restaurante.Models;

public class MoquecaDePalmito extends Produto {
    
    public MoquecaDePalmito(String nome, double preco){
        super(nome,preco,true);
    }

    /**
     * Método para identificar o tipo do produto.
     * 
     * @return O tipo do produto.
     */
    @Override
    public String getCategoria() {
        return "Moqueca de Palmito";
    }
}
