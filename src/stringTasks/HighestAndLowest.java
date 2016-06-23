package stringTasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * In this little assignment you are given a string of space separated numbers,
 * and have to return the highest and lowest number.
 * Created by Dim on 23.06.2016.
 */
public class HighestAndLowest {

    public static void main(String[] args) {
        String numbers = "-1 2 3 4 23123 -3192";
        System.out.println(HighAndLow(numbers));
    }

    public static String HighAndLow(String numbers) {
        String[] strings = numbers.split(" ");
        List<Integer> numList = new ArrayList<>();

        for (int i = 0; i < strings.length ; i++) {
            Integer num = Integer.valueOf(strings[i]);
            numList.add(num);
        }

        Collections.sort(numList);
        int min = numList.get(0);
        int max = numList.get(numList.size()-1);
        return max + " " + min;
    }
}
