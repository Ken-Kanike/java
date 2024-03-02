
public class StringBufferExample {
    public static void main(String[] args)
    {
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" world");
        System.out.println("String is = " + sb);
        System.out.println("String capacity = " + sb.capacity());
        sb.insert(5, " Java");
        System.out.println("String is = " + sb);
        sb.delete(10, 16);
        System.out.println("String is = " + sb);
        sb.getClass();
        
    }
}
