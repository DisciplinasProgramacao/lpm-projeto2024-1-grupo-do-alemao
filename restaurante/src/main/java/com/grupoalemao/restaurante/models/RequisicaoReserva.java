package com.grupoalemao.restaurante.models;

import java.time.LocalDate;

/**
 * Classe RequisicaoReserva representa uma solicitação de reserva em um restaurante.
 * Cada instância desta classe armazena informações sobre a reserva, como data, número de pessoas, cliente associado e mesa reservada.
 * Esta classe controla também o status da reserva.
 */
public class RequisicaoReserva {
    private static int proximoId = 1; 
    private int id; 
    private LocalDate dataReserva; 
    private boolean ativa; 
    private int pessoas; 
    private Cliente cliente; 
    private Mesa mesa; 

    /**
     * Construtor da classe RequisicaoReserva.
     * Inicializa uma reserva com os parâmetros fornecidos e gera um identificador único automaticamente.
     * Marca a mesa associada como indisponível.
     * @param dataReserva A data da reserva.
     * @param pessoas O número de pessoas na reserva.
     * @param cliente O cliente associado à reserva.
     * @param mesa A mesa reservada.
     */
    public RequisicaoReserva(LocalDate dataReserva, int pessoas, Cliente cliente, Mesa mesa) {
        this.id = proximoId++; 
        this.dataReserva = dataReserva;
        this.ativa = true; 
        this.pessoas = pessoas;
        this.cliente = cliente;
        this.mesa = mesa;
        this.mesa.setDisponivel(false); 
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getPessoas() {
        return pessoas;
    }

    public void setPessoas(int pessoas) {
        this.pessoas = pessoas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public void cancelar() {
        this.ativa = false; 
        this.mesa.liberar(); 
    }
}
