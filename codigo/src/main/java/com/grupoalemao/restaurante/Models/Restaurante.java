package com.grupoalemao.restaurante.Models;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.grupoalemao.restaurante.exceptions.GlobalExceptions;

import java.util.ArrayList;

/**
 * Terceira versão da classe Restaurante usando stream e collections. Esta classe permite ao usuário ou gerente adicionar e remover clientes de uma lista,
 * adicionar e remover mesas de uma lista, alocar mesas para clientes específicos e liberar mesas caso elas estejam alocadas.
 * Deve ser melhorada com o tempo, de acordo com o que o professor colocar.
 */
public class Restaurante {
    //#region atributos
    static List<Mesa> mesas = new ArrayList<>();
    FilaDeEspera filaDeEspera = new FilaDeEspera();
    List<Cliente> clientes = new ArrayList<>();
    private Menu menu;
    //#endregion

    // Não há necessidade de um construtor, por isso não foi implementado
    // Construtor sem argumentos
    public Restaurante() {
        // Inicialize os atributos do objeto aqui, se necessário
    }

    public Pedido criarPedido(Mesa mesa, List<Integer> produtoIds) throws GlobalExceptions {
        Pedido pedido = new Pedido();
        pedido.setMesa(mesa);
        
        for (int produtoId : produtoIds) {
            Produto produto = menu.getProduto(produtoId);
            if (produto != null) {
                pedido.addProduto(produto);
            } else {
                throw new GlobalExceptions("Produto não encontrado no menu.");
            }
        }
        return pedido;
    }

    // Adiciona um produto ao pedido específico
    public void adicionarProdutoAoPedido(Pedido pedido, Produto produto) throws GlobalExceptions {
        
        if (produto != null) {
            pedido.addProduto(produto);
        } else {
            throw new GlobalExceptions("Produto não encontrado no menu.");
        }
    }

    public void exibirMenu() {
        System.out.println(menu.mostrarMenu());
    }

    //#region métodos

    /**
     * Adiciona um novo cliente à lista de clientes.
     *
     * @param nome O nome do cliente a ser adicionado.
     */
    public void adicionarCliente(String nome) throws GlobalExceptions{
        Cliente cliente = new Cliente(nome);
        clientes.add(cliente);
    }

    /**
     * Remove um cliente da lista de clientes com base no nome fornecido.
     *
     * @param nome O nome do cliente a ser removido.
     */
    public void removerCliente(String nome) {
        clientes = clientes.stream()
                .filter(cliente -> !cliente.getNome().equals(nome))
                .collect(Collectors.toList());
    }

    /**
     * Adiciona uma mesa à lista de mesas com base no código, capacidade e nome do cliente caso já esteja alocada.
     * Caso não esteja, o cliente deverá ser null.
     *
     * @param cod        O código da mesa que deverá ser adicionada.
     * @param capacidade A capacidade da mesa.
     * @param disponivel A disponibilidade da mesa.
     * @param cliente    O cliente que está ocupando a mesa, ou null se não estiver ocupada.
     */
    public void adicionarMesa(int cod, int capacidade, boolean disponivel, Cliente cliente, Pedido pedido) {
        Mesa mesa = new Mesa(cod, capacidade, disponivel, cliente, pedido);
        mesas.add(mesa);
    }

    /**
     * Remove uma mesa da lista de mesas com base no código fornecido.
     *
     * @param cod O código da mesa a ser removida.
     */
    public void removerMesa(int cod) {
        mesas = mesas.stream()
                .filter(mesa -> mesa.getCod() != cod)
                .collect(Collectors.toList());
    }

    /**
     * Aloca uma mesa para um cliente com base no código da mesa e no nome do cliente fornecidos.
     * Se a mesa estiver disponível, ela será alocada para o cliente especificado. Caso contrário, a requisição será adicionada na fila de espera.
     *
     * @param requisicao A requisição de reserva que contém as informações do cliente e da mesa.
     */
    public void alocarMesa(RequisicaoReserva requisicao) {
        int pessoas = requisicao.getPessoas();
        Optional<Mesa> mesaOptional = mesas.stream()
                .filter(mesa -> mesa.getCod() == requisicao.getMesa().getCod() && mesa.estaDisponivel(pessoas))
                .findFirst();

        if (mesaOptional.isPresent()) {
            Mesa mesa = mesaOptional.get();
            mesa.mudarStatusMesa(requisicao.getCliente());
            mesa.setDisponivel(false);
            mesa.setCliente(requisicao.getCliente());
        } else {
            filaDeEspera.addRequisicaoNaFila(requisicao);
        }
    }

    /**
     * Libera uma mesa com base no código da mesa fornecido.
     * Se a mesa estiver ocupada, ela será liberada.
     *
     * @param codMesa O código da mesa a ser liberada.
     */
    public void liberarMesa(int codMesa) {
        mesas.stream()
                .filter(mesa -> mesa.getCod() == codMesa && !mesa.estaDisponivel(0))
                .findFirst()
                .ifPresent(mesa -> {
                    mesa.mudarStatusMesa(null);
                    mesa.liberar();
                });
    }

    /**
     * Inicializa as mesas com todos os dados fornecidos de acordo com o requisito do trabalho: o código, a capacidade e se está disponível.
     */
    public static void inicializaMesas() {
        mesas.add(new Mesa(1, 4, true, null, null));
        mesas.add(new Mesa(2, 4, true, null, null));
        mesas.add(new Mesa(3, 4, true, null, null));
        mesas.add(new Mesa(4, 4, true, null, null));
        mesas.add(new Mesa(5, 6, true, null, null));
        mesas.add(new Mesa(6, 6, true, null, null));
        mesas.add(new Mesa(7, 6, true, null, null));
        mesas.add(new Mesa(8, 6, true, null, null));
        mesas.add(new Mesa(9, 8, true, null, null));
        mesas.add(new Mesa(10, 8, true, null, null));
    }

    /**
     * Obtém uma mesa pelo código fornecido.
     *
     * @param codigo O código da mesa a ser obtida.
     * @return A mesa correspondente ao código fornecido, ou null se não for encontrada.
     */
    public Mesa getMesaByCodigo(int codigo) {
        return mesas.stream()
                .filter(mesa -> mesa.getCod() == codigo)
                .findFirst()
                .orElse(null);
    }
    
    //#endregion
}
