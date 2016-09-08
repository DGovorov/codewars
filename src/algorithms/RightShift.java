package algorithms;

/**
 * Created by Dim on 08.09.2016.
 */
public class RightShift {

    public void shift(int[] array) {
        int toInsert = array[array.length - 1];
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            array[i] = toInsert;
            toInsert = current;
        }
    }

}
