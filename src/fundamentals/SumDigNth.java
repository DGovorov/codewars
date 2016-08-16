package fundamentals;

/**
 * We have the first value of a certain sequence, we will name it initVal. We define pattern list, patternL, an array
 * that has the differences between contiguous terms of the sequence. E.g: patternL = [k1, k2, k3, k4]
 * <p>
 * The terms of the sequence will be such values that:
 * <p>
 * term1 = initVal
 * term2 - term1 = k1
 * term3 - term2 = k2
 * term4 - term3 = k3
 * term5 - term4 = k4
 * term6 - term5 = k1
 * term7 - term6 = k2
 * term8 - term7 = k3
 * term9 - term8 = k4
 * ....  - ..... = ...
 * ....  - ..... = ...
 * <p>
 * So the values of the differences between contiguous terms are cyclical and are repeated as the differences values of
 * the pattern list stablishes.
 * <p>
 * Let's see an example with numbers:
 * <p>
 * initVal = 10
 * patternL = [2, 1, 3]
 * term1 = 10
 * term2 = 12
 * term3 = 13
 * term4 = 16
 * term5 = 18
 * term6 = 19
 * term7 = 22  # and so on...
 * <p>
 * We can easily obtain the next terms of the sequence following the values in the pattern list. We see that the sixth
 * term of the sequence, 19, has the sum of its digits 10.
 * <p>
 * Make a function sumDig_nthTerm(), that receives three arguments in this order
 * <p>
 * sumDig_nthTerm(initVal, patternL, nthTerm(ordinal number of the term in the sequence))
 * <p>
 * This function will output the sum of the digits of the n-th term of the sequence.
 * Created by Dim on 16.08.2016.
 */
public class SumDigNth {

    public static long sumDigNthTerm(long initval, long[] patternl, int nthterm) {

        long number = initval;
        for (int i = 0; i < nthterm - 1; i++) {
            int patternIndex = i % patternl.length;
            number += patternl[patternIndex];
        }

        long sumOfDigits = 0;
        while (number > 0) {
            sumOfDigits += number % 10;
            number /= 10;
        }

        return sumOfDigits;
    }

}