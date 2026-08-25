import java.util.*;

/**
 * ==============================================================================
 * MODULE 10: TREEMAP & NAVIGABLEMAP (Sorted Key-Value Pairs)
 * ==============================================================================
 * 
 * CORE CONCEPTS:
 * 1. Data Structure: Red-Black Tree.
 * 2. Sorting: Keys are naturally sorted or ordered via a provided Comparator.
 * 3. Time Complexity: O(log n) for get, put, remove, containsKey.
 * 4. NavigableMap Interface:
 *    - firstKey(), lastKey(), firstEntry(), lastEntry()
 *    - ceilingKey(k), floorKey(k), higherKey(k), lowerKey(k)
 *    - subMap(), headMap(), tailMap()
 * 5. Does NOT permit null keys.
 */

class TreeMap_And_NavigableMap {

    // 1. BASIC TREEMAP & SORTING
    public static void treeMapBasicsDemo() {
        System.out.println("==================================================");
        System.out.println("1. TreeMap Basics (Automatic Key Sorting)");
        System.out.println("==================================================");

        NavigableMap<String, String> phoneBook = new TreeMap<>();
        phoneBook.put("Zachary", "555-0199");
        phoneBook.put("Alice", "555-0101");
        phoneBook.put("David", "555-0144");
        phoneBook.put("Charlie", "555-0133");
        phoneBook.put("Bob", "555-0122");

        System.out.println("Phonebook (Sorted by Name Ascending):");
        phoneBook.forEach((name, num) -> System.out.printf("  %-10s -> %s%n", name, num));

        System.out.println("\nFirst Entry: " + phoneBook.firstEntry());
        System.out.println("Last Entry:  " + phoneBook.lastEntry());
    }

    // 2. NAVIGATIONAL RANGE QUERIES (TAX BRACKET CALCULATOR SIMULATION)
    public static void taxBracketDemo() {
        System.out.println("\n==================================================");
        System.out.println("2. Tax Bracket Calculator (floorEntry query)");
        System.out.println("==================================================");

        // Map: Income Threshold -> Marginal Tax Rate %
        NavigableMap<Integer, Double> taxBrackets = new TreeMap<>();
        taxBrackets.put(0, 10.0);
        taxBrackets.put(11_000, 12.0);
        taxBrackets.put(44_725, 22.0);
        taxBrackets.put(95_375, 24.0);
        taxBrackets.put(182_100, 32.0);
        taxBrackets.put(231_250, 35.0);
        taxBrackets.put(578_125, 37.0);

        int income = 75_000;
        // floorEntry gives the largest threshold <= current income
        Map.Entry<Integer, Double> bracket = taxBrackets.floorEntry(income);

        System.out.println("For an income of $" + String.format("%,d", income) + ":");
        System.out.printf("  -> Falls under bracket starting at $%,d with tax rate of %.1f%%%n",
                bracket.getKey(), bracket.getValue());
    }

    // 3. SUBMAP & RANGE VIEWS
    public static void subMapDemo() {
        System.out.println("\n==================================================");
        System.out.println("3. SubMap, HeadMap, and TailMap Range Views");
        System.out.println("==================================================");

        NavigableMap<Integer, String> timestampLogs = new TreeMap<>();
        timestampLogs.put(100, "User Login");
        timestampLogs.put(150, "File Upload");
        timestampLogs.put(200, "DB Query");
        timestampLogs.put(250, "API Call");
        timestampLogs.put(300, "User Logout");

        System.out.println("Logs before timestamp 200 (headMap): " + timestampLogs.headMap(200));
        System.out.println("Logs from timestamp 200 onwards (tailMap): " + timestampLogs.tailMap(200));
        System.out.println("Logs between timestamp [150, 300) (subMap): " + timestampLogs.subMap(150, 300));
    }

    public static void main(String[] args) {
        treeMapBasicsDemo();
        taxBracketDemo();
        subMapDemo();
    }
}
