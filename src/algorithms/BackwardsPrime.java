package algorithms;


import java.util.ArrayList;
import java.util.List;

/**
 * Backwards Read Primes are primes that when read backwards in base 10 (from right to left) are a different prime.
 * (This rules out primes which are palindromes.)
 *
 * 13 17 31 37 71 73 are Backwards Read Primes
 * 13 is such because it's prime and read from right to left writes 31 which is prime too. Same for the others.
 *
 * Find all Backwards Read Primes between two positive given numbers (both inclusive),
 * the second one being greater than the first one. The resulting array or the resulting string
 * will be ordered following the natural order of the prime numbers.
 *
 * Created by Dim on 25.06.2016.
 */
public class BackwardsPrime {

    public static void main(String[] args) {

        String backwardsPrimes = backwardsPrime(9900, 10000);
        System.out.println(backwardsPrimes);

    }

    public static String backwardsPrime(long start, long end) {
        if (start > end) {
            throw new IllegalArgumentException("start:" + start + " end:" + end);
        }

        List<Long> primes = new ArrayList<>();
        for (long i = start; i <= end; i++) {
            if (isPrime(i) && isPrime(reverse(i)) && !isPalindrome(i)) {
                primes.add(i);
            }
        }

        String result = "";
        for (int i = 0; i < primes.size(); i++) {
            result = result + primes.get(i);
            if (i != primes.size() - 1){
                result += " ";
            }
        }

        return result;
    }

    private static boolean isPrime(long num) {
        if (num % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static long reverse(long num) {
        int digit;
        long result = 0;

        while (num != 0) {
            digit = (int) (num % 10);
            num /= 10;
            result *= 10;
            result += digit;
        }

        return result;
    }

    private static boolean isPalindrome(long num) {
        return num == reverse(num);
    }

}
