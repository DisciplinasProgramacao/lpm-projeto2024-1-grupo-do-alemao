package com.grupoalemao.restaurante.models;

/**
 * Classe FilaDeEspera responsável por controlar a fila de requisições dos
 * clientes que ainda não foram alocados em mesas.
 */
public class FilaDeEspera {

    // #region atributos

    private RequisicaoReserva[] requisicoes;
    private int numRequisicoes;

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
        requisicoes = new RequisicaoReserva[100];
        numRequisicoes = 0;
    }
    // #endregion

    /**
     * Método para adicionar uma requisição na fila de espera, representada pelo
     * array de requisições.
     * @param requisicao É a requisição a ser adicionada na fila.
     */
    public void addRequisicaoNaFila(RequisicaoReserva requisicao) {
        requisicoes[numRequisicoes++] = requisicao;
    }

    /**
     * Método para remover uma requisição da fila pelo número de pessoas.
     * @param numPessoas A quantidade de pessoas da requisição a ser removida.
     * @return Requisição removida, caso ela tenha sido encontrada, null, caso não.
     */
    public RequisicaoReserva removerRequisicaoDafiLa(int numPessoas) {
        RequisicaoReserva reqRemovida = null;
        for (int posicao = 0; posicao < numRequisicoes; posicao++) {
            if (numPessoas == requisicoes[posicao].getPessoas()) {
                reqRemovida = requisicoes[posicao];
                for (int i = posicao + 1; i < numRequisicoes; i++) {
                    requisicoes[i - 1] = requisicoes[i];
                }

                requisicoes[numRequisicoes - 1] = null;
                numRequisicoes--;
                return reqRemovida;
            }
        }
        return reqRemovida;
    }

    /**
     * Método para remover uma requisição da fila através de um objeto do tipo
     * Cliente.
     * @param cliente Objeto cliente para indicar qual requisição deve ser removida
     * da fila.
     * @return Requisição removida, caso ela tenha sido encontrada, null, caso não.
     */
    public RequisicaoReserva removerRequisicaoDafiLa(Cliente cliente) {
        RequisicaoReserva reqRemovida = null;
        for (int posicao = 0; posicao < numRequisicoes; posicao++) {
            if (cliente == requisicoes[posicao].getCliente()) {
                reqRemovida = requisicoes[posicao];
                for (int i = posicao + 1; i < numRequisicoes; i++) {
                    requisicoes[i - 1] = requisicoes[i];
                }

                requisicoes[numRequisicoes - 1] = null;
                numRequisicoes--;
                return reqRemovida;
            }
        }
        return reqRemovida;
    }

    /**
     * Método para retornar um número de requisições presentes na fila.
     * @return O número de requisições presentes na fila.
     */
    public int getNumRequisicoes() {
        return numRequisicoes;
    }

    /**
     * Método para recuperar o número de pessoas de todas as requisições da fila.
     * @return O número de pessoas de cada requisição na fila.
     */
    public String getRequisicoes() {
        String resultado = "";
        for (int i = 0; i < numRequisicoes; i++) {
            resultado += requisicoes[i].getPessoas() + " ";
        }
        return resultado;
    }

    /**
     * Método para recuperar os nomes dos clientes que estão na fila.
     * @return Os nomes dos clientes de cada requisição na fila.
     */
    public String getRequisicoesCliente() {
        String resultado = "";
        for (int i = 0; i < numRequisicoes; i++) {
            resultado += requisicoes[i].getCliente().getNome() + " ";
        }
        return resultado;
    }
    // #endregion
}