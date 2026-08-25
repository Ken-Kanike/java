import java.util.*;
import java.util.stream.Collectors;

/**
 * ==============================================================================
 * MODULE 14: STREAMS API & COLLECTORS WITH COLLECTIONS
 * ==============================================================================
 * 
 * CORE CONCEPTS:
 * 1. Stream: A sequence of elements supporting sequential and parallel aggregate operations.
 * 2. Intermediate Operations (Lazy): filter(), map(), sorted(), distinct(), limit().
 * 3. Terminal Operations (Eager): collect(), forEach(), reduce(), count(), anyMatch().
 * 4. Collectors:
 *    - toList(), toSet(), toMap()
 *    - groupingBy() (SQL-like GROUP BY)
 *    - partitioningBy() (Splits by boolean predicate)
 *    - summarizingDouble() (Calculates count, sum, min, average, max in one pass)
 */

class Employee {
    private final int id;
    private final String name;
    private final String department;
    private final double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return String.format("%s (%s) - $%,.2f", name, department, salary);
    }
}

class Streams_With_Collections {

    private static List<Employee> getSampleEmployees() {
        return Arrays.asList(
            new Employee(1, "Alice", "Engineering", 120_000),
            new Employee(2, "Bob", "Marketing", 85_000),
            new Employee(3, "Charlie", "Engineering", 140_000),
            new Employee(4, "Diana", "HR", 75_000),
            new Employee(5, "Evan", "Marketing", 95_000),
            new Employee(6, "Fiona", "Engineering", 110_000)
        );
    }

    // 1. FILTERING, MAPPING, AND SORTING
    public static void filterMapSortDemo() {
        System.out.println("==================================================");
        System.out.println("1. Filtering, Mapping & Sorting");
        System.out.println("==================================================");

        List<Employee> employees = getSampleEmployees();

        // Get names of Engineering employees earning > $115,000, sorted alphabetically
        List<String> topEngineers = employees.stream()
            .filter(e -> e.getDepartment().equals("Engineering"))
            .filter(e -> e.getSalary() > 115_000)
            .sorted(Comparator.comparing(Employee::getName))
            .map(Employee::getName)
            .collect(Collectors.toList());

        System.out.println("Top Engineers: " + topEngineers);
    }

    // 2. ADVANCED GROUPING AND PARTITIONING
    public static void groupingDemo() {
        System.out.println("\n==================================================");
        System.out.println("2. GroupingBy and PartitioningBy");
        System.out.println("==================================================");

        List<Employee> employees = getSampleEmployees();

        // Group employees by Department
        Map<String, List<Employee>> byDept = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("Employees Grouped by Department:");
        byDept.forEach((dept, list) -> {
            System.out.println("  [" + dept + "]: " + list);
        });

        // Average Salary per Department
        Map<String, Double> avgSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
            ));

        System.out.println("\nAverage Salary by Department:");
        avgSalaryByDept.forEach((dept, avg) -> System.out.printf("  %-12s -> $%,.2f%n", dept, avg));

        // Partitioning into High Earners (Salary >= 100,000) vs Regular
        Map<Boolean, List<Employee>> partitioned = employees.stream()
            .collect(Collectors.partitioningBy(e -> e.getSalary() >= 100_000));

        System.out.println("\nHigh Earners (>= $100k): " + partitioned.get(true).size() + " employees");
        System.out.println("Regular Earners (< $100k): " + partitioned.get(false).size() + " employees");
    }

    // 3. STATISTICAL SUMMARIZATION
    public static void statisticsDemo() {
        System.out.println("\n==================================================");
        System.out.println("3. Summarizing Statistics");
        System.out.println("==================================================");

        List<Employee> employees = getSampleEmployees();

        DoubleSummaryStatistics stats = employees.stream()
            .collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.printf("Total Count: %d%n", stats.getCount());
        System.out.printf("Total Payroll: $%,.2f%n", stats.getSum());
        System.out.printf("Min Salary:    $%,.2f%n", stats.getMin());
        System.out.printf("Average Salary:$%,.2f%n", stats.getAverage());
        System.out.printf("Max Salary:    $%,.2f%n", stats.getMax());
    }

    public static void main(String[] args) {
        filterMapSortDemo();
        groupingDemo();
        statisticsDemo();
    }
}
