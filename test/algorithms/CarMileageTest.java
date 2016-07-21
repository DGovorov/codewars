package algorithms;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Dim on 20.07.2016.
 */
public class CarMileageTest {

    @Test
    public void testTooSmall() {
        assertEquals(0, CarMileage.isInteresting(3, new int[]{1337, 256}));
    }

    @Test
    public void testAlmostAwesome() {
        assertEquals(1, CarMileage.isInteresting(1336, new int[]{1337, 256}));
    }

    @Test
    public void testAwesome() {
        assertEquals(2, CarMileage.isInteresting(1337, new int[]{1337, 256}));
    }

    @Test
    public void testFarNotInteresting() {
        assertEquals(0, CarMileage.isInteresting(11208, new int[]{1337, 256}));
    }

    @Test
    public void testAlmostInteresting() {
        assertEquals(1, CarMileage.isInteresting(11209, new int[]{1337, 256}));
    }

    @Test
    public void testInteresting() {
        assertEquals(2, CarMileage.isInteresting(11211, new int[]{1337, 256}));
    }

    @Test
    public void testDecrementing(){
        assertEquals(2, CarMileage.isInteresting(654321, new int[]{}));
    }

    @Test
    public void testDecrementingWithZero(){
        assertEquals(2, CarMileage.isInteresting(6543210, new int[]{}));
    }

    @Test
    public void testIncrementing(){
        assertEquals(2, CarMileage.isInteresting(12345, new int[]{}));
    }

    @Test
    public void testIncrementingWithZero(){
        assertEquals(2, CarMileage.isInteresting(7890, new int[]{}));
    }

}
