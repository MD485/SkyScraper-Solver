import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.Arrays;

public class BoardTests {

    //Currently the class doesn't support termination in the cases of erroneous input or if it
    //somehow looped internally, so I'm using a timeout for these tests; suboptimal but works for
    //now. Test normally finishes in <200ms so a leeway of 10 seconds probably won't get exceeded.

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10);

    @Test
    public void boardTest() {
        Board a = new Board(new ArrayList<>
                (Arrays.asList(0,2,3,0,2,0,0, 5,0,4,5,0,4,0, 0,4,2,0,0,0,6, 5,2,2,2,2,4,1)));

        //Because all the numbers are the char representations of themselves all numbers must be
        //encased in ' ' to be treated as a char.

        int[][] result = new int[][]
                         {{'3','4','5','1','2','6','7'},
                          {'6','7','2','4','5','3','1'},
                          {'1','2','3','7','4','5','6'},
                          {'2','3','4','6','7','1','5'},
                          {'5','6','7','3','1','2','4'},
                          {'4','5','1','2','6','7','3'},
                          {'7','1','6','5','3','4','2'}};

        Assert.assertArrayEquals(result, a.results());
    }
}

