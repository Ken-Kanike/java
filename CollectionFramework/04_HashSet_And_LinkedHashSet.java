import java.util.*;

/**
 * ==============================================================================
 * MODULE 04: HASHSET & LINKEDHASHSET (Hashing & Uniqueness)
 * ==============================================================================
 * 
 * CORE CONCEPTS:
 * 1. Uniqueness: Stores unique elements only (no duplicates).
 * 2. Underlying Structure: Backed by a HashMap instance internally.
 * 3. Hashing Contract: If a.equals(b) == true, then a.hashCode() MUST EQUAL b.hashCode().
 * 4. HashSet: Unordered, fastest O(1) average lookup/insert.
 * 5. LinkedHashSet: Maintains insertion-order via a doubly-linked list through entries.
 */

// Custom object demonstrating proper equals() and hashCode() implementation
class Book {
    private final String isbn;
    private final String title;
    private final String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "Book{" + "isbn='" + isbn + '\'' + ", title='" + title + '\'' + ", author='" + author + '\'' + '}';
    }
}

class HashSet_And_LinkedHashSet {

    // 1. BASIC HASHSET & CONTRACT VIOLATION DEMO
    public static void hashSetBasicsDemo() {
        System.out.println("==================================================");
        System.out.println("1. HashSet & equals() / hashCode() Contract");
        System.out.println("==================================================");

        Set<Book> library = new HashSet<>();
        Book b1 = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        Book b2 = new Book("978-0134685991", "Effective Java (Copy)", "Joshua Bloch"); // Same ISBN
        Book b3 = new Book("978-0596009205", "Head First Java", "Kathy Sierra");

        library.add(b1);
        boolean addedDuplicate = library.add(b2); // Returns false because equals & hashCode match b1
        library.add(b3);

        System.out.println("Was duplicate ISBN added? " + addedDuplicate);
        System.out.println("Total unique books in library: " + library.size());
        library.forEach(System.out::println);
    }

    // 2. MATHEMATICAL SET OPERATIONS (Union, Intersection, Difference)
    public static void setOperationsDemo() {
        System.out.println("\n==================================================");
        System.out.println("2. Mathematical Set Operations");
        System.out.println("==================================================");

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        // Union (A ∪ B)
        Set<Integer> union = new HashSet<>(setA);
        union.addAll(setB);
        System.out.println("Union (A ∪ B): " + union);

        // Intersection (A ∩ B)
        Set<Integer> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);
        System.out.println("Intersection (A ∩ B): " + intersection);

        // Difference (A - B)
        Set<Integer> difference = new HashSet<>(setA);
        difference.removeAll(setB);
        System.out.println("Difference (A - B): " + difference);
    }

    // 3. HASHSET VS LINKEDHASHSET (ORDER PRESERVATION)
    public static void orderComparisonDemo() {
        System.out.println("\n==================================================");
        System.out.println("3. HashSet (Unordered) vs LinkedHashSet (Insertion Order)");
        System.out.println("==================================================");

        List<String> items = Arrays.asList("Banana", "Apple", "Mango", "Cherry", "Blueberry");

        Set<String> hashSet = new HashSet<>(items);
        Set<String> linkedHashSet = new LinkedHashSet<>(items);

        System.out.println("Input Order:         " + items);
        System.out.println("HashSet Order:       " + hashSet + " (No guaranteed order)");
        System.out.println("LinkedHashSet Order: " + linkedHashSet + " (Preserved insertion order)");
    }

    public static void main(String[] args) {
        hashSetBasicsDemo();
        setOperationsDemo();
        orderComparisonDemo();
    }
}
