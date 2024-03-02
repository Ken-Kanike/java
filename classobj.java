class car 
{
    String carname;
    int carno;
    public void getcar( String name , int no )
    {
           carname = name ;
           carno = no ;
    }
    public void dispcar()
    {
        System.out.println("Car Name = " +carname);
        System.out.println("Car Number = " +carno);
    }
}
class classobj // main class
{
     public static void main(String[] args) {
        car obj = new car();
        obj.getcar("Toyota",1240);
        obj.dispcar();
     }
}
