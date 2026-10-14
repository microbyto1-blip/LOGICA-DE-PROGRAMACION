
import java.util.Scanner;

public class MayorMenor {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int[] numeros = new int[10];
        int mayor, menor;
        int posicionMayor = 0;
        int posicionMenor = 0;

        // 1. Leer los diez números
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Ingresa el numero " + (i + 1) + ": ");
            numeros[i] = teclado.nextInt();
        }

        // 2. Inicializar mayor y menor con el primer número
        mayor = numeros[0];
        menor = numeros[0];

        // 3. Recorrer el arreglo para encontrar mayor y menor
        for (int i = 1; i < numeros.length; i++) {

            if (numeros[i] > mayor) {
                mayor = numeros[i];
                posicionMayor = i;
            }

            if (numeros[i] < menor) {
                menor = numeros[i];
                posicionMenor = i;
            }
        }

        // 4. Mostrar los resultados
        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Numero mayor: " + mayor);
        System.out.println("Posicion del mayor: " + (posicionMayor + 1));
        System.out.println("Numero menor: " + menor);
        System.out.println("Posicion del menor: " + (posicionMenor + 1));

        teclado.close();
    }
}
