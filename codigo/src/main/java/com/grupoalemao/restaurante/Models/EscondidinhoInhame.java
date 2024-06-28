package com.grupoalemao.restaurante.Models;

public class EscondidinhoInhame extends Produto{
    
    public EscondidinhoInhame(String nome, double preco){
        super(nome,preco,true);
    }

    /**
     * Método para identificar o tipo do produto.
     * 
     * @return O tipo do produto.
     */
    @Override
    public String getCategoria() {
        return "Escondidinho de Inhame";
    }
}
