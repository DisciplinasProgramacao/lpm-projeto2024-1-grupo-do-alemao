package src;
import java.time.LocalDate;

import RequisicaoReserva;

public class Main {
    public static void main(String[] args) {
        // Criando clientes
        Cliente cliente1 = new Cliente("Maria", "123456789");
        Cliente cliente2 = new Cliente("João", "987654321");

        // Criando mesas
        Mesa mesa1 = new Mesa(1, 4);
        Mesa mesa2 = new Mesa(2, 6);

        // Criando reservas
        LocalDate dataReserva1 = LocalDate.now();
        LocalDate dataReserva2 = LocalDate.now().plusDays(1);
        RequisicaoReserva reserva1 = new RequisicaoReserva("Mesa para 4 pessoas", dataReserva1, 4, cliente1);
        RequisicaoReserva reserva2 = new RequisicaoReserva("Mesa para 6 pessoas", dataReserva2, 6, cliente2);

        // Adicionando reservas à fila de espera
        FilaDeEspera filaDeEspera = new FilaDeEspera();
        filaDeEspera.addRequisicaoNaFila(reserva1);
        filaDeEspera.addRequisicaoNaFila(reserva2);

        // Adicionando clientes à lista do restaurante
        restaurante restaurante = new restaurante();
        restaurante.adicionarCliente(cliente1);
        restaurante.adicionarCliente(cliente2);

        // Adicionando mesas à lista do restaurante
        restaurante.adicionarMesa(mesa1);
        restaurante.adicionarMesa(mesa2);

        // Exibindo informações sobre as reservas na fila de espera
        System.out.println("Reservas na fila de espera:");
        for (RequisicaoReserva reserva : filaDeEspera.getRequisicoes()) {
            System.out.println("Cliente: " + reserva.getCliente().getNome() +
                    ", Mesa: " + reserva.getNomeItem() +
                    ", Data da reserva: " + reserva.getDataReserva());
        }

        // Alocando mesas para as reservas
        for (RequisicaoReserva reserva : filaDeEspera.getRequisicoes()) {
            Mesa mesaDisponivel = restaurante.buscarMesaDisponivel(reserva.getPessoas());
            if (mesaDisponivel != null) {
                mesaDisponivel.setCliente(reserva.getCliente());
                mesaDisponivel.setDisponivel(false);
                filaDeEspera.removerRequisicaoDaFila(reserva);
                System.out.println("Mesa alocada para " + reserva.getCliente().getNome());
            }
        }

        // Exibindo informações atualizadas sobre as mesas
        System.out.println("\nEstado atual das mesas:");
        for (Mesa mesa : restaurante.getMesas()) {
            System.out.println("Mesa " + mesa.getCod() +
                    ": Capacidade: " + mesa.getCapacidade() +
                    ", Cliente: " + (mesa.isDisponivel() ? "Disponível" : mesa.getCliente().getNome()));
        }
    }
}
