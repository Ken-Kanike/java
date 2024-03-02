import java.util.Scanner;
class tute19b
{
    public static void main(String [] args)
    {
        int n;
        Scanner sc= new Scanner(System.in);
        System.out.println("\n Enter a Number:");
        n=sc.nextInt();
       if(n > 0)
           System.out.printf("\n Enterred Number is Positive "); 
       else if(n < 0)
           System.out.printf("\n Enterred Number is Negative ");
       else
           System.out.printf("\n Enterred Number is Zero ");    
    }
}