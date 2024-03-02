class overload {
    int rollno;
    String name;
    float percent;
    
    void info(int r) {
        rollno = r;
        System.out.println("Roll Number: " + rollno);
    }
    
    void info(int r, String n) {
        rollno = r;
        name = n;
        System.out.println("Roll Number: " + rollno);
        System.out.println("Name: " + name);
    }
    
    void info(int r, String n, float f) {
        rollno = r;
        name = n;
        percent = f;
        System.out.println("Roll Number: " + rollno);
        System.out.println("Name: " + name);
        System.out.println("Percentage: " + percent);
    } 
    
    public static void main(String[] args) {
        overload obj = new overload();
        
        // Calling the overloaded methods
        obj.info(1);
        System.out.println("--------------------");
        obj.info(2, "John");
        System.out.println("--------------------");
        obj.info(3, "Jane", 85.5f);
    }
}
