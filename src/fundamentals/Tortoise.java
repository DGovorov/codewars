package fundamentals;

/**
 * Two tortoises named A and B must run a race. A starts with an average speed of 720 feet per hour.
 * Young B knows she runs faster than A and furthermore has not finished her cabbage.
 * When she starts, at last, she can see that A has a 70 feet lead but B speed is 850 feet per hour.
 * How long will it take B to catch A?
 * More generally: given two speeds v1 (A speed, integer > 0) and v2 (B speed, integer > 0) and a lead g (integer > 0)
 * how long will it take B to catch A?
 * <p>
 * The result will be an array [h, mn, s] where h, mn, s is the time needed in hours, minutes and seconds
 * (don't worry for fractions of second). If v1 >= v2 then return nil, nothing, null, None or {-1, -1, -1} for C++.
 * <p>
 * Examples:
 * <p>
 * race(720, 850, 70) => [0, 32, 18]
 * race(80, 91, 37) => [3, 21, 49]
 * Created by Dim on 14.07.2016.
 */
public class Tortoise {

    public static int[] race(int v1, int v2, int g) {
        if (v1 >= v2) {
            return null;
        }

        float distanceToCatchUp = (float) g;
        float timeToCatchUp = distanceToCatchUp / (v2 - v1);

        return toTimeArray(timeToCatchUp);
    }

    private static int[] toTimeArray(float hours) {
        int h = (int) hours;
        float floatPart = hours - (int) hours;
        float floatPartInSeconds = floatPart * 3600;
        int time = (int) floatPartInSeconds;
        int mn = time % 3600 / 60;
        int s = time % 60;

        return new int[]{h, mn, s};
    }

}