import java.time.LocalDate;

public class RequisicaoReserva {
    private static int proximoId = 1;
    private int id;
    private String nomeItem;
    private LocalDate dataReserva;
    private boolean ativa;

    public RequisicaoReserva(String nomeItem, LocalDate dataReserva) {
        this.id = proximoId++;
        this.nomeItem = nomeItem;
        this.dataReserva = dataReserva;
        this.ativa = true;
    }

    public int getId() {
        return id;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void cancelar() {
        this.ativa = false;
    }
}