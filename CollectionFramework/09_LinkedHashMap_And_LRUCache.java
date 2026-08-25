import java.util.*;

/**
 * ==============================================================================
 * MODULE 09: LINKEDHASHMAP & LRU CACHE IMPLEMENTATION
 * ==============================================================================
 * 
 * CORE CONCEPTS:
 * 1. Underlying Structure: HashMap + Doubly-Linked List across all entries.
 * 2. Ordering Modes:
 *    - Insertion-Order (default): Elements iterated in the order they were inserted.
 *    - Access-Order (accessOrder = true): Elements re-ordered to the tail whenever accessed (get or put).
 * 3. LRU Cache: By overriding `removeEldestEntry()`, LinkedHashMap becomes a production-ready
 *    Least Recently Used (LRU) Cache.
 */

// Production-ready custom LRU Cache extending LinkedHashMap
class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int maxCapacity;

    public LRUCache(int maxCapacity) {
        // initialCapacity, loadFactor, accessOrder (true for access-order)
        super(maxCapacity, 0.75f, true);
        this.maxCapacity = maxCapacity;
    }

    // Automatically invoked by put() and putAll() after inserting a new entry
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxCapacity; // Evicts the least recently used element when size exceeds limit
    }
}

class LinkedHashMap_And_LRUCache {

    // 1. INSERTION-ORDER VS ACCESS-ORDER
    public static void orderingDemo() {
        System.out.println("==================================================");
        System.out.println("1. Insertion-Order vs Access-Order in LinkedHashMap");
        System.out.println("==================================================");

        // Insertion Order
        Map<String, String> insertOrderMap = new LinkedHashMap<>();
        insertOrderMap.put("A", "Alpha");
        insertOrderMap.put("B", "Beta");
        insertOrderMap.put("C", "Gamma");
        insertOrderMap.get("A"); // Accessing does NOT change insertion order
        System.out.println("Insertion-order map keys: " + insertOrderMap.keySet());

        // Access Order
        Map<String, String> accessOrderMap = new LinkedHashMap<>(16, 0.75f, true);
        accessOrderMap.put("A", "Alpha");
        accessOrderMap.put("B", "Beta");
        accessOrderMap.put("C", "Gamma");
        System.out.println("Before Accessing: " + accessOrderMap.keySet());

        accessOrderMap.get("A"); // Access "A" -> moves to tail (most recently used)
        System.out.println("After accessing 'A': " + accessOrderMap.keySet());

        accessOrderMap.put("B", "Beta-Updated"); // Updating "B" -> moves to tail
        System.out.println("After updating 'B': " + accessOrderMap.keySet());
    }

    // 2. LRU CACHE SIMULATION
    public static void lruCacheDemo() {
        System.out.println("\n==================================================");
        System.out.println("2. Custom LRU (Least Recently Used) Cache Demo (Capacity = 3)");
        System.out.println("==================================================");

        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "Page 1");
        cache.put(2, "Page 2");
        cache.put(3, "Page 3");
        System.out.println("Cache after inserting 1, 2, 3: " + cache);

        // Access Page 1 (making Page 2 the eldest/least recently used)
        System.out.println("Accessing key 1: " + cache.get(1));
        System.out.println("Cache after accessing 1: " + cache);

        // Insert Page 4 (Capacity full -> Page 2 should be evicted)
        System.out.println("Inserting key 4...");
        cache.put(4, "Page 4");
        System.out.println("Cache after inserting 4: " + cache + " (Key 2 was evicted!)");
    }

    public static void main(String[] args) {
        orderingDemo();
        lruCacheDemo();
    }
}
