package mathematics;

import java.util.ArrayList;
import java.util.List;

/**
 * Once upon a time, on a way through the old wild west,…
 * <p>
 * a man was given directions to go from one point to another. The directions were "NORTH", "SOUTH", "WEST", "EAST".
 * Clearly "NORTH" and "SOUTH" are opposite, "WEST" and "EAST" too. Going to one direction and coming back the opposite
 * direction is a needless effort. Since this is the wild west, with dreadfull weather and not much water,
 * it's important to save yourself some energy, otherwise you might die of thirst!
 * How I crossed the desert the smart way.
 * <p>
 * The directions given to the man are, for example, the following:
 * <p>
 * String[] plan = { "NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST" };
 * <p>
 * You can immediatly see that going "NORTH" and then "SOUTH" is not reasonable, better stay to the same place!
 * So the task is to give to the man a simplified version of the plan. A better plan in this case is simply:
 * <p>
 * String[] plan = { "WEST" };
 * <p>
 * Other examples: In ["NORTH", "SOUTH", "EAST", "WEST"], the direction "NORTH" + "SOUTH" is going north and
 * coming back right away. What a waste of time! Better to do nothing. The path becomes ["EAST", "WEST"],
 * now "EAST" and "WEST" annihilate each other, therefore, the final result is [] (nil in Clojure).
 * In ["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"], "NORTH" and "SOUTH" are not directly opposite but they become
 * directly opposite after the reduction of "EAST" and "WEST" so the whole path is reducible to ["WEST", "WEST"].
 * Task
 * <p>
 * You have to write a function dirReduc which will take an array of strings and returns an array of strings with
 * the needless directions removed (W<->E or S<->N side by side).
 * <p>
 * The Haskell version takes a list of directions with data Direction = North | East | West | South. The Clojure version
 * returns nil when the path is reduced to nothing.
 * Examples
 * <p>
 * dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}) => new String[]{"WEST"}
 * dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"}) => new String[]{}
 * <p>
 * Note
 * <p>
 * All paths can't be made simpler. The path ["NORTH", "WEST", "SOUTH", "EAST"] is not reducible. "NORTH" and "WEST",
 * "WEST" and "SOUTH", "SOUTH" and "EAST" are not directly opposite of each other and can't become such. Hence the
 * result path is itself : ["NORTH", "WEST", "SOUTH", "EAST"].
 * <p>
 * Created by Dim on 23.07.2016.
 */
public class DirReduction {

    public static String[] dirReduc(String[] arr) {
        List<Direction> directions = new ArrayList<>();
        for (String string : arr) {
            directions.add(Direction.of(string));
        }

        boolean didRemove = true;
        while (didRemove) {
            didRemove = false;
            int index = findNeedlessPair(directions);
            if (index >= 0) {
                directions.remove(index + 1);
                directions.remove(index);
                didRemove = true;
            }
        }

        int size = directions.size();
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = directions.get(i).getName();
        }

        return result;
    }

    private static int findNeedlessPair(List<Direction> directions) {
        int size = directions.size();
        for (int i = 0; i < size - 1; i++) {
            if (directions.get(i) == Direction.NORTH && directions.get(i + 1) == Direction.SOUTH) {
                return i;
            }
            if (directions.get(i) == Direction.SOUTH && directions.get(i + 1) == Direction.NORTH) {
                return i;
            }
            if (directions.get(i) == Direction.WEST && directions.get(i + 1) == Direction.EAST) {
                return i;
            }
            if (directions.get(i) == Direction.EAST && directions.get(i + 1) == Direction.WEST) {
                return i;
            }
        }
        return -1;
    }

    private enum Direction {
        NORTH("NORTH"),
        SOUTH("SOUTH"),
        WEST("WEST"),
        EAST("EAST");

        private String name;

        Direction(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static Direction of(String string) {
            switch (string) {
                case "NORTH":
                    return NORTH;
                case "SOUTH":
                    return SOUTH;
                case "WEST":
                    return WEST;
                case "EAST":
                    return EAST;
                default:
                    throw new RuntimeException("no such enum:" + string);
            }
        }
    }

}