package com.grupoalemao.restaurante.models;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    // Objeto da classe Menu para lidar com as opções de produtos
    static Menu menu = new Menu();

    /**
     * Método principal que inicia a aplicação do restaurante.
     * 
     * @param args Os argumentos de linha de comando (não usados).
     */
    public static void main(String[] args) {
        // Scanner para entrada do usuário
        Scanner scanner = new Scanner(System.in);
        // Instância do restaurante
        Restaurante restaurante = new Restaurante();
        // Variável para controlar se o programa deve ser encerrado
        boolean sair = false;

        // Loop principal para exibir o menu e lidar com as opções do usuário
        while (!sair) {
            // Exibe o menu principal
            exibirMenu();
            // Lê a opção do usuário
            int opcao = scanner.nextInt();
            // Executa a ação de acordo com a opção escolhida
            switch (opcao) {
                case 1:
                    verificarMesas(restaurante);
                    break;
                case 2:
                    verificarFila(restaurante);
                    break;
                case 3:
                    solicitarMesa(scanner, restaurante);
                    break;
                case 4:
                    encerrarMesa(scanner, restaurante);
                    break;
                case 5:
                    processarFila(scanner, restaurante);
                    break;
                case 6:
                    adicionarProdutos(scanner, restaurante);
                    break;
                case 7:
                    exibirMenuProdutos();
                    break;
                case 0:
                    sair = true;
                    scanner.close();
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }

    /**
     * Exibe o menu de opções.
     */
    private static void exibirMenu() {
        System.out.println("1 - Verificar mesas");
        System.out.println("2 - Verificar Fila");
        System.out.println("3 - Solicitar Mesa");
        System.out.println("4 - Encerrar Mesa");
        System.out.println("5 - Processar Fila");
        System.out.println("6 - Adicionar Produtos");
        System.out.println("7 - Exibir Menu de Produtos");
        System.out.println("0 - Sair");
        System.out.print("Digite sua Opção: ");
    }

    /**
     * Mostra o status de todas as mesas do restaurante.
     * @param restaurante O restaurante cujas mesas serão verificadas.
     */
    private static void verificarMesas(Restaurante restaurante) {
        System.out.println("Caso o cliente esteja null,ignore porque a mesa não está alocada");
        for (Mesa mesa : Restaurante.mesas) {
            System.out.println("Mesa " + mesa.getCod() + " - Capacidade: " + mesa.getCapacidade() + " - "
                    + (mesa.estaDisponivel(0) ? "Disponível" : "Ocupada") + " - e o cliente alocado é o = " +(mesa.getCliente()));
        }
    }

    /**
     * Mostra o status da fila de espera do restaurante.
     * @param restaurante O restaurante cuja fila de espera será verificada.
     */
    private static void verificarFila(Restaurante restaurante) {
        int numRequisicoes = restaurante.filaDeEspera.getNumRequisicoes();
        if (numRequisicoes == 0) {
            System.out.println("Não há requisições na fila.");
        } else {
            System.out.println("Requisições na fila: " + numRequisicoes);
            System.out.println("Número de Pessoas:");
            System.out.println(restaurante.filaDeEspera.getRequisicoes());
            System.out.println("Clientes:");
            System.out.println(restaurante.filaDeEspera.getRequisicoesCliente());
        }
    }

    /**
     * Solicita uma mesa no restaurante.
     * @param scanner O scanner de entrada.
     * @param restaurante O restaurante onde a mesa será solicitada.
     */
    private static void solicitarMesa(Scanner scanner, Restaurante restaurante) {
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.next();
        System.out.print("Digite o telefone do cliente: ");
        String telefoneCliente = scanner.next();
        Cliente cliente = new Cliente(nomeCliente, telefoneCliente);
        System.out.print("Digite a data da reserva (AAAA-MM-DD): ");
        String dataReservaString = scanner.next();
        LocalDate dataReserva = LocalDate.parse(dataReservaString);
        System.out.print("Digite o número de pessoas: ");
        int numPessoas = scanner.nextInt();
        restaurante.adicionarCliente(nomeCliente, telefoneCliente);
        RequisicaoReserva requisicao = new RequisicaoReserva(dataReserva, numPessoas, cliente, new Mesa(0, numPessoas,true,cliente));
        restaurante.filaDeEspera.addRequisicaoNaFila(requisicao);
        System.out.println("Requisição de mesa adicionada com sucesso!");
    }

   /**
     * Encerra uma mesa no restaurante.
     * @param scanner O scanner de entrada.
     * @param restaurante O restaurante onde a mesa será encerrada.
     */
    private static void encerrarMesa(Scanner scanner, Restaurante restaurante) {
        System.out.print("Digite o código da mesa a ser encerrada: ");
        int codMesa = scanner.nextInt();
        Mesa mesaEncerrar = null;
        for (Mesa mesa : Restaurante.mesas) {
            if (mesa.getCod() == codMesa) {
                mesaEncerrar = mesa;
                break;
            }
        }
        if (mesaEncerrar != null) {
            restaurante.liberarMesa(codMesa);
            System.out.println("Mesa encerrada com sucesso.");
        } else {
            System.out.println("Mesa não encontrada.");
        }
    }

     /**
     * Aloca um cliente em uma mesa do restaurante.
     * @param scanner O scanner de entrada.
     * @param restaurante O restaurante onde a mesa será alocada.
     */
    private static void processarFila(Scanner scanner, Restaurante restaurante) {
        System.out.print("Digite o código da mesa para alocar o cliente: ");
        int codMesa = scanner.nextInt();
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.next();
        System.out.print("Digite a quantidade de pessoas: ");
        int pessoas = scanner.nextInt();
    
        Cliente cliente = new Cliente(nomeCliente, "");

        Mesa mesa = new Mesa(codMesa, pessoas, true, cliente);
    
        RequisicaoReserva requisicao = new RequisicaoReserva(LocalDate.now(), pessoas, cliente, mesa);

        restaurante.alocarMesa(requisicao);
    }

    /**
     * Adiciona produtos ao pedido do cliente.
     * 
     * @param scanner    O scanner de entrada.
     * @param restaurante O restaurante onde o pedido será adicionado.
     */
    private static void adicionarProdutos(Scanner scanner, Restaurante restaurante) {
        System.out.println("Escolha os produtos:");
      System.out.println(menu.mostrarMenu());
      
    }       

    /**
     * Exibe o menu de produtos disponíveis.
     */
    private static void exibirMenuProdutos() {
        System.out.println("Menu de Produtos:");
        menu.mostrarMenu();
    }
}