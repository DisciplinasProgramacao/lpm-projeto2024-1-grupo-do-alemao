package Tests;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Cliente;

public class ClienteTest {
    /*Método que testa a classe cliente quando inserido um nome válido.*/
    @Test 
    public void testeNomeValido() {
        Cliente c = new Cliente("Maria","33 988673212");
        assertEquals("Maria", c.getNome());
    }
    /*Método que testa a classe cliente quando inserido um nome inválido.*/
    @Test 
    public void testeNomeInvalido() {
        Cliente c = new Cliente("zzz","33 988673212");
        assertEquals(null, c.getNome());
    }
    /*Método que testa a classe cliente quando inserido um telefone válido.*/
    @Test 
    public void testeTelefoneValido() {
        Cliente c = new Cliente("Daniel","33 999393212");
        assertEquals("33 999393212", c.getTelefone());
    }
    /*Método que testa a classe cliente quando inserido um telefone inválido.*/
    @Test 
    public void testeTelefoneInvalido() {
        Cliente c = new Cliente("Daniel","3356");
        assertEquals(null, c.getTelefone());
    }
}
