package Actividades;

public class NaiveRodCutting {
    /**
     * Solución recursiva ineficiente (O(2^n))
     * @param prices Precios por longitud de corte
     * @param length Longitud actual de la varilla
     * @return Valor máximo obtenible
     */
    public static int getMaxValue(int[] prices, int length) {
        if (length <= 0) return 0;
        int maxValue = Integer.MIN_VALUE; 
        
        for (int i = 0; i < length; i++) { 
            maxValue = Math.max(maxValue, prices[i] + getMaxValue(prices, length - i - 1)); 
        }
        return maxValue;
    }

    public static void main(String[] args) { 
        int[] prices = {3, 7, 1, 3, 9}; // Precios por longitud de corte
        int rodLength = prices.length; // Longitud de la varilla
        System.out.println("Valor máximo (Naive): " + getMaxValue(prices, rodLength)); // Salida: 17
    }
}