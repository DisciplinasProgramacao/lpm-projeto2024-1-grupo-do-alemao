package com.grupoalemao.restaurante.Models;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;

import com.grupoalemao.restaurante.exceptions.GlobalExceptions;

/**
 * Terceira versão da classe Restaurante usando stream e collections. Esta classe permite ao usuário ou gerente adicionar e remover clientes de uma lista,
 * adicionar e remover mesas de uma lista, alocar mesas para clientes específicos e liberar mesas caso elas estejam alocadas.
 * Deve ser melhorada com o tempo, de acordo com o que o professor colocar.
 */
public class Restaurante {

    static List<Mesa> mesas = new ArrayList<>();
    FilaDeEspera filaDeEspera = new FilaDeEspera();
    List<Cliente> clientes = new ArrayList<>();
    private static Menu menu;
    private static MenuFechado menuFechado;

    /**
     * Cria um novo pedido para uma mesa com base na lista de IDs de produtos fornecidos.
     *
     * @param mesa       A mesa para a qual o pedido está sendo criado.
     * @param produtoIds A lista de IDs de produtos para o pedido.
     * @return O pedido criado.
     * @throws GlobalExceptions Se algum produto na lista de IDs não for encontrado no menu.
     */
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

    /**
     * Adiciona um produto ao pedido específico.
     *
     * @param pedido  O pedido ao qual o produto será adicionado.
     * @param produto O produto a ser adicionado ao pedido.
     * @throws GlobalExceptions Se o produto for nulo.
     */
    public void adicionarProdutoAoPedido(Pedido pedido, Produto produto) throws GlobalExceptions {
        if (produto != null) {
            if (pedido instanceof PedidoFechado) {
                ((PedidoFechado) pedido).addProduto(produto);
            } else {
                pedido.addProduto(produto);
            }
        } else {
            throw new GlobalExceptions("Produto está errado.");
        }
    }

    /**
     * Exibe o menu do restaurante no console.
     */
    public static void exibirMenu() {
        System.out.println(menu.mostrarMenu());
    }

    public static void exibirMenuFechado() {
        System.out.println(menuFechado.mostrarMenu());
    }

    /**
     * Adiciona um novo cliente à lista de clientes.
     *
     * @param nome O nome do cliente a ser adicionado.
     * @throws GlobalExceptions Se ocorrer algum erro ao adicionar o cliente.
     */
    public void adicionarCliente(String nome) throws GlobalExceptions {
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
     * Adiciona uma mesa à lista de mesas com base no código, capacidade e cliente associado.
     *
     * @param cod        O código da mesa a ser adicionada.
     * @param capacidade A capacidade da mesa.
     * @param disponivel A disponibilidade da mesa.
     * @param cliente    O cliente associado à mesa, ou null se não houver cliente associado.
     * @param pedido     O pedido associado à mesa, ou null se não houver pedido associado.
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
     * Aloca uma mesa para um cliente com base na requisição de reserva fornecida.
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
     * Inicializa as mesas do restaurante com os dados pré-definidos.
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

    public static Menu getMenu() {
        return menu;
    }
    
    public static MenuFechado getMenuFechado() {
        return menuFechado;
    }
    
    public static void inicializarMenus() {
        menu = new Menu();
        menuFechado = new MenuFechado();
    }
    
}
