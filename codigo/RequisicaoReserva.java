import java.time.LocalDate;



/**
 * Classe RequisicaoReserva representa uma solicitação de reserva em um restaurante.
 * Cada instância desta classe armazena informações sobre a reserva, como data, número de pessoas, cliente associado e mesa reservada.
 * Esta classe controla também o status da reserva.
 */
public class RequisicaoReserva {
    private static int proximoId = 1; 
    private int id; 
    private LocalDate dataReserva; 
    private boolean ativa; 
    private int pessoas; 
    private Cliente cliente; 
    private Mesa mesa; 

    /**
     * Construtor da classe RequisicaoReserva.
     * Inicializa uma reserva com os parâmetros fornecidos e gera um identificador único automaticamente.
     * Marca a mesa associada como indisponível.
     * @param dataReserva A data da reserva.
     * @param pessoas O número de pessoas na reserva.
     * @param cliente O cliente associado à reserva.
     * @param mesa A mesa reservada.
     */
    public RequisicaoReserva(LocalDate dataReserva, int pessoas, Cliente cliente, Mesa mesa) {
        this.id = proximoId++; 
        this.dataReserva = dataReserva;
        this.ativa = true; 
        this.pessoas = pessoas;
        this.cliente = cliente;
        this.mesa = mesa;
        this.mesa.setDisponivel(false); 
    }

    /**
     * Método para obter o identificador da reserva.
     * @return O identificador único da reserva.
     */
    public int getId() {
        return id;
    }

    /**
     * Método para obter a data da reserva.
     * @return A data da reserva.
     */
    public LocalDate getDataReserva() {
        return dataReserva;
    }

    /**
     * Método para verificar se a reserva está ativa.
     * @return true se a reserva estiver ativa, false caso contrário.
     */
    public boolean isAtiva() {
        return ativa;
    }

    /**
     * Método para cancelar a reserva.
     * Marca a reserva como cancelada e marca a mesa associada como disponível.
     */
    public void cancelar() {
        this.ativa = false; 
        this.mesa.liberar(); 
    }

    /**
     * Método para obter o número de pessoas na reserva.
     * @return O número de pessoas na reserva.
     */
    public int getPessoas() {
        return pessoas;
    }

    /**
     * Método para obter o cliente associado à reserva.
     * @return O cliente associado à reserva.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Método para obter a mesa reservada.
     * @return A mesa reservada.
     */
    public Mesa getMesa() {
        return mesa;
    }
}
