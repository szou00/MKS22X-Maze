import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

  public static void read() throws FileNotFoundException {
    File text = new File("maze.txt");
    Scanner in = new Scanner(text);
    String line;
    while (in.hasNextLine()) {
      line = in.nextLine();
      System.out.println(line);
    }
  }

  public static int readtoArray() throws FileNotFoundException {
    int l = 0;
    File text = new File("maze.txt");
    Scanner in = new Scanner(text);
    String line;
    while (in.hasNextLine()) {
      line = in.nextLine();
      for (int i=0;i<line.length();i++) {
        if (line.substring(i,i+1) != " ") {
          l+=1;
        }
      }
    }
    return l;
  }

  public static void main(String args[])  {
    try {
      // read();
      System.out.println(readtoArray());
    }
    catch(FileNotFoundException e) {
      System.out.print("File Not Found");
    }
  }
}
