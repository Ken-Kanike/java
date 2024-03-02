// Program to implement 2-Dimensional Array 
import java.util.Scanner;
public class PrE_QB8
{
    public static void main (String args[])
    {
        Scanner sc = new Scanner(System.in);
        int row , col , i , j ;
        int a[][]= new int [3][3];

        // Taking Input of size of the array
        System.out.println("Enter number of Rows (Max 3):");
        row = sc.nextInt();
        System.out.println("Enter number of Columns (Max 3):");
        col = sc.nextInt();
  
        //Taking input of the elements of the array 
        System.out.println("Enter "+ (row*col) +" array element:");
        for(i = 0 ;i < row ; i++)
        {
            for(j = 0 ; j < col ; j++)
            {
                a[i][j]= sc.nextInt();
            }
        }

        // Displaying Array
        System.out.println("The Array is:");
        for(i = 0 ;i < row ; i++)
        {
            for(j = 0 ; j < col ; j++)
            {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
