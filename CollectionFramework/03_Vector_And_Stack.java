import java.util.*;

/**
 * ==============================================================================
 * MODULE 03: VECTOR & STACK (Legacy Collections & Modern Alternatives)
 * ==============================================================================
 * 
 * CORE CONCEPTS:
 * 1. Vector: Legacy resizable array, thread-safe (synchronized methods), doubles capacity (100% growth).
 * 2. Stack: Legacy LIFO structure extending Vector (inherits unnecessary vector index methods).
 * 3. Modern Recommendation:
 *    - Use ArrayList instead of Vector for single-threaded.
 *    - Use Collections.synchronizedList() or CopyOnWriteArrayList for concurrency.
 *    - Use ArrayDeque instead of Stack for LIFO operations (faster, no synchronization lock contention).
 */

class Vector_And_Stack {

    // 1. VECTOR OPERATIONS
    public static void vectorDemo() {
        System.out.println("==================================================");
        System.out.println("1. Vector Demonstration (Legacy Thread-Safe List)");
        System.out.println("==================================================");

        Vector<String> vector = new Vector<>(3, 2); // Initial capacity 3, capacity increment 2
        System.out.println("Initial Capacity: " + vector.capacity());

        vector.add("Alpha");
        vector.add("Beta");
        vector.add("Gamma");
        System.out.println("Capacity with 3 elements: " + vector.capacity());

        vector.add("Delta"); // Triggers growth by increment of 2 -> 5
        System.out.println("Capacity after 4th element: " + vector.capacity());
        System.out.println("Elements: " + vector);

        // Enumeration (legacy cursor for Vector)
        Enumeration<String> en = vector.elements();
        System.out.print("Enumeration traversal: ");
        while (en.hasMoreElements()) {
            System.out.print(en.nextElement() + " ");
        }
        System.out.println();
    }

    // 2. STACK (LIFO) OPERATIONS
    public static void stackDemo() {
        System.out.println("\n==================================================");
        System.out.println("2. Stack (LIFO - Last In First Out)");
        System.out.println("==================================================");

        Stack<String> browserHistory = new Stack<>();

        // Push: add to top
        browserHistory.push("google.com");
        browserHistory.push("github.com");
        browserHistory.push("stackoverflow.com");

        System.out.println("Stack: " + browserHistory);
        System.out.println("Top element (peek): " + browserHistory.peek());

        // Pop: remove from top
        String lastVisited = browserHistory.pop();
        System.out.println("Popped (Back button): " + lastVisited);
        System.out.println("Current Stack: " + browserHistory);

        // Search: 1-based index from top of stack (-1 if not found)
        System.out.println("1-based Position of 'google.com' from top: " + browserHistory.search("google.com"));
    }

    // 3. CLASSIC PROBLEM: BALANCED PARENTHESES CHECKER
    public static boolean isBalanced(String expression) {
        // Modern approach: ArrayDeque as stack
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        vectorDemo();
        stackDemo();

        System.out.println("\n==================================================");
        System.out.println("3. Balanced Parentheses (Practical Stack Problem)");
        System.out.println("==================================================");
        String expr1 = "{ [ ( a + b ) * c ] + d }";
        String expr2 = "{ [ ( a + b ) } ]";
        System.out.println("Is '" + expr1 + "' balanced? " + isBalanced(expr1));
        System.out.println("Is '" + expr2 + "' balanced? " + isBalanced(expr2));
    }
}
