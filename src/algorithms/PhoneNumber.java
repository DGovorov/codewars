package algorithms;

/**
 * Write a function that accepts an array of 10 integers (between 0 and 9), that returns a string of those numbers
 * in the form of a phone number.
 * <p>
 * Example:
 * <p>
 * Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // => returns "(123) 456-7890"
 * <p>
 * The returned format must be correct in order to complete this challenge.
 * Don't forget the space after the closing parenthese!
 * <p>
 * Created by Dim on 25.08.2016.
 */
public class PhoneNumber {

    public static String createPhoneNumber(int[] numbers) {
        StringBuilder phone = new StringBuilder("(");
        for (int i = 0; i < 10; i++) {
            if (i == 3) {
                phone.append(") ");
            }

            if (i == 6) {
                phone.append("-");
            }

            phone.append(numbers[i]);
        }

        return phone.toString();
    }

}
