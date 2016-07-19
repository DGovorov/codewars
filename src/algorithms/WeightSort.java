package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * My friend John and I are members of the "Fat to Fit Club (FFC)". John is worried because each month a list with
 * the weights of members is published and each month he is the last on the list which means he is the heaviest.
 *
 * I am the one who establishes the list so I told him: "Don't worry any more, I will modify the order of the list".
 * It was decided to attribute a "weight" to numbers. The weight of a number will be from now on the sum of its digits.
 *
 * For example 99 will have "weight" 18, 100 will have "weight" 1 so in the list 100 will come before 99.
 * Given a string with the weights of FFC members in normal order can you give this string ordered by "weights"
 * of these numbers?
 *
 * Example:
 * "56 65 74 100 99 68 86 180 90" ordered by numbers weights becomes: "100 180 90 56 65 74 68 86 99"
 * When two numbers have the same "weight", let us class them as if they were strings and not numbers:
 * 100 is before 180 because its "weight" (1) is less than the one of 180 (9) and 180 is before 90 since,
 * having the same "weight" (9) it comes before as a string.
 *
 * All numbers in the list are positive numbers and the list can be empty.
 * Created by Dim on 18.07.2016.
 */
public class WeightSort {

    public static String orderWeight(String string) {
        List<Weight> weights = getListOfWeights(string);

        Collections.sort(weights);

        String result = "";
        for (int i = 0; i < weights.size(); i++) {
            result += weights.get(i).getValue();
            if (i != weights.size() - 1) {
                result += " ";
            }
        }
        return result;
    }

    private static List<Weight> getListOfWeights(String string) {
        List<Weight> weights = new ArrayList<>();
        String[] strings = string.split(" ");

        for (String s : strings) {
            weights.add(new Weight(s));
        }
        return weights;
    }

    private static class Weight implements Comparable<Weight> {

        private String value;

        public Weight(String value) {
            this.value = value;
        }

        private String getValue() {
            return value;
        }

        private int getWeightOfValue() {
            List<Integer> digits = getDigits();
            int weightOfValue = 0;
            for (Integer digit : digits) {
                weightOfValue += digit;
            }
            return weightOfValue;
        }

        private List<Integer> getDigits() {
            if (value == null || value.isEmpty()) {
                return Collections.emptyList();
            }

            Integer number = Integer.valueOf(value);

            List<Integer> digits = new ArrayList<>();
            while (number > 0) {
                Integer digit = number % 10;
                number /= 10;
                digits.add(digit);
            }
            return digits;
        }

        @Override
        public int compareTo(Weight other) {
            int weightOfValue = getWeightOfValue();
            int otherWeightOfValue = other.getWeightOfValue();

            if (weightOfValue > otherWeightOfValue) {
                return 1;
            }
            if (weightOfValue < otherWeightOfValue) {
                return -1;
            }
            return value.compareTo(other.getValue());
        }

    }

}
