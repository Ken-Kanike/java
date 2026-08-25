package MyPackage;

import MyPackage.SubFolder.rect;
import java.util.Scanner;

public class Userect {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter Length and Breadth of rectangle :");
            int l = sc.nextInt();
            int b = sc.nextInt();

            rect obj = new rect(l, b);
            obj.display();
        }
    }
}

