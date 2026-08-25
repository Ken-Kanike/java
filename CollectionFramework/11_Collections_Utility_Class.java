import java.util.*;

/**
 * ==============================================================================
 * MODULE 11: COLLECTIONS UTILITY CLASS (Algorithms & Wrappers)
 * ==============================================================================
 * 
 * CORE CONCEPTS:
 * 1. Sorting & Searching: Collections.sort(), binarySearch().
 * 2. Reordering & Shuffling: Collections.reverse(), shuffle(), rotate(), swap().
 * 3. Min/Max/Frequency: Collections.min(), max(), frequency(), disjoint().
 * 4. Wrapper Decorators:
 *    - unmodifiableCollection / List / Set / Map (Read-only views)
 *    - synchronizedCollection / List / Set / Map (Thread-safe wrappers)
 * 5. Factory Methods: Collections.singleton(), emptyList(), nCopies().
 */

class Collections_Utility_Class {

    // 1. SEARCHING & REORDERING ALGORITHMS
    public static void algorithmDemo() {
        System.out.println("==================================================");
        System.out.println("1. Algorithms: Sort, BinarySearch, Reverse, Rotate");
        System.out.println("==================================================");

        List<Integer> list = new ArrayList<>(Arrays.asList(40, 10, 80, 20, 50, 30));
        System.out.println("Initial list: " + list);

        // Sort (Dual-Pivot Quicksort / TimSort O(n log n))
        Collections.sort(list);
        System.out.println("Sorted list: " + list);

        // Binary Search (Must be pre-sorted! O(log n))
        int index = Collections.binarySearch(list, 50);
        System.out.println("Binary Search index for 50: " + index);

        // Reverse
        Collections.reverse(list);
        System.out.println("Reversed list: " + list);

        // Rotate
        Collections.rotate(list, 2); // Shift right by 2 positions
        System.out.println("Rotated by 2: " + list);

        // Swap
        Collections.swap(list, 0, list.size() - 1);
        System.out.println("Swapped first and last: " + list);

        // Min & Max
        System.out.println("Min: " + Collections.min(list) + ", Max: " + Collections.max(list));
    }

    // 2. FREQUENCY & DISJOINT
    public static void analysisDemo() {
        System.out.println("\n==================================================");
        System.out.println("2. Frequency, Disjoint & NCopies");
        System.out.println("==================================================");

        List<String> items = Arrays.asList("Apple", "Banana", "Apple", "Orange", "Apple");
        System.out.println("Frequency of 'Apple': " + Collections.frequency(items, "Apple"));

        List<String> group1 = Arrays.asList("Java", "C++", "Python");
        List<String> group2 = Arrays.asList("Ruby", "PHP", "Rust");
        List<String> group3 = Arrays.asList("Java", "Kotlin");

        // disjoint returns true if two collections share NO common elements
        System.out.println("Are group1 and group2 disjoint? " + Collections.disjoint(group1, group2)); // true
        System.out.println("Are group1 and group3 disjoint? " + Collections.disjoint(group1, group3)); // false (both have Java)
    }

    // 3. UNMODIFIABLE & SYNCHRONIZED WRAPPERS
    public static void wrapperDemo() {
        System.out.println("\n==================================================");
        System.out.println("3. Defensive Wrappers (Unmodifiable & Synchronized)");
        System.out.println("==================================================");

        List<String> modifiable = new ArrayList<>(Arrays.asList("Alpha", "Beta"));
        List<String> readOnly = Collections.unmodifiableList(modifiable);

        System.out.println("Read-only list: " + readOnly);
        try {
            readOnly.add("Gamma"); // Throws UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("Caught expected exception when modifying unmodifiable list!");
        }

        // Synchronized List
        List<String> syncList = Collections.synchronizedList(new ArrayList<>());
        syncList.add("Thread-Safe Item");
        System.out.println("Synchronized List: " + syncList);
    }

    public static void main(String[] args) {
        algorithmDemo();
        analysisDemo();
        wrapperDemo();
    }
}
