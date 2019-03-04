import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

  public static void main (String args[]) {
    try {
      Maze test = new Maze("Maze1.txt");
      // System.out.println(test);
      System.out.println(test.solve());
      System.out.println(test);

      Maze test2 = new Maze("data1.dat");
      // System.out.println(test2);
      System.out.println(test2.solve());
      System.out.println(test2);

      Maze test3 = new Maze("data2.dat");
      // System.out.println(test3);
      System.out.println(test3.solve());
      System.out.println(test3);

      Maze test4 = new Maze("data3.dat");
      // System.out.println(test4);
      System.out.println(test4.solve());
      System.out.println(test4);

      Maze test5 = new Maze("unsolveable.txt");
      // System.out.println(test4);
      System.out.println(test5.solve());
      System.out.println(test5);
    }
    catch (FileNotFoundException e) {
      System.out.println(e);
    }
    catch (IllegalStateException e) {
      System.out.println(e);
    }
  }
}
