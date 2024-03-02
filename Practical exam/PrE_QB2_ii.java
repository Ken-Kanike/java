// Program to check a number is positive or negative
import java.util.Scanner;
public class PrE_QB2_ii
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Number: ");
        Integer n = sc.nextInt();
        String result;
        result =(n > 0 )? "Positive" : "Negative";
        System.out.println(n + " is " + result);
    }
}
