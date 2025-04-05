package Actividades;

public class BinarySearchRecursive {
    /**
     * @param arr Arreglo ordenado.
     * @param lo  Índice inicial.
     * @param hi  Índice final.
     * @param x   Elemento a buscar.
     * */
    public int binarySearch(int arr[], int lo, int hi, int x) {
        if (hi >= lo && lo < arr.length) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearch(arr, lo, mid - 1, x);
            return binarySearch(arr, mid + 1, hi, x);
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchRecursive ob = new BinarySearchRecursive();
        int arr[] = { 1, 2, 3, 4, 5 }; // Arreglo ordenado
        int x = 4; // Elemento a buscar
        // Llamada al método de búsqueda binaria
        int position = ob.binarySearch(arr, 0, arr.length - 1, x);
        System.out.println(position == -1 ? "Elemento no encontrado" : "Elemento en índice: " + position);
    }
}