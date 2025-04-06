import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SubconjuntoPotencias {

    // verifica si un numero es potencia de 2
    private static boolean esPotenciaDeDos(int num) {
        return num > 0 && (num & (num - 1)) == 0;
    }

    private static List<Integer> preprocesarArreglo(int[] arr) {
        List<Integer> obligatorios = new ArrayList<>(); // potencias de 2
        List<Integer> permitidos = new ArrayList<>();   // otros numeros

        // 1. identificar potencias de 2 (obligatorias)
        for (int num : arr) {
            if (esPotenciaDeDos(num)) {
                obligatorios.add(num);
            }
        }

        // 2. filtrar multiplos de 5 segun reglas
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (num % 5 == 0) {
                // excluir solo si el siguiente es impar y no es el ultimo
                if (i < arr.length - 1 && arr[i + 1] % 2 != 0) {
                    continue;
                }
            }
            permitidos.add(num);
        }

        // combinar listas sin duplicados
        List<Integer> resultado = new ArrayList<>(obligatorios);
        resultado.addAll(permitidos.stream()
                .filter(num -> !obligatorios.contains(num))
                .collect(Collectors.toList()));
        return resultado;
    }

    // verifica si existe un subconjunto que cumpla las condiciones
    private static boolean existeSubconjunto(List<Integer> numeros, int objetivo) {
        int sumaPotencias = numeros.stream()
                .filter(SubconjuntoPotencias::esPotenciaDeDos)
                .mapToInt(Integer::intValue)
                .sum();
        int objetivoRestante = objetivo - sumaPotencias;

        if (objetivoRestante < 0) return false;
        if (objetivoRestante == 0) return true;

        List<Integer> opcionales = numeros.stream()
                .filter(num -> !esPotenciaDeDos(num))
                .collect(Collectors.toList());
        return backtrack(opcionales, 0, objetivoRestante);
    }

    // metodo de backtracking para encontrar la suma
    private static boolean backtrack(List<Integer> nums, int index, int objetivo) {
        if (objetivo == 0) return true;
        if (index >= nums.size() || objetivo < 0) return false;
        return backtrack(nums, index + 1, objetivo - nums.get(index)) || 
               backtrack(nums, index + 1, objetivo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // pedir n
        System.out.print("ingrese el numero de elementos (n): ");
        int N = scanner.nextInt();

        // pedir elementos uno por uno
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            System.out.print("ingrese el elemento " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        // pedir objetivo
        System.out.print("ingrese el objetivo (suma esperada): ");
        int objetivo = scanner.nextInt();

        // calcular y mostrar resultado
        List<Integer> numerosProcesados = preprocesarArreglo(arr);
        boolean resultado = existeSubconjunto(numerosProcesados, objetivo);
        System.out.println("resultado: " + resultado);
    }
}
