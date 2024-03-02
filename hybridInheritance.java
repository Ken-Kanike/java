class student 
{
    int rollno;
    void getstudent(int r)
    {
        rollno = r;
    }
    void putstudent()
    {
        System.out.println("Rollno = " + rollno);
    }
}
class marks extends student
{
    int ct1, ct2;
    void getmarks(int m1 , int m2)
    {
        ct1 = m1;
        ct2 = m2;
    }
    void putmarks()
    {
        System.out.println("Total marks =  " + (ct1+ct2)); 
    }
}
interface sports
{
    static final float score = 9.5f;
}
class hybridInheritance extends marks implements sports
{     
    void putscore()
    {
        System.out.println(" Sports Score = " + score);

    }
    public static void main(String[] args) {
        hybridInheritance obj = new hybridInheritance();
        obj.getstudent(1240);
        obj.getmarks(18, 19);
        obj.putstudent();
        obj.putmarks();
       obj.putscore();
    }
}