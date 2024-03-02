//program for implementation of explicit type conversion
class PrE_QB5
{
    public static void main(String [] args)
    {
        double d = 100.04;
        long l =(long)d; // convert double to long
        int i =(int)l;   // convert long to int
        float f =(float)i;  // convert int to float 

        System.out.println("Double value =" +d);
        System.out.println("Long value =" +l);
        System.out.println("Integer value =" +i);
        System.out.println("Float value =" +f);
    }
}
