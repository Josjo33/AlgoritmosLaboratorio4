package Actividades;

/**
 * Implementación del algoritmo Divide y Vencerás para encontrar la moda.
 */
public class Moda3 {

    // Divide el subarreglo en tres partes: < mediana, = mediana, > mediana
    private static void pivote2(int[] array, int mediana, int prim, int ult, int[] izqDer) {
        int i = prim;
        int j = prim;
        int k = ult;

        while (j <= k) {
            if (array[j] < mediana) {
                swap(array, i, j);
                i++;
                j++;
            } else if (array[j] == mediana) {
                j++;
            } else {
                swap(array, j, k);
                k--;
            }
        }
        izqDer[0] = i;  // Inicio de elementos = mediana
        izqDer[1] = k + 1;  // Inicio de elementos > mediana
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Algoritmo principal
    public static int moda3(int[] array, int prim, int ult) {
        SetVectors heterogeneo = new SetVectors();
        SetVectors homogeneo = new SetVectors();
        heterogeneo.insertar(new Limits(array, prim, ult));

        while (heterogeneo.longMayor() > homogeneo.longMayor()) {
            Limits p = heterogeneo.mayor();
            int mediana = p.array[(p.prim + p.ult) / 2];

            int[] izqDer = new int[2];
            pivote2(p.array, mediana, p.prim, p.ult, izqDer);

            Limits p1 = new Limits(p.array, p.prim, izqDer[0] - 1);
            Limits p2 = new Limits(p.array, izqDer[0], izqDer[1] - 1);
            Limits p3 = new Limits(p.array, izqDer[1], p.ult);

            if (p1.length() > 0) heterogeneo.insertar(p1);
            if (p3.length() > 0) heterogeneo.insertar(p3);
            if (p2.length() > 0) homogeneo.insertar(p2);
        }

        if (homogeneo.esVacio()) {
            return array[prim];  // Todos los elementos son únicos
        }

        Limits moda = homogeneo.mayor();
        homogeneo.destruir();
        heterogeneo.destruir();
        return moda.array[moda.prim];
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 2, 3, 3, 4, 4, 4, 4};
        System.out.println("Moda: " + moda3(array, 0, array.length - 1));  // Salida: 4
    }
}