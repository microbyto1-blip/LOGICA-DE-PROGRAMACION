
import java.util.Scanner;

public class asistenciaalumnos {

    public static void main(String[] args) {

        // Arreglo con la lista de los 27 alumnos
        String[] alumnos = {
            "Álvarez Urrea Chelsea Jeraldyn",
            "Avila Ramirez Emmanuel",
            "Escareño Solorio Juan Mauricio",
            "Escobedo Guerra Victor Manuel",
            "González De Alba Francisco Javier",
            "Gonzalez Rossi Santiago",
            "Hernandez Aguilar Emiliano",
            "Lozano Aldana José Mariano",
            "Macias Hernandez Luis Leonardo",
            "Manrique Morales Fernanda Arely",
            "Marquez Esparza Saul Alejandro",
            "Meza Lozano Barbara",
            "Montoya Sandoval Viery Dassaeb",
            "Ornelas González Gael",
            "Pimentel Dolores Angel Salvador",
            "Piñon Garcia Axel Emmanuel",
            "Ramírez Zaldumbide Ignacio Xavier",
            "Rodríguez Arellano Cruz Ángel",
            "Rodríguez Santoyo Diego Tadeo",
            "Sánchez Álvarez Ingrid Regina",
            "Sierra Perez José Angel",
            "Torres Gonzalez Cesar Santiago",
            "Tovar Romero Jhostyn Alexander",
            "Trejo Hernández Jorge Alonso",
            "Vazquez Gomez Angel De Jesus",
            "Vilchis Perez Jose Miguel",
            "Viveros Tellez Kevin"
        };

        boolean[] asistencia = new boolean[alumnos.length];
        Scanner consola = new Scanner(System.in);

        System.out.println("=== SISTEMA DE PASE DE LISTA ===");
        System.out.println("Escribe 's' si asistió o 'n' si faltó.\n");

        // 1. Registrar la asistencia de cada alumno
        for (int i = 0; i < alumnos.length; i++) {

            String respuesta;

            while (true) {
                System.out.print((i + 1) + ". ¿Asistió "
                        + alumnos[i] + "? (s/n): ");

                respuesta = consola.nextLine()
                        .trim()
                        .toLowerCase();

                if (respuesta.equals("s")
                        || respuesta.equals("si")
                        || respuesta.equals("sí")) {

                    asistencia[i] = true;
                    break;

                } else if (respuesta.equals("n")
                        || respuesta.equals("no")) {

                    asistencia[i] = false;
                    break;

                } else {
                    System.out.println(
                        "Respuesta no válida. Escribe s o n."
                    );
                }
            }
        }

        int totalAsistencias = 0;
        int totalFaltas = 0;

        // 2. Mostrar el reporte y contar los totales
        System.out.println("\n--- REPORTE DETALLADO DE ASISTENCIA ---");

        for (int i = 0; i < alumnos.length; i++) {

            String estado;

            if (asistencia[i]) {
                estado = "Presente";
                totalAsistencias++;
            } else {
                estado = "Ausente";
                totalFaltas++;
            }

            System.out.println(
                (i + 1) + ". " + alumnos[i] + " -> " + estado
            );
        }

        // 3. Mostrar el resumen final
        System.out.println("\n---------------------------------------");
        System.out.println("Total de alumnos: " + alumnos.length);
        System.out.println("Total de asistencias: " + totalAsistencias);
        System.out.println("Total de faltas: " + totalFaltas);
        System.out.println("---------------------------------------");

        consola.close();
    }
}
