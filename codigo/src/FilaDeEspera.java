public class FilaDeEspera {
    private RequisicaoReserva[] requisicoes;
    private int numRequisicoes;

    public FilaDeEspera() {
        requisicoes = new RequisicaoReserva[100];
        numRequisicoes = 0;
    }

    // Método para adicionar uma requisição na fila
    public void addRequisicaoNaFila(RequisicaoReserva requisicao) {
        requisicoes[numRequisicoes++] = requisicao;
    }

    // Método para remover uma requição na fila pelo número de pessoas
    public void removerRequisicaoDafiLa(int numPessoas) {
        for (int posicao = 0; posicao < numRequisicoes; posicao++) {
            if (numPessoas == requisicoes[posicao].getPessoas()) {

                for (int i = posicao + 1; i < numRequisicoes; i++) {
                    requisicoes[i - 1] = requisicoes[i];
                }

                requisicoes[numRequisicoes - 1] = null;
                numRequisicoes--;
                return;
            }
        }
    }

    // Método para remover requisição da fila por um objeto do tipo Cliente
    public void removerRequisicaoDafiLa(Cliente cliente) {
        for (int posicao = 0; posicao < numRequisicoes; posicao++) {
            if (cliente == requisicoes[posicao].getCliente()) {

                for (int i = posicao + 1; i < numRequisicoes; i++) {
                    requisicoes[i - 1] = requisicoes[i];
                }

                requisicoes[numRequisicoes - 1] = null;
                numRequisicoes--;
                return;
            }
        }
    }

    // Método para recuperar o número de requisições presentes na fila
    public int getNumRequisicoes() {
        return numRequisicoes;
    }

    // Método para recuperar o número de pessoas de todas as requisições da fila
    public String getRequisicoes() {
        String resultado = "";
        for (int i = 0; i < numRequisicoes; i++) {
            resultado += requisicoes[i].getPessoas() + " ";
        }
        return resultado;
    }

    // Método para recuperar os nomes dos clientes que estão na fila
    public String getRequisicoesCliente() {
        String resultado = "";
        for (int i = 0; i < numRequisicoes; i++) {
            resultado += requisicoes[i].getCliente().getNome() + " ";
        }
        return resultado;
    }
}