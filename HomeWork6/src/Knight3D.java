public class Knight3D extends Knight {
    public boolean isSave(int thisRow, int thisColumn, int thisWidth, Board3D board3D) {
        return  	board3D.isThereAChessPiece(thisRow, thisColumn,  thisWidth, chessPieceColor )			&&	// 0
                board3D.isThereAChessPiece(thisRow - 2, thisColumn - 1, thisWidth,  chessPieceColor )			&&	// 1
                board3D.isThereAChessPiece(thisRow - 2, thisColumn + 1,thisWidth, chessPieceColor )			&&	// 2
                board3D.isThereAChessPiece(thisRow - 1, thisColumn + 2,thisWidth, chessPieceColor )			&&	// 3
                board3D.isThereAChessPiece(thisRow - 1, thisColumn - 2,thisWidth, chessPieceColor )			&&	// 4
                board3D.isThereAChessPiece(thisRow + 1, thisColumn + 2,thisWidth, chessPieceColor )			&&	// 5
                board3D.isThereAChessPiece(thisRow + 1, thisColumn - 2,thisWidth, chessPieceColor )			&&	// 6
                board3D.isThereAChessPiece(thisRow + 2, thisColumn - 1,thisWidth, chessPieceColor )			&&	// 7
                board3D.isThereAChessPiece(thisRow + 2, thisColumn + 1,thisWidth, chessPieceColor )			&&	// 8
                board3D.isThereAChessPiece(thisRow - 1, thisColumn , thisWidth + 2, chessPieceColor ) &&
                board3D.isThereAChessPiece(thisRow + 1, thisColumn , thisWidth + 2, chessPieceColor ) &&
                board3D.isThereAChessPiece(thisRow - 2, thisColumn , thisWidth + 1, chessPieceColor ) &&
                board3D.isThereAChessPiece(thisRow + 2, thisColumn , thisWidth + 1, chessPieceColor ) &&
                board3D.isThereAChessPiece(thisRow - 1, thisColumn , thisWidth - 2, chessPieceColor ) &&
                board3D.isThereAChessPiece(thisRow + 1, thisColumn , thisWidth - 2, chessPieceColor ) &&
                board3D.isThereAChessPiece(thisRow - 1, thisColumn , thisWidth - 2, chessPieceColor ) &&
                board3D.isThereAChessPiece(thisRow - 1, thisColumn , thisWidth - 2, chessPieceColor );
    }

    public void placeKnight(int startC, int startR, int startW, Board3D board3D)	{
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
                            placeKnight(1,  1, 1, board3D);
                            board3D.removePieceFrom(row, column, width, chessPieceColor);
                            noOfPieces--;
                        }
                    }
                }

            }
        }
    }
}
