package com.grupoalemao.restaurante.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe FilaDeEspera responsável por controlar a fila de requisições dos
 * clientes que ainda não foram alocados em mesas.
 */
public class FilaDeEspera {

    // #region atributos

    private List<RequisicaoReserva> requisicoes;
    //private int numRequisicoes;

    // #endregion

    // #region métodos

    // #region Construtor

    /**
     * Construtor simples: aloca na memória um objeto da classe RequisiçãoReserva
     * e atribui à variável requisicoes uma referência a ele. Esse objeto é um array
     * que representa uma fila de requisições.
     * O Construtor também inicializa o atributo numRequisições com o valor zero,
     * pois nesse momento ainda não há requisições na fila.
     */
    public FilaDeEspera() {
        requisicoes = new ArrayList<>();
    }
    // #endregion

    /**
     * Método para adicionar uma requisição na fila de espera, representada pelo
     * array de requisições.
     * @param requisicao É a requisição a ser adicionada na fila.
     */
    public void addRequisicaoNaFila(RequisicaoReserva requisicao) {
        requisicoes.add(requisicao);
    }

    /**
     * Método para remover uma requisição da fila pelo número de pessoas.
     * @param numPessoas A quantidade de pessoas da requisição a ser removida.
     * @return Requisição removida, caso ela tenha sido encontrada, null, caso não.
     */
    public RequisicaoReserva removerRequisicaoDafiLa(int numPessoas) {
       for(RequisicaoReserva requisicao : requisicoes) {
            if(requisicao.getPessoas() == numPessoas) {
                requisicoes.remove(requisicao);
                return requisicao;
            }
       }
       return null;
    }

    /**
     * Método para remover uma requisição da fila através de um objeto do tipo
     * Cliente.
     * @param cliente Objeto cliente para indicar qual requisição deve ser removida
     * da fila.
     * @return Requisição removida, caso ela tenha sido encontrada, null, caso não.
     */
    public RequisicaoReserva removerRequisicaoDafiLa(Cliente cliente) {
        for(RequisicaoReserva requisicao : requisicoes) {
            if(requisicao.getCliente().equals(cliente)) {
                requisicoes.remove(requisicao);
                return requisicao;
            }
        }
        return null;
    }

    /**
     * Método para retornar um número de requisições presentes na fila.
     * @return O número de requisições presentes na fila.
     */
    public int getNumRequisicoes() {
        return requisicoes.size();
    }

    /**
     * Método para recuperar o número de pessoas de todas as requisições da fila.
     * @return O número de pessoas de cada requisição na fila.
     */
    public String getRequisicoes() {
        StringBuilder resultado = new StringBuilder();
        for (RequisicaoReserva requisicao : requisicoes) {
            resultado.append(requisicao.getPessoas()).append(" ");
        }
        return resultado.toString();
    }

    /**
     * Método para recuperar os nomes dos clientes que estão na fila.
     * @return Os nomes dos clientes de cada requisição na fila.
     */
    public String getRequisicoesCliente() {
        StringBuilder resultado = new StringBuilder();
        for (RequisicaoReserva requisicao : requisicoes) {
            resultado.append(requisicao.getCliente().getNome()).append(" ");
        }
        return resultado.toString();
    }
    // #endregion
}