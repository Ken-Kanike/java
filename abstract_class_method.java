abstract class Shape {
    abstract double area(); // abstract method to calculate area
}

class Rectangle extends Shape {
    int length, width;
    Rectangle(int l, int w) {
        length = l;
        width = w;
    }
    double area() {
        double result =  length * width;
        return result; // implementation of abstract method for Rectangle class
    }
}

public class abstract_class_method {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5, 7); // create object of Rectangle class
        double area = rect.area(); // calculate area of rectangle
        System.out.println("Area of Rectangle: " + area);
    }
}
