```java
import java.util.ArrayList;
import java.util.Scanner;

public class asistenciaalumnos {

    public static void main(String[] args) {

        // 1. Lista de los 27 alumnos utilizando ArrayList
        ArrayList<String> alumnos = new ArrayList<>();

        alumnos.add("Álvarez Urrea Chelsea Jeraldyn");
        alumnos.add("Avila Ramirez Emmanuel");
        alumnos.add("Escareño Solorio Juan Mauricio");
        alumnos.add("Escobedo Guerra Victor Manuel");
        alumnos.add("González De Alba Francisco Javier");
        alumnos.add("Gonzalez Rossi Santiago");
        alumnos.add("Hernandez Aguilar Emiliano");
        alumnos.add("Lozano Aldana José Mariano");
        alumnos.add("Macias Hernandez Luis Leonardo");
        alumnos.add("Manrique Morales Fernanda Arely");
        alumnos.add("Marquez Esparza Saul Alejandro");
        alumnos.add("Meza Lozano Barbara");
        alumnos.add("Montoya Sandoval Viery Dassaeb");
        alumnos.add("Ornelas González Gael");
        alumnos.add("Pimentel Dolores Angel Salvador");
        alumnos.add("Piñon Garcia Axel Emmanuel");
        alumnos.add("Ramírez Zaldumbide Ignacio Xavier");
        alumnos.add("Rodríguez Arellano Cruz Ángel");
        alumnos.add("Rodríguez Santoyo Diego Tadeo");
        alumnos.add("Sánchez Álvarez Ingrid Regina");
        alumnos.add("Sierra Perez José Angel");
        alumnos.add("Torres Gonzalez Cesar Santiago");
        alumnos.add("Tovar Romero Jhostyn Alexander");
        alumnos.add("Trejo Hernández Jorge Alonso");
        alumnos.add("Vazquez Gomez Angel De Jesus");
        alumnos.add("Vilchis Perez Jose Miguel");
        alumnos.add("Viveros Tellez Kevin");

        // 2. Lista para guardar la asistencia
        ArrayList<Boolean> asistencia = new ArrayList<>();

        Scanner consola = new Scanner(System.in);

        System.out.println("=== SISTEMA DE PASE DE LISTA ===");
        System.out.println("Escribe 's' si asistió o 'n' si faltó.\n");

        // 3. Registrar la asistencia
        for (int i = 0; i < alumnos.size(); i++) {

            String respuesta;

            while (true) {

                System.out.print((i + 1) + ". ¿Asistió "
                        + alumnos.get(i) + "? (s/n): ");

                respuesta = consola.nextLine()
                        .trim()
                        .toLowerCase();

                if (respuesta.equals("s")
                        || respuesta.equals("si")
                        || respuesta.equals("sí")) {

                    asistencia.add(true);
                    break;

                } else if (respuesta.equals("n")
                        || respuesta.equals("no")) {

                    asistencia.add(false);
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

        // 4. Mostrar el reporte de asistencia
        System.out.println("\n--- REPORTE DETALLADO DE ASISTENCIA ---");

        for (int i = 0; i < alumnos.size(); i++) {

            if (asistencia.get(i)) {

                System.out.println((i + 1) + ". "
                        + alumnos.get(i) + " -> Presente");

                totalAsistencias++;

            } else {

                System.out.println((i + 1) + ". "
                        + alumnos.get(i) + " -> Ausente");

                totalFaltas++;
            }
        }

        // 5. Mostrar el resumen final
        System.out.println("\n---------------------------------------");
        System.out.println("Total de alumnos: " + alumnos.size());
        System.out.println("Total de asistencias: " + totalAsistencias);
        System.out.println("Total de faltas: " + totalFaltas);
        System.out.println("---------------------------------------");

        consola.close();
    }
}
