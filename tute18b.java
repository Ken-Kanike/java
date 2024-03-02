import java.util.Scanner;
class tute18b
{
    public static void main(String [] args)
    {
        int a,b,c;
        Scanner sc= new Scanner(System.in);
        System.out.println("\n Enter 1st Number:");
        a=sc.nextInt();
        System.out.println("\n Enter 2nd Number:");
        b=sc.nextInt();
        System.out.println("\n Enter 3rd Number:");
        c=sc.nextInt();
       if(a>b && a>c)
           System.out.printf("\n 1st Number i.e %d is Graeter", a);
       else if(b>a && b>c)
           System.out.printf("\n 2nd Number i.e %d is Greater", b);    
       else
           System.out.printf("\n 3rd Number i.e %d is Greater", c);
    }
}