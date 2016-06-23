package stringTasks;

/**
 * This kata is to practice simple string output. Jamie is a programmer, and girlfriend of James. She likes diamonds,
 * and this time she expects String of diamond from James. As James doesn't know how to do it, he needs your help.
 * Task:
 * You need to print a shape on the screen using asterisk ("*") characters.
 *
 * The shape that will be returned from print method resembles a diamond, where the number provided as input represents
 * the number of *’s printed on the middle line. The line above and below will be centered and will have 2 less *’s
 * than the middle line. This reduction by 2 *’s for each line continues until a line with a single * is printed at
 * the top and bottom of the figure.
 *
 * Return null if input is even number (as it is not possible to print diamond with even number).
 * Created by Dim on 23.06.2016.
 */
public class Diamond {

    public static void main(String[] args) {
        System.out.println(print(11));
    }

    public static String print(int n) {
        if (n % 2 == 0 || n < 0){
            return null;
        }

        String upperPart = buildUpperPart(n);
        String lowerPart = buildLowerPart(n);
        return upperPart + lowerPart;
    }

    private static String buildUpperPart(int n) {
        StringBuilder diamond = new StringBuilder();
        int middleLineNumber = n/2 + 1;
        for (int i = 1; i <= middleLineNumber; i++) {
            String space = stringOfChars(' ', middleLineNumber - i);
            String asterisks = stringOfChars('*', i*2 - 1);
            diamond.append(space).append(asterisks).append('\n');
        }
        return diamond.toString();
    }

    private static String buildLowerPart(int n) {
        StringBuilder lowerHalf = new StringBuilder();
        int middleLineNumber = n/2 + 1;
        for (int i = 1; i < middleLineNumber; i++) {
            String space = stringOfChars(' ', i);
            String asterisks = stringOfChars('*', n - i * 2);
            lowerHalf.append(space).append(asterisks).append('\n');
        }
        return lowerHalf.toString();
    }

    private static String stringOfChars(char c, int n){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(c);
        }
        return builder.toString();
    }

}
