package Actividades;

/**
 * Representa los límites de un subarreglo (prim, ult) en un array.
 */
public class Limits {
    public int[] array;
    public int prim;
    public int ult;

    public Limits(int[] array, int prim, int ult) {
        this.array = array;
        this.prim = prim;
        this.ult = ult;
    }

    // Longitud del subarreglo
    public int length() {
        return ult - prim + 1;
    }
}