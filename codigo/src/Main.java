import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    /**
     * Método principal que inicia a aplicação do restaurante.
     * @param args Os argumentos de linha de comando (não usados).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurante restaurante = new Restaurante();
        boolean sair = false;

        while (!sair) {
            exibirMenu();
            int opcao = scanner.nextInt();
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
        System.out.println("0 - Sair");
        System.out.print("Digite sua Opção: ");
    }

    /**
     * Mostra o status de todas as mesas do restaurante.
     * @param restaurante O restaurante cujas mesas serão verificadas.
     */
    private static void verificarMesas(Restaurante restaurante) {
        for (Mesa mesa : restaurante.mesas) {
            System.out.println("Mesa " + mesa.getCod() + " - Capacidade: " + mesa.getCapacidade() + " - "
                    + (mesa.isDisponivel() ? "Disponível" : "Ocupada"));
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
        RequisicaoReserva requisicao = new RequisicaoReserva(dataReserva, numPessoas, cliente, new Mesa(0, numPessoas));
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
        for (Mesa mesa : restaurante.mesas) {
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
        restaurante.alocarMesa(codMesa, nomeCliente);
    }
}
