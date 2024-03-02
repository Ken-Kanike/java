import java.util.Scanner;
class NoMatchExceptio extends Exception
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Password:");
        String pass;
        pass = sc.next();
        try
        {
            if(!pass.equals("MSBTE")){
                throw new NoMatchException("Incorrect Password!");
            }
            else{
                System.out.println("Correct Password.");
            }
        }
        catch(NoMatchExceptio e)
        {
            System.out.println(e.getMessage());
        }
    }
}