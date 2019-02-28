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
      int c = 0;
      int l = 0;
      File text = new File(filename);
      Scanner in = new Scanner(text);
      String line;
      while (in.hasNextLine()) {
        line = in.nextLine();
        l+=1;
        c = line.length();
      }
      maze = new char[l][c];
      Scanner fill = new Scanner(text);
      while (fill.hasNextLine()) {
        for (int i=0;i<l;i++) {
          line = fill.nextLine();
          for (int x=0;x<c;x++) {
            maze[i][x] = line.charAt(x);
          }
        }
      }
    }

    public String toString() {
      String ans = "";
      for (int i = 0;i<maze.length;i++) {
        for (int x = 0; x<maze[0].length;x++) {
          ans += maze[i][x];
        }
        ans += "\n";
      }
      return ans;
    }


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



    /*Wrapper Solve Function returns the helper function

      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

    */
    public int solve(){
      int sx = 0;
      int sy = 0;
      for(int i=0;i<maze.length;i++) {
        for (int x=0;x<maze[0].length;x++) {
          if (maze[i][x] == 'S') {
            maze[i][x] = ' ';
            sx = i;
            sy = x;
          }
        }
      }
      return solve(sx,sy,0);

            //find the location of the S.


            //erase the S


            //and start solving at the location of the s.

            //return solve(???,???);

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
      int[][] d = {{0,-1},{0,1},{1,0},{-1,0}}; //all the possible directions
      if (maze[row][col] == 'E') {
        return a;
      }
      for (int i = 0;i<d.length;i++) {
        if solve(row+1,col+1,a+1); //?? does this work
      }

        //automatic animation! You are welcome.
        if(animate){

            clearTerminal();
            System.out.println(this);

            wait(20);
        }

        //COMPLETE SOLVE

        return -1; //so it compiles
    }


}
