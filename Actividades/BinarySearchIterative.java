package Actividades;

public class BinarySearchIterative {
    /**
     * Realiza una búsqueda binaria iterativa en un arreglo ordenado.
     * @param arr Arreglo ordenado.
     * @param x   Elemento a buscar.
     * @return Índice del elemento o -1 si no se encuentra.
     */
    public int binarySearch(int arr[], int x) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; // Evita overflow
            if (arr[mid] == x)
                return mid;
            if (arr[mid] < x)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1; // Elemento no encontrado
    }

    public static void main(String[] args) {
        BinarySearchIterative ob = new BinarySearchIterative();
        int arr[] = { 1, 2, 3, 4, 5 }; // Arreglo ordenado
        int x = 3; // Elemento a buscar
        // Llamada al método de búsqueda binaria
        int position = ob.binarySearch(arr, x);
        System.out.println(position == -1 ? "Elemento no encontrado" : "Elemento en índice: " + position);
    }
}