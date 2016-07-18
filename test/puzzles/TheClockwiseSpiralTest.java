package puzzles;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Dim on 17.07.2016.
 */
public class TheClockwiseSpiralTest {

    TheClockwiseSpiral spiral = new TheClockwiseSpiral();

    @Test
    public void oddNumberSpiral() {
        int[][] expected = new int[][]{
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}};

        Assert.assertArrayEquals(expected, spiral.createSpiral(3));
    }

    @Test
    public void evenNumberSpiral() {
        int[][] expected = new int[][]{
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}};

        Assert.assertArrayEquals(expected, spiral.createSpiral(4));
    }

    @Test
    public void negativeParameterPassed() {
        int[][] expected = new int[][]{};

        Assert.assertArrayEquals(expected, spiral.createSpiral(-1));
    }

    @Test
    public void sizeOneSpiral() {
        int[][] expected = new int[][]{{1}};

        Assert.assertArrayEquals(expected, spiral.createSpiral(1));
    }

}
