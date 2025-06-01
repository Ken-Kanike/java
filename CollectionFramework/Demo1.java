// Arrays in Java ( not in collection framework)
// Array List

import java.util.ArrayList;

public class Demo1{

    void arrayDemo(){
        //fiexed size
        int[] arr = {1, 2, 3,4,5};
        int arr2[] = new int[3];
        for(int i =0; i<3 ; i++){
            arr2[i]=i;
        }
        for(int i:arr){
            System.out.println(i);
        }
        for(int i:arr2){
            System.out.println(i);
        }
    }

    void arrayListDemo(){
        // dynamic
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana"); // appends at the end of the array
        fruits.add(1,"cherry"); // adds at specified index
        ArrayList<String> fruits2 = new ArrayList<>();
        fruits2.add("mango");
        fruits2.add("lichy");
        fruits.addAll(fruits2); // appends whole array to previos arrays end
        System.out.println(fruits);
        System.out.println(fruits.get(1));// gets elements from index
        fruits.remove("apple"); // removes given element
        fruits.remove(0); // removes element from given 
        fruits2.clear(); // clears all element of the array
        System.out.println(fruits);
        fruits.set(0,"new_apple"); // adds element at specified index
        System.out.println(fruits.contains("cherry")); // returns true if element exist
        //printing elements from array list , can use normal for int array list using list.get(i)
        for(String fruit : fruits){
            System.out.println(fruit);
        }
    }

    void iteratorDemo(){
        //17.30
    }

    public static void main(String[] args) {
        Demo1 obj1 = new Demo1();
        obj1.arrayDemo();
        obj1.arrayListDemo();
    }
}