// Program to find sum of numbers from 1 to 100
public class PrE_QB4_i 
{
    public static void main(String[] args) {
        int i = 1, sum = 0;
        while (i <= 100) {
            sum += i;  // or use sum = sum + i;
            i++;
        }
        System.out.println("The sum of numbers from 1 to 100 is: " + sum);
    }
}

