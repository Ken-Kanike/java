// program to take student info and find average of marks using multilevel inheritance 
import java.util.Scanner;
class student {
    Scanner sc = new Scanner(System.in);
    String sname;
    int rollno;
    public void get_student() {
      System.out.print("Name :");
      sname = sc.next();
      System.out.print("Rollno :");
      rollno = sc.nextInt();
    }
  
    public void disp_student() {
      System.out.println("Name =" + sname);
      System.out.println("Rollno =" + rollno);
    }
  }
  
  class marks extends student {
    float ct1 , ct2 ;
    public void get_marks() {
      System.out.println("Enter marks of Class Test 1 & Class Test 2 :");
      ct1 = sc.nextFloat();
      ct2 = sc.nextFloat();
    }
    public void disp_marks() {
        System.out.println("Class Test 1 Marks =" + ct1);
        System.out.println("Class Test 2 Marks =" + ct2);
        System.out.println("Avegrage =" + (ct1 +ct2)/2 );
      }
  }
  
  public class PrEQB_13ii extends marks
  {
    public static void main(String[] args) {
        PrEQB_13ii obj = new PrEQB_13ii();

        System.out.println("Enter Details of Student :");
        obj.get_student();
        obj.get_marks();
        System.out.println("Details of Student :");
        obj.disp_student();
        obj.disp_marks();
    }
  }
  