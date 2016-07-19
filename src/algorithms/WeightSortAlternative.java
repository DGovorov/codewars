package algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Dim on 19.07.2016.
 */
public class WeightSortAlternative {

    public static String orderWeight(String string) {
        List<String> weights = Arrays.asList(string.split(" "));

        Comparator<String> comparator = new WeightComparator();
        weights.sort(comparator);

        return String.join(" ", weights);
    }

    private static class WeightComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {

            char[] chars1 = o1.toCharArray();
            char[] chars2 = o2.toCharArray();
            int firstValue = 0;
            int secondValue = 0;

            for (char c : chars1) {
                firstValue += c - '0';
            }
            for (char c : chars2) {
                secondValue += c - '0';
            }

            if (firstValue > secondValue) {
                return 1;
            }
            if (firstValue < secondValue) {
                return -1;
            }
            return o1.compareTo(o2);

        }
    }

}

