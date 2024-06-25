package com.grupoalemao.restaurante.Models;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.grupoalemao.restaurante.exceptions.GlobalExceptions;

public class Main {
    static Menu menu = new Menu();
    static MenuFechado menuFechado = new MenuFechado();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurante restaurante = new Restaurante();
        boolean sair = false;

        Restaurante.inicializaMesas();

        while (!sair) {
            exibirMenuOpcoes();
            try {
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer
                
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
                        fecharConta(scanner, restaurante);
                        break;
                    case 8:
                        exibirCardapios();
                        break;
                    case 0:
                        sair = true;
                        scanner.close();
                        System.out.println("Saindo do programa. Até mais!");
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); // Limpar o buffer
            } catch (NoSuchElementException e) {
                System.out.println("Nenhum elemento encontrado. Verifique a entrada e tente novamente.");
                scanner.nextLine(); // Limpar o buffer
            } catch (IllegalArgumentException e) {
                System.out.println("Argumento inválido: " + e.getMessage());
                scanner.nextLine(); // Limpar o buffer
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                scanner.nextLine(); // Limpar o buffer
            }
        }
    }

    private static void exibirMenuOpcoes() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Verificar mesas");
        System.out.println("2 - Verificar fila de espera");
        System.out.println("3 - Solicitar mesa");
        System.out.println("4 - Encerrar mesa");
        System.out.println("5 - Processar fila de espera");
        System.out.println("6 - Adicionar produtos ao pedido");
        System.out.println("7 - Fechar conta da mesa");
        System.out.println("8 - Exibir cardápios");
        System.out.println("0 - Sair");
        System.out.print("Digite sua opção: ");
    }

    private static void exibirMenuProdutos() {
        System.out.println(menu.mostrarMenu());
    }

/**
 * Mostra o status de todas as mesas do restaurante.
 * @param restaurante O restaurante cujas mesas serão verificadas.
 */
