package fundamentals;

/**
 * In mathematics, the factorial of a non-negative integer n, denoted by n!, is the product of all positive integers
 * less than or equal to n. For example: 5! = 5 * 4 * 3 * 2 * 1 = 120. By convention the value of 0! is 1.
 *
 * Write a function to calculate factorial for a given input. If input is below 0 or above 12 throw an exception of type
 * ArgumentOutOfRangeException (C#) or IllegalArgumentException (Java).
 * Created by Dim on 24.06.2016.
 */
public class Factorial {

    public static void main(String[] args) {
        Factorial f = new Factorial();

        System.out.println(f.factorial(0));
    }

    public int factorial(int n) {

        if (n < 0 || n > 12){
            throw new IllegalArgumentException("Number is out of 0 - 12 range: " + n);
        }

        int factorial = 1;

        for (int i = n; i > 0; i--) {
            factorial *= i;
        }

        return factorial;
    }

}
