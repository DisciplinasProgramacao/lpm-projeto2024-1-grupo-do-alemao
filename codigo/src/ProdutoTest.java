import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ProdutoTest {

    @Test
    public void testNomeValido(){
        Produto p1 = new Bebida("Água",2.40);
        assertEquals("Água",p1.getNome());
    }

    @Test
    public void testNomeInvalido(){
        Produto p1 = new Bebida("ag",2.40);
        assertEquals(null,p1.getNome());
    }

    @Test
    public void testPrecoValido(){
        Produto p1 = new Prato("Falafel Assado",20);
        assertEquals(20,p1.getPreco());
    }

    @Test
    public void testPrecoInvalido(){
        Produto p1 = new Prato("Falafel Assado",-32.90);
        assertEquals(0,p1.getPreco());
    }
}
