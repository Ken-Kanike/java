public class override {

    static class BaseClass {
        void info(int r, String n) {
            System.out.println("Base Class - Roll Number: " + r);
            System.out.println("Base Class - Name: " + n);
        }
    }

    static class DerivedClass extends BaseClass {
        @Override
        void info(int r, String n) {
            System.out.println("Derived Class - Roll Number: " + r);
            System.out.println("Derived Class - Name: " + n);
        }
    }

    public static void main(String[] args) {
        BaseClass baseObj = new BaseClass();
        DerivedClass derivedObj = new DerivedClass();
        
        baseObj.info(1, "John"); // Call the base class method
        System.out.println("--------------------");
        
        derivedObj.info(2, "James"); // Call the overridden method in the derived class
    }
}
