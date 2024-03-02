import java.util.Vector;

class Vectorpr
{
    public static void main(String[] args) {
        Vector vec = new Vector<>();
        vec.addElement("Apple");
        vec.addElement("Mango");
        vec.addElement("Banana");
        vec.addElement("Lichy");
        System.out.println("Vector = " + vec);
        vec.insertElementAt("Peach", 2);
        System.out.println("Vector = " + vec);
        System.out.println("Vector size= " + vec.size());
        System.out.println("Vector capacity = " + vec.capacity());
        System.out.println("First element of vector = " + vec.firstElement());
        vec.remove(1);
        System.out.println("Vector = " + vec);
        vec.removeElement("Lichy");
        System.out.println("Vector = " + vec);
        vec.removeElementAt(2);
        System.out.println("Vector = " + vec);
        vec.removeAllElements();
        System.out.println("Vector = " + vec);
        
    }
}