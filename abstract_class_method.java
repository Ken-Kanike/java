public class abstract_class_method {

    abstract static class Shape {
        abstract double area(); // abstract method to calculate area
    }

    static class Rectangle extends Shape {
        int length, width;

        Rectangle(int l, int w) {
            length = l;
            width = w;
        }

        @Override
        double area() {
            return (double) length * width; // implementation of abstract method for Rectangle class
        }
    }

    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5, 7); // create object of Rectangle class
        double area = rect.area(); // calculate area of rectangle
        System.out.println("Area of Rectangle: " + area);
    }
}
