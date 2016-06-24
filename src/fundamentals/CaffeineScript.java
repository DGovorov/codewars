package fundamentals;

/**
 * Complete the function caffeineBuzz, which takes a non-zero integer as it's one argument.
 * If the integer is divisible by 3, return the string "Java".
 * If the integer is divisible by 3 and divisible by 4, return the string "Coffee"
 * If the integer is one of the above and is even, add "Script" to the end of the string.
 * Otherwise, return the string "mocha_missing!"
 * Created by Dim on 24.06.2016.
 */
public class CaffeineScript {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(caffeineBuzz(i));
        }
    }

    public static String caffeineBuzz(int n) {

        if (!isMultipleOfThree(n)) {
            return "mocha_missing!";
        }

        String caffeine = "";

        if (isMultipleOfFour(n)) {
            caffeine += "Coffee";
        } else {
            caffeine += "Java";
        }

        if (isEven(n)) {
            caffeine += "Script";
        }

        return caffeine;
    }

    private static boolean isMultipleOfFour(int n) {
        return n % 4 == 0;
    }

    private static boolean isMultipleOfThree(int n) {
        return n % 3 == 0;
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }
}
