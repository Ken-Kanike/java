import java.util.Scanner;
class tute20
{
    public static void main(String [] args)
    {
        int n1,n2,ch;
        Scanner sc= new Scanner(System.in);
        System.out.println("\n Enter 1st Number:");
        n1=sc.nextInt();
        System.out.println("\n Enter 2nd Number:");
        n2=sc.nextInt();
        System.out.println("\n Enter Your Choice .");
        System.out.println("\n 1]Addition \t2]Subtraction \t3]Devision \t4]Multiplication.");
        ch=sc.nextInt();
       if(ch==1)
           System.out.println("\n Sum = "+(n1+ n2)); 
       else if(ch==2)
           System.out.printf("\n difference = "+(n1-n2));
       else if(ch==3)
           System.out.printf("\n Quotient = "+(n1/n2));
       else if(ch==4)
           System.out.printf("\n Product = "+(n1*n2));
       else
           System.out.printf("\n Invalid Choice !");    
    }
}