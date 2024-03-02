//program for implementation of multithreading operation
class CounterThread extends Thread {
    private int counter = 10;
    public void run() {
      for (int i = 1; i <= counter; i++) {
        System.out.println("Counter Thread: " + i);
      }
    }
  }
  
  class AlphabetThread extends Thread {
    public void run() {
      for (char c = 'A'; c <= 'Z'; c++) {
        System.out.println("Alphabet Thread: " + c);
      }
    }
  }
  
  public class PrEQB16 {
    public static void main(String[] args) {
      CounterThread CTobj = new CounterThread();
      AlphabetThread ATobj = new AlphabetThread();
  
      CTobj.start();
      ATobj.start();
    }
  }
  