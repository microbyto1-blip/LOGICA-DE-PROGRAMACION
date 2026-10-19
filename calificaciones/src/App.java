import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        String nombre;
        double mate, progra, baseDatos, comunicacion, promedio;
        boolean beca;

        System.out.println("Ingresa el nombre del estudiante:");
        nombre = entrada.nextLine();

        System.out.println("Ingresa la calificacion de Matematicas:");
        mate = entrada.nextDouble();

        System.out.println("Ingresa la calificacion de Programacion:");
        progra = entrada.nextDouble();

        System.out.println("Ingresa la calificacion de Base de Datos:");
        baseDatos = entrada.nextDouble();

        System.out.println("Ingresa la calificacion de Comunicacion:");
        comunicacion = entrada.nextDouble();

        promedio = (mate + progra + baseDatos + comunicacion) / 4;

        System.out.println("Estudiante: " + nombre);
        System.out.println("Promedio general: " + promedio);

        if (promedio < 6) {
            System.out.println("Desempeno: Rezagado");
        } else if (promedio < 8) {
            System.out.println("Desempeno: Aprobado");
        } else if (promedio < 9) {
            System.out.println("Desempeno: Buen desempeno");
        } else {
            System.out.println("Desempeno: Excelencia academica");
        }

        if (promedio >= 9 &&
            mate >= 8 &&
            progra >= 8 &&
            baseDatos >= 8 &&
            comunicacion >= 8) {

            beca = true;

        } else {
            beca = false;
        }

        if (beca == true) {
            System.out.println("Obtiene beca academica del 20% en la siguiente inscripcion");
        } else {
            System.out.println("No obtiene beca academica");
        }

        entrada.close();
    }
}