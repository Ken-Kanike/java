//program for implementation of try , catch and finally  block
public class PrEQB17 
{
    public static void main(String[] args) {
      int a = 10, b = 0;
      try 
      {
        int result1 = a / b;
        System.out.println("Result: " + result1);
      } 
      catch (ArithmeticException e) 
      {
        System.out.println("Error: " + e.getMessage());
      } 
      finally 
      {
        b = 2;
        int result2 = a / b;
        System.out.println("Result: " + result2);
        System.out.println("Finally block executed.");
      }
    }
  }
  