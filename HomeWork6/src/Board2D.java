public class Board2D extends Board {
    int MAX_ROWS;
    int MAX_COLUMNS;
    char[][] theBoard;
    char[][] theBestBoard;

    Board2D(int boardSize){
        this.MAX_ROWS = boardSize;
        this.MAX_COLUMNS = boardSize;
        this.theBoard = new char[ 2 + MAX_ROWS][ 2 + MAX_COLUMNS];
        this.theBestBoard= new char[ 2 + MAX_ROWS][ 2+ MAX_COLUMNS];
    }

    public boolean isThereAChessPiece( int row, int column, char chessPieceColor )	{
        if ( row < 0 )
            return true;
        if ( column < 0 )
            return true;
        if ( row >= MAX_ROWS )
            return true;
        if ( column >= MAX_COLUMNS )
            return true;

        return ( theBoard[row][column] !=  chessPieceColor);
    }

    public void removePieceFrom( int row, int column, char chessPieceColor )	{
        if ( theBoard[row][column] != chessPieceColor )
            System.out.println("No king on this position.");
        if ( theBoard[row][column] ==  chessPieceColor )  {
            theBoard[row][column] = whatColor(row, column);
        }
    }

    public void setPieceTo( int row, int column, char chessPieceColor)	{
        char thisIsOneTheSquare = theBoard[row][column];
        if ( thisIsOneTheSquare == chessPieceColor )
            System.out.println("King is already there.");
        if ( ( thisIsOneTheSquare ==  BLACK ) || ( thisIsOneTheSquare == WHITE ) ) {
            theBoard[row][column] = chessPieceColor;
        } else
            System.out.println("A wall piece is there (" + row + "/" + column + ")");
    }

    public void setTheBoard(char[][] theBoard) {
        this.theBoard = theBoard;
    }

    public char[][] getTheBoard() {
        return theBoard;
    }

    public void createWall() {
        theBoard[2][1] = NOT_LEGAL;
        theBoard[2][2] = NOT_LEGAL;
        theBoard[2][3] = NOT_LEGAL;
    }

    public char whatColor(int row, int column) {
        return ( (row + column ) % 2 == 0 ? WHITE : BLACK );
    }

    public void initTheBoard() {
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

    public void printTheBoard(char[][] board) {
        for (int row = 0; row < MAX_ROWS; row ++ )	{
            for (int column = 0; column < MAX_COLUMNS; column ++ )	{
                System.out.print(" " + board[row][column]);
            }
            System.out.println();
        }
    }

    public void copyTheBoard() {
        for (int row = 0; row < MAX_ROWS; row ++ )	{
            for (int column = 0; column < MAX_COLUMNS; column ++ )	{
                theBestBoard[row][column] = theBoard[row][column];
            }
        }
    }
}
