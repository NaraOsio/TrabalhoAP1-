import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de linhas: ");
        int linhas = scanner.nextInt();
        System.out.print("Digite o número de colunas: ");
        int colunas = scanner.nextInt();

        Matriz matriz = new Matriz(linhas, colunas);

        System.out.print("Deseja preencher com valores aleatórios? true ou false: ");
        boolean aleatorio = scanner.nextBoolean();

        if (aleatorio) {
            matriz.preencherAleatorio(100);
        } else {
            int[][] valores = new int[linhas][colunas];
            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {
                    System.out.printf("Digite o valor para [%a][%a]: ", i, j);
                    valores[i][j] = scanner.nextInt();
                }
            }
            matriz.preencherManual(valores);
        }

        System.out.println("\nMatriz criada:");
        matriz.exibir();

        System.out.print("\nDeseja inserir um novo valor?: ");
        if (scanner.nextBoolean()) {
            System.out.print("Linha: ");
            int l = scanner.nextInt();
            System.out.print("Coluna: ");
            int c = scanner.nextInt();
            System.out.print("Valor: ");
            int valor = scanner.nextInt();
            matriz.inserirElemento(l, c, valor);
            System.out.println("Matriz após inserção:");
            matriz.exibir();
        }

        System.out.print("\nDeseja remover um valor? (true/false): ");
        if (scanner.nextBoolean()) {
            System.out.print("Linha: ");
            int l = scanner.nextInt();
            System.out.print("Coluna: ");
            int c = scanner.nextInt();
            matriz.removerElemento(l, c);
            System.out.println("Matriz após remoção:");
            matriz.exibir();
        }

        System.out.println("\nEscolha o tipo de ordenação:");
        System.out.println("1 - Por linhas (Bubble Sort)");
        System.out.println("2 - Por colunas (Bubble Sort)");
        System.out.println("3 - Matriz completa (Merge Sort)");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                matriz.ordenarLinhas();
                break;
            case 2:
                matriz.ordenarColunas();
                break;
            case 3:
                matriz.ordenarMatrizCompleta();
                break;
            default:
                System.out.println("Opção inválida.");
        }

        System.out.println("\nMatriz final:");
        matriz.exibir();

        scanner.close();
    }
}
