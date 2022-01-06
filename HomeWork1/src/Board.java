import java.util.Date;
//	----> columns
//	|
//	|
//	v
//	row
public class Board {

    static final int MAX_ROWS 	= 5;
    static final int MAX_COLUMNS 	= 5;
    static final char KING_COLOR 	= 'K';			// if a king is put a square
    static final char NOT_LEGAL 	= '.' ;			// a king can not be put on this square
    static final char WHITE	 	= 'w';			// white square
    static final char BLACK	 	= 'b';			// black square
    static char theBoard[][] 	= new char[ 2 + MAX_ROWS][ 2+ MAX_COLUMNS];	// the board in the recursion
    static char theBestBoard[][] 	= new char[ 2 + MAX_ROWS][ 2+ MAX_COLUMNS];	// best olution so far
    static int soManyKings 		= 0;			// so many kings in this iteration
    static int maxNofKings 		= 0;			// maximum number of kings over all iteration
    static boolean verbose 		= false;

    static public void copyTheBoard() {
        for (int row = 0; row < MAX_ROWS; row ++ )	{
            for (int column = 0; column < MAX_COLUMNS; column ++ )	{
                theBestBoard[row][column] = theBoard[row][column];
            }
        }
    }
    static public void printTheBoard(char theBoard[][]) {
        for (int row = 0; row < MAX_ROWS; row ++ )	{
            for (int column = 0; column < MAX_COLUMNS; column ++ )	{
                System.out.print(" " + theBoard[row][column]);
            }
            System.out.println();
        }
    }
    static public char whatColor(int row, int column) {
        return ( (row + column ) % 2 == 0 ? WHITE : BLACK );
    }
    static public void initTheBoard() {
        soManyKings = 0;
        maxNofKings = 0;
        for (int row = 0; row < MAX_ROWS; row ++ )	{
            for (int column = 0; column < MAX_COLUMNS; column ++ )	{
                theBoard[row][column] = ' ';
            }
        }
        for (int row = 1; row < MAX_ROWS; row ++ )	{
            for (int column = 1; column < MAX_COLUMNS; column ++ )	{
                theBoard[row][column] = whatColor(row, column);
            }
        }
    }
    static public void createWall() {
        theBoard[2][1] = NOT_LEGAL;
        theBoard[2][2] = NOT_LEGAL;
        theBoard[2][3] = NOT_LEGAL;
        // theBoard[4][1] = NOT_LEGAL;
        // theBoard[4][2] = NOT_LEGAL;
        // theBoard[4][3] = NOT_LEGAL;
        // theBoard[4][1] = NOT_LEGAL;
        // theBoard[3][1] = NOT_LEGAL;
        // theBoard[3][3] = NOT_LEGAL;
		/*
		   for ( int index = 0; index < MAX_ROWS-1; index +=2 )	{
		   theBoard[1][index] = NOT_LEGAL;
		   theBoard[MAX_ROWS-2][index] = NOT_LEGAL;
		   }
		 */
    }

    static public void setPieceTo( int row, int column )	{
        char thisIsOneTheSquare = theBoard[row][column];
        if ( thisIsOneTheSquare == KING_COLOR )
            System.out.println("King is already there.");
        if ( ( thisIsOneTheSquare ==  BLACK ) || ( thisIsOneTheSquare == WHITE ) ) {
            theBoard[row][column] = KING_COLOR;
        } else
            System.out.println("A wall piece is there (" + row + "/" + column + ")");

    }
    static public void removePieceFrom( int row, int column )	{
        if ( theBoard[row][column] != KING_COLOR )
            System.out.println("No king on this position.");
        if ( theBoard[row][column] ==  KING_COLOR )  {
            theBoard[row][column] = whatColor(row, column);
        }
    }

    static public boolean isThereAking( int row, int column )	{
        if ( row < 0 )
            return true;
        if ( column < 0 )
            return true;
        if ( row >= MAX_ROWS )
            return true;
        if ( column >= MAX_COLUMNS )
            return true;

        return ( theBoard[row][column] !=  KING_COLOR);
    }

    /*
     *			----> column
     *			|
     *			|
     *			v
     *			row
     *
     *			--+----+----+----+--------
     *			  | 1  | 8  | 7  |
     *			--+----+----+----+--------
     *			  | 2  |    | 6  |
     *			--+----+----+----+--------
     *			  | 3  | 4  | 5  |
     *			--+----+----+----+--------
     */
    static public boolean isSave(int thisRow, int thisColumn) {
        return  	isThereAking(thisRow - 0, thisColumn - 0 )			&&	// 0
                isThereAking(thisRow - 1, thisColumn - 1 )			&&	// 1
                isThereAking(thisRow - 0, thisColumn - 1 )			&&	// 2
                isThereAking(thisRow + 1, thisColumn - 1 )			&&	// 3
                isThereAking(thisRow + 1, thisColumn + 0 )			&&	// 4
                isThereAking(thisRow + 1, thisColumn + 1 )			&&	// 5
                isThereAking(thisRow - 0, thisColumn + 1 )			&&	// 6
                isThereAking(thisRow - 1, thisColumn + 1 )			&&	// 7
                isThereAking(thisRow - 1, thisColumn - 0 );				// 8
    }
    static public void placeKings(int startC, int startR)	{
        for (int row = startR; row < MAX_ROWS; row ++ )	{
            for (int column = startC; column < MAX_COLUMNS; column ++ )	{
                char thisIsOnTheSquare = theBoard[row][column];
                if ( thisIsOnTheSquare != NOT_LEGAL ) {
                    if ( isSave(row, column) )	{
                        soManyKings ++;
                        setPieceTo(row, column);
                        if ( soManyKings > maxNofKings )	{
                            maxNofKings = soManyKings;
                            copyTheBoard();
                        }
                        placeKings(1,  1);
                        removePieceFrom(row, column);
                        soManyKings --;
                    }
                }
            }
        }
    }
    static public void printMaxKings()	{
        System.out.println("maximum number of kings = " + maxNofKings );
    }
    public static void main(String[] args) {
        initTheBoard();
        createWall();
        printTheBoard(theBoard);
        placeKings(1, 1);
        printMaxKings();
        printTheBoard(theBestBoard);
    }
}