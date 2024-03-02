package SubFolder;
public class rect
{
    int length ;
    int breadth;
    public rect(int l, int b)
    {
        length = l;
        breadth= b;
    }
    public void display()
    {
        System.out.println("Area of Rectangle =" +(length*breadth));
        System.out.println("Perimeter of Rectangle =" + 2*(length+breadth));
    }
}
