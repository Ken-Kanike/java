class BaseClass {
    int rollNumber;
    String name;

    BaseClass(int r, String n) {
        rollNumber = r;
        name = n;
    }

    void display() {
        System.out.println("Base Class - Roll Number: " + rollNumber);
        System.out.println("Base Class - Name: " + name);
    }
}

class DerivedClass extends BaseClass {
    DerivedClass(int r, String n) {
        super(r, n); // Calling the base class constructor using 'super'
    }
}

public class consoverride {
    public static void main(String[] args) {
        DerivedClass derivedObj = new DerivedClass(1, "John");
        derivedObj.display(); // Call the display method of the base class
    }
}
