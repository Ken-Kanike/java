class HybridStudent {
    int rollno;

    void getstudent(int r) {
        rollno = r;
    }

    void putstudent() {
        System.out.println("Rollno = " + rollno);
    }
}

class HybridMarks extends HybridStudent {
    int ct1, ct2;

    void getmarks(int m1, int m2) {
        ct1 = m1;
        ct2 = m2;
    }

    void putmarks() {
        System.out.println("Total marks = " + (ct1 + ct2)); 
    }
}

interface HybridSports {
    float SCORE = 9.5f;
}

public class hybridInheritance extends HybridMarks implements HybridSports {     
    void putscore() {
        System.out.println("Sports Score = " + SCORE);
    }

    public static void main(String[] args) {
        hybridInheritance obj = new hybridInheritance();
        obj.getstudent(101);
        obj.getmarks(18, 19);
        obj.putstudent();
        obj.putmarks();
        obj.putscore();
    }
}