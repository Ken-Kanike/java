import java.util.*;

/**
 * ==============================================================================
 * MODULE 02: LINKEDLIST (List & Deque Double Nature)
 * ==============================================================================
 * 
 * CORE CONCEPTS:
 * 1. Data Structure: Doubly-Linked List (Node: prev, item, next).
 * 2. Interfaces Implemented: List<E>, Deque<E>, Queue<E>.
 * 3. Head/Tail Insert/Delete: O(1) time complexity.
 * 4. Index-based Access (get(i)): O(n) traversal from nearest end (head or tail).
 * 5. Memory Overhead: Higher than ArrayList because of Node references (prev, next).
 */

class LinkedList_ListAndDeque {

    // 1. LINKEDLIST AS A LIST
    public static void listUsageDemo() {
        System.out.println("==================================================");
        System.out.println("1. LinkedList as a standard List");
        System.out.println("==================================================");

        List<String> list = new LinkedList<>();
        list.add("First");
        list.add("Second");
        list.add("Third");
        list.add(1, "Inserted at 1");

        System.out.println("List elements: " + list);
        System.out.println("Get element at index 2: " + list.get(2)); // O(n) traversal
    }

    // 2. LINKEDLIST AS A DEQUE / QUEUE (FIFO & LIFO)
    public static void dequeUsageDemo() {
        System.out.println("\n==================================================");
        System.out.println("2. LinkedList as a Deque (Double Ended Queue)");
        System.out.println("==================================================");

        LinkedList<String> deque = new LinkedList<>();

        // Add to front and back - O(1)
        deque.addFirst("Front-A");
        deque.addFirst("Front-B");
        deque.addLast("Back-X");
        deque.addLast("Back-Y");

        System.out.println("Current Deque: " + deque);
        System.out.println("Peek First: " + deque.peekFirst());
        System.out.println("Peek Last: " + deque.peekLast());

        // Poll / Remove from front and back - O(1)
        System.out.println("Polled First: " + deque.pollFirst()); // Removes Front-B
        System.out.println("Polled Last: " + deque.pollLast());   // Removes Back-Y
        System.out.println("Deque after polling: " + deque);
    }

    // 3. PERFORMANCE BENCHMARK: ARRAYLIST VS LINKEDLIST
    public static void performanceComparisonDemo() {
        System.out.println("\n==================================================");
        System.out.println("3. Performance Comparison: ArrayList vs LinkedList");
        System.out.println("==================================================");

        int iterations = 100_000;

        // Test 1: Insertions at Beginning (Index 0)
        List<Integer> arrayList = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            arrayList.add(0, i); // O(n) shift per insertion -> O(n^2) total
        }
        long arrayListHeadTime = System.nanoTime() - start;

        LinkedList<Integer> linkedList = new LinkedList<>();
        start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            linkedList.addFirst(i); // O(1) pointer updates -> O(n) total
        }
        long linkedListHeadTime = System.nanoTime() - start;

        System.out.printf("100k Insertions at Head:%n  - ArrayList:  %,d ms%n  - LinkedList: %,d ms (Winner!)%n",
                arrayListHeadTime / 1_000_000, linkedListHeadTime / 1_000_000);

        // Test 2: Random Access by Index (Middle elements)
        long checksum = 0;
        start = System.nanoTime();
        for (int i = 0; i < 5_000; i++) {
            checksum += arrayList.get(50_000); // O(1) pointer arithmetic
        }
        long arrayListAccessTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 5_000; i++) {
            checksum += linkedList.get(50_000); // O(n) node traversal
        }
        long linkedListAccessTime = System.nanoTime() - start;

        System.out.printf("%n5,000 Random Accesses in Middle (checksum=%d):%n  - ArrayList:  %,d ms (Winner!)%n  - LinkedList: %,d ms%n",
                checksum, arrayListAccessTime / 1_000_000, linkedListAccessTime / 1_000_000);
    }

    public static void main(String[] args) {
        listUsageDemo();
        dequeUsageDemo();
        performanceComparisonDemo();
    }
}
