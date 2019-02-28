import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

  public static void main (String args[]) {
    try {
      Maze test = new Maze("Maze1.txt");
      System.out.println(test);
      System.out.println(test.solve());
      System.out.println(test);
    }
    catch (FileNotFoundException e) {
      System.out.println("no");
    }
  }
}
