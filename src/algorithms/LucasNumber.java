package algorithms;

/**Lucas numbers are numbers in a sequence defined like this:
 * L(n) = 2 if n = 0
 * L(n) = 1 if n = 1
 * otherwise
 * L(n) = L(n - 1) + L(n - 2)
 * Your mission is to define a function lucasnum(n) that returns the nth term of this sequence.
 * Note: It should work for negative numbers as well (how you do this is you flip the equation around,
 * so for negative numbers: L(n) = L(n + 2) - L(n + 1))
 * Examples:
 * lucasnum(-10) -> 123
 * lucasnum(-5) -> -11
 * lucasnum(-1) -> -1
 * lucasnum(0) -> 2
 * lucasnum(1) -> 1
 * lucasnum(5) -> 11
 * lucasnum(10) -> 123
 * Created by Dim on 25.06.2016.
 */
public class LucasNumber {

    public static void main(String[] args) {
        System.out.println(lucas(-5));
        System.out.println(lucas(-10));

        System.out.println(lucas(-1));
        System.out.println(lucas(0));
        System.out.println(lucas(1));
    }

    public static int lucas(int n) {
        if (n == 0){
            return 2;
        }

        boolean isNegative;
        if (n < 0) {
            isNegative = true;
            n *= -1;
        } else {
            isNegative = false;
        }

        boolean isEven;
        if (n % 2 == 0) {
            isEven = true;
        } else {
            isEven = false;
        }

        int beforeLast = 1;
        int last = 0;
        int current = 0;
        for (int i = 1; i <= n; i++) {
            current = last + beforeLast;
            beforeLast = last;
            if (i != n) {
                last = current;
            }
        }

        int result = last * 2 + current;

        if (isNegative && !isEven) {
            result *= -1;
        }
        return result;
    }
}