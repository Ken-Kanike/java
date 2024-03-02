// Pgrgram to check a number is even or odd
import java.util.Scanner;
class PrE_QB1 
{
    public static void main(String [] args)
    {
        int n;
        Scanner sc= new Scanner(System.in);
        System.out.println("\n Enter a Number:");
        n=sc.nextInt();
       if(n % 2 == 0)
           System.out.println(n + " is a Even number");
       else
           System.out.println(n + " is a Odd number");    
    }
}

