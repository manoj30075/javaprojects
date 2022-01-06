public class Knight extends ChessPiece {
    Knight() {
        this.chessPieceColor = 'k';
    }

    public void printMaxRooks()	{
        System.out.println("maximum number of Knights = " + maxNoOfPieces );
    }


   public boolean isSave(int thisRow, int thisColumn, Board2D board2D) {
        return  	board2D.isThereAChessPiece(thisRow, thisColumn, chessPieceColor )			&&	// 0
                board2D.isThereAChessPiece(thisRow - 2, thisColumn - 1, chessPieceColor )			&&	// 1
                board2D.isThereAChessPiece(thisRow - 2, thisColumn + 1, chessPieceColor )			&&	// 2
                board2D.isThereAChessPiece(thisRow - 1, thisColumn + 2, chessPieceColor )			&&	// 3
                board2D.isThereAChessPiece(thisRow - 1, thisColumn - 2, chessPieceColor )			&&	// 4
                board2D.isThereAChessPiece(thisRow + 1, thisColumn + 2, chessPieceColor )			&&	// 5
                board2D.isThereAChessPiece(thisRow + 1, thisColumn - 2, chessPieceColor )			&&	// 6
                board2D.isThereAChessPiece(thisRow + 2, thisColumn - 1, chessPieceColor )			&&	// 7
                board2D.isThereAChessPiece(thisRow + 2, thisColumn + 1, chessPieceColor );				// 8
    }

    public void placeKnight(int startC, int startR, Board2D board2D)	{
        for (int row = startR; row < board2D.MAX_ROWS; row ++ )	{
            for (int column = startC; column < board2D.MAX_COLUMNS; column ++ )	{
                char thisIsOnTheSquare = board2D.theBoard[row][column];
                if ( thisIsOnTheSquare != board2D.NOT_LEGAL ) {
                    if (isSave(row, column, board2D))	{
                        noOfPieces++;
                        board2D.setPieceTo(row, column, chessPieceColor);
                        if ( noOfPieces > maxNoOfPieces )	{
                            maxNoOfPieces = noOfPieces;
                            board2D.copyTheBoard();
                        }
                        placeKnight(1,  1, board2D);
                        board2D.removePieceFrom(row, column, chessPieceColor);
                        noOfPieces--;
                    }
                }
            }
        }
    }
}
