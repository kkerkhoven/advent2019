import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] ranges = PUZZLE_INPUT.split("-");
        int start = Integer.parseInt(ranges[0]);
        int end = Integer.parseInt(ranges[1]);

        List<Integer> suitablePasswords = findSuitablePasswords(start, end);

        System.out.println("The amount of suitable passwords is " + suitablePasswords.size());
        System.out.println("Passwords: " + suitablePasswords);
    }

    /**
     * Find all possible six-digit passwords by a given start and end range. The following rules apply:
     * - The value is within the range provided (start to end).
     * - Two adjacent digits are the same (like 22 in 122345).
     * - Going from left to right, the digits never decrease; they only ever increase or stay the same (like 111123 or 135679).
     *
     * @param start Start range
     * @param end   End range
     * @return Six-digit passwords
     */
    private static List<Integer> findSuitablePasswords(int start, int end) {
        List<Integer> possiblePasswords = new ArrayList<>();
        for (int currentGuess = start; currentGuess <= end; currentGuess++) {
            if (checkIfNumberHasTwoAdjacentDigits(currentGuess) && checkIfNumberHasIncreasingDigitsLeftToRight(currentGuess)) {
                possiblePasswords.add(currentGuess);
            }
        }
        return possiblePasswords;
    }

    /**
     * Check if the provided number has to adjacent digits (for example: 123455, but not 123456)
     * Update: no larger groups allowed, so no 111111 anymore
     *
     * @param number The provided number
     * @return boolean answer
     */
    private static boolean checkIfNumberHasTwoAdjacentDigits(int number) {
        String uglyButEasy = String.valueOf(number);
        int countingDoubleAdjacents = 0;

        if (uglyButEasy.contains("00") && !uglyButEasy.contains("000")) {
            countingDoubleAdjacents++;
        }
        if (uglyButEasy.contains("11") && !uglyButEasy.contains("111")) {
            countingDoubleAdjacents++;
        }
        if (uglyButEasy.contains("22") && !uglyButEasy.contains("222")) {
            countingDoubleAdjacents++;
        }
        if (uglyButEasy.contains("33") && !uglyButEasy.contains("333")) {
            countingDoubleAdjacents++;
        }
        if (uglyButEasy.contains("44") && !uglyButEasy.contains("444")) {
            countingDoubleAdjacents++;
        }
        if (uglyButEasy.contains("55") && !uglyButEasy.contains("555")) {
            countingDoubleAdjacents++;
        }
        if (uglyButEasy.contains("66") && !uglyButEasy.contains("666")) {
            countingDoubleAdjacents++;
        }
        if (uglyButEasy.contains("77") && !uglyButEasy.contains("777")) {
            countingDoubleAdjacents++;
        }
        if (uglyButEasy.contains("88") && !uglyButEasy.contains("888")) {
            countingDoubleAdjacents++;
        }
        if (uglyButEasy.contains("99") && !uglyButEasy.contains("999")) {
            countingDoubleAdjacents++;
        }
        return countingDoubleAdjacents > 0;
    }

    /**
     * Check if the provided number has no increasing digits going from left to right (for example: 123456, 123455, but not 123454)
     *
     * @param number The provided number
     * @return boolean answer
     */
    private static boolean checkIfNumberHasIncreasingDigitsLeftToRight(int number) {
        int[] individualNumbers = String.valueOf(number).chars().toArray();
        for (int i = 0; i < individualNumbers.length - 1; i++) {
            if (individualNumbers[i] > individualNumbers[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static final String PUZZLE_INPUT = "134564-585159";
}
