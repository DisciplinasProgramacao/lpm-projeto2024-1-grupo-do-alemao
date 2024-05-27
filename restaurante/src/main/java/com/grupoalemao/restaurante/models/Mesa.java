package com.grupoalemao.restaurante.models;

import java.util.ArrayList;
import java.util.List;

public class Mesa {

    private int cod;
    private int capacidade;
    private Cliente cliente;
    private List<RequisicaoReserva> pessoas;
    private boolean disponivel;


    /**
     * Construtor da classe Mesa.
     * @param cod O código da mesa.
     * @param capacidade A capacidade máxima de pessoas que a mesa pode acomodar.
     * @param disponivel Boolean se está disponível ou nao.
     * @param cliente Nome do cliente em que esta alocado ou nao.
     */
    public Mesa(int cod, int capacidade,boolean disponivel,Cliente cliente) {
        this.cod = cod;
        setCapacidade(capacidade);
        this.cliente = null;
        this.pessoas = new ArrayList<>();
        this.disponivel = disponivel;
        this.cliente = cliente;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
    /**
     * Obtém o código da mesa.
     * @return O código da mesa.
     */
    public int getCod() {
        return cod;
    }

    public boolean isDisponivel() {
        return disponivel;
    }
    /**
     * Obtém a capacidade máxima de pessoas que a mesa pode acomodar.
     * @return A capacidade da mesa.
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * Obtém o nome da mesa.
     * @return O nome da mesa.
     */
    public String getNome() {
        return "Mesa " + cod;
    }

    /**
     * Define a capacidade máxima de pessoas que a mesa pode acomodar.
     * @param capacidade A nova capacidade da mesa.
     */
    public void setCapacidade(int capacidade) {
        if (capacidade <= 4 || capacidade <= 6 || capacidade <= 8) {
            this.capacidade = capacidade;
        } else {
            System.out.println("A capacidade da mesa deve ser até 4, até 6 ou até 8 pessoas.");
        }
    }

    /**
     * Obtém o cliente atualmente associado à mesa.
     * @return O cliente associado à mesa, ou null se a mesa estiver vazia.
     */
    public Cliente getCliente() {
        return cliente;
    }
     /**
     * Obtém o cliente atualmente associado à mesa.
     * @return O cliente associado à mesa, ou null se a mesa estiver vazia.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Muda o status da mesa para ocupada ou liberada.
     * @param cliente O cliente que está ocupando a mesa, ou null se a mesa estiver sendo liberada.
     * @return true se a mesa estava disponível antes da operação e false caso contrário.
     */
    public boolean mudarStatusMesa(Cliente cliente) {
        boolean estavaDisponivel = estaDisponivel(0);
        
        if (estavaDisponivel) {
            this.cliente = cliente;
        } else {
            this.cliente = null;
            pessoas.clear();
        }
        
        boolean agoraEstaDisponivel = estaDisponivel(0);
        
        return estavaDisponivel && !agoraEstaDisponivel;
    }

    /**
     * Verifica se a mesa está disponível para uma certa quantidade de pessoas.
     * @param qtPessoas A quantidade de pessoas que deseja ocupar a mesa.
     * @return true se a mesa estiver disponível para a quantidade especificada de pessoas, false caso contrário.
     */
    public boolean estaDisponivel(int qtPessoas) {
        int totalPessoas = qtPessoas;
        for (RequisicaoReserva requisicao : pessoas) {
            totalPessoas += requisicao.getPessoas();
        }
        return totalPessoas <= capacidade && cliente == null;
    }

    public void liberar() {
        this.disponivel = true;
    }
}