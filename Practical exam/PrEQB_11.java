//program for implementation of wrapper class to convert object into primitive
class PrEQB_11
{
    public static void main(String[] args) {
       Integer obj = Integer.valueOf(100);
       int num = obj.intValue();
       System.out.println("Wrapper Class Object :" + obj);
       System.out.println("Primitive Data :" + num);
    }
}
