import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;

public class RequisicaoReservaTeste {

    @Test
    public void testarFuncionalidadesRestaurante() {
      
        Mesa mesa1 = new Mesa();
        mesa1.setCod(1);
        mesa1.setDisponivel(true);

        Cliente cliente1 = new Cliente("João");

        
        LocalDate dataReserva = LocalDate.now();
        int pessoas = 4;
        RequisicaoReserva requisicao1 = new RequisicaoReserva(dataReserva, pessoas, cliente1, mesa1);

        assertTrue("A reserva deve estar ativa antes do cancelamento", requisicao1.isAtiva());
        requisicao1.cancelar();
        assertFalse("A reserva deve estar cancelada após o cancelamento", requisicao1.isAtiva());

   
        mesa1.setDisponivel(false);
        assertTrue("A mesa deve estar ocupada antes da liberação", mesa1.estaDisponivel());
        mesa1.liberarMesa(1);
        assertTrue("A mesa deve estar livre após a liberação", mesa1.estaDisponivel());
    }
}
