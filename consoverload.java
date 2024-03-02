class consoverload {
    int rollno;
    String name;
    float percent;

    consoverload(int r) {
        rollno = r;
        System.out.println("Roll Number: " + rollno);
    }

    consoverload(int r, String n) {
        rollno = r;
        name = n;
        System.out.println("Roll Number: " + rollno);
        System.out.println("Name: " + name);
    }

    consoverload(int r, String n, float f) {
        rollno = r;
        name = n;
        percent = f;
        System.out.println("Roll Number: " + rollno);
        System.out.println("Name: " + name);
        System.out.println("Percentage: " + percent);
    }

    public static void main(String[] args) {
        consoverload obj = new consoverload(1);
        System.out.println("--------------------");
        consoverload obj2 = new consoverload(2, "John");
        System.out.println("--------------------");
        consoverload obj3 = new consoverload(3, "Jane", 85.5f);
    }
}
