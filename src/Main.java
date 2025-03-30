import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número de linhas e colunas:");
        int linhas = scanner.nextInt();
        int colunas = scanner.nextInt();
        Matriz matriz = new Matriz(linhas, colunas);
        System.out.println("Preencher com (true/false):");
        matriz.preencherMatriz(scanner.nextBoolean());

        System.out.println("Matriz:");
        matriz.exibirMatriz();

        System.out.println("Ordenando por linhas:");
        matriz.ordenarLinhas();
        matriz.exibirMatriz();

        System.out.println("Ordenando por colunas:");
        matriz.ordenarColunas();
        matriz.exibirMatriz();

        System.out.println("Ordenando a matriz como um vetor:");
        matriz.ordenarMatrizCompleta();
        matriz.exibirMatriz();
    }
}