public class pgno42_x { 
    public static void main(String[] args) {
        int i = 10;
        float f = 3.14f;
        double d = 5.6789;
        char c = 'A';
        
        // Convert int to float
        float cf = (float) i;
        System.out.println("Converted float  " + cf);
        
        // Convert double to int
        int ci = (int) d;
        System.out.println("Converted int " + ci);
        
        // Convert char to int
        int cc = (int) c;
        System.out.println("Converted int  " + cc);
        
        // Convert float to double
        double cd = (double) f;
        System.out.println("Converted double  " + cd);
    }
}
