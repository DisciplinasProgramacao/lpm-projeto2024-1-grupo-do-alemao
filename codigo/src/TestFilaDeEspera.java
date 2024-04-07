import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestFilaDeEspera {

    // Teste do método que adiciona requisições na fila
    @Test
    public void testAdicionaRequisicao() {
        FilaDeEspera fila = new FilaDeEspera();
        RequisicaoReserva req1 = new RequisicaoReserva(null, null, 3, null);
        RequisicaoReserva req2 = new RequisicaoReserva(null, null, 2, null);
        fila.addRequisicaoNaFila(req1);
        fila.addRequisicaoNaFila(req2);
        assertEquals(2, fila.getNumRequisicoes());
    }

    // Teste do método que remove requisições da fila pelo número de pessoas
    @Test
    public void testRemoveRequisicaoNumPessoas() {
        FilaDeEspera fila = new FilaDeEspera();
        RequisicaoReserva req1 = new RequisicaoReserva(null, null, 4, null);
        RequisicaoReserva req2 = new RequisicaoReserva(null, null, 3, null);
        fila.addRequisicaoNaFila(req1);
        fila.addRequisicaoNaFila(req2);
        fila.removerRequisicaoDafiLa(3);
        assertEquals(1, fila.getNumRequisicoes());
    }

    // Teste para verificar se é removida apenas a primeira requisição da fila que
    // tenha
    // o número de pessoas definido
    @Test
    public void testRemoveApenasAPrimeiraReq() {
        FilaDeEspera fila = new FilaDeEspera();
        RequisicaoReserva req1 = new RequisicaoReserva(null, null, 3, null);
        RequisicaoReserva req2 = new RequisicaoReserva(null, null, 3, null);
        fila.addRequisicaoNaFila(req1);
        fila.addRequisicaoNaFila(req2);
        assertEquals(2, fila.getNumRequisicoes());
        fila.removerRequisicaoDafiLa(3);
        assertEquals(1, fila.getNumRequisicoes());
    }

    // Teste do método que remove a requisição por um objeto do tipo Cliente
    @Test
    public void testRemoveRequisicaoCliente() {
        FilaDeEspera fila = new FilaDeEspera();
        Cliente c = new Cliente("Maria", "998234581");
        Cliente c1 = new Cliente("Joao", "997654534");
        RequisicaoReserva req1 = new RequisicaoReserva(null, null, 0, c);
        RequisicaoReserva req2 = new RequisicaoReserva(null, null, 0, c1);
        fila.addRequisicaoNaFila(req1);
        fila.addRequisicaoNaFila(req2);
        fila.removerRequisicaoDafiLa(c);
        assertEquals(1, fila.getNumRequisicoes());
    }

    // Teste do médoto que recupera a quantidade de pessoas de cada requisição da
    // fila
    @Test
    public void getRequisicoesNumPessoas() {
        FilaDeEspera fila = new FilaDeEspera();
        RequisicaoReserva req1 = new RequisicaoReserva(null, null, 5, null);
        RequisicaoReserva req2 = new RequisicaoReserva(null, null, 8, null);
        fila.addRequisicaoNaFila(req1);
        fila.addRequisicaoNaFila(req2);
        assertEquals("5 8 ", fila.getRequisicoes());
    }

    // Teste do método que recupera os nomes dos clientes de cada requisição da fila
    @Test
    public void getRequisicoesCliente() {
        FilaDeEspera fila = new FilaDeEspera();
        Cliente c = new Cliente("Maria", "997185456");
        Cliente c1 = new Cliente("João", "998765656");
        RequisicaoReserva req1 = new RequisicaoReserva(null, null, 5, c);
        RequisicaoReserva req2 = new RequisicaoReserva(null, null, 8, c1);
        fila.addRequisicaoNaFila(req1);
        fila.addRequisicaoNaFila(req2);
        assertEquals("Maria João ", fila.getRequisicoesCliente());
    }
}
