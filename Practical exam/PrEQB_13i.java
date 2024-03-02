// Program to find Area and Perimeter of rectangle using single inheritance
import java.util.Scanner;
class Baseclass
{
    int length ;
    int breadth;
    Scanner sc = new Scanner(System.in);
    void input()
    {
        System.out.println("Enter length of Rectangle :");
        length = sc.nextInt();
        System.out.println("Enter breadth of Rectangle :");
        breadth = sc.nextInt();
    }
    void display()
    {
        System.out.println("Area of Rectangle =" +(length*breadth));
        System.out.println("Perimeter of Rectangle =" + 2*(length+breadth));
    }
}
class PrEQB_13i extends Baseclass // subclass
{
    public static void main(String[] args) {
        PrEQB_13i obj = new PrEQB_13i();
        obj.input();
        obj.display();    
    }
}
