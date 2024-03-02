//program for implementation of vectors in java
import java.util.Vector;
public class PrEQB9 
{
    public static void main(String[] args) {
        // Creating a vector with initial capacity of 5
        Vector<String> vec = new Vector<>(5);
        
        // Adding elements to the vector
        vec.add("Apple");
        vec.add("Banana");
        vec.add("Cherry");
        vec.add("Mango");
        vec.add("Kiwi");
        
        // Displaying the vector elements
        System.out.println("Vector elements: " + vec);
        
        // Accessing an element at a specific index
        String element = vec.get(2);
        System.out.println("Element at index 2: " + element);
        
        // Replacing an element at a specific index
        vec.set(1, "Grape");
        System.out.println("Vector elements after replacing Banana with Grape: " + vec);
        
        // Removing an element from the vector
        vec.remove(3);
        System.out.println("Vector elements after removing Date: " + vec);
        
        // Displaying the size and capacity of the vector
        System.out.println("Size of vector: " + vec.size());
        System.out.println("Capacity of vector: " + vec.capacity());
    }
}
