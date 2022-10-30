/*
Carolne Hsu - 3/1/2022
This program allows for users to navigate a 2D array.
This includes populating an array, shuffling an array, swapping 2 rows, swapping
2 columns, adding diagonals, and allowing the user to check the sum with a 
user-inputted value. 

 */
package hsu2d;

// import scanner from API
import java.util.Scanner;

public class Hsu2D
{

  public static void main(String[] args)
  {
    // declare scanner for input
    Scanner input = new Scanner(System.in);
    // counter populates array from 0 to 24
    int counter = 0;
    // declare row and column length of 5x5
    int r = 5;
    int c = 5;
    // declare 2d array of r x c which is 5x5
    int[][] twoD = new int[r][c];
    // receives sum for diagonals
    int diagonals;
    // user number input
    int userNumber;

    // for loop to populate the array 
    for (r = 0; r < twoD.length; r++)
    {
      for (c = 0; c < twoD[0].length; c++)
      {
        // set it equal to counter (first is 0, will continue until 24)
        twoD[r][c] = counter;
        // add one to the counter for next loop
        counter++;
      }
    }
    // print the populated array
    System.out.println("Print populated array: ");
    printArray(twoD);
    // print the shuffled array
    System.out.println("Print shuffled array: ");
    shuffle(twoD);
    printArray(twoD);
    // print the swapped rows array
    System.out.println("Print swapped rows array: ");
    swapRows(twoD, 0, 2);
    printArray(twoD);
    // print the swapped columns array
    System.out.println("Print swapped columns array: ");
    swapColumns(twoD, 1, 4);
    printArray(twoD);
    // dummy next line
    System.out.println();
    // get the diagonals sum
    diagonals = addDiagonals(twoD);
    // print the diagonal length
    System.out.println("Your diagonal length is: " + diagonals);
    // dummy next line
    System.out.println();

    // ask for user input to compare with diagonal length
    System.out.print("Enter any integer and we will check if this value is"
        + " greater than, less than, or equal to the diagonals sum: ");
    // get user input in the form of integer
    userNumber = input.nextInt();

    // tell user accordingly if the user number is equal to diagonal length 
    if (userNumber == diagonals)
    {
      System.out.println("Your user input and diagonal length are matching.");
    }
    // tell user accordingly if the user number is greater than diagonal length
    else if (userNumber > diagonals)
    {
      System.out.println("Your user input is greater than the diagonal length.");
    }
    // tell user accordingly if the user number is less than diagonal length
    else if (userNumber < diagonals)
    {
      System.out.println("Your user input is less than the diagonal length.");
    }
  }

  // print array method in square shape
  public static void printArray(int[][] twoD)
  {
    for (int r = 0; r < twoD.length; r++)
    {
      for (int c = 0; c < twoD[0].length; c++)
      {
        // minimum width of 5 spaces to align every entry
        // %- for print f right justifies, % left justifies for print f
        System.out.printf("%-5d", twoD[r][c]);
      }
      // new line for 5x5 2d array after every row
      System.out.print("\n");
    }
  }

  // shuffle array method
  public static void shuffle(int[][] twoD)
  {
    // declare one dimensional array
    int[] temp = new int[4];
    int temporary;

    // for loop to shuffle through rows
    for (int row = 0; row < twoD.length - 1; row++)
    {
      // assign the row to temp and swap accordingly
      temp = twoD[row];
      twoD[row] = twoD[row + 1];
      twoD[row + 1] = temp;
      // this shuffles rows
    }

    // for loop to shuffle through rows and then columns
    for (int row = 0; row < twoD.length - 1; row++)
    {
      for (int column = 0; column < twoD.length - 1; column++)
      {
        // assign the row and column to temp and swap accordingly
        temporary = twoD[row][column];
        twoD[row][column] = twoD[row][column + 1];
        twoD[row][column + 1] = temporary;
        // this shuffles columns
      }

    }
  }

  // swap rows method, receive the rows needed to switch plus the 2d array
  public static void swapRows(int[][] twoD, int ROW_ZERO, int ROW_TWO)
  {
    // declare a temp value to swap
    int temp;

    // for loop for column
    for (int column = 0; column < twoD[ROW_ZERO].length; column++)
    {
      // swap accordingly and use column for loop
      temp = twoD[ROW_ZERO][column];
      twoD[ROW_ZERO][column] = twoD[ROW_TWO][column];
      twoD[ROW_TWO][column] = temp;
    }
  }

  // swap columns method, receive the columns needed to switch plus the 2d array
  public static void swapColumns(int[][] twoD, int COLUMN_ONE, int COLUMN_FOUR)
  {
    // declare a temp value to swap
    int temp;

    // for loop for rows
    for (int row = 0; row < twoD.length; row++)
    {
      // swap accordingly and use row for loop
      temp = twoD[row][COLUMN_ONE];
      twoD[row][COLUMN_ONE] = twoD[row][COLUMN_FOUR];
      twoD[row][COLUMN_FOUR] = temp;
    }
  }

  // add diagonals method
  public static int addDiagonals(int[][] twoD)
  {
    // diagonal values for addition, returns total to main method
    int diagonalOne = 0;
    int diagonalTwo = 0;
    int total = 0;

    // for loop for rows
    for (int row = 0; row < twoD.length; row++)
    {
      // square length for matrix
      // (0,0), (1,1)... get the same value at row use for loop
      diagonalOne = diagonalOne + twoD[row][row];
      // need the second diagonal in opposite direction, so subtract row and 1
      // for the values
      diagonalTwo = diagonalTwo + twoD[row][twoD.length - row - 1];
    }
    // add the two diagonals 
    total = diagonalTwo + diagonalOne;
    // return total diagonal sum
    return total;
  }
}
