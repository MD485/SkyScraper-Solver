import org.junit.Assert;
import org.junit.Test;


public class VariationsTests {

    @Test
    public void getHeight() {
        String test = "ABDC";
        Assert.assertEquals(new Integer(3), Variations.getHeight(test));
    }

    @Test
    public void reverseString() {
        String test = "ABDC";
        Assert.assertEquals("CDBA", Variations.reverseString(test));
    }

    @Test
    public void generatePossbilities() {
        String result = "123456";
        Assert.assertEquals(result, Variations.generatePossibilities(6));
    }
}
