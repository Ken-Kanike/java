/**
 * ==============================================================================
 * MODULE 06: STRINGS, STRING POOL & STRINGBUILDER
 * ==============================================================================
 * 
 * CORE CONCEPTS:
 * 1. String Immutability & The String Constant Pool (SCP).
 * 2. == (Reference Identity) vs .equals() (Content Equality).
 * 3. StringBuilder (Mutable, High-Performance, Unsynchronized) vs StringBuffer (Synchronized).
 * 4. Common String Operations: substring, split, replace, trim, toCharArray.
 */

class Strings_And_StringBuilder {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("1. String Pool & Equality (== vs .equals())");
        System.out.println("==================================================");

        String s1 = "Java";               // Lives in String Constant Pool
        String s2 = "Java";               // Points to same SCP reference
        String s3 = new String("Java");   // Creates a new Object on Heap

        System.out.println("s1 == s2 (Same SCP reference):      " + (s1 == s2));      // true
        System.out.println("s1 == s3 (Heap vs SCP reference):    " + (s1 == s3));      // false
        System.out.println("s1.equals(s3) (Content comparison):   " + s1.equals(s3));   // true

        // s3.intern() returns the canonical SCP reference
        System.out.println("s1 == s3.intern():                   " + (s1 == s3.intern())); // true

        System.out.println("\n==================================================");
        System.out.println("2. StringBuilder Performance vs String Concatenation");
        System.out.println("==================================================");

        StringBuilder sb = new StringBuilder("Core");
        sb.append(" Java");
        sb.append(" Mastery");
        sb.insert(0, "🔥 ");
        sb.reverse();

        System.out.println("Reversed StringBuilder: " + sb);
        sb.reverse(); // Restore
        System.out.println("Restored:               " + sb);

        System.out.println("\n==================================================");
        System.out.println("3. Useful String Manipulation Algorithms");
        System.out.println("==================================================");

        String text = "   Java,Python,Rust,Kotlin,Go   ";
        String[] languages = text.trim().split(",");

        System.out.println("Trimmed & Split array:");
        for (String lang : languages) {
            System.out.println("  -> " + lang);
        }

        // Palindrome Checker
        String palindromeTest = "racecar";
        boolean isPalindrome = new StringBuilder(palindromeTest).reverse().toString().equals(palindromeTest);
        System.out.printf("Is '%s' a palindrome? %b%n", palindromeTest, isPalindrome);
    }
}
