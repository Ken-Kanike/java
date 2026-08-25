import java.util.*;

/**
 * ==============================================================================
 * MODULE 12: ITERATORS & FAIL-FAST VS FAIL-SAFE BEHAVIOR
 * ==============================================================================
 * 
 * CORE CONCEPTS:
 * 1. Cursors:
 *    - Iterator: Forward-only traversal for all Collections (hasNext, next, remove).
 *    - ListIterator: Bidirectional traversal for Lists only (hasPrevious, previous, add, set).
 *    - Enumeration: Legacy forward cursor (Vector, Hashtable).
 * 2. Fail-Fast (Default Collections):
 *    - Uses an internal `modCount` counter.
 *    - If collection is modified structurally during iteration (outside iterator.remove()),
 *      throws `ConcurrentModificationException` immediately.
 * 3. Fail-Safe (Concurrent Collections):
 *    - Operates on a cloned array / snapshot (e.g. CopyOnWriteArrayList, ConcurrentHashMap).
 *    - Does NOT throw `ConcurrentModificationException`.
 */

class Iterators_And_FailFast {

    // 1. ITERATOR VS LISTITERATOR
    public static void iteratorBasicsDemo() {
        System.out.println("==================================================");
        System.out.println("1. Iterator vs ListIterator Traversal");
        System.out.println("==================================================");

        List<String> frameworkList = new ArrayList<>(Arrays.asList("Spring", "Hibernate", "Struts", "Quarkus"));

        // Forward traversal with standard Iterator & safe removal
        Iterator<String> it = frameworkList.iterator();
        while (it.hasNext()) {
            String fw = it.next();
            if (fw.equals("Struts")) {
                it.remove(); // SAFE removal during iteration!
            }
        }
        System.out.println("After safe Iterator.remove(): " + frameworkList);

        // Bidirectional traversal with ListIterator
        ListIterator<String> listIt = frameworkList.listIterator();
        System.out.println("\nListIterator Forward:");
        while (listIt.hasNext()) {
            System.out.println("Index " + listIt.nextIndex() + " -> " + listIt.next());
        }

        System.out.println("\nListIterator Backward:");
        while (listIt.hasPrevious()) {
            System.out.println("Index " + listIt.previousIndex() + " -> " + listIt.previous());
        }
    }

    // 2. CONCURRENT MODIFICATION EXCEPTION & FAIL-FAST
    public static void failFastDemo() {
        System.out.println("\n==================================================");
        System.out.println("2. The Fail-Fast Mechanism & ConcurrentModificationException");
        System.out.println("==================================================");

        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));

        try {
            for (String item : list) {
                if (item.equals("B")) {
                    list.remove("B"); // DANGER: Structural modification via List directly!
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("CAUGHT ConcurrentModificationException!");
            System.out.println("Explanation: Enhanced for-loop uses an Iterator internally. Modifying the list directly");
            System.out.println("mismatches expectedModCount != modCount, triggering fail-fast safety check.");
        }

        // Modern safe alternative: removeIf (Java 8+)
        list.removeIf(s -> s.equals("B"));
        System.out.println("Safely removed 'B' using Collection.removeIf(): " + list);
    }

    public static void main(String[] args) {
        iteratorBasicsDemo();
        failFastDemo();
    }
}
