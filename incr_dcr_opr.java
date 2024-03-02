class incr_dcr_opr
{
    public static void main (String args [])
    {
        int a=5;
        int b=6;
        int c=7;
        System.out.println("Prefix :");
        System.out.println(++a + ++b + ++c);
        System.out.println("Postfix :");
        System.out.println(a++ +  b++ + c++);
        System.out.println("After postfix :");
        System.out.printf(" a=%d b=%d c=%d ", a , b , c );
     
    }
}