import java.util.*;

/**
 * ==============================================================================
 * MODULE 08: HASHMAP INTERNALS & ADVANCED USAGE
 * ==============================================================================
 * 
 * CORE CONCEPTS:
 * 1. Data Structure: Array of Buckets (Node<K, V>[]).
 * 2. Hash Calculation: int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16)
 * 3. Bucket Index: index = (n - 1) & hash  (bitwise AND where n is power of 2).
 * 4. Collision Resolution: Separate Chaining (Linked List of entries per bucket).
 * 5. Java 8+ Treeification: When a bucket chain length >= 8 and total capacity >= 64,
 *    the bucket converts from LinkedList (O(n)) to Red-Black Tree (TreeNode, O(log n)).
 * 6. Load Factor: Default 0.75. When size > capacity * 0.75, table doubles in size.
 */

class HashMap_Internals_And_Usage {

    // 1. BASIC MAP OPERATIONS & ITERATION IDIOMS
    public static void mapBasicsDemo() {
        System.out.println("==================================================");
        System.out.println("1. Basic HashMap Operations & Iteration");
        System.out.println("==================================================");

        Map<String, Integer> inventory = new HashMap<>();

        // Put (Insert / Update)
        inventory.put("MacBook Pro", 15);
        inventory.put("iPhone 15", 40);
        inventory.put("iPad Air", 25);
        inventory.put("Apple Watch", 30);

        System.out.println("Inventory Map: " + inventory);
        System.out.println("Quantity of 'MacBook Pro': " + inventory.get("MacBook Pro"));
        System.out.println("Contains 'AirPods'? " + inventory.containsKey("AirPods"));

        // Best Practice: Iterating using entrySet() (O(N) without redundant get() lookups)
        System.out.println("\nIterating via Map.entrySet():");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.printf("  Product: %-15s | Stock: %d%n", entry.getKey(), entry.getValue());
        }
    }

    // 2. MODERN JAVA 8+ CONVENIENCE METHODS
    public static void modernMapMethodsDemo() {
        System.out.println("\n==================================================");
        System.out.println("2. Modern Java 8+ Map Functional Methods");
        System.out.println("==================================================");

        Map<String, List<String>> userRoles = new HashMap<>();

        // computeIfAbsent: Automatically initializes a new list if key is not present
        userRoles.computeIfAbsent("AdminUser", k -> new ArrayList<>()).add("READ");
        userRoles.computeIfAbsent("AdminUser", k -> new ArrayList<>()).add("WRITE");
        userRoles.computeIfAbsent("AdminUser", k -> new ArrayList<>()).add("DELETE");
        userRoles.computeIfAbsent("GuestUser", k -> new ArrayList<>()).add("READ");

        System.out.println("User Roles: " + userRoles);

        // Word Frequency Counter using merge()
        String text = "java spring java kotlin java spring microservices";
        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : text.split(" ")) {
            // If word exists, add 1 to old value; otherwise set to 1
            wordCounts.merge(word, 1, Integer::sum);
        }
        System.out.println("Word Frequencies (using merge): " + wordCounts);

        // getOrDefault
        int dockerCount = wordCounts.getOrDefault("docker", 0);
        System.out.println("Count for 'docker' (getOrDefault): " + dockerCount);

        // putIfAbsent
        wordCounts.putIfAbsent("docker", 10);
        System.out.println("After putIfAbsent('docker', 10): " + wordCounts);
    }

    // 3. UNDERSTANDING MUTABLE KEYS & HASHMAP HAZARDS
    static class MutableKey {
        int id;
        MutableKey(int id) { this.id = id; }
        @Override public boolean equals(Object o) { return o instanceof MutableKey && this.id == ((MutableKey) o).id; }
        @Override public int hashCode() { return id; }
    }

    public static void mutableKeyHazardDemo() {
        System.out.println("\n==================================================");
        System.out.println("3. DANGER: Modifying a Key after inserting into HashMap");
        System.out.println("==================================================");

        Map<MutableKey, String> map = new HashMap<>();
        MutableKey key = new MutableKey(100);
        map.put(key, "Secret Data");

        System.out.println("Lookup before key modification: " + map.get(key));

        // Mutating key changes its hashCode!
        key.id = 999;
        System.out.println("Lookup after key mutation: " + map.get(key) + " (NULL! Memory leak / lost entry!)");
        System.out.println("RULE: Map keys MUST ALWAYS be immutable (e.g. String, Integer, Records).");
    }

    public static void main(String[] args) {
        mapBasicsDemo();
        modernMapMethodsDemo();
        mutableKeyHazardDemo();
    }
}
