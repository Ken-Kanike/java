// Taking input using Scanner class.
import java.util.Scanner;
class tute15
{
    public static void main(String[] args)
    {
        int a;
        float b;
        String c;
        Scanner sc=new Scanner(System.in);
        // string input
        System.out.println("Enter a string :");
        c=sc.next();
        // integer input
        System.out.println("Enter Int Number :");
        a=sc.nextInt();
        // float input
        System.out.println("Enter Float Number :");
        b=sc.nextFloat();
        System.out.println("The String is : "+ c);
        System.out.println("The Int Number is : "+ a);
        System.out.println("The Float Number is : "+ b);
    }
}        