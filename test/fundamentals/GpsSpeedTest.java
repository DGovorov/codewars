package fundamentals;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by Dim on 17.08.2016.
 */
public class GpsSpeedTest {

    @Test
    public void test1() {
        double[] x = new double[] {0.0, 0.23, 0.46, 0.69, 0.92, 1.15, 1.38, 1.61};
        assertEquals(GpsSpeed.gps(20, x), 41);
    }

    @Test
    public void test2() {
        double[] x = new double[] {0.0, 0.11, 0.22, 0.33, 0.44, 0.65, 1.08, 1.26, 1.68, 1.89, 2.1, 2.31, 2.52, 3.25};
        assertEquals(GpsSpeed.gps(12, x), 219);
    }

    @Test
    public void test3() {
        double[] x = new double[] {0.0, 0.18, 0.36, 0.54, 0.72, 1.05, 1.26, 1.47, 1.92, 2.16, 2.4, 2.64, 2.88, 3.12, 3.36, 3.6, 3.84};
        assertEquals(GpsSpeed.gps(20, x), 80);
    }
}