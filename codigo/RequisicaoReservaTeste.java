import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class RequisicaoReservaTeste {

    @Test
    public void testeIsAtivaVerdadeiro() {
        Cliente cliente1 = new Cliente("João", "98878932");
        Mesa mesa1 = new Mesa(1, 6, true, cliente1);

        LocalDate dataReserva = LocalDate.now();
        int pessoas = 4;
        RequisicaoReserva requisicao1 = new RequisicaoReserva(dataReserva, pessoas, cliente1, mesa1);

        assertTrue("A reserva deve estar ativa antes do cancelamento", requisicao1.isAtiva());
    }

    @Test
    public void testeIsAtivaFalso() {
        Cliente cliente1 = new Cliente("João", "98878932");
        Mesa mesa1 = new Mesa(1, 6, true, cliente1);

        LocalDate dataReserva = LocalDate.now();
        int pessoas = 4;
        RequisicaoReserva requisicao1 = new RequisicaoReserva(dataReserva, pessoas, cliente1, mesa1);

        requisicao1.cancelar();
        assertFalse("A reserva deve estar cancelada após o cancelamento", requisicao1.isAtiva());
    }

    @Test
    public void testarFuncionalidadesRestaurante() {
        Cliente cliente1 = new Cliente("João", "98878932");
        Mesa mesa1 = new Mesa(1, 6, true, cliente1);

        LocalDate dataReserva = LocalDate.now();
        int pessoas = 4;
        RequisicaoReserva requisicao1 = new RequisicaoReserva(dataReserva, pessoas, cliente1, mesa1);

        // Testa se a reserva está ativa inicialmente
        assertTrue("A reserva deve estar ativa antes do cancelamento", requisicao1.isAtiva());

        // Cancela a reserva e verifica se está inativa
        requisicao1.cancelar();
        assertFalse("A reserva deve estar cancelada após o cancelamento", requisicao1.isAtiva());

        // Verifica se a mesa está ocupada
        mesa1.setDisponivel(false);
        assertFalse("A mesa deve estar ocupada antes da liberação", mesa1.isDisponivel());

        // Libera a mesa e verifica se está disponível
        mesa1.liberar();
        assertTrue("A mesa deve estar livre após a liberação", mesa1.isDisponivel());
    }
}
