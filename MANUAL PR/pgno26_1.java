public class pgno26_1 {
    public static void main(String [] args)
    {
        int sum=0;
        for (int i=0;i<=200;i++) {
            if(i%7==0)
            {
                sum=sum+i;
            }
           
        }
         System.out.println("sum is = "+sum);
    }
}