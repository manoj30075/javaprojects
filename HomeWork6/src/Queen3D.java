public class Queen3D extends  Queen{

    public boolean isSave(int thisRow, int thisColumn, int thisWidth, Board3D board3D) {
        for (int i = 1; i <= board3D.MAX_ROWS; i++) {
            for (int j = 1; j <= board3D.MAX_COLUMNS; j++) {
                for (int k = 1; k <= board3D.MAX_WIDTH; k++) {
                    if (thisRow == i || thisColumn == j || thisWidth == k) {
                        if (!board3D.isThereAChessPiece(i, j, k, chessPieceColor)) {
                            return false;
                        };
                    } else if (Math.abs(i-j-k) == (Math.abs(thisRow - thisColumn - thisWidth))) {
                        if (!board3D.isThereAChessPiece(i, j, k, chessPieceColor)) {
                            return false;
                        };
                    }
                }

            }
        }

        return true;
    }

    public void placeQueen(int startC, int startR, int startW, Board3D board3D)	{
        for (int row = startR; row < board3D.MAX_ROWS; row ++ )	{
            for (int column = startC; column < board3D.MAX_COLUMNS; column ++ )	{
                for (int width = startW; width < board3D.MAX_WIDTH; width ++ )	{
                    char thisIsOnTheSquare = board3D.theBoard[row][column][width];
                    if ( thisIsOnTheSquare != board3D.NOT_LEGAL ) {
                        if (isSave(row, column,width, board3D))	{
                            noOfPieces++;
                            board3D.setPieceTo(row, column, width, chessPieceColor);
                            if ( noOfPieces > maxNoOfPieces )	{
                                maxNoOfPieces = noOfPieces;
                                board3D.copyTheBoard();
                            }
                            placeQueen(1,  1, 1, board3D);
                            board3D.removePieceFrom(row, column, width, chessPieceColor);
                            noOfPieces--;
                        }
                    }
                }

            }
        }
    }
}
