import java.util.List;
import java.util.ArrayList;


public class restaurante {

    List<Mesa> mesas = new ArrayList<>();
    FilaDeEspera filaDeEspera = new FilaDeEspera();
    List<Cliente> clientes = new ArrayList<>();
  

    //Adiciona cliente pelo nome e pelo telefone do mesmo na lista.
   public void adicionarCliente(String nome, String telefone) {
    Cliente cliente = new Cliente(nome, telefone);
    clientes.add(cliente);
}

//Remove cliente pelo nome do mesmo.Pegando o nome como parâmetro.
public void removerCliente(String nome) {
    for (Cliente cliente : clientes) {
        if (cliente.getNome().equals(nome)) {
            clientes.remove(cliente);
            return;
        }
    }
    System.out.println("Cliente não encontrado.");
}


//Adiciona mesa,com parâmetros de código,capacidade e o cliente que está adicionando-a
public void adicionarMesa(int cod, int capacidade,String cliente) {
    Mesa mesa= new Mesa(cod, capacidade, cliente);
    mesas.add(mesa);
}


//Remove mesa de acordo com o código
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
//Aloca mesa pelo código da mesa e pelo nome do cliente com 3 possibilidades,a mesa já está alocada/mesa está ocupada e mesa não foi encontrada
public void alocarMesa(int codMesa, String nomeCliente) {
    for (Mesa mesa : mesas) {
        if (mesa.getCod() == codMesa) {
            if (mesa.isDisponivel()) {
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
//Libera a mesa de acordo com o código da mesma.Caso não ache o código,mostra mensagem de erro.
public void liberarMesa(int codMesa) {
    for (Mesa mesa : mesas) {
        if (mesa.getCod() == codMesa) {
            if (!mesa.isDisponivel()) {
                mesa.liberar();
                System.out.println("Mesa liberada.");
            } else {
                System.out.println("A mesa já está livre.");
            }
            return;
        }
    }
    System.out.println("Mesa não encontrada.");
}

}
