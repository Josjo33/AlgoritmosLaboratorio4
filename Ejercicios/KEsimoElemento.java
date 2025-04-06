import java.util.Scanner;

public class KEsimoElemento {

    // metodo principal para encontrar el k-esimo elemento mas pequeño
    public static int encontrarKesimo(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            throw new IllegalArgumentException("k debe estar entre 1 y " + arr.length);
        }
        return quickSelect(arr, 0, arr.length - 1, k - 1); // k-1 porque trabajamos con indices base 0
    }

    // algoritmo quickselect 
    private static int quickSelect(int[] arr, int izquierda, int derecha, int k) {
        if (izquierda == derecha) {
            return arr[izquierda];
        }

        int indicePivote = particion(arr, izquierda, derecha);

        if (k == indicePivote) {
            return arr[k];
        } else if (k < indicePivote) {
            return quickSelect(arr, izquierda, indicePivote - 1, k);
        } else {
            return quickSelect(arr, indicePivote + 1, derecha, k);
        }
    }

    // particion similar a quicksort
    private static int particion(int[] arr, int izquierda, int derecha) {
        int pivote = arr[derecha]; // elegimos el ultimo elemento como pivote
        int i = izquierda;

        for (int j = izquierda; j < derecha; j++) {
            if (arr[j] <= pivote) {
                intercambiar(arr, i, j);
                i++;
            }
        }
        intercambiar(arr, i, derecha);
        return i;
    }

    // metodo auxiliar para intercambiar elementos
    private static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // entrada interactiva
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // pedir el arreglo
        System.out.print("ingrese el numero de elementos: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("ingrese los elementos uno por uno:");
        for (int i = 0; i < n; i++) {
            System.out.print("elemento " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        // pedir k
        System.out.print("ingrese el valor de k: ");
        int k = scanner.nextInt();

        // calcular y mostrar resultado
        try {
            int resultado = encontrarKesimo(arr, k);
            System.out.println("el " + k + "-esimo elemento mas pequeno es: " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
