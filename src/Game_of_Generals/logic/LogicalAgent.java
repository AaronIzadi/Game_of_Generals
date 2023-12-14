package Game_of_Generals.logic;

import Game_of_Generals.graphic.GameEngine;
import Game_of_Generals.model.*;
import Game_of_Generals.model.piece.Piece;
import Game_of_Generals.model.piece.PieceType;

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
        if (x > 0 && x < 6 && y > 0 && y < 5) {
            for (Cell cell : board.getCells()) {
                if (cell.getX() == x && cell.getY() == y) {
                    return cell;
                }
            }
        }
        return null;
    }

    public void selectCell(int x, int y) {
        Player player = GameEngine.getInstance().getCurrentPlayer();
        Cell cell = GameEngine.getInstance().getBoard().getCell(x, y);
        if (player.getSelectedPiece() == null && cell.getPiece() != null && cell.getPiece().getPlayer().equals(player)) {
            player.setSelectedPiece(cell.getPiece());
        } else if (player.getSelectedPiece() != null) {
            if (cell.getPiece() != null && cell.getPiece().getPlayer().equals(player)) {
                player.setSelectedPiece(cell.getPiece());
            } else {
                Piece piece = player.getSelectedPiece();
                if (piece.isValidMove(cell)) {
                    piece.moveTo(cell);
                    GameEngine.getInstance().setNextPlayer();
                }
            }
        }


        // TODO update board
        checkForEndGame();
    }

    public void updateBoard(Cell current, Cell destination) {
        for (Piece thePiece : board.getPieces()) {
            if (thePiece.getCurrentCell() == current) {
                thePiece.setCurrentCell(destination);
                destination.setPiece(thePiece);
            }
        }
        current.setPiece(null);
    }

}
