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
                    produtos[posicao] = new MoquecaDePalmito("Moqueca de Palmito", 32);
                    break;
                case 2:
                    produtos[posicao] = new FalafelAssado("Falafel Assado", 20);
                    break;
                case 3:
                    produtos[posicao] = new SaladaMacarrao("Salada Primavera com Macarrão Konjac", 25);
                    break;
                case 4:
                    produtos[posicao] = new EscondidinhoInhame("Escondidinho de Inhame", 18);
                    break;
                case 5:
                    produtos[posicao] = new StrogonoffeCogumelos("Strogonoffe de Cogumelos", 35);
                    break;
                case 6:
                    produtos[posicao] = new CacarolaLegumes("Caçarola de Legumes", 22);
                    break;
                case 7:
                    produtos[posicao] = new Agua("água", 3);
                    break;
                case 8:
                    produtos[posicao] = new CopoDeSuco("Copo de Suco", 7);
                    break;
                case 9:
                    produtos[posicao] = new RefrigeranteOrganico("Refrigerante Orgânico", 7);
                    break;
                case 10:
                    produtos[posicao] = new CervejaVegana("Cerveja Vegana", 9);
                    break;
                case 11:
                    produtos[posicao] = new VinhoVegano("Taça de vinho vegano", 18);
                    break;
            }
            posicao++;
        } while (opcao != 0 && posicao < produtos.length);

        leitorTeclado.close();
        return produtos;
    }
    public void mostrarMenu() {
        System.out.println("Comidas:");
        System.out.println("1. Moqueca de Palmito");
        System.out.println("2. Falafel Assado");
        System.out.println("3. Salada Primavera com Macarrão Konjac");
        System.out.println("4. Escondidinho de Inhame");
        System.out.println("5. Strogonoff de Cogumelos");
        System.out.println("6. Caçarola de Legumes");
        System.out.println();
        System.out.println("Bebidas:");
        System.out.println("7. Água");
        System.out.println("8. Copo de suco");
        System.out.println("9. Refrigerante orgânico");
        System.out.println("10. Cerveja vegana");
        System.out.println("11. Taça de vinho vegano");
        System.out.println("0. Sair");
        System.out.print("Digite sua Opção: ");
    }
}
