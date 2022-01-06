public class Queen extends ChessPiece {
    Queen() {
        this.chessPieceColor = 'q';
    }

    public void printMaxRooks()	{
        System.out.println("maximum number of Queens = " + maxNoOfPieces );
    }

    public boolean isSave(int thisRow, int thisColumn, Board2D board2D) {
        for (int i = 1; i <= board2D.MAX_ROWS; i++) {
            for (int j = 1; j <= board2D.MAX_COLUMNS; j++) {
                if (thisRow == i || thisColumn == j) {
                    if (!board2D.isThereAChessPiece(i, j, chessPieceColor)) {
                        return false;
                    };
                } else if (Math.abs(i-j) == (Math.abs(thisRow - thisColumn))) {
                    if (!board2D.isThereAChessPiece(i, j, chessPieceColor)) {
                        return false;
                    };
                }
            }
        }

        return true;
    }

    public void placeQueen(int startC, int startR, Board2D board2D)	{
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
                        placeQueen(1,  1, board2D);
                        board2D.removePieceFrom(row, column, chessPieceColor);
                        noOfPieces--;
                    }
                }
            }
        }
    }
}
