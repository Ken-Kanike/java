class staticmethod {
    static void myMethod() {
      System.out.println("I just got executed!");
    }
  
    public static void main(String[] args) {
      myMethod();
    }
  }
  /*

  using static method of another class
   * class student{
  static void myMethod() {
    System.out.println("I just got executed! twice");
  }

}
class staticmethod {
   public static void main(String[] args) {
      student.myMethod();
    }
  }
  
   */