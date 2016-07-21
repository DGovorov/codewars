package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * "7777...8?!??!", exclaimed Bob, "I missed it again! Argh!" Every time there's an interesting number coming up,
 * he notices and then promptly forgets. Who doesn't like catching those one-off interesting mileage numbers?
 * <p>
 * Let's make it so Bob never misses another interesting number. We've hacked into his car's computer,
 * and we have a box hooked up that reads mileage numbers. We've got a box glued to his dash that lights up yellow
 * or green depending on whether it receives a 1 or a 2 (respectively).
 * <p>
 * It's up to you, intrepid warrior, to glue the parts together. Write the function that parses the mileage number input,
 * and returns a 2 if the number is "interesting" (see below), a 1 if an interesting number occurs within the next two
 * miles, or a 0 if the number is not interesting.
 * <p>
 * Note: In Haskell, we use No, Almost and Yes instead of 0, 1 and 2.
 * "Interesting" Numbers
 * <p>
 * Interesting numbers are 3-or-more digit numbers that meet one or more of the following criteria:
 * <p>
 * Any digit followed by all zeros: 100, 90000
 * Every digit is the same number: 1111
 * The digits are sequential, incementing†: 1234
 * The digits are sequential, decrementing‡: 4321
 * The digits are a palindrome: 1221 or 73837
 * The digits match one of the values in the awesomePhrases array
 * <p>
 * † For incrementing sequences, 0 should come after 9, and not before 1, as in 7890.
 * ‡ For decrementing sequences, 0 should come after 1, and not before 9, as in 3210.
 * <p>
 * Error Checking
 * <p>
 * A number is only interesting if it is greater than 99!
 * Input will always be an integer greater than 0, and less than 1,000,000,000.
 * The awesomePhrases array will always be provided, and will always be an array, but may be empty.
 * (Not everyone thinks numbers spell funny words...)
 * You should only ever output 0, 1, or 2.
 * <p>
 * Created by Dim on 20.07.2016.
 */
public class CarMileage {

    public static int isInteresting(int number, int[] awesomePhrases) {
        if (isAwesome(number, awesomePhrases)) {
            return 2;
        }
        if (isNearAwesome(number, awesomePhrases)) {
            return 1;
        }
        return 0;
    }

    private static boolean isAwesome(int number, int[] awesomePhrases) {
        if (number < 100) {
            return false;
        }
        List<Integer> digits = getDigits(number);
        return isFollowedByZeros(digits)
                || isMadeOfSingleDigit(digits)
                || isIncrementingSequence(digits)
                || isDecrementingSequence(digits)
                || isPalindrome(digits)
                || isAwesomePhrase(number, awesomePhrases);
    }

    private static boolean isNearAwesome(int number, int[] awesomePhrases) {
        if (number < 98) {
            return false;
        }
        List<Integer> plusOneDigits = getDigits(number + 1L);
        List<Integer> plusTwoDigits = getDigits(number + 2L);
        return isFollowedByZeros(plusOneDigits)
                || isFollowedByZeros(plusTwoDigits)
                || isMadeOfSingleDigit(plusOneDigits)
                || isMadeOfSingleDigit(plusTwoDigits)
                || isIncrementingSequence(plusOneDigits)
                || isIncrementingSequence(plusTwoDigits)
                || isDecrementingSequence(plusOneDigits)
                || isDecrementingSequence(plusTwoDigits)
                || isPalindrome(plusOneDigits)
                || isPalindrome(plusTwoDigits)
                || isAwesomePhrase(number + 1, awesomePhrases)
                || isAwesomePhrase(number + 2, awesomePhrases);
    }

    private static List<Integer> getDigits(long number) {
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            int digit = (int) number % 10;
            digits.add(digit);
            number /= 10;
        }
        Collections.reverse(digits);
        return digits;
    }

    private static boolean isFollowedByZeros(List<Integer> digits) {
        for (int i = 1; i < digits.size(); i++) {
            if (digits.get(i) != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMadeOfSingleDigit(List<Integer> digits) {
        int firstDigit = digits.get(0);
        for (int i = 1; i < digits.size(); i++) {
            if (digits.get(i) != firstDigit) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIncrementingSequence(List<Integer> digits) {
        int firstDigit = digits.get(0);
        for (int i = 1; i < digits.size(); i++) {
            if (digits.get(i - 1) == 9 && digits.get(i) == 0) {
                continue;
            }
            if (digits.get(i) != firstDigit + i) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDecrementingSequence(List<Integer> digits) {
        int firstDigit = digits.get(0);
        for (int i = 1; i < digits.size(); i++) {
            if (digits.get(i) != firstDigit - i) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrome(List<Integer> digits) {
        for (int i = 0; i <= digits.size() / 2; i++) {
            if (!(digits.get(i).equals(digits.get(digits.size() - i - 1)))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAwesomePhrase(int number, int[] awesomePhrases) {
        for (int phrase : awesomePhrases) {
            if (number == phrase) {
                return true;
            }
        }
        return false;
    }

}