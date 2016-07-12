package fundamentals;

import java.util.ArrayList;

/**
 * Created by Dim on 12.07.2016.
 */
public class Metro {

    public static int countPassengers(ArrayList<int[]> stops) {
        int passangers = 0;

        for (int[] stop: stops) {
            passangers += stop[0];
            passangers -= stop[1];
        }

        return passangers;
    }

}
