import java.util.*;

/**
 * ==============================================================================
 * MODULE 05: TREESET & NAVIGABLESET (Sorted Sets & Range Queries)
 * ==============================================================================
 * 
 * CORE CONCEPTS:
 * 1. Data Structure: Red-Black Tree (Self-balancing Binary Search Tree).
 * 2. Time Complexity: O(log n) for add, remove, contains.
 * 3. Sorting: Elements are kept automatically sorted (Natural or via Comparator).
 * 4. NavigableSet Interface: Provides closest-match and subset methods:
 *    - ceiling(e) / floor(e)   -> smallest >= e / largest <= e
 *    - higher(e)  / lower(e)   -> smallest > e  / largest < e
 *    - subSet, headSet, tailSet
 */

class TreeSet_And_NavigableSet {

    // 1. BASIC TREESET SORTING & COMPARATOR
    public static void basicTreeSetDemo() {
        System.out.println("==================================================");
        System.out.println("1. Basic TreeSet (Automatic Sorted Order)");
        System.out.println("==================================================");

        // Natural order (Alphabetical)
        NavigableSet<String> names = new TreeSet<>();
        names.add("Zara");
        names.add("Alex");
        names.add("Liam");
        names.add("Emma");
        names.add("Noah");

        System.out.println("Natural Sorted Order (Ascending): " + names);

        // Reverse order view
        System.out.println("Descending View: " + names.descendingSet());

        // Custom Comparator (Sort by String length, then alphabetically)
        TreeSet<String> customSorted = new TreeSet<>(
            Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder())
        );
        customSorted.addAll(Arrays.asList("Elephant", "Cat", "Dog", "Giraffe", "Lion"));
        System.out.println("Sorted by Length then Alphabetical: " + customSorted);
    }

    // 2. NAVIGABLESET CLOSEST MATCH & BOUNDARY METHODS
    public static void navigableSetQueryDemo() {
        System.out.println("\n==================================================");
        System.out.println("2. NavigableSet Boundary Queries (floor, ceiling, etc.)");
        System.out.println("==================================================");

        TreeSet<Integer> scores = new TreeSet<>(Arrays.asList(10, 25, 40, 55, 70, 85, 100));
        System.out.println("Available Milestone Scores: " + scores);

        int query = 50;
        System.out.println("Querying for target: " + query);
        System.out.println("  - lower(50)   [greatest < 50]:  " + scores.lower(query));
        System.out.println("  - floor(50)   [greatest <= 50]: " + scores.floor(query));
        System.out.println("  - ceiling(50) [smallest >= 50]: " + scores.ceiling(query));
        System.out.println("  - higher(50)  [smallest > 50]:  " + scores.higher(query));

        System.out.println("\nExact match query (target = 55):");
        System.out.println("  - floor(55):   " + scores.floor(55));   // 55
        System.out.println("  - lower(55):   " + scores.lower(55));   // 40
        System.out.println("  - ceiling(55): " + scores.ceiling(55)); // 55
        System.out.println("  - higher(55):  " + scores.higher(55));  // 70
    }

    // 3. RANGE VIEWS (subSet, headSet, tailSet)
    public static void rangeViewsDemo() {
        System.out.println("\n==================================================");
        System.out.println("3. NavigableSet Range Views (subSet, headSet, tailSet)");
        System.out.println("==================================================");

        TreeSet<Integer> grades = new TreeSet<>(Arrays.asList(45, 52, 63, 71, 80, 88, 92, 99));
        System.out.println("All Grades: " + grades);

        // headSet: Elements < 70 (or <= 70 with inclusive flag)
        System.out.println("Grades < 70 (headSet): " + grades.headSet(70));
        System.out.println("Grades <= 71 (inclusive headSet): " + grades.headSet(71, true));

        // tailSet: Elements >= 80
        System.out.println("Grades >= 80 (tailSet): " + grades.tailSet(80));

        // subSet: Range [60, 90)
        System.out.println("Grades between 60 and 90 (subSet): " + grades.subSet(60, 90));
    }

    public static void main(String[] args) {
        basicTreeSetDemo();
        navigableSetQueryDemo();
        rangeViewsDemo();
    }
}
