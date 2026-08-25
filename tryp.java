import java.util.Scanner;

class NoMatchException extends Exception {
    public NoMatchException(String msg) {
        super(msg);
    }
}

public class tryp {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter Password:");
            String pass = sc.next();
            try {
                if (!pass.equals("MSBTE")) {
                    throw new NoMatchException("Incorrect Password!");
                } else {
                    System.out.println("Correct Password.");
                }
            } catch (NoMatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}