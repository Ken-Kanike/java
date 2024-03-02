// program for implimentation of  multiple inheritance
interface printable
{
    void print();
}
interface showable
{
    void show();
}
class PrEQB14 implements printable , showable
{
    public void print()
    {
        System.out.print("Hello ");
    }
    public void show()
    {
        System.out.println("World");
    }
    public static void main(String[] args) {
        PrEQB14 obj = new PrEQB14();
        obj.print();
        obj.show();
    }
}
