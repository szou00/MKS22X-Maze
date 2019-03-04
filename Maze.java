import java.util.*;
import java.io.*;
public class Maze{


    private char[][]maze;
    private boolean animate;//false by default

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!


      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then:

         throw a FileNotFoundException or IllegalStateException

    */

    public Maze(String filename) throws FileNotFoundException{
      int c = 0; //keeps track of the num of columns
      int l = 0; //keeps track of the num of lines
      File text = new File(filename); //opens the file
      Scanner in = new Scanner(text);
      String line;
      while (in.hasNextLine()) { //if it has another line
        line = in.nextLine();
        l+=1; //adds one
        c = line.length(); //the num of columns is just how long the line is
      }
      maze = new char[l][c]; //initializes the maze with those information
      Scanner fill = new Scanner(text); //now that maze is the correct size, it can be filled up
      while (fill.hasNextLine()) {
        for (int i=0;i<l;i++) {
          line = fill.nextLine();
          for (int x=0;x<c;x++) {
            maze[i][x] = line.charAt(x); //fills the maze correspondingly
          }
        }
      }
      if (!this.goodFile()) { //if it doesn't contain either E or S
        throw new IllegalStateException(); //an exception is thrown
      }
      in.close(); //file is closed
    }

    //checks to see if the file contains both E and S
    //if yes, returns true
    //otherwise returns false
    public boolean goodFile(){
      int Sr = -1; int Sc = -1; int Er = -1;int Ec= -1;
      //the values are all initialized at -1
      for (int r=0;r<maze.length;r++) {
        for (int c=0;c<maze[0].length;c++) {
          if (maze[r][c] == 'S') { //if there's an S
            Sr = r; //changes the variables to their corresponding values
            Sc = c;
          }
          if (maze[r][c] == 'E') { //if there's an E
            Er = r; //changes the variables to their corresponding values
            Ec = c;
          }
        }
      }
      //if any of the variable remain unchanged, that means either E or S wasn't found
      if (Sr == -1 || Sc == -1 || Er == -1 || Ec == -1) {
        return false;
      }
      return true;
    }

    //prints out the maze
    public String toString() {
      String ans = "";
      for (int i = 0;i<maze.length;i++) {
        for (int x = 0; x<maze[0].length;x++) {
          ans += maze[i][x];
        }
        ans += "\n"; //moves to a new line
      }
      return ans;
    }

    //-----------------------------------
    //animation from K's website
    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }
    //------------------------------------



    /*Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public int solve(){
      int sx = 0; //finds the coordinates of x
      int sy = 0;
      for(int i=0;i<maze.length;i++) {
        for (int x=0;x<maze[0].length;x++) {
          if (maze[i][x] == 'S') {
            maze[i][x] = ' '; //once it finds it, removes the S
            sx = i;
            sy = x;
          }
        }
      }
      return solve(sx,sy,0); //begins solving at the location of S
    }


    /*
      Recursive Solve function:
      A solved maze has a path marked with '@' from S to E.
      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col,int a){ //you can add more parameters since this is private
        //automatic animation! You are welcome.
        // setAnimate(true);
        if(animate){

            clearTerminal();
            System.out.println(this);

            wait(20);
        }
        //

        int[][] d = {{0,-1},{0,1},{1,0},{-1,0}}; //all the possible directions
        if (maze[row][col] == 'E') { //base case
          return a;
        }
        if (maze[row][col] != ' ') { //base case
          return -1;
        }
        for (int i = 0;i<d.length;i++) {
          maze[row][col] = '@'; //marks the path it's taking
          int solution = solve(row+d[i][0],col+d[i][1],a+1); //calls itself
          if (solution != -1) { //if it's solved, returns the solution
            return solution;
          }
          else { //if it's not solved, a period is used to indicate that it passed this area
            maze[row][col] = '.';
          }
        }
        return -1;
    }
}
