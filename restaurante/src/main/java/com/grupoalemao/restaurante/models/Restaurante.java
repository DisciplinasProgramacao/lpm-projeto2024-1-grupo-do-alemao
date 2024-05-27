package com.grupoalemao.restaurante.models;

import java.util.List;
import java.util.ArrayList;

/**
*Segunda versão da classe restaurante,esta classe permite ao usuário ou gerente adicionar clientes e remover clientes de uma lista,adicionar e remover mesa de uma lista,alocar mesa para um cliente específico e liberar mesa caso ela esteja alocada
*Deve ser melhorada com o tempo,de acordo com oque o professor colocará
*/
public class Restaurante {
 //#region atributos
    
    static List<Mesa> mesas = new ArrayList<>();
    FilaDeEspera filaDeEspera = new FilaDeEspera();
    List<Cliente> clientes = new ArrayList<>();
    
   //#endregion
    
//Não há necessidade de um construtor,por isso não foi implementado
    
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
}


/**
    *Adiciona uma mesa da lista de mesas com base no código,capacidade e o nome do cliente caso já esteja alocada,caso não esteja,cliente deverá ser null
    *
    *@param cod O código da mesa que deverá ser adicionada
    *@param capacidade A capacidade da mesa
    *@param disponivel A disponibilidade da mesa
*/
public void adicionarMesa(int cod, int capacidade,boolean disponivel,Cliente cliente) {
    Mesa mesa= new Mesa(cod,capacidade,disponivel,cliente);
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
    }
}

    
/**
 * Aloca uma mesa para um cliente com base no código da mesa e no nome do cliente fornecidos.
 * Se a mesa estiver disponível, ela será alocada para o cliente especificado. Caso contrário, uma mensagem será exibida informando que a mesa já está ocupada.
 * Se a mesa não for encontrada,será exibida uma mensagem de que a mesa não foi encontrada
 *
 * @param requisicao ele puxa a requisição da mesa e aloca de acordo com os dados que foram passados para ela
 */
public void alocarMesa(RequisicaoReserva requisicao) {
    int pessoas = requisicao.getPessoas(); 

    for (Mesa mesa : mesas) {
        if (mesa.getCod() == requisicao.getMesa().getCod()) {
            if (mesa.estaDisponivel(pessoas)) { 
                mesa.mudarStatusMesa(requisicao.getCliente());
                mesa.setDisponivel(false);
                mesa.setCliente(requisicao.getCliente());
                return; 
            }
        }
    }
    filaDeEspera.addRequisicaoNaFila(requisicao);
}

/**
 * Libera uma mesa com base no código da mesa fornecido.
 * Se a mesa estiver ocupada, ela será liberada. Caso contrário, uma mensagem será exibida informando que a mesa já está livre.
 * 
 * @param codMesa O código da mesa a ser liberada.
 */
public void liberarMesa(int codMesa) {
    for (Mesa mesa : mesas) {
        if (mesa.getCod() == codMesa) {
            if (!mesa.isDisponivel()) {
                mesa.mudarStatusMesa(null);
                mesa.liberar();
            } 
            return;
        }
    }
}
/**
 * Inicializa a mesa com todos os dados fornecidos de acordo com o requisito do trabalho,o código, a capacidade e se está disponível
 */
public static void inicializaMesas(){
mesas.add(new Mesa(1, 4, true,null));
mesas.add(new Mesa(2, 4, true,null));
mesas.add(new Mesa(3, 4, true,null));
mesas.add(new Mesa(4, 4, true,null));
mesas.add(new Mesa(5, 6, true,null));
mesas.add(new Mesa(6, 6, true,null));
mesas.add(new Mesa(7, 6, true,null));
mesas.add(new Mesa(8, 6, true,null));
mesas.add(new Mesa(9, 8, true,null));
mesas.add(new Mesa(10, 8, true,null));
}
 //#endregion
 //
}
