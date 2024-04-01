import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestFilaDeEspera { 
    @Test
    public void testAdicionaRequisicao() {
        FilaDeEspera fila = new FilaDeEspera();
        Requisicao req1 = new Requisicao(3, null);
        fila.addRequisicaoNaFila(req1);
        assertEquals(1, fila.getNumRequisicoes());
    }

    @Test
    public void testRemoveRequisicao(){
        FilaDeEspera fila = new FilaDeEspera();
        Requisicao req1 = new Requisicao(4, null);
        Requisicao req2 = new Requisicao(3, null);
        fila.addRequisicaoNaFila(req1);
        fila.addRequisicaoNaFila(req2);
        fila.removerRequisicaoDafiLa(3);
        assertEquals(1, fila.getNumRequisicoes());
    }

    @Test
    public void testRemoveApenasAPrimeiraReq() {
        FilaDeEspera fila = new FilaDeEspera();
        Requisicao req1 = new Requisicao(3, null);
        Requisicao req2 = new Requisicao(3, null);
        fila.addRequisicaoNaFila(req1);
        fila.addRequisicaoNaFila(req2);
        assertEquals(2, fila.getNumRequisicoes());
        fila.removerRequisicaoDafiLa(3);
        assertEquals(1, fila.getNumRequisicoes());
    }

    @Test
    public void testRemoveRequisicaoCliente(){
        FilaDeEspera fila = new FilaDeEspera();
        Cliente c = new Cliente();
        Cliente c1 = new Cliente();
        Requisicao req1 = new Requisicao(0, c);
        Requisicao req2 = new Requisicao(0, c1);
        fila.addRequisicaoNaFila(req1);
        fila.addRequisicaoNaFila(req2);
        fila.removerRequisicaoDafiLa(c);
        assertEquals(1, fila.getNumRequisicoes());
    }
}

