import java.util.concurrent.*;
import java.util.*;

/**
 * ==============================================================================
 * MODULE 13: CONCURRENT COLLECTIONS (Multi-Threaded Safety)
 * ==============================================================================
 * 
 * CORE CONCEPTS:
 * 1. ConcurrentHashMap: Lock Striping / CAS (Compare-And-Swap).
 *    - Reads are completely non-blocking.
 *    - Writes lock only the affected bucket node/segment, allowing high concurrent throughput.
 * 2. CopyOnWriteArrayList:
 *    - Creates a fresh copy of the backing array on every write (add, set, remove).
 *    - Ideal for read-heavy scenarios (e.g. event listeners, subscriber lists).
 * 3. BlockingQueue (ArrayBlockingQueue / LinkedBlockingQueue):
 *    - Thread-safe Producer-Consumer queue with blocking `put()` and `take()` methods.
 */

class Concurrent_Collections {

    // 1. CONCURRENTHASHMAP DEMO
    public static void concurrentHashMapDemo() {
        System.out.println("==================================================");
        System.out.println("1. ConcurrentHashMap (High Throughput Thread-Safe Map)");
        System.out.println("==================================================");

        ConcurrentMap<String, Integer> pageHits = new ConcurrentHashMap<>();

        // Atomic update operations without synchronized blocks
        pageHits.putIfAbsent("home", 0);
        pageHits.compute("home", (k, v) -> (v == null) ? 1 : v + 10);
        pageHits.merge("about", 5, Integer::sum);
        pageHits.merge("about", 10, Integer::sum);

        System.out.println("Page Hits: " + pageHits);
    }

    // 2. COPYONWRITEARRAYLIST (FAIL-SAFE ITERATION)
    public static void copyOnWriteDemo() {
        System.out.println("\n==================================================");
        System.out.println("2. CopyOnWriteArrayList (Fail-Safe Iteration)");
        System.out.println("==================================================");

        List<String> subscribers = new CopyOnWriteArrayList<>(Arrays.asList("User1", "User2", "User3"));

        System.out.println("Iterating while simultaneously modifying list:");
        for (String sub : subscribers) {
            System.out.println("  Notifying: " + sub);
            if (sub.equals("User2")) {
                subscribers.add("User4_New"); // Does NOT throw ConcurrentModificationException!
            }
        }

        System.out.println("Final Subscribers after iteration: " + subscribers);
    }

    // 3. PRODUCER-CONSUMER WITH BLOCKINGQUEUE
    public static void producerConsumerDemo() throws InterruptedException {
        System.out.println("\n==================================================");
        System.out.println("3. Producer-Consumer with ArrayBlockingQueue");
        System.out.println("==================================================");

        BlockingQueue<String> messageQueue = new ArrayBlockingQueue<>(3);

        // Producer Thread
        Thread producer = new Thread(() -> {
            try {
                String[] msgs = {"Message 1", "Message 2", "Message 3", "Message 4"};
                for (String m : msgs) {
                    messageQueue.put(m); // Blocks if queue is full
                    System.out.println(" [Producer] -> Produced: " + m);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 4; i++) {
                    String item = messageQueue.take(); // Blocks if queue is empty
                    System.out.println(" [Consumer] <- Consumed: " + item);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
        System.out.println("Producer-Consumer completed successfully.");
    }

    public static void main(String[] args) throws InterruptedException {
        concurrentHashMapDemo();
        copyOnWriteDemo();
        producerConsumerDemo();
    }
}
