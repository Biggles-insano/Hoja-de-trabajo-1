import static org.junit.Assert.assertEquals;

import org.junit.Test;



public class RadioTest {
    @Test
    public void testGetCurrentFrequency() {

    }


    @Test
    public void testGetStateFalse() {

        IRadio radio =  new Radio();

        assertEquals(false, radio.getState());
        
    }

    @Test
    public void testGetStateAMFM() {

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

    @Test
    public void testToogleAMFM() {

    }

    @Test
    public void testTooglePowerOffOn() {
        IRadio radio =  new Radio();
        //inicia como false
        radio.tooglePowerOffOn();
        //cambia a true
        assertEquals(true, radio.getState());
        
    }
}
