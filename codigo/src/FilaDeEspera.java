public class FilaDeEspera {
    private Requisicao[] requisicoes; 
    private int numRequisicoes;

    public FilaDeEspera () {
        requisicoes = new Requisicao[100];
        numRequisicoes = 0;
    }

    public void addRequisicaoNaFila(Requisicao requisicao) {
            requisicoes[numRequisicoes++] = requisicao;
    }

    public void removerRequisicaoDafiLa(int numPessoas) {
        for (int posicao = 0; posicao < numRequisicoes; posicao++) {
            if(numPessoas == requisicoes[posicao].getPessoas()){
                
                for(int i = posicao + 1; i < numRequisicoes; i++ ) {
                    requisicoes[i - 1] = requisicoes[i];
                }

                requisicoes[numRequisicoes - 1] = null;
                numRequisicoes--;
                return;
            }
        }
    }

    public int getNumRequisicoes() {
        return numRequisicoes;
    }

    public String imprimirRequisicoes() {
        String resultado = "";
        for(int i = 0; i < numRequisicoes; i ++) {
            resultado+=(requisicoes[i].getPessoas());
        }
        return resultado;
    }
}