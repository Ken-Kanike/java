import SubFolder.*;
import java.util.Scanner;
class Userect
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Length and Breadth of rectangle :");
        int l = sc.nextInt();
        int b = sc.nextInt();

        rect obj = new rect(l,b);
        obj.display();
    }
}

