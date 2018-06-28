import audio.Cut;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tomov on 27.6.2018 г..
 */
public class CutTest {
    Cut cut;
    String name = "My Song 1";
    double from = 10.0;
    double to = 30.0;
    @Before
    public void setUp(){
        try {
            cut = new Cut("My Song 1", 10.0,30.0);
        }catch(Exception exc) {
            exc.printStackTrace();
        }
    }
    @Test
    public void testConstructor(){
        assertEquals("Name field not correct!",cut.getName(),name);
        assertEquals("From field not correct!",cut.getFrom(),from,0.1);
        assertEquals("To field not correct!",cut.getTo(),to,0.1);
    }

}