private static void verificarMesas(Restaurante restaurante) {
    for (Mesa mesa : Restaurante.mesas) {
        if (mesa.getCliente() == null) {
            System.out.println("Mesa " + mesa.getCod() + " - Capacidade: " + mesa.getCapacidade() + " - " +
                (mesa.estaDisponivel(0) ? "Disponível" : "Ocupada") + " - Sem pedido registrado");
        } else {
            Pedido pedido = mesa.getPedido();
            System.out.println("Mesa " + mesa.getCod() + " - Capacidade: " + mesa.getCapacidade() + " - " +
                (mesa.estaDisponivel(0) ? "Disponível" : "Ocupada") + " - Cliente alocado: " + mesa.getCliente().getNome());
            
            if (pedido != null) {
                System.out.println("  Produtos no pedido:");
                for (Produto produto : pedido.getProdutos()) {
                    System.out.println("    - " + produto.getNome());
                }
            } else {
                System.out.println("  Sem pedido registrado.");
            }
        }
        System.out.println(); // Adiciona uma linha em branco entre as mesas para melhorar a legibilidade
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
     * Procura uma mesa disponível no array mesas de Restaurante, de acordo com o número de pessoas
     * informadas.
     * @param numPessoas O número de pessoas.
     * @param restaurante O restaurante que possui a lista de mesas existentes.
     * @return A mesa disponível correspondente ao número de pessoas informado.
     */
    private static Mesa encontrarMesaDisponivel(int numPessoas, Restaurante restaurante) {
        for (Mesa mesa : Restaurante.mesas) {
            if (mesa.estaDisponivel(numPessoas) && mesa.getCapacidade() >= numPessoas) {
                return mesa;
            }
        }
        return null;
    }

    /**
     * Solicita uma mesa no restaurante.
     * @param scanner O scanner de entrada.
     * @param restaurante O restaurante onde a mesa será solicitada.
     */
    private static void solicitarMesa(Scanner scanner, Restaurante restaurante) throws GlobalExceptions {
        try {
            System.out.print("Digite o nome do cliente: ");
            String nomeCliente = scanner.nextLine();
            Cliente cliente = new Cliente(nomeCliente);
            System.out.print("Digite o número de pessoas: ");
            int numPessoas = scanner.nextInt();
            scanner.nextLine();
    
            Mesa mesaDisponivel = encontrarMesaDisponivel(numPessoas, restaurante);
            if (mesaDisponivel != null) {
                System.out.print("Deseja um menu fechado? (s/n): ");
                String menuFechadoOpcao = scanner.nextLine();
    
                Pedido pedido;
                if (menuFechadoOpcao.equalsIgnoreCase("s")) {
                    pedido = new PedidoFechado(numPessoas);
                } else {
                    pedido = new Pedido();
                }
    
                RequisicaoReserva requisicao = new RequisicaoReserva(numPessoas, cliente, mesaDisponivel);
                restaurante.alocarMesa(requisicao);
                System.out.println("Mesa " + mesaDisponivel.getCod() + " alocada com sucesso para " + numPessoas + " pessoas.");
            } else {
                System.out.println("Não há mesas disponíveis para " + numPessoas + " pessoas. Cliente adicionado à fila de espera.");
                RequisicaoReserva requisicao = new RequisicaoReserva(numPessoas, cliente, null);
                restaurante.filaDeEspera.addRequisicaoNaFila(requisicao);
            }
        } catch (InputMismatchException e) {
            System.out.println("Número de pessoas inválido. Por favor, insira um número.");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Erro ao solicitar mesa: " + e.getMessage());
            scanner.nextLine();
        }
    }
    

    /**
     * Encerra uma mesa no restaurante.
     * @param scanner O scanner de entrada.
     * @param restaurante O restaurante onde a mesa será encerrada.
     */
    private static void encerrarMesa(Scanner scanner, Restaurante restaurante) throws GlobalExceptions, Exception{
        try {
            System.out.print("Digite o código da mesa a ser encerrada: ");
            int codMesa = scanner.nextInt();
            scanner.nextLine(); 
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
                throw new GlobalExceptions("Mesa com código " + codMesa + " não encontrada.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Código de mesa inválido. Por favor, insira um número.");
            scanner.nextLine(); 
        } catch (Exception e) {
            System.out.println("Erro ao encerrar mesa: " + e.getMessage());
            scanner.nextLine(); 
        }
    }

    /**
     * Aloca um cliente em uma mesa do restaurante.
     * @param scanner O scanner de entrada.
     * @param restaurante O restaurante onde a mesa será alocada.
     */
    private static void processarFila(Scanner scanner, Restaurante restaurante) throws GlobalExceptions, Exception {
        try {
            System.out.print("Digite o código da mesa para alocar o cliente: ");
            int codMesa = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Digite o nome do cliente: ");
            String nomeCliente = scanner.nextLine();
            System.out.print("Digite a quantidade de pessoas: ");
            int pessoas = scanner.nextInt();
            scanner.nextLine(); 

            Cliente cliente = new Cliente(nomeCliente);

            Mesa mesa = new Mesa(codMesa, pessoas, true, cliente, null);

            RequisicaoReserva requisicao = new RequisicaoReserva(pessoas, cliente, mesa);

            restaurante.alocarMesa(requisicao);
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, insira os dados corretamente.");
            scanner.nextLine(); 
        } catch (Exception e) {
            System.out.println("Erro ao processar fila: " + e.getMessage());
            scanner.nextLine(); 
        }
    }

    /**
 * Adiciona produtos ao pedido do cliente.
 * 
 * @param scanner    O scanner de entrada.
 * @param restaurante O restaurante onde o pedido será adicionado.
 */
/**
 * Adiciona produtos ao pedido do cliente e associa o pedido à mesa.
 * 
 * @param scanner    O scanner de entrada.
 * @param restaurante O restaurante onde o pedido será adicionado.
 */
private static void adicionarProdutos(Scanner scanner, Restaurante restaurante) throws GlobalExceptions, Exception {
    try {
        System.out.println("Escolha os produtos:");
        System.out.println(menu.mostrarMenu());

        System.out.print("Digite o número do produto que deseja adicionar ao pedido (0 para finalizar): ");
        int opcaoProduto = scanner.nextInt();
        scanner.nextLine(); 

        Pedido pedido = new Pedido(); // Cria um novo pedido

        while (opcaoProduto != 0) {
            Produto produto = menu.getProduto(opcaoProduto); // Obtém o produto selecionado
            if (produto != null) {
                restaurante.adicionarProdutoAoPedido(pedido, produto);
                System.out.println("Produto adicionado ao pedido: " + produto.getNome());
            } else {
                System.out.println("Produto não encontrado. Por favor, escolha um produto válido.");
            }

            System.out.print("Digite o número do próximo produto (0 para finalizar): ");
            opcaoProduto = scanner.nextInt();
            scanner.nextLine(); 
        }

        // Verifica se o pedido não está vazio antes de fechá-lo
        if (!pedido.getProdutos().isEmpty()) {
            double[] totalConta = pedido.fecharPedido(1);
            System.out.println("Total do pedido: R$" + totalConta[0]);

            // Solicitar e associar o pedido à mesa
            boolean mesaEncontrada = false;
            while (!mesaEncontrada) {
                System.out.print("Digite o código da mesa para associar o pedido: ");
                int codMesa = scanner.nextInt();
                scanner.nextLine();

                Mesa mesa = restaurante.getMesaByCodigo(codMesa);

                if (mesa != null && !mesa.estaDisponivel(0)) {
                    mesa.setPedido(pedido);
                    System.out.println("Pedido associado à Mesa " + codMesa + " com sucesso.");
                    mesaEncontrada = true; // Mesa encontrada e pedido associado com sucesso, sair do loop
                } else {
                    System.out.println("Mesa não encontrada ou não está ocupada. Tente novamente.");
                }
            }
        } else {
            System.out.println("Pedido vazio. Nenhum produto foi adicionado.");
        }

    } catch (InputMismatchException e) {
        System.out.println("Entrada inválida. Por favor, insira um número.");
        scanner.nextLine(); 
    } catch (Exception e) {
        System.out.println("Erro ao adicionar produtos: " + e.getMessage());
        scanner.nextLine(); 
    }
}


 /**
 * Fecha a conta da mesa.
 *
 * @param scanner     O scanner de entrada.
 * @param restaurante O restaurante onde a conta será fechada.
 */
private static void fecharConta(Scanner scanner, Restaurante restaurante) {
    try {
        System.out.print("Digite o código da mesa para fechar a conta: ");
        int codMesa = scanner.nextInt();
        scanner.nextLine();

        Mesa mesa = restaurante.getMesaByCodigo(codMesa);

        if (mesa != null && !mesa.estaDisponivel(0)) {
            Pedido pedido = mesa.getPedido();
            if (pedido != null) {
                double[] totalConta;
                if (pedido instanceof PedidoFechado) {
                    totalConta = ((PedidoFechado) pedido).fecharPedido(mesa.getCapacidade());
                } else {
                    totalConta = pedido.fecharPedido(mesa.getCapacidade());
                }
                System.out.println("Total da conta da Mesa " + codMesa + ": R$" + totalConta[0]);

                // Remover o pedido associado à mesa após fechar a conta
                mesa.removerPedido();
            } else {
                System.out.println("Não há pedidos registrados para a Mesa " + codMesa);
            }
        } else {
            System.out.println("Mesa não encontrada ou não está ocupada.");
        }
    } catch (InputMismatchException e) {
        System.out.println("Código de mesa inválido. Por favor, insira um número.");
        scanner.nextLine();
    } catch (Exception e) {
        System.out.println("Erro ao fechar conta: " + e.getMessage());
        scanner.nextLine();
    }
}

    /**
     * Exibe os cardápios disponíveis, incluindo o menu fechado.
     */
    private static void exibirCardapios() {
        Restaurante.inicializarMenus();
        System.out.println("Cardápios Disponíveis:");
        System.out.println("1. Menu Normal");
        System.out.println(Restaurante.getMenu().mostrarMenu());
        System.out.println("2. Menu Fechado");
        System.out.println(Restaurante.getMenuFechado().mostrarMenu());
    }
}
