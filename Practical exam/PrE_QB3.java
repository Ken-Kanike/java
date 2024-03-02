// Program to Print Table of any number 
import java.util.Scanner;
class PrE_QB3
{
    public static void main(String args [])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Number: ");
        Integer n = sc.nextInt();
        for(int i = 1; i <= 10 ;i++)
        {
               System.out.println(n +" * "+ i +" = " +(n*i));
        }

    }
}
