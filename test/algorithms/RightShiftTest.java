package algorithms;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Dim on 08.09.2016.
 */
public class RightShiftTest {

    @Test
    public void oneToFiveTest() {
        int[] array = {1, 2, 3, 4, 5};
        RightShift rs = new RightShift();
        rs.shift(array);
        Assert.assertArrayEquals(array, new int[]{5, 1, 2, 3, 4});
    }

}
