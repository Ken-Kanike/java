class pgno48
{
    int id;
    String name;
    pgno48(int i , String n)
    {
        id=i;
        name=n;
    }
    void display()
    {
        System.out.println(id+" "+name);
    }
    public static void main(String [] args)
    {
        pgno48 s1= new pgno48(1240,"junaid");
        pgno48 s2= new pgno48(1205,"vishwas");
        s1.display();
        s2.display();
    }
}