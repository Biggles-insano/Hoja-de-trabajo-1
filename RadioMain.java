import java.util.Scanner;

public class RadioMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Radio radio = new Radio();  // Instancia de la clase Radio

        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Prende el radio");
            System.out.println("2. Cambia de AM a FM a AM");
            System.out.println("3. Avanzar en el dial de las emisoras. Al llegar al final del dial inicia nuevamente.");
            System.out.println("4. Salir");
            System.out.print("Ingresa la opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    radio.tooglePowerOffOn();
                    System.out.println("Estado del radio: " + (radio.getState() ? "Encendido" : "Apagado"));
                    break;
                case 2:
                    radio.toogleAMFM();
                    System.out.println("Banda actual: " + (radio.getStateAMFM() ? "AM" : "FM"));
                    break;
                case 3:
                    radio.nextFrequency();
                    System.out.println("Frecuencia actual: " + radio.getCurrentFrequency());
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }

        } while (opcion != 4);

        scanner.close();
    }
}
