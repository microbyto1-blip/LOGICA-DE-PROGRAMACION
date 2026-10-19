
import java.util.Scanner;

public class CarreraAritmetica {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double entrada = 25;
        double promedio;
        int mes;
        int residuo;
        int n;
        int valor;
        int suma = 0;
        int divisor;

        System.out.println("=== CARRERA ARITMETICA ===");
        System.out.println("Dato inicial: " + entrada);

        // Solicitar mes de nacimiento
        do {
            System.out.print("¿En que mes naciste? (1-12): ");
            mes = sc.nextInt();
        } while (mes < 1 || mes > 12);

        // ETAPA 1: PROMEDIO
        promedio = (entrada + mes) / 2.0;
        entrada = entrada + promedio;

        System.out.println("\nEtapa 1: Promedio");
        System.out.println("Promedio: " + promedio);
        System.out.println("Resultado: " + entrada);

        // ETAPA 2: RESIDUO
        residuo = (int) entrada % mes;
        entrada = entrada + residuo;

        System.out.println("\nEtapa 2: Residuo");
        System.out.println("Residuo: " + residuo);
        System.out.println("Resultado: " + entrada);

        // ETAPA 3: PORCENTAJE DEL 12%
        entrada = entrada + (entrada * 0.12);

        System.out.println("\nEtapa 3: Porcentaje del 12%");
        System.out.println("Resultado: " + entrada);

        // ETAPA 4: SUMA DE N VALORES ENTEROS
        System.out.print("\n¿Cuantos valores enteros deseas sumar?: ");
        n = sc.nextInt();

        suma = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Ingresa el valor " + i + ": ");
            valor = sc.nextInt();
            suma = suma + valor;
        }

        entrada = entrada + suma;

        System.out.println("\nEtapa 4: Suma de valores");
        System.out.println("Suma de valores: " + suma);
        System.out.println("Resultado: " + entrada);

        // ETAPA 5: DIVISION
        do {
            System.out.print("\nElige un divisor (1-9): ");
            divisor = sc.nextInt();
        } while (divisor < 1 || divisor > 9);

        entrada = entrada / divisor;

        System.out.println("\nEtapa 5: Division");
        System.out.println("Resultado final: " + entrada);

        System.out.println("\n=== FIN DE LA CARRERA ===");

        sc.close();
    }
}
