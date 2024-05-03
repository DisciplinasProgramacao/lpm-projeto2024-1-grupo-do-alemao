import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ProdutoTest {

    @Test
    public void testNomeValido(){
        Agua p1 = new Agua("Água",2.40);
        assertEquals("Água",p1.getNome());
    }

    @Test
    public void testNomeInvalido(){
        Agua p1 = new Agua("ag",2.40);
        assertEquals(null,p1.getNome());
    }

    @Test
    public void testPrecoValido(){
        FalafelAssado f = new FalafelAssado("Falafel Assado",20);
        assertEquals(20,f.getPreco());
    }

    @Test
    public void testPrecoInvalido(){
        FalafelAssado f = new FalafelAssado("Falafel Assado",-32.90);
        assertEquals(0,f.getPreco());
    }
}
