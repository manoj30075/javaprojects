/**
 * Board.java
 *
 * Version: 1
 * Revisions: 0
 *
 * This program produces max number of kings that can be 
 * placed in the board without getting check-mate.
 * 
 *
 * @author      Ashwath sreedhar halemane, ah7387
 * @author      Manoj kumar reddy Palasamudram, mp6112
 */

package hw01;

import java.io.*;

public class Board {

	int N = 6;
	
	private static final char NOT_LEGAL = 'X';
	
	/**
     * Initializes the board with restrictions, no parameters required
	 * @return	char[][]	returns the char[][] with board once it is initiated 
     **/
    
	public static char[][] initTheBoard(){
        int soManyKings = 0;
        int maxNofKings = 0;
        int MAX_ROWS  = 6;
        int MAX_COLUMNS = 6;
        char theBoard[][] = new char[1+MAX_ROWS][MAX_COLUMNS];
        
        theBoard[2][1] = NOT_LEGAL;
        theBoard[2][2] = NOT_LEGAL;
        theBoard[2][3] = NOT_LEGAL;
        theBoard[4][1] = NOT_LEGAL;
        theBoard[4][2] = NOT_LEGAL;
        theBoard[4][3] = NOT_LEGAL;
        theBoard[4][1] = NOT_LEGAL;
        theBoard[3][1] = NOT_LEGAL;
        theBoard[3][3] = NOT_LEGAL;
        
        for ( int index = 0; index < MAX_ROWS-1; index +=2 )    {
                theBoard[1][index] = NOT_LEGAL;
                theBoard[MAX_ROWS-2][index] = NOT_LEGAL;
        }
        
        for (int row = 0; row < MAX_ROWS; row ++ ){
                for (int column = 0; column < MAX_COLUMNS; column ++ )  {
                	if(theBoard[row][column] != NOT_LEGAL) {
                        theBoard[row][column] = whatUnit(row, column);
                	}
                }
        }
         return theBoard;
        
    } 
	
	/**
     * Given an char 2-D array, function prints each elements
     *
     * @param    board[][]	board[][] array is passed, which will be printed	
     *                     is prime or not prime
     * @return   void	just prints the elements of the board
     *                     
     */
	
	void printSolution(char board[][])
	{
		int N=6;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(board[i][j]
								+ " ");
			System.out.println();
		}
		
	}
	
	/**
     * Checks if the king's position is safe to place or not 
     *
     * @param    board[][]    board[][] array is passed
     * 
     * @param	row		row number which needs to be checked
     *                     
     * @param	col		column number which needs to be checked
     * 	                    
     * @return   boolean   returns boolean, if position(row, col) is safe, return true else
     *                     returns false
     */
	
	boolean isSafe(char board[][], int row, int col)
	{
		int i, j;

		return true;
	}
	
	
	/**
	 * To be implemented method which finds the max kings without checkmates.
	 * @param board 	board[][] array is passed
	 * @param col	column number of the board array
	 * @return boolean		returns true is there is a solution, returns false if not	
	 */
	boolean solveMaxKings(char board[][], int col)
	{
		return true;
	}
	
	
    /**
     * Decides element to be on row, column
     * @param row 	row number of the board[][]
     * @param column    column number of the board[][]
     * @return char		returns a char, either white or black
     */
    public static char whatUnit(int row, int column) {
    	char ch1 = 'w';
    	char ch2 = 'b';
	   	 if((row+ column) % 2 == 0) {
	   		 return ch1;
	   	 }
	   	 else {
	   		return ch2;
	   	 }
	   	 
	}
    
    /**
	 * To be implemented method which is the driver function.
	 * @return	boolean		returns true if the driver function passes, returns false if not	
	 */
    
    boolean solveBoard()
	{	
    	char[][] theBoard = initTheBoard();
    	
		if (solveMaxKings(theBoard, 0) == false) {
			System.out.print("Solution does not exist");
			return false;
		}

		printSolution(theBoard);
		return true;
	}

    /**
     * The main program.
     *
     * @param    args    command line arguments (ignored)
     */
	public static void main(String[] args) {
		
		Board b = new Board();
		b.solveBoard();
	}

}

