import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private int cod;
    private int capacidade;
    private Cliente cliente;
    private List<RequisicaoPorMesa> pessoas;

    // Construtor da classe Mesa
    
    public Mesa(int cod, int capacidade) {
        this.cod = cod;
        this.capacidade = capacidade;
        this.cliente = null;
        this.pessoas = new ArrayList<>(); 
    }

    public int getCod() {
        return cod;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public String getNome() {
        return "Mesa " + cod;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    // Método para mudar o status da mesa (ocupada/desocupada)
    // Verifica se a mesa está disponível para ser ocupada. Se sim, define um novo cliente (ocupada),
    // se não, remove o cliente da mesa (desocupada) e limpa a lista de pessoas.
    // Retorna true se a mesa está ocupada e false se estiver desocupada.
    
    public boolean mudarStatusMesa() {
        if (estaDisponivel(0)) {
            cliente = new Cliente(); 
        } else {
            cliente = null; 
            pessoas.clear(); 
        }
        
        return cliente != null;
    }
    
 // Verifica se a mesa está disponível para uma certa quantidade de pessoas.
 // Retorna true se o número total de pessoas na mesa (incluindo as requisições) é menor ou igual
 // à capacidade da mesa e se a mesa está desocupada. Caso contrário, retorna false.
    
    public boolean estaDisponivel(int qtPessoas) {
        int totalPessoas = qtPessoas;
        for (RequisicaoPorMesa requisicao : pessoas) {
            totalPessoas += requisicao.getPessoas();
        }
        return totalPessoas <= capacidade && cliente == null;
    }

}
