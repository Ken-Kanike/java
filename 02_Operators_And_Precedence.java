/**
 * ==============================================================================
 * MODULE 02: OPERATORS & OPERATOR PRECEDENCE
 * ==============================================================================
 * 
 * CORE CONCEPTS:
 * 1. Arithmetic (+, -, *, /, %) & Integer Division nuances.
 * 2. Relational (==, !=, <, >, <=, >=).
 * 3. Logical (&&, ||, !) with Short-Circuit Evaluation.
 * 4. Bitwise (&, |, ^, ~, <<, >>, >>> unsigned right shift).
 * 5. Ternary Operator (condition ? valTrue : valFalse).
 * 6. Assignment & Compound Assignment (+=, -=, *=, /=).
 */

class Operators_And_Precedence {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("1. Short-Circuit Logical Operators (&& vs &)");
        System.out.println("==================================================");

        int a = 10;
        int b = 20;

        // In short-circuit (&&), if first operand is false, second is NEVER evaluated
        if (a > 15 && ++b > 20) {
            System.out.println("Condition met");
        }
        System.out.println("Value of b after short-circuit && (still 20, not incremented): " + b);

        // In bitwise (&), both sides are evaluated unconditionally
        if (a > 15 & ++b > 20) {
            System.out.println("Condition met");
        }
        System.out.println("Value of b after non-short-circuit & (incremented): " + b);

        System.out.println("\n==================================================");
        System.out.println("2. Bitwise Shifts (<<, >>, >>>)");
        System.out.println("==================================================");
        int num = 8; // 0000 1000
        System.out.println("Original: 8");
        System.out.println("Left Shift (8 << 2) [Multiply by 2^2]: " + (num << 2)); // 32
        System.out.println("Right Shift (8 >> 2) [Divide by 2^2]:   " + (num >> 2)); // 2

        int negativeNum = -16;
        System.out.println("-16 >> 2 (Arithmetic signed shift):  " + (negativeNum >> 2));
        System.out.println("-16 >>> 2 (Logical unsigned shift): " + (negativeNum >>> 2));

        System.out.println("\n==================================================");
        System.out.println("3. Ternary Operator & Precedence");
        System.out.println("==================================================");
        int score = 85;
        String grade = (score >= 90) ? "A" : (score >= 80) ? "B" : "C";
        System.out.println("Score: " + score + " -> Grade: " + grade);

        // Precedence demonstration: * has higher precedence than +
        int result = 5 + 3 * 2; // 5 + 6 = 11 (NOT 16)
        System.out.println("Result of 5 + 3 * 2: " + result);
    }
}
