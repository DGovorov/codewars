package algorithms;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Dim on 19.07.2016.
 */
public class WeightSortAlternativeTest {

    @Test
    public void secondTests() {
        assertEquals("2000 103 123 4444 99", WeightSortAlternative.orderWeight("103 123 4444 99 2000"));
    }

    @Test
    public void secondTest() {
        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", WeightSortAlternative.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }
}
