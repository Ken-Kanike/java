import java.util.*;

/**
 * ==============================================================================
 * MODULE 06: PRIORITYQUEUE & HEAP (Priority-based Processing)
 * ==============================================================================
 * 
 * CORE CONCEPTS:
 * 1. Data Structure: Binary Heap (represented as a dynamic array).
 * 2. Default: Min-Heap (head is the smallest element according to natural order).
 * 3. Max-Heap: Created using Collections.reverseOrder() or custom Comparator.
 * 4. Time Complexity:
 *    - offer() / add():  O(log n)
 *    - poll() / remove(): O(log n)
 *    - peek():            O(1)
 * 5. Does NOT permit null elements.
 */

// Model class for Hospital Emergency Room Triage
class Patient {
    private final String name;
    private final int severity; // 1 = Critical, 2 = Urgent, 3 = Stable

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() { return name; }
    public int getSeverity() { return severity; }

    @Override
    public String toString() {
        String level = switch (severity) {
            case 1 -> "CRITICAL";
            case 2 -> "URGENT";
            default -> "STABLE";
        };
        return String.format("Patient{name='%s', priority=%s}", name, level);
    }
}

class PriorityQueue_And_Heap {

    // 1. MIN-HEAP VS MAX-HEAP BASICS
    public static void minMaxHeapDemo() {
        System.out.println("==================================================");
        System.out.println("1. Min-Heap vs Max-Heap with PriorityQueue");
        System.out.println("==================================================");

        // Default: Min-Heap (Smallest integer served first)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(40);
        minHeap.offer(10);
        minHeap.offer(30);
        minHeap.offer(5);

        System.out.print("Min-Heap Dequeue Order: ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " "); // 5 10 30 40
        }
        System.out.println();

        // Max-Heap: Largest integer served first
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(40);
        maxHeap.offer(10);
        maxHeap.offer(30);
        maxHeap.offer(5);

        System.out.print("Max-Heap Dequeue Order: ");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " "); // 40 30 10 5
        }
        System.out.println();
    }

    // 2. REAL WORLD SIMULATION: EMERGENCY ROOM TRIAGE
    public static void hospitalTriageDemo() {
        System.out.println("\n==================================================");
        System.out.println("2. Real World Simulation: Hospital ER Triage");
        System.out.println("==================================================");

        // Comparator: Lowest severity number (1) has highest priority
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(
            Comparator.comparingInt(Patient::getSeverity)
        );

        triageQueue.offer(new Patient("John (Fever)", 3));
        triageQueue.offer(new Patient("Sarah (Cardiac Arrest)", 1));
        triageQueue.offer(new Patient("Mark (Fractured Arm)", 2));
        triageQueue.offer(new Patient("Elena (Severe Bleeding)", 1));

        System.out.println("Doctor attending patients in order of medical priority:");
        while (!triageQueue.isEmpty()) {
            Patient p = triageQueue.poll();
            System.out.println("  -> Treated: " + p);
        }
    }

    // 3. FINDING K-TH LARGEST ELEMENT USING A MIN-HEAP
    public static int findKthLargest(int[] nums, int k) {
        // Maintain a Min-Heap of size k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Evict smallest
            }
        }
        return minHeap.peek(); // Top of heap is the k-th largest
    }

    public static void main(String[] args) {
        minMaxHeapDemo();
        hospitalTriageDemo();

        System.out.println("\n==================================================");
        System.out.println("3. Top K Elements Problem (Heap Algorithm)");
        System.out.println("==================================================");
        int[] nums = {3, 2, 1, 5, 6, 4, 10, 8};
        int k = 3;
        System.out.println("Input Array: " + Arrays.toString(nums));
        System.out.println(k + "-th Largest Element: " + findKthLargest(nums, k));
    }
}
