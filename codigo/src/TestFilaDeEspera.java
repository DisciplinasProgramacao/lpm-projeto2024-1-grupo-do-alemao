public class TestFilaDeEspera {
    import static org.junit.Assert.assertEquals;

import org.junit.Test;
 
    @Test
    public void testAdicionaRequisicao() {
        FilaDeEspera fila = new FilaDeEspera();
        Requisicao req1 = new Requisicao(3);
        fila.addRequisicaoNaFila(req1);
        assertEquals(1, fila.getNumRequisicoes());
    }

    @Test
    public void testRemoveRequisicao(){
        FilaDeEspera fila = new FilaDeEspera();
        Requisicao req1 = new Requisicao(4);
        Requisicao req2 = new Requisicao(3);
        fila.addRequisicaoNaFila(req1);
        fila.addRequisicaoNaFila(req2);
        fila.removerRequisicaoDafiLa(3);
        assertEquals(1, fila.getNumRequisicoes());
    }

    @Test
    public void testRemoveApenasAPrimeiraReq() {
        FilaDeEspera fila = new FilaDeEspera();
        Requisicao req1 = new Requisicao(3);
        Requisicao req2 = new Requisicao(3);
        fila.addRequisicaoNaFila(req1);
        fila.addRequisicaoNaFila(req2);
        assertEquals(2, fila.getNumRequisicoes());
        fila.removerRequisicaoDafiLa(3);
        assertEquals(1, fila.getNumRequisicoes());
    }
}

