public class HierarchicalInheritance {

    static class Shape {
        void draw() {
            System.out.println("Drawing a shape");
        }
    }

    static class Circle extends Shape {
        @Override
        void draw() {
            System.out.println("Drawing a circle");
        }
    }

    static class Rectangle extends Shape {
        @Override
        void draw() {
            System.out.println("Drawing a rectangle");
        }
    }

    public static void main(String[] args) {
        Shape shape = new Shape();
        shape.draw(); // Specific to Shape class

        Circle circle = new Circle();
        circle.draw(); // Specific to Circle class

        Rectangle rectangle = new Rectangle();
        rectangle.draw(); // Specific to Rectangle class
    }
}
