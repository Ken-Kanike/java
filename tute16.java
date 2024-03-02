import java.util.Scanner;
class tute16
{
    public static void main(String [] args)
    {
        int len,br;
        float peri, area;
        Scanner sc= new Scanner(System.in);
        System.out.println("\n Enter Length of Rectanlge:");
        len=sc.nextInt();
        System.out.println("\n Enter Breadth of Rectanlge:");
        br=sc.nextInt();
        peri=2*(len+br);
        area=len*br;
        System.out.println("\n Perimeter of Rectangle = "+ peri);
        System.out.println("\n Area of Reactangle = "+ area);

    }
}