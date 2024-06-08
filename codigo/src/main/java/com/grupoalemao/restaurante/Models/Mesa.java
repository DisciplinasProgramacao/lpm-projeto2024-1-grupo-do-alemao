package com.grupoalemao.restaurante.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe representa uma mesa no restaurante.
 */
@Entity
@Table(name = "mesas")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod;

    @Column(nullable = false)
    private int capacidade;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = true)
    private Cliente cliente;

    @OneToMany(mappedBy = "mesa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RequisicaoReserva> pessoas = new ArrayList<>();

    @Column(nullable = false)
    private boolean disponivel;

    @OneToOne(mappedBy = "mesa", cascade = CascadeType.ALL, orphanRemoval = true)
    private Pedido pedido;

    /**
     * Construtor padrão da classe Mesa.
     */
    public Mesa() {
    }

    /**
     * Construtor da classe Mesa.
     *
     * @param cod        O código da mesa.
     * @param capacidade A capacidade máxima de pessoas que a mesa pode acomodar.
     * @param disponivel Boolean indicando se a mesa está disponível.
     * @param cliente    O cliente associado à mesa.
     */
    public Mesa(int cod, int capacidade, boolean disponivel, Cliente cliente) {
        this.cod = cod;
        setCapacidade(capacidade);
        this.disponivel = disponivel;
        this.cliente = cliente;
    }

    /**
     * Obtém o código da mesa.
     *
     * @return O código da mesa.
     */
    public int getCod() {
        return cod;
    }

    /**
     * Obtém a capacidade da mesa.
     *
     * @return A capacidade da mesa.
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * Obtém o nome da mesa.
     *
     * @return O nome da mesa.
     */
    public String getNome() {
        return "Mesa " + cod;
    }

    /**
     * Obtém o cliente associado à mesa.
     *
     * @return O cliente associado à mesa.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Obtém o pedido associado à mesa.
     *
     * @return O pedido associado à mesa.
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * Define a capacidade da mesa.
     *
     * @param capacidade A capacidade da mesa.
     * @throws IllegalArgumentException Se a capacidade não for 4, 6 ou 8 pessoas.
     */
    public void setCapacidade(int capacidade) {
        if (capacidade == 4 || capacidade == 6 || capacidade == 8) {
            this.capacidade = capacidade;
        } else {
            throw new IllegalArgumentException("A capacidade da mesa deve ser 4, 6 ou 8 pessoas.");
        }
    }

    /**
     * Define se a mesa está disponível.
     *
     * @param disponivel Boolean indicando se a mesa está disponível.
     */
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    /**
     * Define o cliente associado à mesa.
     *
     * @param cliente O cliente associado à mesa.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Define o pedido associado à mesa.
     *
     * @param pedido O pedido associado à mesa.
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * Muda o status da mesa para ocupada ou desocupada.
     *
     * @param cliente O cliente que ocupará a mesa.
     * @return true se a mesa estava disponível antes da mudança, false caso contrário.
     */
    public boolean mudarStatusMesa(Cliente cliente) {
        boolean estavaDisponivel = estaDisponivel(0);

        if (estavaDisponivel) {
            this.cliente = cliente;
            this.disponivel = false;
        } else {
            this.cliente = null;
            pessoas.clear();
            this.disponivel = true;
        }

        return estavaDisponivel;
    }

    /**
     * Verifica se a mesa está disponível para um número específico de pessoas.
     *
     * @param pessoas O número de pessoas.
     * @return true se a mesa estiver disponível para o número de pessoas especificado, false caso contrário.
     */
    public boolean estaDisponivel(int pessoas) {
        return pessoas <= capacidade && cliente == null;
    }
    
    /**
     * Libera a mesa, tornando-a disponível para uso.
     */
    public void liberar() {
        this.disponivel = true;
        this.cliente = null;
        pessoas.clear();
    }
}