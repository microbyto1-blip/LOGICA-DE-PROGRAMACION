import java.util.ArrayList;
import java.util.Scanner;

public class Examensegundoparciañ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] productos = {"Chocolate", "Paleta", "Gomitas", "Galletas"};
        double[] precios = {18.0, 12.0, 25.0, 15.0};
        ArrayList<String> clientes = new ArrayList<>();
        int[] vendidos = new int[4];

        double totalGlobal = 0.0;
        int totalClientes = 0;

        int nClientes = 0;
        while (nClientes <= 0) {
            System.out.print("Cantidad de clientes: ");
            if (sc.hasNextInt()) {
                nClientes = sc.nextInt();
            } else {
                sc.next();
            }
        }
        sc.nextLine();

        for (int i = 1; i <= nClientes; i++) {
            System.out.print("Nombre del cliente " + i + ": ");
            String nombre = sc.nextLine();
            clientes.add(nombre);
            totalClientes++;

            double totalCliente = 0.0;
            String op = "s";

            while (op.equalsIgnoreCase("s")) {
                System.out.println("\nCatálogo:");
                for (int p = 0; p < productos.length; p++) {
                    System.out.println((p + 1) + " | " + productos[p] + " | $" + precios[p]);
                }

                int codigo = 0;
                while (codigo < 1 || codigo > 4) {
                    System.out.print("Código del producto (1-4): ");
                    if (sc.hasNextInt()) {
                        codigo = sc.nextInt();
                    } else {
                        sc.next();
                    }
                }

                int cantidad = 0;
                while (cantidad <= 0) {
                    System.out.print("Cantidad: ");
                    if (sc.hasNextInt()) {
                        cantidad = sc.nextInt();
                    } else {
                        sc.next();
                    }
                }

                double precioUnitario = 0.0;
                switch (codigo) {
                    case 1: precioUnitario = precios[0]; break;
                    case 2: precioUnitario = precios[1]; break;
                    case 3: precioUnitario = precios[2]; break;
                    case 4: precioUnitario = precios[3]; break;
                }

                totalCliente += precioUnitario * cantidad;
                vendidos[codigo - 1] += cantidad;

                sc.nextLine();
                System.out.print("¿Agregar otro producto? (s/n): ");
                op = sc.nextLine();
            }

            totalGlobal += totalCliente;
        }

        System.out.println("\n--- REPORTE DE PRODUCTOS VENDIDOS ---");
        System.out.printf("%-10s | %-10s | %-10s | %-10s\n", "Producto", "Precio", "Vendidos", "Importe");
        for (int i = 0; i < productos.length; i++) {
            double bruto = vendidos[i] * precios[i];
            System.out.printf("%-10s | $%-9.2f | %-10d | $%-9.2f\n", productos[i], precios[i], vendidos[i], bruto);
        }

        double promedio = totalClientes > 0 ? totalGlobal / totalClientes : 0;

        System.out.println("\n--- REPORTE FINAL ---");
        System.out.println("Total clientes atendidos: " + totalClientes);
        System.out.println("Lista de clientes:");
        for (String c : clientes) {
            System.out.println("- " + c);
        }
        System.out.println("Total recaudado: $" + totalGlobal);
        System.out.println("Promedio de venta por cliente: $" + promedio);

        sc.close();
    }
}