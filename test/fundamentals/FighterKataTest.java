package fundamentals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Dim on 01.09.2016.
 */

public class FighterKataTest {

    @Test
    public void test1() {
        FighterKata fighterKata = new FighterKata(new Fighter("Lew", 10, 2), new Fighter("Harry", 5, 4), "Lew");
        assertEquals("Lew", fighterKata.declareWinner());
    }

    @Test
    public void test2() {
        FighterKata fighterKata = new FighterKata(new Fighter("Lew", 10, 2), new Fighter("Harry", 5, 4), "Harry");
        assertEquals("Harry", fighterKata.declareWinner());
    }

    @Test
    public void test3() {
        FighterKata fighterKata = new FighterKata(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry");
        assertEquals("Harald", fighterKata.declareWinner());
    }

    @Test
    public void test4() {
        FighterKata fighterKata = new FighterKata(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald");
        assertEquals("Harald", fighterKata.declareWinner());
    }

    @Test
    public void test5() {
        FighterKata fighterKata = new FighterKata(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald");
        assertEquals("Harald", fighterKata.declareWinner());
    }

    @Test
    public void test6() {
        FighterKata fighterKata = new FighterKata(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry");
        assertEquals("Harald", fighterKata.declareWinner());
    }

}