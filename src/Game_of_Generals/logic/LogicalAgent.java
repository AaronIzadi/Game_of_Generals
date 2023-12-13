package logic;

import model.*;
import model.piece.Piece;
import model.piece.PieceType;

public class LogicalAgent {

    private final GameState gameState;
    private final BoardBuilder boardBuilder = new BoardBuilder();
    private Board board = Board.getInstance();


    public LogicalAgent() {
        this.gameState = loadGameState();
    }

    public GameState getGameState() {
        return gameState;
    }

    private GameState loadGameState() {
        board = boardBuilder.build();
        Player player1 = board.getPlayer1();
        Player player2 = board.getPlayer2();
        return new GameState(board, player1, player2);
    }

    public String checkForEndGame() {

        Piece kingWhite = null;
        Piece kingBlack = null;
        String str = null;

        for (Piece piece : board.getPieces()) {
            if (piece.getType() == PieceType.KING) {
                if (piece.getColor() == Color.WHITE) {
                    kingWhite = piece;
                }
            }
        }
        for (Piece piece : board.getPieces()) {
            if (piece.getType() == PieceType.KING) {
                if (piece.getColor() == Color.BLACK) {
                    kingBlack = piece;
                }
            }
        }

        if (kingBlack == null || !kingBlack.isAlive()) {
            str = "white wins!";
        }
        if (kingWhite == null || !kingWhite.isAlive()) {
            str = "black wins!";
        }

        return str;
    }

    public Piece getPieceByCell(PieceType pieceType, Color color, int x, int y) {

        for (Piece piece : board.getPieces()) {
            if (pieceType == piece.getType() && piece.getColor() == color && piece.getCurrentCell().getX() == x && piece.getCurrentCell().getY() == y) {
                return piece;
            }
        }
        return null;
    }

    public Cell getDestination(int x, int y) {
        if (x > 0 && x < 6 && y > 0 && y < 6) {
            for (Cell cell : board.getCells()) {
                if (cell.getX() == x && cell.getY() == y) {
                    return cell;
                }
            }
        }
        return null;
    }

}
