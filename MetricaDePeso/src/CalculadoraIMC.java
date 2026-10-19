
import java.util.Scanner;

public class CalculadoraIMC {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        double peso, altura, imc;
        char genero, continuar;
        int opcion;

        do {
            System.out.println("\n=== CALCULADORA DE IMC ===");

            System.out.print("Ingresa tu peso en kilogramos: ");
            peso = entrada.nextDouble();

            System.out.print("Ingresa tu altura en metros: ");
            altura = entrada.nextDouble();

            System.out.print("Ingresa tu genero (M/F): ");
            genero = entrada.next().charAt(0);

            if (peso > 0 && altura > 0) {

                imc = peso / (altura * altura);

                System.out.printf("Tu IMC es: %.2f%n", imc);

                if (imc < 18.5) {
                    opcion = 1;
                } else if (imc < 25) {
                    opcion = 2;
                } else if (imc < 30) {
                    opcion = 3;
                } else if (imc < 35) {
                    opcion = 4;
                } else if (imc < 40) {
                    opcion = 5;
                } else {
                    opcion = 6;
                }

                switch (opcion) {

                    case 1:
                        System.out.println("Clasificacion: Bajo peso");
                        System.out.println("Accion 1: Consultar a un profesional de salud.");
                        System.out.println("Accion 2: Revisar habitos de alimentacion.");
                        break;

                    case 2:
                        System.out.println("Clasificacion: Peso normal");
                        System.out.println("Accion 1: Mantener una alimentacion equilibrada.");
                        System.out.println("Accion 2: Realizar actividad fisica.");
                        break;

                    case 3:
                        System.out.println("Clasificacion: Sobrepeso");
                        System.out.println("Accion 1: Mejorar los habitos alimenticios.");
                        System.out.println("Accion 2: Incrementar la actividad fisica.");
                        break;

                    case 4:
                        System.out.println("Clasificacion: Obesidad grado I");
                        System.out.println("Accion 1: Solicitar orientacion medica.");
                        System.out.println("Accion 2: Establecer habitos saludables.");
                        break;

                    case 5:
                        System.out.println("Clasificacion: Obesidad grado II");
                        System.out.println("Accion 1: Buscar seguimiento profesional.");
                        System.out.println("Accion 2: Elaborar un plan de salud.");
                        break;

                    case 6:
                        System.out.println("Clasificacion: Obesidad grado III");
                        System.out.println("Accion 1: Solicitar evaluacion medica.");
                        System.out.println("Accion 2: Recibir seguimiento especializado.");
                        break;
                }

            } else {
                System.out.println("Error: el peso y la altura deben ser mayores que cero.");
            }

            System.out.print("\nDeseas registrar otra persona? (S/N): ");
            continuar = entrada.next().charAt(0);

        } while (continuar == 'S' || continuar == 's');

        System.out.println("Programa finalizado.");

        entrada.close();
    }
}
