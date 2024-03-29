import java.util.Scanner;

/**
 * Clase principal para la interacción con la instancia de Radio.
 * Esta clase contiene el método main que permite a los usuarios interactuar con un radio
 * a través de una interfaz de texto en la consola.
 */
public class RadioMain {
    /**
     * Método principal que se ejecuta al iniciar el programa.
     * Establece un menú interactivo para controlar una instancia de Radio.
     *
     * @param args Argumentos pasados por línea de comandos (no utilizados en este programa).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IRadio radio = new Radio();  // Instancia de la clase Radio
        boolean continuar = true, subContinuar = true;
        int opcion, button;

        while (continuar) {
            System.out.println("Menú:");
            System.out.println("1. Prende el radio");
            System.out.println("2. Salir");
            System.out.print("Ingresa la opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    radio.tooglePowerOffOn();
                    System.out.println("Estado del radio: " + (radio.getState() ? "Encendido" : "Apagado"));
                    subContinuar = true;
                    while (subContinuar) {                                
                        System.out.println("Banda actual: " + (radio.getStateAMFM() ? "AM" : "FM"));
                        System.out.println("-------------------------------------------------------");

                        System.out.println("1. Cambia de AM a FM a AM");
                        System.out.println("2. Avanzar en el dial de las emisoras. Al llegar al final del dial inicia nuevamente.");
                        System.out.println("3. Retroceder en el dial de las emisoras. Al llegar al inicio del dial inicia nuevamente.");
                        System.out.println("4. Guardar la emisora actual en favoritos");
                        System.out.println("5. Seleccionar una emisora favorita");
                        System.out.println("6. Apagar radio");

                        opcion = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcion) {
                            case 1:
                                System.out.println("Banda actual: " + (radio.getStateAMFM() ? "AM" : "FM"));
                                radio.toogleAMFM();
                                subContinuar = volverAlMenu(scanner, " al menú? ", radio);
                                break;

                            case 2:
                                System.out.println("Frecuencia actual: " + radio.getCurrentFrequency());
                                radio.nextFrequency();                                
                                subContinuar = volverAlMenu(scanner, " al menú? ", radio);

                                break;

                            case 3:
                                System.out.println("Frecuencia actual: " + radio.getCurrentFrequency());
                                radio.previousFrequency();
                                subContinuar = volverAlMenu(scanner, " al menú? ", radio);
                                break;

                            case 4:
                                System.out.println("Usted se encuentra en: " + (radio.getStateAMFM() ? "AM" : "FM"));
                                System.out.println("Frecuencia actual: " + radio.getCurrentFrequency());

                                System.out.println("Seleccione el boton para guardar en favoritos:");
                                button = scanner.nextInt();
                                scanner.nextLine();

                                radio.setFavFrequency(button);

                                System.out.println("Frecuencia " + radio.getFavFrequency(button) + " guardada en el boton: " + button);

                                subContinuar = volverAlMenu(scanner, " al menú? ", radio);
                                break;

                            case 5:
                                System.out.println("Seleccione el boton de la frecuencia favorita");
                                button = scanner.nextInt();
                                scanner.nextLine();

                                System.out.println("La frecuencia es: " + radio.getFavFrequency(button));

                                subContinuar = volverAlMenu(scanner, " al menú? ", radio);
                                break;

                            case 6:
                                System.out.println("Saliendo del programa...");
                                subContinuar = false;
                                break;
                            default:
                                System.out.println("Opción no válida. Inténtalo de nuevo.");
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Saliendo del programa...");
                    continuar = false;
                    break;
            }
        }
        scanner.close();
    }

    private static boolean volverAlMenu(Scanner scanner, String eleccion, IRadio radio) {
        System.out.println("¿Desea" + eleccion + "(1: Sí, 0: No): ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion == 0) {
            System.out.println("Apagando la radio...");
            radio.tooglePowerOffOn();
            return false;
        } else {
            return true;
        }
    }
}
