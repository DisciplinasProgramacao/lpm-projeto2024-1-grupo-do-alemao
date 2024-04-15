import java.util.List;
import java.util.ArrayList;

/**
*Primeira versão da classe restaurante,esta classe permite ao usuário ou gerente adicionar clientes e remover clientes de uma lista,adicionar e remover mesa de uma lista,alocar mesa para um cliente específico e liberar mesa caso ela esteja alocada
*Deve ser melhorada com o tempo,de acordo com oque o professor colocará
*/
public class restaurante {
 //#region atributos
    
    List<Mesa> mesas = new ArrayList<>();
    FilaDeEspera filaDeEspera = new FilaDeEspera();
    List<Cliente> clientes = new ArrayList<>();
    
   //#endregion
    
//Não há necessidade de um construtor,por isso não foi implementado.
    
 //#region métodos
    
   /**
 * Adiciona um novo cliente à lista de clientes.
 * 
 * @param nome O nome do cliente a ser adicionado.
 * @param telefone O número de telefone do cliente a ser adicionado.
 */
   public void adicionarCliente(String nome, String telefone) {
    Cliente cliente = new Cliente(nome, telefone);
    clientes.add(cliente);
}

/**
 * Remove um cliente da lista de clientes com base no nome fornecido.
 * Se nenhum cliente for encontrado com o nome especificado, uma mensagem de aviso será exibida.
 * 
 * @param nome O nome do cliente a ser removido.
 */
public void removerCliente(String nome) {
    for (Cliente cliente : clientes) {
        if (cliente.getNome().equals(nome)) {
            clientes.remove(cliente);
            return;
        }
    }
    System.out.println("Cliente não encontrado.");
}


/**
    *Adiciona uma mesa da lista de mesas com base no código,capacidade e o nome do cliente caso já esteja alocada,caso não esteja,cliente deverá ser null
    *
    *@param cod O código da mesa que deverá ser adicionada
    *@param capacidade A capacidade da mesa
    *@param cliente O nome do cliente associado à mesa
*/
public void adicionarMesa(int cod, int capacidade,String cliente) {
    Mesa mesa= new Mesa(cod, capacidade, cliente);
    mesas.add(mesa);
}


/**
 * Remove uma mesa da lista de mesas com base no código fornecido.
 * Se nenhuma mesa for encontrada com o código especificado, uma mensagem de aviso será exibida.
 * 
 * @param cod O código da mesa a ser removida.
 */
public void removerMesa(int cod) {
    Mesa mesaRemover = null;
    for (Mesa mesa : mesas) {
        if (mesa.getCod() == cod) {
            mesaRemover = mesa;
            break;
        }
    }
    if (mesaRemover != null) {
        mesas.remove(mesaRemover);
    } else {
        System.out.println("Mesa não encontrada.");
    }
}

    
/**
 * Aloca uma mesa para um cliente com base no código da mesa e no nome do cliente fornecidos.
 * Se a mesa estiver disponível, ela será alocada para o cliente especificado. Caso contrário, uma mensagem será exibida informando que a mesa já está ocupada.
 * Se a mesa não for encontrada,será exibida uma mensagem de que a mesa não foi encontrada
 *
 * @param codMesa O código da mesa a ser alocada.
 * @param nomeCliente O nome do cliente para quem a mesa será alocada.
 */
public void alocarMesa(int codMesa, String nomeCliente) {
    for (Mesa mesa : mesas) {
        if (mesa.getCod() == codMesa) {
            if (mesa.estaDisponivel()) {
                mesa.setCliente(nomeCliente);
                System.out.println("Mesa alocada para " + nomeCliente);
            } else {
                System.out.println("A mesa já está ocupada.");
            }
            return;
        }
    }
    System.out.println("Mesa não encontrada.");
}
/**
 * Libera uma mesa com base no código da mesa fornecido.
 * Se a mesa estiver ocupada, ela será liberada. Caso contrário, uma mensagem será exibida informando que a mesa já está livre.
 * 
 * @param codMesa O código da mesa a ser liberada.
 */
public void liberarMesa(int codMesa,Cliente cliente) {
    for (Mesa mesa : mesas) {
        if (mesa.getCod() == codMesa) {
            if (!mesa.estaDisponivel()) {
                mesa.mudarStatusMesa();
                System.out.println("Mesa liberada.");
            } else {
                System.out.println("A mesa já está livre.");
            }
            return;
        }
    }
    System.out.println("Mesa não encontrada.");
}
 //#endregion
}
