import audio.Cut;
import audio.InvalidCutException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tomov on 27.6.2018 г..
 */
public class CutTest {
    Cut goodCut,badCut;
    String name = "My Song 1";
    double from = 10.0;
    double to = 30.0;
    @Test(expected = InvalidCutException.class)
    public void testConstructorFailNegative() throws InvalidCutException{
        badCut = new Cut("My Song 1",-10,30);
    }
    @Test(expected = InvalidCutException.class)
    public void testConstructorFailFromTo() throws InvalidCutException{
        badCut = new Cut("My Song 1",30,10);
    }
    @Test
    public void testConstructorSuccess() throws InvalidCutException{
        goodCut = new Cut("My Song 1", 10.0,30.0);
        assertEquals("Name field not correct!",goodCut.getName(),name);
        assertEquals("From field not correct!",goodCut.getFrom(),from,0.1);
        assertEquals("To field not correct!",goodCut.getTo(),to,0.1);
    }

}
