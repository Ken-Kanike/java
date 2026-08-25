/**
 * ==============================================================================
 * MODULE 03: CONTROL STATEMENTS & MODERN SWITCH EXPRESSIONS
 * ==============================================================================
 * 
 * CORE CONCEPTS:
 * 1. if, if-else, and if-else-if ladder.
 * 2. Nested conditions.
 * 3. Traditional switch statement with break.
 * 4. Modern Java Enhanced Switch Expression (with arrow syntax -> and yield).
 */

class Control_Statements_Conditionals {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("1. If-Else-If Decision Ladder");
        System.out.println("==================================================");

        int age = 22;
        boolean hasLicense = true;

        if (age >= 18 && hasLicense) {
            System.out.println("Eligible to drive independently.");
        } else if (age >= 16) {
            System.out.println("Eligible for learner permit with supervision.");
        } else {
            System.out.println("Not eligible to drive.");
        }

        System.out.println("\n==================================================");
        System.out.println("2. Modern Java Enhanced Switch (Arrow Syntax)");
        System.out.println("==================================================");

        String day = "WEDNESDAY";
        // Modern switch expression returning a value without fallthrough bugs
        String dayType = switch (day) {
            case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> "Weekday";
            case "SATURDAY", "SUNDAY" -> "Weekend";
            default -> "Invalid Day";
        };

        System.out.printf("Day: %s -> Type: %s%n", day, dayType);

        // Switch with code blocks and yield
        int quarter = 3;
        String season = switch (quarter) {
            case 1 -> "Winter to Spring";
            case 2 -> "Spring to Summer";
            case 3 -> {
                System.out.println("Processing Q3 Summer Peak...");
                yield "Summer to Autumn";
            }
            case 4 -> "Autumn to Winter";
            default -> throw new IllegalArgumentException("Unexpected quarter: " + quarter);
        };
        System.out.println("Quarter " + quarter + " Season: " + season);
    }
}
