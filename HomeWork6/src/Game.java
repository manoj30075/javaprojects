/**
 * Game.java
 *
 * Version: 1
 * Revisions: 0
 *
 * This program produces max number of queens, bishops, knights, rooks that can be
 * placed in the board without getting check-mate.
 *
 *
 * @author      Ashwath sreedhar halemane, ah7387
 * @author      Manoj kumar reddy Palasamudram, mp6112
 */

public class Game {
    static Board2D board2D;
    static Board3D board3D;
    static Knight knight = new Knight();
    static Bishop bishop = new Bishop();
    static Rook rook = new Rook();
    static Queen queen = new Queen();
    static Knight3D knight3D = new Knight3D();
    static Queen3D queen3D = new Queen3D();
    static Rook3D rook3D = new Rook3D();
    static Bishop3D bishop3D = new Bishop3D();

    public static void start2DGame() {
        board2D.initTheBoard();
        board2D.createWall();
        board2D.printTheBoard(board2D.theBoard);
        bishop.placeBishop(1, 1, board2D);
        bishop.printMaxRooks();
        board2D.printTheBoard(board2D.theBestBoard);
        board2D.initTheBoard();
        board2D.createWall();
        knight.placeKnight(1, 1, board2D);
        knight.printMaxRooks();
        board2D.printTheBoard(board2D.theBestBoard);
        board2D.initTheBoard();
        board2D.createWall();
        queen.placeQueen(1, 1, board2D);
        queen.printMaxRooks();
        board2D.printTheBoard(board2D.theBestBoard);
        board2D.initTheBoard();
        board2D.createWall();
        rook.placeRook(1, 1, board2D);
        rook.printMaxRooks();
        board2D.printTheBoard(board2D.theBestBoard);
    }

    public static void start3DGame() {
        board3D.initTheBoard();
        board3D.createWall();
        board3D.printTheBoard(board3D.theBoard);
        bishop3D.placeBishop(1, 1, 1, board3D);
        bishop3D.printMaxRooks();
        board3D.printTheBoard(board3D.theBestBoard);
        board3D.initTheBoard();
        board3D.createWall();
        knight3D.placeKnight(1, 1, 1, board3D);
        knight3D.printMaxRooks();
        board3D.printTheBoard(board3D.theBestBoard);
        board3D.initTheBoard();
        board3D.createWall();
        queen3D.placeQueen(1, 1, 1, board3D);
        queen3D.printMaxRooks();
        board3D.printTheBoard(board3D.theBestBoard);
        board3D.initTheBoard();
        board3D.createWall();
        rook3D.placeRook(1, 1, 1, board3D);
        rook3D.printMaxRooks();
        board3D.printTheBoard(board3D.theBestBoard);
    }

    public static void main(String[] args) {
        String dimension = args[0];
        int boardSize = Integer.parseInt(args[1]);

        if (dimension.equals("2")) {
            board2D = new Board2D(boardSize);
            start2DGame();
        } else {
            board3D = new Board3D(boardSize);
            start3DGame();
        }
    }
}
