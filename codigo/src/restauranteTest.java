
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class restauranteTest {


    //Teste de adiciona o cliente na lista.
    @Test
    public void testAdicionarCliente() {
        restaurante restaurante = new restaurante();
        restaurante.adicionarCliente("João", "123456789");
        assertEquals(1, restaurante.clientes.size());
    }
    //Teste que remove o cliente da lista.
    @Test
    public void testRemoverCliente() {
        restaurante restaurante = new restaurante();
        restaurante.adicionarCliente("Maria", "987654321");
        restaurante.removerCliente("Maria");
        assertEquals(0, restaurante.clientes.size());
    }
    //Teste de adicionar a mesa da lista.
    @Test
    public void testAdicionarMesa() {
        restaurante restaurante = new restaurante();
        restaurante.adicionarMesa(1, 4, "Cliente");
        assertEquals(1, restaurante.mesas.size());
    }
    //Teste de remover a mesa da lista.
    @Test
    public void testRemoverMesa() {
        restaurante restaurante = new restaurante();
        restaurante.adicionarMesa(1, 4, "Cliente");
        restaurante.removerMesa(1);
        assertEquals(0, restaurante.mesas.size());
    }
    //Testa de como alocar uma mesa
    @Test
    public void testAlocarMesa() {
        restaurante restaurante = new restaurante();
        restaurante.adicionarMesa(1, 4, "");
        restaurante.alocarMesa(1, "Cliente");
        assertFalse(restaurante.mesas.get(0).isDisponivel());
    }
    //Teste de liberar a mesa pelo código fornecido
    @Test
    public void testLiberarMesa() {
        restaurante restaurante = new restaurante();
        restaurante.adicionarMesa(1, 4, "Cliente");
        restaurante.liberarMesa(1);
        assertTrue(restaurante.mesas.get(0).isDisponivel());
    }
}
