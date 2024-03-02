import java.util.Scanner;
class tute19a
{
    public static void main(String [] args)
    {
        int n;
        Scanner sc= new Scanner(System.in);
        System.out.println("\n Enter a Number:");
        n=sc.nextInt();
       if(n%2==0)
           System.out.printf("\n Enterred Number is even"); 
       else
           System.out.printf("\n Enterred Number is odd");
    }
}