import java.util.Scanner;
class tute18a
{
    public static void main(String [] args)
    {
        int a,b;
        Scanner sc= new Scanner(System.in);
        System.out.println("\n Enter 1st Number:");
        a=sc.nextInt();
        System.out.println("\n Enter 2nd Number:");
        b=sc.nextInt();
       if(a>b)
           System.out.printf("\n 1st Number i.e %d is Graeter", a);
       else
           System.out.printf("\n 2nd Number i.e %d is Greater", b);    
    }
}