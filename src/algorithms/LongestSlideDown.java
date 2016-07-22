package algorithms;

/**
 * Pyramids are amazing! Both in architectural and mathematical sense. If you have a computer, you can mess with
 * pyramids even if you are not in Egypt at the time. For example, let's consider the following problem.
 * Imagine that you have a plane pyramid built of numbers, like this one here:
 * <p>
 * /3/
 * \7\ 4
 * 2 \4\ 6
 * 8 5 \9\ 3
 * <p>
 * Here comes the task...
 * Let's say that the 'slide down' is a sum of consecutive numbers from the top to the bottom of the pyramid.
 * As you can see, the longest 'slide down' is 3 + 7 + 4 + 9 = 23
 * Your task is to write a function longestSlideDown (in ruby: longest_slide_down) that takes a pyramid representation
 * as argument and returns its' longest 'slide down'. For example,
 * <p>
 * longestSlideDown [[3], [7, 4], [2, 4, 6], [8, 5, 9, 3]]
 * // => 23
 * Created by Dim on 22.07.2016.
 */
public class LongestSlideDown {

    public static int longestSlideDown(int[][] pyramid) {
        int[][] slideDownPyramid = new int[pyramid.length][];
        slideDownPyramid[pyramid.length - 1] = pyramid[pyramid.length - 1];
        for (int rowIndex = pyramid.length - 1; rowIndex >= 1; rowIndex--) {
            int size = slideDownPyramid[rowIndex].length - 1;
            int[] row = new int[size];
            for (int i = 0; i < row.length; i++) {
                row[i] = pyramid[rowIndex - 1][i] + Math.max(slideDownPyramid[rowIndex][i], slideDownPyramid[rowIndex][i + 1]);
            }
            slideDownPyramid[rowIndex - 1] = row;
        }

        return slideDownPyramid[0][0];
    }

}
