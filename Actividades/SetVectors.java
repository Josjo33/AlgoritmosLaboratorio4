package Actividades;

import java.util.ArrayList;
import java.util.List;

/**
 * Maneja conjuntos de subarreglos (homogéneos y heterogéneos).
 */
public class SetVectors {
    private List<Limits> vectors;

    public SetVectors() {
        this.vectors = new ArrayList<>();
    }

    // Inserta un subarreglo si no está vacío
    public void insertar(Limits p) {
        if (p.prim <= p.ult) {
            vectors.add(p);
        }
    }

    // Extrae el subarreglo de mayor longitud
    public Limits mayor() {
        Limits mayor = vectors.get(0);
        for (Limits p : vectors) {
            if (p.length() > mayor.length()) {
                mayor = p;
            }
        }
        vectors.remove(mayor);
        return mayor;
    }

    // Longitud del subarreglo más grande
    public int longMayor() {
        if (vectors.isEmpty()) return 0;
        return mayor().length();
    }

    // Verifica si el conjunto está vacío
    public boolean esVacio() {
        return vectors.isEmpty();
    }

    // Libera memoria
    public void destruir() {
        vectors.clear();
    }
}