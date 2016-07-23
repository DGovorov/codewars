package mathematics;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by Dim on 23.07.2016.
 */

public class DirReductionTest {

    @Test
    public void test1() throws Exception {
        assertEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
                new String[]{"WEST"},
                DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
    }

    @Test
    public void test2() throws Exception {
        assertEquals("\"NORTH\", \"WEST\", \"SOUTH\", \"EAST\"",
                new String[]{"NORTH", "WEST", "SOUTH", "EAST"},
                DirReduction.dirReduc(new String[]{"NORTH", "WEST", "SOUTH", "EAST"}));
    }
}