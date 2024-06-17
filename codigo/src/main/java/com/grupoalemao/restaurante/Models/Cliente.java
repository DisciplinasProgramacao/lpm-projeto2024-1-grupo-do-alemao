package com.grupoalemao.restaurante.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.grupoalemao.exceptions.GlobalExceptions;

/**
 * Esta classe tem a responsabilidade de armazenar os dados pessoais de um
 * cliente do restaurante.
 */
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer cod;

    @Column(nullable = false)
    private String nome;

    /**
     * Construtor padrão da classe Cliente.
     */
    public Cliente() {
    }

    /**
     * Construtor da classe Cliente.
     * 
     * @param n   Representa o nome do cliente.
     * @throws GlobalExceptions 
     */
    public Cliente(String n) throws GlobalExceptions{
        setNome(n);
    }

    /**
     * Método que atribui um valor recebido à variável Nome, se este tiver mais que 3 caracteres.
     * 
     * @param nome Representa o nome do cliente
     */
    public void setNome(String nome) throws GlobalExceptions{
        if(nome == null){
            throw new GlobalExceptions("Nome do cliente deve ser não nulo.");
        }
            this.nome = nome;
    }

    /**
     * Método que retorna o código do Cliente.
     * 
     * @return Um número inteiro que é o código do Cliente
     */
    public Integer getCod() {
        return cod;
    }

    /**
     * Método que retorna o nome do Cliente.
     * 
     * @return Uma string que é o nome do Cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método que retorna uma string com os dados do cliente.
     * @return Uma string que têm os dados do cliente.
     */
    @Override
    public String toString() {
        return "Cliente: " + nome;
    }
}
