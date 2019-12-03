import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // We have to change the values before running the code for this assignment:
        intCodes[1] = 12;
        intCodes[2] = 2;

        // Now, to run the opcode calculator until the program needs to halt (move index f places after each calculation):
        for (int i = 0; shouldExecute; i = i + 4) {
            determineAndExecute(i);
        }

        // Finally, print our finished array:
        System.out.println("Calculated opcodes: " + Arrays.toString(intCodes));
    }

    /**
     * Determine what calculations need to be done and update the array with codes.
     * Always start at given starting location and change the pointed value within the array by doing calculations of values at positions starting location + 1 and starting location + 2.
     * Example: [0, 1, 2]: change value pointing at index 0 by doing calculations (dependent on starting point value) with the values on index 1 and 2
     * @param startingPos index of starting position
     */
    private static void determineAndExecute(int startingPos) {
        switch (intCodes[startingPos]) {
            case 99:
                // Halt the program!
                shouldExecute = false;
                break;
            case 1:
                // change value at starting position with addition of the two values following it.
                intCodes[intCodes[startingPos + 3]] = (intCodes[intCodes[startingPos + 1]] + intCodes[intCodes[startingPos + 2]]);
                break;
            case 2:
                // Change value at starting position with multipliction of the two values following it.
                intCodes[intCodes[startingPos + 3]] = (intCodes[intCodes[startingPos + 1]] * intCodes[intCodes[startingPos + 2]]);
                break;
        }
    }

    private static boolean shouldExecute = true;
    private static int[] intCodes = {1, 0, 0, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 1, 13, 19, 2, 9, 19, 23, 1, 23, 6, 27, 1, 13, 27, 31, 1, 31, 10, 35, 1, 9, 35, 39, 1, 39, 9, 43, 2, 6, 43, 47, 1, 47, 5, 51, 2, 10, 51, 55, 1, 6, 55, 59, 2, 13, 59, 63, 2, 13, 63, 67, 1, 6, 67, 71, 1, 71, 5, 75, 2, 75, 6, 79, 1, 5, 79, 83, 1, 83, 6, 87, 2, 10, 87, 91, 1, 9, 91, 95, 1, 6, 95, 99, 1, 99, 6, 103, 2, 103, 9, 107, 2, 107, 10, 111, 1, 5, 111, 115, 1, 115, 6, 119, 2, 6, 119, 123, 1, 10, 123, 127, 1, 127, 5, 131, 1, 131, 2, 135, 1, 135, 5, 0, 99, 2, 0, 14, 0};
}
