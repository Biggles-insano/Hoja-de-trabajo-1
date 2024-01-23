public class Radio implements IRadio {

    boolean state, AMFM; // true = AM , false = FM
    float frequencyAM=530, frequencyFM=87.9f;
    int button;
    float[] botones = new float[12];

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
    }

    @Override
    public void toogleAMFM() {
        AMFM = !AMFM;
    }

    @Override
    public void nextFrequency() {
        if (AMFM) { //TRUE sería AM
            if (frequencyAM<=1610) {
                frequencyAM += 10; 
            }else{
                frequencyAM=530;
            }
        }else{ //FALSE sería FM
            if (frequencyFM<=107.9) {
                frequencyFM += 0.2; 
            }else{
                frequencyFM=87.9f;
            }
        }
    }

    @Override
    public void previousFrequency() {        
        if (AMFM) { //TRUE sería AM
            if (frequencyAM>=530) {
                frequencyAM -= 10; 
            }else{
                frequencyAM=1610;
            }
        }else{ //FALSE sería FM
            if (frequencyFM>=87.9f) {
                frequencyFM -= 0.2f; 
            }else{
                frequencyFM=107.9f;
            }
        }
    }

    @Override
    public float getCurrentFrequency() {
        if (AMFM) { //TRUE sería AM
            return frequencyAM;
        }else{ //FALSE sería FM
            return frequencyFM;
        }
    }

    @Override
    public void setFavFrequency(int button) {
        if(button>=1 && button<=botones.length){
            botones[button] = getCurrentFrequency();
        }else{
            System.out.println("La posición ingresada no es válida. Debe estar en el rango de 0 a 11.");
        }
    }

    // @Override
    // public float getFavFrequency(int button) {
        
    // }
    
}
