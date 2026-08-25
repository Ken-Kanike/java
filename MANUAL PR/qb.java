import java.util.Scanner;

class Rev {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();

            int reverse = 0;
            while (number != 0) {
                int digit = number % 10;
                reverse = reverse * 10 + digit;
                number /= 10;
            }

            System.out.println("The reverse of the number is: " + reverse);
        }
    }
}