import java.util.*;
class ATM 
{ 
    int pin1=1240;
    int pin2=1241;
    int pin3=1242;
    String user1= "Juniad Shaikh";
    String user2= "Sarah Shaikh";
    String user3= "Harsh Shelar";
    public static void main(String [] args)
    {
        Scanner sc= new Scanner(System.in);
        ATM a = new ATM();
        machine m = new machine();
        int pin;
        String user;
        int i=1;
        int flag=0;

        System.out.println("========================================================");
        System.out.println("                   ICICI ATM SERVICES                   ");
        System.out.println("========================================================");
        System.out.println("Please Inerst Your ATM card.");
        do{
            System.out.println(" Enter pin :");
            pin=sc.nextInt();         
             if(pin == a.pin1 || pin == a.pin2 || pin == a.pin3)
            {
                flag=1;
                System.out.println("Verifying................");
                System.out.println("Verified Successfully.");
                if(pin == a.pin1)
                    user = a.user1;
                else if ( pin == a.pin2)
                    user = a.user2;
                else
                    user = a.user3;        
                System.out.println(" Welcome Mr / Ms : " + user );
                System.out.println("________________________________________________________");
                m.main();
                break;
            }
            else
            {
               System.out.println(" Invalid pin !");
            }
            i++;
        }while(i <= 3);
        if(i >=3 && flag==0)
        {
            System.out.println(" You have Tried to Enter pin many times ..Try after 24 Hours:");
        }
    }   
}
class machine
{
    float balance=0;
    float withdraw_amount=0;
    float deposit_amount=0;
    Scanner sc= new Scanner(System.in);

    public void main()
    { 
       int ch;
       System.out.println("--------------------------MENU------------------------ :");
       System.out.println("\n");
       System.out.print(" 1] Check baalance");
       System.out.println("\t\t 2] Deposit cash ");
       System.out.print(" 3] Widraw cash");
       System.out.println("\t\t\t 4] exit ");  
       System.out.println(" Enter Your Choice :");
       ch=sc.nextInt();
       switch(ch)
       {
          case 1:show_balance();
                 break;

          case 2:deposit();
                 break;

          case 3:withdraw();
                 break;

          case 4:exit();
                 break;

          default : System.out.println(" Please enter a valid choice :");
                    main();
       }
    }

    public void show_balance()
    {
        System.out.println("________________________________________________________");
        System.out.println("\n  Your Current Balance is :" + balance);
        System.out.println("________________________________________________________");
        main();

    }

    public void deposit()
    {
        System.out.println("________________________________________________________");
        System.out.println(" \n Enter Amount To be deposited :");
        deposit_amount=sc.nextFloat();
        balance = balance + deposit_amount;
        System.out.println("Amount deposited Successfully.");
        show_balance();
    }

    public void withdraw()
    {
        System.out.println("________________________________________________________");
        System.out.println(" \n Enter Withdrawel Amount:");
        withdraw_amount=sc.nextFloat();
        if(withdraw_amount > balance )
        {
            System.out.println(" Cant withdraw !... Insufficiant Balance ");
            main();
        }
        else
        {
            balance = balance - withdraw_amount;
            System.out.println(" Amount withdrawed");
            show_balance();
        }
    }
     
    public void exit()
    {
        System.out.println("==============Thank You So Much For Visit===============");
    }
}