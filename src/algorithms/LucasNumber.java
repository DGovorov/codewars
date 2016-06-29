package algorithms;

/**
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