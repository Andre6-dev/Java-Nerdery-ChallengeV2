/* (C)2024 */
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* (C)2024 */
public class Challenges {

    /* *****
    Challenge 1

    "Readable Time"

    The function "readableTime" accepts a positive number as argument,
    you should be able to modify the function to return the time from seconds
    into a human readable format.

    Example:

    Invoking "readableTime(3690)" should return "01:01:30" (HH:MM:SS)
    ***** */

    public String readableTime(Integer seconds) {
        // YOUR CODE HERE...

        if (seconds < 0) {
            return "";
        }

        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int sec = seconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, sec);
    }
    ;

    /* *****
    Challenge 2

    "Circular Array"

    Given the following array "COUNTRY_NAMES", modify the function "circularArray"
    to return an array that meets the following criteria:

    - The index number passed to the function should be the first element in the resulting array
    - The resulting array must have the same length as the initial array
    - The value of the argument "index" will always be a positive number

    Example:

    Invoking "circularArray(2)" should return "["Island", "Japan", "Israel", "Germany", "Norway"]"
    ***** */

    public String[] circularArray(int index) {
        String[] COUNTRY_NAMES = {"Germany", "Norway", "Island", "Japan", "Israel"};

        // Validate the index should be a positive number
        if (index < 0) {
            return new String[]{};
        }

        // YOUR CODE HERE...
        String[] result = new String[COUNTRY_NAMES.length];
        for (int i = 0; i < COUNTRY_NAMES.length; i++) {
            // Using the modulo operator ensure that if the index is greater than the length of the array, it will wrap around
            result[i] = COUNTRY_NAMES[(index + i) % COUNTRY_NAMES.length];
        }
        return result;
    }
    ;

    /* *****
    Challenge 3

    "Own Powers"

    The function "ownPower" accepts two arguments. "number" and "lastDigits".

    The "number" indicates how long is the series of numbers you are going to work with, your
    job is to multiply each of those numbers by their own powers and after that sum all the results.

    "lastDigits" is the length of the number that your function should return, as a string!.
    See example below.

    Example:

    Invoking "ownPower(10, 3)" should return "317"
    because 1^1 + 2^2 + 3^3 + 4^4 + 5^5 + 6^6 + 7^7 + 8^8 + 9^9 + 10^10 = 10405071317
    The last 3 digits for the sum of powers from 1 to 10 is "317"
    ***** */
    public String ownPower(int number, int lastDigits) {
        // YOUR CODE HERE...
        BigInteger sum = BigInteger.ZERO;

        for (int i = 1; i <= number; i++) {
            // Calculate the power of the number and add it to the sum
            BigInteger power = BigInteger.valueOf(i).pow(i);
            sum = sum.add(power);
        }

        return sum
                .toString()
                .substring(sum.toString().length() - lastDigits);
    }
    ;

    /* *****
    Challenge 4

    "Sum of factorial digits"

    A factorial (x!) means x! * (x - 1)... * 3 * 2 * 1.
    For example: 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800

    Modify the function "digitSum" to return a number that
    equals to the sum of the digits in the result of 10!

    Example:

    Invoking "digitSum(10)" should return "27".
    Since 10! === 3628800 and you sum 3 + 6 + 2 + 8 + 8 + 0 + 0
    ***** */

    public Integer digitSum(int n) {
        // BigInteger can represent integers of any magnitude, limited only by the available memory on the system.
        BigInteger factorial = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        // Convert the factorial to a string and sum the digits
        int sum = 0;
        String factorialString = factorial.toString();
        for (int i = 0; i < factorialString.length(); i++) {
            sum += Character.getNumericValue(factorialString.charAt(i));
        }

        return sum;
    }

    /**
     * Decryption.
     * Create a decryption function that takes as parameter an array of ASCII values. The addition between values is the ascii value decrypted.
     * decrypt([ 72, 33, -73, 84, -12, -3, 13, -13, -68 ]) ➞ "Hi there!"
     * H = 72, the sum of H 72 and 33 gives 105 which ascii value is i;
     * The function must return the string encoded using the encryption function below.
     *
     * @param ascivalues  hand, player2 hand
     */
    public String decrypt(List<Integer> ascivalues) {
        StringBuilder decryptedString = new StringBuilder();
        int prevValue = 0;

        for (int asciiValue : ascivalues) {
            // sum the previous value with the current value
            int decryptedValue = prevValue + asciiValue;

            // update the previous value
            prevValue = decryptedValue;

            // append the decrypted value to the string
            decryptedString.append((char) decryptedValue);
        }

        return decryptedString.toString();
    }

    /**
     * Encryption Function.
     * Create an encryption function that takes a string and converts into an array of ASCII character values.
     * encrypt("Hello") ➞ [72, 29, 7, 0, 3]
     * // H = 72, the difference between the H and e is 29
     * The function must return an array of integer ascii values.
     *
     * @param text  hand, player2 hand
     */
    public List<Integer> encrypt(String text) {
        // YOUR CODE HERE...
        List<Integer> asciiValues = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {

            int asciiValue = text.charAt(i);
            int difference = asciiValue - (i == 0 ? 0 : text.charAt(i - 1));

            asciiValues.add(difference);
        }

        return asciiValues;
    }
}
