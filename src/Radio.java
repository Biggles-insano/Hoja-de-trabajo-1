public class Radio implements IRadio {

    private boolean state, AMFM; // true = AM , false = FM
    private float frequencyAM = 530, frequencyFM = 87.9f;
    private int button;
    private float[] botones = new float[12];

    @Override
    public boolean getState() {
        return state;
    }

    @Override
    public boolean getStateAMFM() {
        return AMFM;
    }

    @Override
    public void tooglePowerOffOn() {
        state = !state;
        if (state) {
            System.out.println("Radio encendido.");
        } else {
            System.out.println("Radio apagado.");
        }
    }

    @Override
    public void toogleAMFM() {
        AMFM = !AMFM;
        System.out.println("Banda cambiada a: " + (AMFM ? "AM" : "FM"));
    }

    @Override
    public void nextFrequency() {
        if (AMFM) { // TRUE sería AM
            if (frequencyAM < 1610) {
                frequencyAM += 10;
            } else {
                frequencyAM = 530;
            }
        } else { // FALSE sería FM
            if (frequencyFM < 107.9) {
                frequencyFM += 0.2;
            } else {
                frequencyFM = 87.9f;
            }
        }
        displayCurrentInfo();
    }

    @Override
    public void previousFrequency() {
        if (AMFM) { // TRUE sería AM
            if (frequencyAM > 530) {
                frequencyAM -= 10;
            } else {
                frequencyAM = 1610;
            }
        } else { // FALSE sería FM
            if (frequencyFM > 87.9) {
                frequencyFM -= 0.2;
            } else {
                frequencyFM = 107.9f;
            }
        }
        displayCurrentInfo();
    }

    @Override
    public float getCurrentFrequency() {
        return AMFM ? frequencyAM : frequencyFM;
    }

    @Override
    public void setFavFrequency(int button) {
        if (button >= 0 && button < botones.length) {
            botones[button] = getCurrentFrequency();
            System.out.println("Frecuencia guardada en el botón " + button + ": " + getCurrentFrequency());
        } else {
            System.out.println("La posición ingresada no es válida. Debe estar en el rango de 0 a 11.");
        }
    }

    @Override
    public float getFavFrequency(int button) {
        if (button >= 0 && button < botones.length) {
            return botones[button];
        } else {
            return -1;
        }
    }

    private void displayCurrentInfo() {
        System.out.println("Frecuencia actual: " + getCurrentFrequency() + ", Banda: " + (AMFM ? "AM" : "FM"));
    }

    public void displayCurrentStation() {
        System.out.println("Emisora actual: " + getCurrentFrequency() + ", Banda: " + (AMFM ? "AM" : "FM"));
    }
}
