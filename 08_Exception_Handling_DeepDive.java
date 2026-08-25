/**
 * ==============================================================================
 * MODULE 08: EXCEPTION HANDLING & TRY-WITH-RESOURCES
 * ==============================================================================
 * 
 * CORE CONCEPTS:
 * 1. Throwable Hierarchy: Error vs Exception (Checked vs Unchecked/RuntimeException).
 * 2. try, catch, multi-catch, and finally.
 * 3. try-with-resources (AutoCloseable interface).
 * 4. throw vs throws.
 * 5. Creating Custom Checked & Unchecked Exceptions.
 */

// Custom Checked Exception (Must be declared or handled)
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Custom AutoCloseable Resource
class DatabaseConnection implements AutoCloseable {
    public void executeQuery(String sql) {
        System.out.println("Executing SQL query: " + sql);
    }

    @Override
    public void close() {
        System.out.println("DatabaseConnection closed automatically by Try-With-Resources!");
    }
}

class Exception_Handling_DeepDive {

    public static void withdraw(double balance, double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(
                String.format("Cannot withdraw $%.2f. Current balance is only $%.2f.", amount, balance)
            );
        }
        System.out.printf("Successfully withdrew $%.2f. Remaining balance: $%.2f%n", amount, balance - amount);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("1. Multi-Catch & Finally Block Execution");
        System.out.println("==================================================");

        try {
            int[] arr = {10, 20, 30};
            int divisor = 0;
            // Uncomment to trigger ArithmeticException:
            // int result = arr[0] / divisor;
            // Triggers ArrayIndexOutOfBoundsException:
            int val = arr[5];
            System.out.println("Val: " + val);
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught Expected Exception: " + e.getClass().getSimpleName() + " -> " + e.getMessage());
        } finally {
            System.out.println("Finally block ALWAYS executes (used for cleanup).");
        }

        System.out.println("\n==================================================");
        System.out.println("2. Try-With-Resources (AutoCloseable Pattern)");
        System.out.println("==================================================");

        try (DatabaseConnection conn = new DatabaseConnection()) {
            conn.executeQuery("SELECT * FROM users");
        } // conn.close() is automatically called here, even if an exception occurs!

        System.out.println("\n==================================================");
        System.out.println("3. Custom Checked Exception Handling");
        System.out.println("==================================================");

        try {
            withdraw(100.0, 250.0);
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction Failed: " + e.getMessage());
        }
    }
}
