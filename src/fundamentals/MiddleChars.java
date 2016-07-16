package fundamentals;

/**
 * You are going to be given a word. Your job is to return the middle character of the word.
 * If the word's length is odd, return the middle character. If the word's length is even, return the middle 2 characters.
 *
 * Examples:
 * MiddleChars.getMiddle("test") should return "es"
 * MiddleChars.getMiddle("testing") should return "t"
 * MiddleChars.getMiddle("middle") should return "dd"
 * MiddleChars.getMiddle("A") should return "A"
 *
 * Input
 * A word (string) of length 0 < str < 1000
 * Output
 * The middle character(s) of the word represented as a string.
 * Created by Dim on 15.07.2016.
 */
public class MiddleChars {

    public static String getMiddle(String word) {
        int middle = word.length() / 2;

        if (word.length() % 2 == 0){
            return word.substring(middle-1, middle+1);
        } else {
            return word.substring(middle, middle+1);
        }
    }

}
