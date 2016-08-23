package algorithms;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SecretDetectiveTest {

    private SecretDetective detective;

    @Before public void setup() {
        detective = new SecretDetective();
    }

    @Test public void secret1() {
        char[][] triplets = {
                {'t','u','p'},
                {'w','h','i'},
                {'t','s','u'},
                {'a','t','s'},
                {'h','a','p'},
                {'t','i','s'},
                {'w','h','s'}
        };
        assertEquals("whatisup", detective.recoverSecret(triplets));
    }

    @Test public void secret2() {
        char[][] triplets = {
                {'l','e','d'},
                {'o','e','d'},
                {'o','l','e'},
                {'o','v','e'},
                {'s','o','l'},
                {'s','e','d'},
                {'s','l','e'},
                {'v','e','d'},
                {'o','l','v'},
                {'l','v','d'},
                {'s','v','d'}
        };
        assertEquals("solved", detective.recoverSecret(triplets));
    }

}