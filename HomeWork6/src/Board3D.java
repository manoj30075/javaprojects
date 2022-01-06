public class Board3D extends Board {
    int MAX_ROWS;
    int MAX_COLUMNS;
    int MAX_WIDTH;
    char[][][] theBoard;
    char[][][] theBestBoard;

    Board3D(int boardSize){
        this.MAX_ROWS = boardSize;
        this.MAX_COLUMNS = boardSize;
        this.MAX_WIDTH = boardSize;
        this.theBoard = new char[ 2 + MAX_ROWS][ 2+ MAX_COLUMNS][2 + MAX_WIDTH];
        this.theBestBoard= new char[ 2 + MAX_ROWS][ 2+ MAX_COLUMNS][2 + MAX_WIDTH];
    }

    public boolean isThereAChessPiece( int row, int column, int width, char chessPieceColor )	{
        if ( row < 0 )
            return true;
        if ( column < 0 )
            return true;
        if ( width < 0 )
            return true;
        if ( row >= MAX_ROWS )
            return true;
        if ( column >= MAX_COLUMNS )
            return true;
        if ( column >= MAX_WIDTH )
            return true;

        return ( theBoard[row][column][width] !=  chessPieceColor);
    }

    public void removePieceFrom( int row, int column, int width, char chessPieceColor )	{
        if ( theBoard[row][column][width] != chessPieceColor )
            System.out.println("No king on this position.");
        if ( theBoard[row][column][width] ==  chessPieceColor )  {
            theBoard[row][column][width] = whatColor(row, column, width);
        }
    }

    public void setPieceTo( int row, int column, int width, char chessPieceColor)	{
        char thisIsOneTheSquare = theBoard[row][column][width];
        if ( thisIsOneTheSquare == chessPieceColor )
            System.out.println("King is already there.");
        if ( ( thisIsOneTheSquare ==  BLACK ) || ( thisIsOneTheSquare == WHITE ) ) {
            theBoard[row][column][width] = chessPieceColor;
        } else
            System.out.println("A wall piece is there (" + row + "/" + column + ")");
    }

    public void createWall() {
        theBoard[2][1][1] = NOT_LEGAL;
        theBoard[1][2][1] = NOT_LEGAL;
        theBoard[3][3][2] = NOT_LEGAL;
    }

    public char whatColor(int row, int column, int width) {
        return ( (row + column + width ) % 2 == 0 ? WHITE : BLACK );
    }

    public void initTheBoard() {
        for (int row = 0; row < MAX_ROWS; row ++ )	{
            for (int column = 0; column < MAX_COLUMNS; column ++ )	{
                for (int width = 0; width < MAX_WIDTH; width ++ ) {
                    theBoard[row][column][width] = ' ';
                }
            }
        }
        for (int row = 1; row < MAX_ROWS; row ++ )	{
            for (int column = 1; column < MAX_COLUMNS; column ++ )	{
                for (int width = 1; width < MAX_WIDTH; width ++ )	{
                    theBoard[row][column][width] = whatColor(row, column, width);
                }
            }
            }
    }

    public void printTheBoard(char[][][] board) {
        for (int row = 0; row < MAX_ROWS; row ++ )	{
            for (int column = 0; column < MAX_COLUMNS; column ++ )	{
                for (int width = 0; width < MAX_WIDTH; width ++ ) {
                    System.out.print(" " + board[row][column][width]);
                }
                System.out.println();
            }
        }
    }

    public void copyTheBoard() {
        for (int row = 0; row < MAX_ROWS; row ++ )	{
            for (int column = 0; column < MAX_COLUMNS; column ++ )	{
                for (int width = 0; width < MAX_WIDTH; width ++ ) {
                    theBestBoard[row][column][width] = theBoard[row][column][width];
                }
            }
        }
    }
}
