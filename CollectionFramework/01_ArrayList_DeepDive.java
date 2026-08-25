import java.util.*;

/**
 * ==============================================================================
 * MODULE 01: ARRAYLIST DEEP DIVE (Basic to Advanced)
 * ==============================================================================
 * 
 * CORE CONCEPTS:
 * 1. Resizable Array: Backed by an Object[] array.
 * 2. Growth Formula: newCapacity = oldCapacity + (oldCapacity >> 1)  (~ 1.5x growth)
 * 3. Access Time: O(1) random access by index.
 * 4. Insert/Delete: O(1) amortized at tail; O(n) at middle/head (requires arraycopy).
 * 5. Not Thread-Safe.
 */

// Custom model class to demonstrate sorting and object management
class Student implements Comparable<Student> {
    private final int id;
    private final String name;
    private final double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getGpa() { return gpa; }

    // Natural ordering: by ID ascending
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return String.format("Student{id=%d, name='%s', gpa=%.2f}", id, name, gpa);
    }
}

class ArrayList_DeepDive {

    // 1. BASIC CRUD OPERATIONS
    public static void basicCrudDemo() {
        System.out.println("==================================================");
        System.out.println("1. Basic CRUD Operations in ArrayList");
        System.out.println("==================================================");

        List<String> cities = new ArrayList<>();

        // Create / Add
        cities.add("Tokyo");
        cities.add("New York");
        cities.add("London");
        cities.add(1, "Paris"); // Inserts at index 1, shifts elements right
        System.out.println("Initial List: " + cities);

        // Read / Access
        String firstCity = cities.get(0);
        System.out.println("City at index 0: " + firstCity);
        System.out.println("Contains 'London'? " + cities.contains("London"));
        System.out.println("Index of 'London': " + cities.indexOf("London"));

        // Update
        cities.set(2, "Berlin"); // Replaces element at index 2
        System.out.println("After updating index 2 to 'Berlin': " + cities);

        // Delete / Remove
        cities.remove("Tokyo"); // Remove by object
        cities.remove(0);       // Remove by index
        System.out.println("After removals: " + cities);
        System.out.println("Size: " + cities.size() + ", Is Empty: " + cities.isEmpty());
    }

    // 2. CAPACITY & MEMORY MANAGEMENT
    public static void capacityManagementDemo() {
        System.out.println("\n==================================================");
        System.out.println("2. Capacity & Memory Optimization");
        System.out.println("==================================================");

        // Pre-allocating initial capacity avoids multiple costly internal array re-allocations
        ArrayList<Integer> numbers = new ArrayList<>(1000); // initial capacity = 1000

        for (int i = 1; i <= 50; i++) {
            numbers.add(i * 10);
        }

        // ensureCapacity guarantees the list can hold at least the specified number of elements
        numbers.ensureCapacity(2000);
        System.out.println("Added 50 elements with pre-allocated buffer.");

        // trimToSize trims the internal array capacity down to current size to free unused memory
        numbers.trimToSize();
        System.out.println("Trimmed internal capacity to current size: " + numbers.size());
    }

    // 3. SORTING WITH COMPARABLE & COMPARATOR
    public static void sortingDemo() {
        System.out.println("\n==================================================");
        System.out.println("3. Sorting Custom Objects (Comparable & Comparator)");
        System.out.println("==================================================");

        List<Student> roster = new ArrayList<>();
        roster.add(new Student(103, "Bob", 3.8));
        roster.add(new Student(101, "Alice", 3.9));
        roster.add(new Student(105, "Charlie", 3.4));
        roster.add(new Student(102, "David", 3.6));

        System.out.println("Original Roster:");
        roster.forEach(System.out::println);

        // 1. Natural sorting via Comparable (by ID)
        Collections.sort(roster);
        System.out.println("\nSorted by ID (Comparable Natural Order):");
        roster.forEach(System.out::println);

        // 2. Custom sorting via Comparator (by GPA descending)
        roster.sort(Comparator.comparingDouble(Student::getGpa).reversed());
        System.out.println("\nSorted by GPA Descending (Comparator):");
        roster.forEach(System.out::println);

        // 3. Multi-field sorting (by Name, then by GPA)
        roster.sort(Comparator.comparing(Student::getName).thenComparing(Student::getGpa));
        System.out.println("\nSorted by Name then GPA:");
        roster.forEach(System.out::println);
    }

    // 4. ARRAY <-> ARRAYLIST CONVERSIONS
    public static void conversionDemo() {
        System.out.println("\n==================================================");
        System.out.println("4. Array <-> ArrayList Conversions");
        System.out.println("==================================================");

        // Convert Array -> List
        String[] skillArray = {"Java", "Python", "Rust", "Go"};
        
        // Fixed-size list backed by array (modifying will alter array, cannot add/remove)
        List<String> fixedList = Arrays.asList(skillArray);
        System.out.println("Fixed-size List (backed by array): " + fixedList);
        
        // Mutable, independent ArrayList
        List<String> mutableList = new ArrayList<>(Arrays.asList(skillArray));
        mutableList.add("TypeScript");
        System.out.println("Mutable List: " + mutableList);

        // Convert List -> Array
        String[] exportedArray = mutableList.toArray(new String[0]);
        System.out.println("Exported Array: " + Arrays.toString(exportedArray));
    }

    public static void main(String[] args) {
        basicCrudDemo();
        capacityManagementDemo();
        sortingDemo();
        conversionDemo();
    }
}
