import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.time.LocalDate;

public class RequisicaoReservaTest {

    @Test
    public void testRequisicaoReserva() {
        // Create a new RequisicaoReserva object
        LocalDate dataReserva = LocalDate.of(2023, 3, 15);
        RequisicaoReserva req = new RequisicaoReserva("Livro", dataReserva);

        // Check the initial state of the object
        assertEquals(1, req.getId());
        assertEquals("Livro", req.getNomeItem());
        assertEquals(dataReserva, req.getDataReserva());
        assertTrue(req.isAtiva());

        // Test the cancelar() method
        req.cancelar();
        assertFalse(req.isAtiva());

        // Test the getId() method with a new object
        RequisicaoReserva req2 = new RequisicaoReserva("Computador", dataReserva);
        assertEquals(2, req2.getId());
    }
}
