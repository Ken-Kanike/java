import java.util.*;

/**
 * ==============================================================================
 * MODULE 07: ARRAYDEQUE (High Performance Stack & Queue)
 * ==============================================================================
 * 
 * CORE CONCEPTS:
 * 1. Data Structure: Resizable circular array buffer (head and tail pointers).
 * 2. Superior Performance:
 *    - Faster than Stack (no synchronized overhead).
 *    - Faster than LinkedList when used as a Queue (no node allocation / GC overhead, better CPU cache locality).
 * 3. Double-Ended: Insert/delete at BOTH head and tail in O(1) amortized time.
 * 4. Capacity: Automatically doubles when full; no capacity restrictions.
 * 5. Does NOT allow null values.
 */

class ArrayDeque_Modern_Queue_Stack {

    // 1. ARRAYDEQUE AS A MODERN FIFO QUEUE
    public static void queueDemo() {
        System.out.println("==================================================");
        System.out.println("1. ArrayDeque as a FIFO Queue (First In, First Out)");
        System.out.println("==================================================");

        Queue<String> printJobs = new ArrayDeque<>();

        // Enqueue (add at tail)
        printJobs.offer("Doc1_Invoice.pdf");
        printJobs.offer("Doc2_Resume.pdf");
        printJobs.offer("Doc3_Report.pdf");

        System.out.println("Current Queue: " + printJobs);
        System.out.println("Next job to print (peek): " + printJobs.peek());

        // Dequeue (remove from head)
        while (!printJobs.isEmpty()) {
            System.out.println("Printing & processing: " + printJobs.poll());
        }
    }

    // 2. ARRAYDEQUE AS A MODERN LIFO STACK
    public static void stackDemo() {
        System.out.println("\n==================================================");
        System.out.println("2. ArrayDeque as a Modern LIFO Stack (Preferred over java.util.Stack)");
        System.out.println("==================================================");

        Deque<String> undoStack = new ArrayDeque<>();

        // Push action
        undoStack.push("Type 'Hello'");
        undoStack.push("Change Font to Bold");
        undoStack.push("Insert Image");

        System.out.println("Undo Stack: " + undoStack);

        // Pop action (Undo)
        while (!undoStack.isEmpty()) {
            System.out.println("Reverting action: " + undoStack.pop());
        }
    }

    // 3. SLIDING WINDOW MAXIMUM ALGORITHM (CLASSIC DEQUE PATTERN)
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resultIndex = 0;

        // Store indices of useful elements in monotonically decreasing order of their values
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // Remove indices that fall outside the current sliding window [i - k + 1, i]
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller values from back as they are useless for max
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // Record window maximum once window of size k is formed
            if (i >= k - 1) {
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        queueDemo();
        stackDemo();

        System.out.println("\n==================================================");
        System.out.println("3. Sliding Window Maximum with Deque (O(N) time)");
        System.out.println("==================================================");
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] maxes = maxSlidingWindow(nums, k);
        System.out.println("Array: " + Arrays.toString(nums) + ", Window Size: " + k);
        System.out.println("Sliding Window Maximums: " + Arrays.toString(maxes));
    }
}
