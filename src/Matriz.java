import java.util.Random;

public class Matriz {
    private int[][] dados;
    private int linhas;
    private int colunas;

    public Matriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        dados = new int[linhas][colunas];
    }

    public void preencherAleatorio(int limite) {
        Random random = new Random();
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                dados[i][j] = random.nextInt(limite + 1);
            }
        }
    }

    public void preencherManual(int[][] valores) {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                dados[i][j] = valores[i][j];
            }
        }
    }

    public void inserirElemento(int linha, int coluna, int valor) {
        if (linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas) {
            dados[linha][coluna] = valor;
        }
    }

    public void removerElemento(int linha, int coluna) {
        if (linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas) {
            dados[linha][coluna] = 0; // zera o valor
        }
    }

    public void exibir() {
        for (int[] linha : dados) {
            for (int valor : linha) {
                System.out.printf("%4d", valor);
            }
            System.out.println();
        }
    }

    public void ordenarLinhas() {
        for (int i = 0; i < linhas; i++) {
            bubbleSort(dados[i]);
        }
    }

    public void ordenarColunas() {
        for (int j = 0; j < colunas; j++) {
            int[] coluna = new int[linhas];
            for (int i = 0; i < linhas; i++) {
                coluna[i] = dados[i][j];
            }
            bubbleSort(coluna);
            for (int i = 0; i < linhas; i++) {
                dados[i][j] = coluna[i];
            }
        }
    }

    public void ordenarMatrizCompleta() {
        int total = linhas * colunas;
        int[] vetor = new int[total];
        int k = 0;

        // Achatar a matriz
        for (int[] linha : dados) {
            for (int valor : linha) {
                vetor[k++] = valor;
            }
        }

        mergeSort(vetor, 0, vetor.length - 1);

        k = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                dados[i][j] = vetor[k++];
            }
        }
    }


    private void bubbleSort(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    }
    private void mergeSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);
            intercalar(vetor, inicio, meio, fim);
        }
    }

    private void intercalar(int[] vetor, int inicio, int meio, int fim) {
        int[] temp = new int[fim - inicio + 1];
        int i = inicio, j = meio + 1, k = 0;

        while (i <= meio && j <= fim) {
            if (vetor[i] <= vetor[j]) {
                temp[k++] = vetor[i++];
            } else {
                temp[k++] = vetor[j++];
            }
        }

        while (i <= meio) temp[k++] = vetor[i++];
        while (j <= fim) temp[k++] = vetor[j++];

        for (i = 0; i < temp.length; i++) {
            vetor[inicio + i] = temp[i];
        }
    }
}

