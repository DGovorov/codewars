package fundamentals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dim on 15.07.2016.
 */
public class MiddleCharsTest {
    @Test
    public void evenTests() {
        assertEquals("es", MiddleChars.getMiddle("test"));
        assertEquals("dd", MiddleChars.getMiddle("middle"));
    }

    @Test
    public void oddTests() {
        assertEquals("t", MiddleChars.getMiddle("testing"));
        assertEquals("A", MiddleChars.getMiddle("A"));
    }
}
