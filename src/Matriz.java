import java.util.Random;
import java.util.Scanner;

public class Matriz {
    private int[][] matriz;
    private int linhas, colunas;

    public Matriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.matriz = new int[linhas][colunas];
    }
    public void preencherMatriz(boolean aleatorio) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = aleatorio ? rand.nextInt(100) : scanner.nextInt();
            }
        }
    }
    public void inserirElemento(int linha, int coluna, int valor) {
        if (linha < linhas && coluna < colunas) {
            matriz[linha][coluna] = valor;
        }
    }
    public void removerElemento(int linha, int coluna) {
        if (linha < linhas && coluna < colunas) {
            matriz[linha][coluna] = 0;
        }
    }
    public void exibirMatriz() {
        for (int[] linha : matriz) {
            for (int elemento : linha) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }
    public void ordenarLinhas() {
        for (int[] linha : matriz) {
            bubbleSort(linha);
        }
    }
    public void ordenarColunas() {
        for (int j = 0; j < colunas; j++) {
            int[] coluna = new int[linhas];
            for (int i = 0; i < linhas; i++) {
                coluna[i] = matriz[i][j];
            }
            bubbleSort(coluna);
            for (int i = 0; i < linhas; i++) {
                matriz[i][j] = coluna[i];
            }
        }
    }
    public void ordenarMatrizCompleta() {
        int[] vetor = new int[linhas * colunas];
        int index = 0;
        for (int[] linha : matriz) {
            for (int elemento : linha) {
                vetor[index++] = elemento;
            }
        }
        mergeSort(vetor, 0, vetor.length - 1);
        index = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = vetor[index++];
            }
        }
    }
    private void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
}