import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

  public static void read() throws FileNotFoundException {
    File text = new File("Maze1.txt");
    Scanner in = new Scanner(text);
    String line;
    while (in.hasNextLine()) {
      line = in.nextLine();
      System.out.println(line);
    }
  }

  public static void readtoArray() throws FileNotFoundException {
    int c = 0;
    int l = 0;
    File text = new File("Maze1.txt");
    Scanner in = new Scanner(text);
    String line;
    while (in.hasNextLine()) {
      line = in.nextLine();
      l+=1;
      for (int i=0;i<line.length();i++) {
        // if (line.charAt(i) != ' ') {
          c+=1;
        // }
      }
    }
    System.out.println(l + " " + c);
  }

  public static void main(String args[])  {
    try {
      // read();
      readtoArray();
    }
    catch(FileNotFoundException e) {
      System.out.print("File Not Found");
    }
  }
}
