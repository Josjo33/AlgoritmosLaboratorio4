package Actividades;

public class Hanoi {

    public static void main(String[] args) {
        int numDiscos = 3;  
        int torreAuxiliar = 2; 
        int torreDestino = 3; 

        if (numDiscos <= 0) {
            System.out.println("Error: El número de discos debe ser positivo.");
            return;
        }

        System.out.println("=== Solución Torres de Hanói con " + numDiscos + " discos ===");
        resolverHanoi(numDiscos, torreOrigen, torreDestino, torreAuxiliar);
    }

    public static void resolverHanoi(int discos, int origen, int destino, int auxiliar) {
        if (discos == 1) {
            System.out.println("Mover disco 1 de torre " + origen + " a torre " + destino);
            return;
        }

        // Paso 1: Mover n-1 discos de origen a auxiliar (usando destino como auxiliar)
        resolverHanoi(discos - 1, origen, auxiliar, destino);

        // Paso 2: Mover el disco más grande (n) de origen a destino
        System.out.println("Mover disco " + discos + " de torre " + origen + " a torre " + destino);

        // Paso 3: Mover n-1 discos de auxiliar a destino (usando origen como auxiliar)
        resolverHanoi(discos - 1, auxiliar, destino, origen);
    }
}