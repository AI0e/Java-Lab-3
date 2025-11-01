import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * Main executable class for Laboratory Work #3.
 * This class creates an array of MotorBoat objects, sorts them
 * using a complex sort (ascending capacity, descending price),
 * and searches for a specific object.
 */
public class Lab3 {

    /**
     * Program entry point.
     * All variables used by the assignment are declared and assigned in this
     * method.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        MotorBoat[] boats;
        try {
            boats = new MotorBoat[] {
                    new MotorBoat("Bayliner DX2000", 10, 47.0, 55000.0, "Outboard"),
                    new MotorBoat("Sea Ray SPX 190", 8, 50.5, 65000.0, "Inboard"),
                    new MotorBoat("Yamaha 212S", 10, 52.0, 75000.0, "Jet"),
                    new MotorBoat("Lund 1875", 8, 45.0, 68000.0, "Outboard"),
                    new MotorBoat("Chaparral 21 SSi", 10, 48.0, 53000.0, "Inboard")
            };
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating initial data: " + e.getMessage());
            return;
        }

        System.out.println("--- Original Array ---");
        printArray(boats);

        Comparator<MotorBoat> comparator = Comparator.comparingInt(MotorBoat::getPassengerCapacity)
                .thenComparing(Comparator.comparingDouble(MotorBoat::getPrice).reversed());

        Arrays.sort(boats, comparator);

        System.out.println("\n--- Sorted Array (Capacity ASC, Price DESC) ---");
        printArray(boats);

        System.out.println("\n--- Search Result (Found) ---");
        MotorBoat target = new MotorBoat("Sea Ray SPX 190", 8, 50.5, 65000.0, "Inboard");
        System.out.println("Target: " + target);

        int indexFound = findBoatIndex(boats, target);

        if (indexFound != -1) {
            System.out.printf("Found identical boat at index %d: %s%n", indexFound, boats[indexFound]);
        } else {
            System.out.println("No identical boat found in the array.");
        }

        System.out.println("\n--- Search Result (Not Found) ---");
        MotorBoat notPresentTarget = new MotorBoat("Zodiac", 4, 30.0, 25000.0, "Outboard");
        System.out.println("Target: " + notPresentTarget);

        int notFoundIndex = findBoatIndex(boats, notPresentTarget);
        System.out.printf("Searching for a non-existing boat returns index: %d%n", notFoundIndex);
    }

    /**
     * Helper method to print the contents of the MotorBoat array.
     *
     * @param array The array to print.
     */
    private static void printArray(MotorBoat[] array) {
        if (array == null) {
            System.out.println("[null array]");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("[%d] %s%n", i, array[i]);
        }
    }

    /**
     * Finds the index of the first boat in the array that is equal to the target.
     *
     * @param array  array of boats (non-null)
     * @param target boat to find (may be null)
     * @return index of found element, or -1 if not found
     * @throws IllegalArgumentException if array is null
     */
    private static int findBoatIndex(MotorBoat[] array, MotorBoat target) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null.");
        }
        for (int i = 0; i < array.length; i++) {
            if (Objects.equals(array[i], target)) {
                return i;
            }
        }
        return -1;
    }
}