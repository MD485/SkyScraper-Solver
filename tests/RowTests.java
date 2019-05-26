import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class RowTests {
    private HashSet<String> rowInput;

    @Before
    public void init() {
        rowInput = new HashSet<>(
                Arrays.asList("11111","12222","12333", "12344", "12345"));
    }

    @Test
    public void settingElementsAtIndex() {
        Row r = new Row(new HashSet<>(rowInput));
        r.setEntriesAtIndex(4,
                new HashSet<>(Arrays.asList('1','2','3','4')));
        Assert.assertEquals(4, r.getPossibilitiesAtIndex(4).size());
    }

    @Test
    public void retainingListOfElements() {
        Row r = new Row(new HashSet<>(rowInput));
        r.retainList(new HashSet<>(Arrays.asList("11111","12222","12333")));
        Assert.assertEquals(3, r.getPossibilitiesAtIndex(4).size());
    }

    @Test
    public void gettingElementsAtIndex() {
        Row r = new Row(new HashSet<>(rowInput));
        HashSet<Character> expected = new HashSet<>(Arrays.asList('1','2','3'));
        Assert.assertEquals(expected, r.getPossibilitiesAtIndex(2));
    }
}
