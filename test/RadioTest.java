import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RadioTest {
    IRadio radio =  new Radio();

    @Test
    public void testGetStateFalse() {
        
        assertEquals(false, radio.getState());
        
    }

    @Test
    public void testTooglePowerOffOn() {
        //inicia como false
        radio.tooglePowerOffOn();
        //cambia a true
        assertEquals(true, radio.getState());
        
    }

    @Test
    public void testToogleAMFM() {
        //inicia en FM
        radio.toogleAMFM();
        //cambia a AM
        assertEquals(true, radio.getStateAMFM());

    }
    @Test
    public void testGetStateFM() {
        //al ser falso, es FM
        assertEquals(false, radio.getStateAMFM());
    }
    @Test
    public void testGetStateAM() {
        //al ser falso, es FM
        radio.toogleAMFM();
        assertEquals(true, radio.getStateAMFM());
    }

    @Test
    public void testGetCurrentFrequencyFM() {
        assertEquals(87.9f, radio.getCurrentFrequency(),0.001);
    }

    @Test
    public void testGetCurrentFrequencyAM() {
        radio.toogleAMFM();
        assertEquals(530, radio.getCurrentFrequency(),0.1);
    }

    @Test
    public void testNextFrequencyFM() {
        radio.nextFrequency();
        assertEquals(88.1f, radio.getCurrentFrequency(),0.001);
    }

    @Test
    public void testPreviousFrequencyFM() {        
        radio.previousFrequency();
        assertEquals(107.9f, radio.getCurrentFrequency(),0.001);
    }

    @Test
    public void testNextFrequencyAM() {
        radio.toogleAMFM();
        radio.nextFrequency();
        assertEquals(540, radio.getCurrentFrequency(),0.1);
    }

    @Test
    public void testPreviousFrequencyAM() {  
        radio.toogleAMFM();      
        radio.previousFrequency();
        assertEquals(1610, radio.getCurrentFrequency(),0.001);
    }

    @Test
    public void testSetFavFrequencyFM() {
        int button = 5; 
        radio.previousFrequency();
        radio.setFavFrequency(button);
        assertEquals(radio.getCurrentFrequency(), radio.getFavFrequency(button), 0.001);
    }

    @Test
    public void testSetFavFrequencyAM() {
        int button = 5; 
        radio.toogleAMFM();
        radio.previousFrequency();
        radio.setFavFrequency(button);
        assertEquals(radio.getCurrentFrequency(), radio.getFavFrequency(button), 0.001);
    }

    @Test
    public void testGetFavFrequencyFM() {
        radio.previousFrequency();
        radio.setFavFrequency(2);
        int botonValido = 2;
        float frecuenciaEsperada = 107.9f;
        float frecuenciaObtenida = radio.getFavFrequency(botonValido);
        assertEquals(frecuenciaEsperada, frecuenciaObtenida, 0.001);
    
    }

    @Test
    public void testGetFavFrequencyAM() {
        radio.toogleAMFM();
        radio.previousFrequency();
        radio.setFavFrequency(2);
        int botonValido = 2;
        float frecuenciaEsperada = 1610;
        float frecuenciaObtenida = radio.getFavFrequency(botonValido);
        assertEquals(frecuenciaEsperada, frecuenciaObtenida, 0.1);
    
    }

}
