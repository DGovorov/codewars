package fundamentals;

/**
 * In John's car the GPS records every s seconds the distance travelled from an origin (distances are measured in an
 * arbitrary but consistent unit). For example, below is part of a record with s = 15:
 * <p>
 * x = [0.0, 0.19, 0.5, 0.75, 1.0, 1.25, 1.5, 1.75, 2.0, 2.25]
 * <p>
 * The sections are:
 * <p>
 * 0.0-0.19, 0.19-0.5, 0.5-0.75, 0.75-1.0, 1.0-1.25, 1.25-1.50, 1.5-1.75, 1.75-2.0, 2.0-2.25
 * <p>
 * We can calculate John's average hourly speed on every section and we get:
 * <p>
 * [45.6, 74.4, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0]
 * <p>
 * Given s and x the task is to return as an integer the floor of the maximum average speed per hour obtained on the
 * sections of x. If x length is less than or equal to 1 return 0 since the car didn't move.
 * Example:
 * <p>
 * with the above data your function gps(x, s)should return 74
 * <p>
 * Created by Dim on 17.08.2016.
 */
public class GpsSpeed {

    public static int gps(int s, double[] x) {
        if (x.length < 2) {
            return 0;
        }

        double maxInterval = 0;
        for (int i = 0; i < x.length - 1; i++) {
            maxInterval = Math.max(maxInterval, x[i + 1] - x[i]);
        }

        double result = maxInterval * 3600 / s;
        return (int) result;
    }

}