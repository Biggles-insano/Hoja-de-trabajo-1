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
    public void testNextFrequency() {

    }

    @Test
    public void testPreviousFrequency() {

    }

    @Test
    public void testSetFavFrequency() {

    }


}
