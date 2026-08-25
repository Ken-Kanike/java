import java.util.Arrays;

/**
 * ==============================================================================
 * MODULE 05: 1D, 2D & JAGGED ARRAYS WITH ARRAYS UTILITY
 * ==============================================================================
 * 
 * CORE CONCEPTS:
 * 1. 1D Array Declaration, Instantiation, and Memory Allocation.
 * 2. 2D Rectangular Matrix Arrays.
 * 3. Jagged Arrays (Arrays of varying column lengths per row).
 * 4. java.util.Arrays Utility: sort(), binarySearch(), copyOf(), fill(), equals(), deepToString().
 */

class Arrays_1D_and_2D {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("1. 1D Array Operations & java.util.Arrays");
        System.out.println("==================================================");

        int[] numbers = {45, 12, 85, 32, 89, 39, 69, 44, 42, 1, 6, 8};

        System.out.println("Original Array: " + Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("Sorted Array:   " + Arrays.toString(numbers));

        int searchKey = 42;
        int index = Arrays.binarySearch(numbers, searchKey);
        System.out.printf("Binary search for %d found at index: %d%n", searchKey, index);

        // Copy array
        int[] copy = Arrays.copyOf(numbers, 5); // First 5 elements
        System.out.println("Copy of first 5 elements: " + Arrays.toString(copy));

        System.out.println("\n==================================================");
        System.out.println("2. 2D Rectangular Matrix (3x3)");
        System.out.println("==================================================");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%3d ", val);
            }
            System.out.println();
        }

        System.out.println("\n==================================================");
        System.out.println("3. Jagged (Ragged) Array");
        System.out.println("==================================================");
        // A jagged array has rows of varying sizes
        int[][] jagged = new int[3][];
        jagged[0] = new int[]{1, 2};
        jagged[1] = new int[]{3, 4, 5, 6};
        jagged[2] = new int[]{7, 8, 9};

        System.out.println("Jagged Array representation: " + Arrays.deepToString(jagged));
        for (int i = 0; i < jagged.length; i++) {
            System.out.printf("Row %d (length %d): %s%n", i, jagged[i].length, Arrays.toString(jagged[i]));
        }
    }
}
