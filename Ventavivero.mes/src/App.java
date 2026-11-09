
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Productos y sus precios
        String[] productos = {
            "Cactus", "Suculenta", "Maceta",
            "Tierra", "Fertilizante"
        };

        double[] precios = {45.5, 35.5, 60, 80, 95};

        // Días de venta
        String[] dias = {
            "Lunes", "Martes", "Miercoles",
            "Jueves", "Viernes", "Sabado"
        };

        // Matriz para almacenar los montos de venta
        double[][] ventas = new double[6][5];

        int unidades;

        // Captura de unidades vendidas
        for (int i = 0; i < 6; i++) {

            System.out.println("\n--- " + dias[i] + " ---");

            for (int j = 0; j < 5; j++) {

                System.out.print("Unidades vendidas de "
                        + productos[j] + ": ");

                unidades = entrada.nextInt();

                // Calcular el monto de venta
                ventas[i][j] = unidades * precios[j];
            }
        }

        // Mostrar resultados
        System.out.println("\n========== REPORTE DE VENTAS ==========");

        System.out.printf("%-12s", "Dia");

        for (int j = 0; j < 5; j++) {
            System.out.printf("%-15s", productos[j]);
        }

        System.out.println();

        for (int i = 0; i < 6; i++) {

            System.out.printf("%-12s", dias[i]);

            for (int j = 0; j < 5; j++) {

                System.out.printf("$%-14.2f", ventas[i][j]);
            }

            System.out.println();
        }

        entrada.close();
    }
}

