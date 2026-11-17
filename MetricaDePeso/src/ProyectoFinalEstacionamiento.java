
import java.util.Scanner;

public class MetricaD {
    static Scanner sc = new Scanner(System.in);
    static final double TARIFA = 20.0;
    static int capacidad, ocupados = 0;
    static boolean[] espacios;
    static String[] placas, entradas;
    static int[] minutosEntrada;

    public static void main(String[] args) {
        System.out.println("=== PROYECTO FINAL ESTACIONAMIENTO ===");
        capacidad = leerEntero("Capacidad del estacionamiento: ", 1, 10000);
        espacios = new boolean[capacidad];
        placas = new String[capacidad];
        entradas = new String[capacidad];
        minutosEntrada = new int[capacidad];

        int opcion;
        do {
            System.out.println("\n========== MENU PRINCIPAL ==========");
            System.out.println("1. Registrar entrada");
            System.out.println("2. Registrar salida y cobro");
            System.out.println("3. Consultar disponibilidad");
            System.out.println("4. Consultar tarifa");
            System.out.println("5. Salir");
            opcion = leerEntero("Seleccione: ", 1, 5);

            switch (opcion) {
                case 1: registrarEntrada(); break;
                case 2: registrarSalida(); break;
                case 3: mostrarEspacios(); break;
                case 4: mostrarTarifa(); break;
                case 5: System.out.println("Sistema finalizado."); break;
            }
        } while (opcion != 5);
        sc.close();
    }

    static void registrarEntrada() {
        System.out.println("\n=== REGISTRO DE ENTRADA ===");
        mostrarEspacios();

        if (ocupados == capacidad) {
            System.out.println("ESTACIONAMIENTO LLENO.");
            return;
        }

        int sugerido = buscarLibre() + 1;
        System.out.println("Espacio sugerido: " + sugerido);
        System.out.println("1. Aceptar  2. Elegir otro  3. Cancelar");
        int opcion = leerEntero("Opcion: ", 1, 3);
        if (opcion == 3) return;

        int id = sugerido;
        if (opcion == 2) {
            id = leerEntero("Numero de espacio: ", 1, capacidad);
            if (espacios[id - 1]) {
                System.out.println("ERROR: Espacio ocupado.");
                return;
            }
        }

        int i = id - 1;
        String placa = leerPlaca();
        if (placaRegistrada(placa)) {
            System.out.println("ERROR: Vehiculo ya registrado.");
            return;
        }

        String hora = leerHora("Hora de entrada (HH:MM): ");
        System.out.println("Vehiculo: " + placa);
        System.out.println("Espacio: " + id + " | Entrada: " + hora);

        if (!confirmar("Confirmar entrada (S/N): ")) {
            System.out.println("Entrada cancelada.");
            return;
        }

        espacios[i] = true;
        placas[i] = placa;
        entradas[i] = hora;
        minutosEntrada[i] = aMinutos(hora);
        ocupados++;

        System.out.println("ENTRADA REGISTRADA CORRECTAMENTE.");
        mostrarTotales();
    }

    static void registrarSalida() {
        System.out.println("\n=== SALIDA Y COBRO ===");
        if (ocupados == 0) {
            System.out.println("No hay vehiculos registrados.");
            return;
        }

        mostrarEspacios();
        int id = leerEntero("Espacio a liberar: ", 1, capacidad);
        int i = id - 1;

        if (!espacios[i]) {
            System.out.println("ERROR: El espacio esta libre.");
            return;
        }

        String salida = leerHora("Hora de salida (HH:MM): ");
        int minutos = aMinutos(salida) - minutosEntrada[i];
        if (minutos < 0) minutos += 1440;

        int horas = (minutos + 59) / 60;
        int totalCentavos = horas * 2000;
        int pagado = 0;

        System.out.println("\n=== RESUMEN PREVIO ===");
        System.out.println("Placa: " + placas[i]);
        System.out.println("Espacio: " + id);
        System.out.println("Entrada: " + entradas[i]);
        System.out.println("Salida: " + salida);
        System.out.println("Duracion: " + minutos / 60 +
                           " horas y " + minutos % 60 + " minutos");
        System.out.println("Horas cobradas: " + horas);
        System.out.println("Total: " + dinero(totalCentavos));

        if (!confirmar("Iniciar cobro (S/N): ")) return;

        while (pagado < totalCentavos) {
            System.out.println("Saldo pendiente: " +
                               dinero(totalCentavos - pagado));
            int abono = leerPago();
            if (abono > Integer.MAX_VALUE - pagado) {
                System.out.println("Monto demasiado grande.");
                continue;
            }
            pagado += abono;

            if (pagado < totalCentavos) {
                System.out.println("Pago insuficiente. Faltan " +
                                   dinero(totalCentavos - pagado));
                System.out.println("1. Agregar pago  2. Cancelar");
                if (leerEntero("Opcion: ", 1, 2) == 2) {
                    System.out.println("Cobro cancelado. Espacio ocupado.");
                    return;
                }
            }
        }

        if (!confirmar("Confirmar salida (S/N): ")) {
            System.out.println("Salida cancelada. Espacio ocupado.");
            return;
        }

        System.out.println("\n========== COMPROBANTE ==========");
        System.out.println("Vehiculo: " + placas[i]);
        System.out.println("Espacio: " + id);
        System.out.println("Entrada: " + entradas[i]);
        System.out.println("Salida: " + salida);
        System.out.println("Tiempo: " + minutos / 60 + " h " +
                           minutos % 60 + " min");
        System.out.println("Horas cobradas: " + horas);
        System.out.println("Tarifa: $20.00 por hora iniciada");
        System.out.println("Importe: " + dinero(totalCentavos));
        System.out.println("Pago recibido: " + dinero(pagado));
        System.out.println("Cambio: " + dinero(pagado - totalCentavos));
        System.out.println("Saldo pendiente: $0.00");
        System.out.println("Estado: PAGADO");
        System.out.println("===============================");

        espacios[i] = false;
        placas[i] = null;
        entradas[i] = null;
        minutosEntrada[i] = 0;
        ocupados--;
        System.out.println("Espacio liberado correctamente.");
        mostrarTotales();
    }

