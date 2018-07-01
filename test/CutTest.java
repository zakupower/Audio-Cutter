import audio.Cut;
import audio.InvalidCutException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tomov on 27.6.2018 г..
 */
public class CutTest {
    private Cut goodCut,badCut;
    private String name = "My Song 1";
    private double from = 10.0;
    private double to = 30.0;


    @Test(expected = InvalidCutException.class)
    public void onlySpaceNameConstructor() throws InvalidCutException{
        badCut = new Cut("       ",10,30);
    }
    @Test(expected = InvalidCutException.class)
    public void emptyNameConstructor() throws InvalidCutException{
        badCut = new Cut("",10,30);
    }
    @Test(expected = InvalidCutException.class)
    public void testConstructorFailNegative() throws InvalidCutException{
        badCut = new Cut("My Song 1",-10,30);
    }
    @Test(expected = InvalidCutException.class)
    public void testConstructorFailSwitchedFromTo() throws InvalidCutException{
        badCut = new Cut("My Song 1",30,10);
    }
    @Test
    public void testConstructorSuccess() throws InvalidCutException{
        goodCut = new Cut("My Song 1", 10.0,30.0);
        assertEquals("Name field not correct!",name,goodCut.getName());
        assertEquals("From field not correct!",from,goodCut.getFrom(),0.1);
        assertEquals("To field not correct!",to,goodCut.getTo(),0.1);
    }

}
