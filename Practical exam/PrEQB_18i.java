
// Program for implementation of throw,throws clause
import java.util.Scanner;
public class PrEQB_18i 
{
  public static void main(String[] args) throws Exception {
    
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a number between 1 and 100: ");
    int num = sc.nextInt();

    if (num < 1 || num > 100) 
    {
      throw new Exception("Number is out of range.");
    } 
    else 
    {
      System.out.println("Number is valid.");
    }
  }
}
/* if asked on;y for throw
  -------------------------------------
  public class Main {
  public static void main(String[] args) {
    int age = 17;

    if (age < 18) {
      throw new ArithmeticException("You must be 18 or older to vote.");
    } else {
      System.out.println("You are eligible to vote.");
    }
  }
}


  if asked only for throws 
  -------------------------------------
  public class Main {
  public static void main(String[] args) {
    try {
      int result = divide(10, 0);
      System.out.println("Result: " + result);
    } catch (ArithmeticException e) {
      System.out.println("Error: Division by zero.");
    }
  }

  public static int divide(int a, int b) throws ArithmeticException {
    return a / b;
  }
}
 */
