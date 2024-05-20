import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

public class PedidoTest {
    private Produto produto1;
    private Produto produto2;
    private Pedido pedido;

    @Before
    public void setUp() {
        produto1 = new Produto("Pizza", 50.0);
        produto2 = new Produto("Hamburguer", 30.0);

        pedido = new Pedido();
    }

    @Test
    public void testAddProduto() {
        pedido.addProduto(produto1);
        pedido.addProduto(produto2);

        assertEquals(2, pedido.getPedido().size());
    }

    @Test
    public void testRemoverProduto() {
        pedido.addProduto(produto1);
        pedido.addProduto(produto2);

        pedido.removerProduto(produto1);

        assertEquals(1, pedido.getPedido().size());
        assertEquals("Hamburguer", pedido.getPedido().get(0).getNome());
    }

    @Test
    public void testFecharPedido() {
        pedido.addProduto(produto1);
        pedido.addProduto(produto2);

        Cliente cliente = new Cliente("João", "123456789");
        Mesa mesa = new Mesa(1, 4);

        RequisicaoReserva requisicaoReserva = new RequisicaoReserva(LocalDate.now(), 4, cliente, mesa);

        int numeroPessoas = requisicaoReserva.getPessoas();

        double[] valores = pedido.fecharPedido(numeroPessoas);

        assertEquals(88.0, valores[0], 0.01);
        assertEquals(22.00, valores[1], 0.01);
    }
}