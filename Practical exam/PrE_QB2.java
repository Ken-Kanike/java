// program to check a chracater is vowel or not
import java.util.Scanner;
public class PrE_QB2 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a character: ");
        char c = sc.next().charAt(0);  // .charAt(0) is used to 
                // convert take only First Character of the Input String
        switch(c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                System.out.println(c + " is a vowel.");
                break;
            default:
                System.out.println(c + " is not a vowel.");
        }
    }
}
