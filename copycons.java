class copycons{
    int rollno;
    String name;
    copycons(int r, String n){
        rollno = r;
        name = n;
    }
    // copy constructor
    copycons( copycons obj){
        rollno = obj.rollno;
        name = obj.name;
    }
    void display()
    {
        System.out.println(rollno);
        System.out.println(name);
    }
    public static void main(String[] args) {
        copycons obj1 = new copycons(1240,"Meliodas");
        copycons obj2 = new copycons(obj1);
        System.out.println("Student 1:");
        obj1.display();
        System.out.println("Student 2:");
        obj2.display();
    }
}