    static void mostrarEspacios() {
        System.out.println("\n=== DISPONIBILIDAD ===");
        for (int i = 0; i < capacidad; i++) {
            System.out.print("Espacio " + (i + 1) + ": ");
            if (espacios[i])
                System.out.println("OCUPADO | " + placas[i] +
                                   " | Entrada: " + entradas[i]);
            else
                System.out.println("DISPONIBLE");
        }
        mostrarTotales();
    }

    static void mostrarTotales() {
        System.out.println("Capacidad: " + capacidad +
                           " | Ocupados: " + ocupados +
                           " | Libres: " + (capacidad - ocupados));
    }

    static void mostrarTarifa() {
        System.out.println("\nTarifa: $20.00 MXN por hora iniciada.");
        System.out.println("30 min = $20 | 60 min = $20 | 61 min = $40");
        System.out.println("Salida anterior a entrada = dia siguiente.");
        mostrarTotales();
    }

    static int buscarLibre() {
        for (int i = 0; i < capacidad; i++)
            if (!espacios[i]) return i;
        return -1;
    }

    static boolean placaRegistrada(String placa) {
        for (int i = 0; i < capacidad; i++)
            if (espacios[i] && placas[i].equals(placa)) return true;
        return false;
    }

    static String leerPlaca() {
        while (true) {
            System.out.print("Placa del vehiculo: ");
            String placa = sc.nextLine().trim().toUpperCase();
            if (placa.matches("[A-Z0-9 -]{1,20}")) return placa;
            System.out.println("ERROR: Placa invalida.");
        }
    }

    static String leerHora(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String hora = sc.nextLine().trim();
            if (hora.matches("([01][0-9]|2[0-3]):[0-5][0-9]"))
                return hora;
            System.out.println("ERROR: Use HH:MM (00:00 a 23:59).");
        }
    }

    static int aMinutos(String hora) {
        return Integer.parseInt(hora.substring(0, 2)) * 60 +
               Integer.parseInt(hora.substring(3, 5));
    }

    static int leerEntero(String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            try {
                int n = Integer.parseInt(sc.nextLine().trim());
                if (n >= min && n <= max) return n;
            } catch (NumberFormatException e) {}
            System.out.println("ERROR: Ingrese un entero entre " +
                               min + " y " + max + ".");
        }
    }

    static int leerPago() {
        while (true) {
            System.out.print("Monto entregado (MXN): ");
            String dato = sc.nextLine().trim();
            if (dato.matches("[0-9]+(\\.[0-9]{1,2})?")) {
                try {
                    java.math.BigDecimal monto =
                        new java.math.BigDecimal(dato).movePointRight(2);
                    return monto.intValueExact();
                } catch (ArithmeticException e) {}
            }
            System.out.println("ERROR: Monto invalido o demasiado grande.");
        }
    }

    static boolean confirmar(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String r = sc.nextLine().trim();
            if (r.equalsIgnoreCase("S")) return true;
            if (r.equalsIgnoreCase("N")) return false;
            System.out.println("Responda S o N.");
        }
    }

    static String dinero(int centavos) {
        return String.format(java.util.Locale.US, "$%d.%02d",
                             centavos / 100, centavos % 100);
    }
}
