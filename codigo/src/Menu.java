import java.util.Scanner;

public class Menu {
    static Scanner leitorTeclado = new Scanner(System.in);
    private int opcao;
    private Produto[] produtos = new Produto[100];
    private int posicao = 0;

     
    public Produto[] escolherProdutos() {
        do {
            System.out.println("Comidas:");
            System.out.println("1.Moqueca de Palmito");
            System.out.println("2.Falafel Assado");
            System.out.println("3.Salada Primavera com Macarrão Konjac");
            System.out.println("4.Escondidinho de Inhame");
            System.out.println("5.Strogonoff de Cogumelos");
            System.out.println("6.Caçarola de Legumes");
            System.out.println();
            System.out.println("Bebidas:");
            System.out.println("7.Água");
            System.out.println("8.Copo de suco");
            System.out.println("9.Refrigerante orgânico");
            System.out.println("10.Cerveja vegana");
            System.out.println("11.Taça de vinho vegano");
            System.out.println("0.Sair");
            opcao = Integer.parseInt (leitorTeclado.nextLine());

            switch (opcao) {
                case 1:
                    produtos[posicao] = new MoquecaDePalmito();
                    break;
                case 2:
                    produtos[posicao] = new FalafelAssado();
                    break;
                case 3:
                    produtos[posicao] = new SaladaMacarrao();
                    break;
                case 4:
                    produtos[posicao] = new EscondidinhoInhame();
                    break;
                case 5:
                    produtos[posicao] = new StrogonoffeCogumelos();
                    break;
                case 6:
                    produtos[posicao] = new CacarolaLegumes();
                    break;
                case 7:
                    produtos[posicao] = new Agua();
                    break;
                case 8:
                    produtos[posicao] = new CopoDeSuco();
                    break;
                case 9:
                    produtos[posicao] = new RefrigeranteOrganico();
                    break;
                case 10:
                    produtos[posicao] = new CervejaVegana();
                    break;
                case 11:
                    produtos[posicao] = new VinhoVegano();
                    break;
                default:
                    break;
            }
            posicao++;
        } while (opcao != 0 && posicao < produtos.length);

        leitorTeclado.close();
        return produtos;
    }
}

