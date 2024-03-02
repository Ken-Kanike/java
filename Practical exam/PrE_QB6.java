// Program to keep record of people using constructor
class PrE_QB6
{  
    private String name;
    private int age;
    // Default constructor
    PrE_QB6() {
        name = "Unknown";
        age = 0;
    }
    // Constructor with parameters
    PrE_QB6(String n, int a){
        name = n;
        age = a;
    }
    // Display function to print object attributes
    void display(){
        System.out.println("Name: " + name + " ; Age: " + age);
    }
    public static void main(String[] args) {
        // Creating objects using the constructor and passing values to constructor
       PrE_QB6 p1 = new PrE_QB6("John", 30);
       PrE_QB6 p2 = new PrE_QB6("Jane", 25);
        // Calling the display function to print object attributes
        System.out.print("Person 1 :- ");
        p1.display();
        System.out.print("Person 2 :- ");
        p2.display();
    }
}
