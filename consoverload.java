public class consoverload {
    int rollno;
    String name;
    float percent;

    consoverload(int r) {
        rollno = r;
    }

    consoverload(int r, String n) {
        rollno = r;
        name = n;
    }

    consoverload(int r, String n, float f) {
        rollno = r;
        name = n;
        percent = f;
    }

    void display() {
        System.out.println("Roll Number: " + rollno);
        if (name != null) System.out.println("Name: " + name);
        if (percent > 0) System.out.println("Percentage: " + percent);
    }

    public static void main(String[] args) {
        consoverload obj1 = new consoverload(1);
        obj1.display();
        System.out.println("--------------------");
        consoverload obj2 = new consoverload(2, "John");
        obj2.display();
        System.out.println("--------------------");
        consoverload obj3 = new consoverload(3, "Jane", 85.5f);
        obj3.display();
    }
}
