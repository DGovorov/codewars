package puzzles;

/**
 * Do you know how to make a spiral? Let's test it!
 * Classic definition: A spiral is a curve which emanates from a central point,
 * getting progressively farther away as it revolves around the point.
 * Your objective is to complete a function createSpiral(N) that receives an integer N
 * and returns two-dimensional array where numbers from 1 to N should be represented as clockwise spiral.
 * Return an empty array if N < 1
 *
 * Examples:
 * N = 3 Output:   [[1,2,3],
 *                  [8,9,4],
 *                  [7,6,5]]
 * N = 4 Output:   [[1,2,3,4],
 *                 [12,13,14,5],
 *                 [11,16,15,6],
 *                 [10,9,8,7]]
 * N = 5 Output:   [[1,2,3,4,5],
 *                 [16,17,18,19,6],
 *                 [15,24,25,20,7],
 *                 [14,23,22,21,8],
 *                 [13,12,11,10,9]]
 *
 * P.S.
 * Weird class structuring used for codewars purposes, test cases there expect to see static method calls like this:
 * TheClockwiseSpiral.createSpiral(int N);
 * There are better ways to solve this problem.
 * Created by Dim on 17.07.2016.
 */
public class TheClockwiseSpiral {

    public static int[][] createSpiral(int N) {
        SpiralBuilder builder = new SpiralBuilder();
        return builder.getArray(N);
    }

    private static class SpiralBuilder {

        private int[][] array;
        private int num;
        private int depth;

        private int[][] getArray(int size){
            if (size <= 0){
                return new int[][]{};
            }

            init(size);
            fillArray();
            return array;
        }

        private void init(int size) {
            array = new int[size][size];
            num = 1;
            depth = 0;
        }

        private int[][] fillArray() {

            if (centerReached()) {
                return array;
            }

            drawUpperRow();

            if (centerReached()) {
                return array;
            }

            drawRightColumn();
            drawLowerRow();
            drawLeftColumn();

            depth++;
            return fillArray();
        }

        private boolean centerReached() {
            return num > array.length * array.length;
        }

        private void drawUpperRow() {
            for (int i = depth; i < array.length - depth; i++) {
                array[depth][i] = num;
                num++;
            }
        }

        private void drawRightColumn() {
            for (int i = depth + 1; i < array.length - 1 - depth; i++) {
                array[i][array.length - 1 - depth] = num;
                num++;
            }
        }

        private void drawLowerRow() {
            for (int i = array.length - depth - 1; i >= depth; i--) {
                array[array.length - 1 - depth][i] = num;
                num++;
            }
        }

        private void drawLeftColumn() {
            for (int i = array.length - 2 - depth; i >= depth + 1; i--) {
                array[i][depth] = num;
                num++;
            }
        }

    }

}
