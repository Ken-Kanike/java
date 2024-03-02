/*import java.io.*;
class pyramid
{
    public static void main(String [] args)
    {
        int n=5;
       for(int i=1;i<=n;i++)
       {
         for(int b=1;b<=n-1;b++)
         {
          System.out.print(" ");
         }
         for(int j=1;j<2*i-1;j++)
         {
            System.out.print("*");
         }
          System.out.println();
       }

        for(int i=0;i<n;i++)
        {
           for(int k=n-i;k>i;k--)
           {
             System.out.print(" ");
           }   
           for(int j=0;j<=i;j++)
           {
             System.out.print("*");
           }
          System.out.println(); 
        }
    }
}*/

//import java.io.*;
public class pyramid {
    public static void main(String [] args)
    {
        int a, b ,n=5;
        for (a = 0; a < n; a++) {
 
            for (b = 0; b <= a; b++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}