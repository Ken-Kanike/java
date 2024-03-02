class Shape {
    void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends Shape {
    void draw() {
        System.out.println("Drawing a rectangle");
    }
}

public class HierarchicalInheritance {
    public static void main(String[] args) {
        Shape shape = new Shape();
        shape.draw(); // Specific to Shape class

        Circle circle = new Circle();
        circle.draw(); // Specific to Circle class

        Rectangle rectangle = new Rectangle();
        rectangle.draw(); // Specific to Rectangle class
    }
}
