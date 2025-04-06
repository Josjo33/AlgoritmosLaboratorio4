import java.util.Scanner;

public class ViajeMasBarato {

    // calcula el costo minimo entre todos los embarcaderos usando programacion dinamica
    public static int[][] calcularCostosMinimos(int[][] tarifas) {
        int n = tarifas.length;
        int[][] costos = new int[n][n];

        // copiar tarifas iniciales
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                costos[i][j] = tarifas[i][j];
            }
        }

        // aplicar programacion dinamica
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (costos[i][k] + costos[k][j] < costos[i][j]) {
                        costos[i][j] = costos[i][k] + costos[k][j];
                    }
                }
            }
        }
        return costos;
    }

    // metodo para imprimir una matriz
    private static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == Integer.MAX_VALUE) {
                    System.out.print("inf\t");
                } else {
                    System.out.print(matriz[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // pedir numero de embarcaderos
        System.out.print("ingrese el numero de embarcaderos: ");
        int n = scanner.nextInt();

        // inicializar matriz de tarifas
        int[][] tarifas = new int[n][n];

        // pedir tarifas directas
        System.out.println("ingrese las tarifas directas (infinito = 9999):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= j) {
                    tarifas[i][j] = 0; // no se puede remontar el rio
                } else {
                    System.out.print("tarifa de " + i + " a " + j + ": ");
                    tarifas[i][j] = scanner.nextInt();
                }
            }
        }

        // calcular costos minimos
        int[][] costosMinimos = calcularCostosMinimos(tarifas);

        // mostrar resultados
        System.out.println("\nmatriz de costos minimos:");
        imprimirMatriz(costosMinimos);

        // consultar costos especificos
        System.out.print("\ningrese el embarcadero de origen (0-" + (n-1) + "): ");
        int origen = scanner.nextInt();
        System.out.print("ingrese el embarcadero de destino (0-" + (n-1) + "): ");
        int destino = scanner.nextInt();

        System.out.println("el costo minimo de " + origen + " a " + destino + " es: " + 
                          costosMinimos[origen][destino]);
    }
}
