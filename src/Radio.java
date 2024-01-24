/**
 * Clase Radio que implementa la interfaz IRadio.
 * Proporciona funcionalidades para manejar un radio con soporte para bandas AM y FM.
 */

public class Radio implements IRadio {

    private boolean state, AMFM; // true = AM , false = FM
    private float frequencyAM = 530, frequencyFM = 87.9f;
    private float[] botones = new float[12];

    /**
     * Obtiene el estado actual del radio (encendido/apagado).
     *
     * @return true si el radio está encendido, false si está apagado.
     */
    @Override
    public boolean getState() {
        return state;
    }

    /**
     * Obtiene el estado actual de la banda (AM/FM).
     *
     * @return true si la banda actual es AM, false si es FM.
     */
    
    @Override
    public boolean getStateAMFM() {
        return AMFM;
    }

    /**
     * Cambia el estado de encendido/apagado del radio.
     * Imprime el estado actual del radio después del cambio.
     */
    @Override
    public void tooglePowerOffOn() {
        state = !state;
        if (state) {
            System.out.println("Radio encendido.");
        } else {
            System.out.println("Radio apagado.");
        }
    }
    /**
     * Cambia la banda del radio entre AM y FM.
     * Imprime la banda actual después del cambio.
     */
    @Override
    public void toogleAMFM() {
        AMFM = !AMFM;
        System.out.println("Banda cambiada a: " + (AMFM ? "AM" : "FM"));
    }

    /**
     * Avanza a la siguiente frecuencia en la banda actual.
     * En AM, avanza en incrementos de 10. En FM, avanza en incrementos de 0.2.
     * Si se alcanza el final del rango, vuelve al inicio.
     */
    @Override
    public void nextFrequency() {
        if (AMFM) { // TRUE sería AM
            if (frequencyAM < 1610) {
                frequencyAM += 10;
            } else {
                frequencyAM = 530;
            }
        } else { // FALSE sería FM
            if (frequencyFM < 107.9f) {
                Math.round(frequencyFM += 0.2);
            } else {
                frequencyFM = 87.9f;
            }
        }
        displayCurrentInfo();
    }

    /**
     * Retrocede a la frecuencia anterior en la banda actual.
     * En AM, retrocede en decrementos de 10. En FM, retrocede en decrementos de 0.2.
     * Si se alcanza el inicio del rango, vuelve al final.
     */
    @Override
    public void previousFrequency() {
        if (AMFM) { // TRUE sería AM
            if (frequencyAM > 530) {
                frequencyAM -= 10;
            } else {
                frequencyAM = 1610;
            }
        } else { // FALSE sería FM
            if (frequencyFM > 87.9f) {
                Math.round(frequencyFM -= 0.2);
            } else {
                frequencyFM = 107.9f;
            }
        }
        displayCurrentInfo();
    }

    /**
     * Obtiene la frecuencia actual dependiendo de la banda (AM/FM).
     *
     * @return la frecuencia actual en la banda seleccionada.
     */
    @Override
    public float getCurrentFrequency() {
        return AMFM ? frequencyAM : frequencyFM;
    }

    /**
     * Guarda la frecuencia actual en uno de los botones de favoritos.
     *
     * @param button el índice del botón donde se guardará la frecuencia (0-11).
     *               Imprime un mensaje si la frecuencia se guarda correctamente o si el índice es inválido.
     */
    @Override
    public void setFavFrequency(int button) {
        if (button >= 0 && button < botones.length) {
            botones[button] = getCurrentFrequency();
            System.out.println("Frecuencia guardada en el botón " + button + ": " + getCurrentFrequency());
        } else {
            System.out.println("La posición ingresada no es válida. Debe estar en el rango de 0 a 11.");
        }
    }

    /**
     * Obtiene la frecuencia guardada en uno de los botones de favoritos.
     *
     * @param button el índice del botón del cual se quiere obtener la frecuencia (0-11).
     * @return la frecuencia guardada en el botón especificado, o -1 si el índice es inválido.
     */
    @Override
    public float getFavFrequency(int button) {
        if (button >= 0 && button < botones.length) {
            return botones[button];
        } else {
            return -1;
        }
    }

    /**
     * Muestra la información actual del radio, incluyendo la frecuencia y la banda.
     */
    private void displayCurrentInfo() {
        System.out.println("Frecuencia actual: " + getCurrentFrequency() + ", Banda: " + (AMFM ? "AM" : "FM"));
    }

    /**
     * Muestra la estación actual del radio, incluyendo la frecuencia y la banda.
     * Método similar a displayCurrentInfo, pero con un mensaje diferente.
     */
    public void displayCurrentStation() {
        System.out.println("Emisora actual: " + getCurrentFrequency() + ", Banda: " + (AMFM ? "AM" : "FM"));
    }
}
