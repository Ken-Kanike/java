/**
 * ==============================================================================
 * MODULE 01: DATA TYPES, LITERALS & MEMORY SIZES
 * ==============================================================================
 * 
 * CORE CONCEPTS:
 * 1. 8 Primitive Data Types: byte, short, int, long, float, double, char, boolean.
 * 2. Wrapper Classes: Byte, Short, Integer, Long, Float, Double, Character, Boolean.
 * 3. Range & Limits: Min/Max values and bit widths.
 * 4. Literals: Binary (0b), Octal (0), Hexadecimal (0x), underscore in numbers (1_000_000).
 */

class DataTypes_And_Variables {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("1. Java 8 Primitive Data Types & Specifications");
        System.out.println("==================================================");

        // Integer Types
        byte byteVal = 127;                          // 8-bit (-128 to 127)
        short shortVal = 32767;                      // 16-bit (-32,768 to 32,767)
        int intVal = 2_147_483_647;                  // 32-bit (~ -2.14B to 2.14B)
        long longVal = 9_223_372_036_854_775_807L;   // 64-bit with 'L' suffix

        // Floating Point Types
        float floatVal = 3.14159f;                   // 32-bit IEEE 754 with 'f' suffix
        double doubleVal = 2.718281828459045;        // 64-bit IEEE 754 (default decimal)

        // Character & Boolean
        char charVal = 'A';                          // 16-bit Unicode character (0 to 65,535)
        char unicodeChar = '\u2615';                 // Coffee cup Unicode symbol ☕
        boolean isJavaAwesome = true;                // true or false

        System.out.printf("byte:    %d (Size: %d bits, Range: %d to %d)%n", 
                byteVal, Byte.SIZE, Byte.MIN_VALUE, Byte.MAX_VALUE);
        System.out.printf("short:   %d (Size: %d bits, Range: %d to %d)%n", 
                shortVal, Short.SIZE, Short.MIN_VALUE, Short.MAX_VALUE);
        System.out.printf("int:     %,d (Size: %d bits, Range: %,d to %,d)%n", 
                intVal, Integer.SIZE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.printf("long:    %,d (Size: %d bits)%n", longVal, Long.SIZE);
        System.out.printf("float:   %f (Precision: 6-7 decimal digits)%n", floatVal);
        System.out.printf("double:  %f (Precision: 15-16 decimal digits)%n", doubleVal);
        System.out.printf("char:    %c (Unicode: %s)%n", charVal, unicodeChar);
        System.out.printf("boolean: %b%n", isJavaAwesome);

        System.out.println("\n==================================================");
        System.out.println("2. Number Base Literals");
        System.out.println("==================================================");
        int decimal = 42;
        int binary = 0b101010; // 0b prefix
        int octal = 052;       // 0 prefix
        int hex = 0x2A;        // 0x prefix

        System.out.printf("Decimal 42 in Binary (0b101010): %d%n", binary);
        System.out.printf("Decimal 42 in Octal  (052):      %d%n", octal);
        System.out.printf("Decimal 42 in Hex    (0x2A):     %d%n", hex);
    }
}
