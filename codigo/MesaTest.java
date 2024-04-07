import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MesaTest {
    private Mesa mesa; 

    @Before
    public void setUp() {
        mesa = new Mesa(1, 4); 
    }

    // Teste para verificar se o status da mesa muda corretamente de disponível para ocupada
    @Test
    public void testMudarStatusMesaDisponivel() {
        assertTrue(mesa.estaDisponivel(0)); 
        mesa.mudarStatusMesa(); 
        assertFalse(mesa.estaDisponivel(0));
    }

    // Teste para verificar se o status da mesa muda corretamente de ocupada para disponível
    @Test
    public void testMudarStatusMesaOcupada() {
        mesa.mudarStatusMesa();
        assertFalse(mesa.estaDisponivel(0));
        mesa.mudarStatusMesa(); 
        assertTrue(mesa.estaDisponivel(0));
    }

    // Teste para verificar se a mesa está disponível para uma certa quantidade de pessoas
    @Test
    public void testEstaDisponivel() {
        assertTrue(mesa.estaDisponivel(4));
        mesa.mudarStatusMesa();
        assertFalse(mesa.estaDisponivel(2));
    }
}

