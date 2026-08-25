import java.util.*;

public class ATM { 
    int pin1 = 1001;
    int pin2 = 1002;
    int pin3 = 1003;
    String user1 = "Alice Johnson";
    String user2 = "Bob Smith";
    String user3 = "Charlie Brown";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM a = new ATM();
        machine m = new machine();
        int pin;
        String user;
        int i = 1;
        int flag = 0;

        System.out.println("========================================================");
        System.out.println("                   BANK ATM SERVICES                    ");
        System.out.println("========================================================");
        System.out.println("Please insert your ATM card.");
        do {
            System.out.println("Enter PIN:");
            pin = sc.nextInt();         
            if (pin == a.pin1 || pin == a.pin2 || pin == a.pin3) {
                flag = 1;
                System.out.println("Verifying................");
                System.out.println("Verified Successfully.");
                if (pin == a.pin1)
                    user = a.user1;
                else if (pin == a.pin2)
                    user = a.user2;
                else
                    user = a.user3;        
                System.out.println("Welcome Mr / Ms : " + user);
                System.out.println("________________________________________________________");
                m.main();
                break;
            } else {
                System.out.println("Invalid PIN!");
            }
            i++;
        } while (i <= 3);

        if (i >= 3 && flag == 0) {
            System.out.println("You have tried to enter PIN too many times. Please try again after 24 hours.");
        }
        sc.close();
    }   
}

class machine {
    float balance = 0;
    float withdraw_amount = 0;
    float deposit_amount = 0;
    Scanner sc = new Scanner(System.in);

    public void main() { 
        int ch;
        System.out.println("--------------------------MENU------------------------ :");
        System.out.println("\n");
        System.out.print(" 1] Check balance");
        System.out.println("\t\t 2] Deposit cash ");
        System.out.print(" 3] Withdraw cash");
        System.out.println("\t\t\t 4] Exit ");  
        System.out.println("Enter your choice:");
        ch = sc.nextInt();
        switch (ch) {
            case 1:
                show_balance();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                exit();
                break;
            default:
                System.out.println("Please enter a valid choice:");
                main();
        }
    }

    public void show_balance() {
        System.out.println("________________________________________________________");
        System.out.println("\n  Your Current Balance is: " + balance);
        System.out.println("________________________________________________________");
        main();
    }

    public void deposit() {
        System.out.println("________________________________________________________");
        System.out.println(" \nEnter amount to be deposited:");
        deposit_amount = sc.nextFloat();
        balance = balance + deposit_amount;
        System.out.println("Amount deposited successfully.");
        show_balance();
    }

    public void withdraw() {
        System.out.println("________________________________________________________");
        System.out.println(" \nEnter withdrawal amount:");
        withdraw_amount = sc.nextFloat();
        if (withdraw_amount > balance) {
            System.out.println("Cannot withdraw! Insufficient balance.");
            main();
        } else {
            balance = balance - withdraw_amount;
            System.out.println("Amount withdrawn successfully.");
            show_balance();
        }
    }
     
    public void exit() {
        System.out.println("==============Thank You For Visiting===============");
    }
}