//program to implement the concept of overriding
class demo 
{
    int i;
    demo (int a , int b)
    {
        i = a + b;
    }
    void add()
    {
        System.out.println(i);
    }
}
class subclass extends demo 
{
    int j;
    subclass(int a , int b , int c)
    {
        super(a,b); // used to acces data variables of overriden class
        j = a + b + c;
    }
    void add()
    {
        System.out.println(j);
    }
}
class PrEQB_12 // mainclass
{
    public static void main(String[] args) {
        subclass obj = new subclass(10, 20, 30);
        obj.add();
    }
}
