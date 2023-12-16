package Game_of_Generals.logic;

import Game_of_Generals.graphic.State.GameState;
import Game_of_Generals.graphic.loader.BoardBuilder;
import Game_of_Generals.model.*;
import Game_of_Generals.model.piece.King;
import Game_of_Generals.model.piece.Piece;

public class LogicalAgent {
    private final BoardBuilder boardBuilder = new BoardBuilder();
    private Board board = Board.getInstance();
    private Cell current;

    private static final LogicalAgent instance = new LogicalAgent();


    private LogicalAgent() {
        buildBoard();
    }

    public static LogicalAgent getInstance() {
        return instance;
    }

    private void buildBoard() {
        board = boardBuilder.build();
    }

    public void checkForEndGame() {

        Piece kingWhite = null;
        Piece kingBlack = null;
        String str = null;

        for (Piece piece : board.getPieces()) {
            if (piece instanceof King && piece.getColor() == Color.WHITE) {
                kingWhite = piece;
            }
        }
        for (Piece piece : board.getPieces()) {
            if (piece instanceof King && piece.getColor() == Color.BLACK) {
                kingBlack = piece;
            }
        }

        if (kingBlack == null || !kingBlack.isAlive()) {
            str = "white wins!";
            GameEngine.getInstance().setBlackWon(false);
        }
        if (kingWhite == null || !kingWhite.isAlive()) {
            str = "black wins!";
            GameEngine.getInstance().setBlackWon(true);
        }

        if (str != null){
            GameEngine.getInstance().setGraphicalGameState(GameState.WINNER_ANNOUNCEMENT);
        }
    }


    public void selectCell(int x, int y) {
        Player player = GameEngine.getInstance().getCurrentPlayer();
        Cell cell = GameEngine.getInstance().getBoard().getCell(x, y);
        if (player.getSelectedPiece() == null && cell.getPiece() != null && cell.getPiece().getPlayer().equals(player)) {
            player.setSelectedPiece(cell.getPiece());
            current = cell;
        } else if (player.getSelectedPiece() != null) {
            if (cell.getPiece() != null && cell.getPiece().getPlayer().equals(player)) {
                player.setSelectedPiece(cell.getPiece());
                current = cell;
            } else {
                Piece piece = player.getSelectedPiece();
                if (piece.isValidMove(cell)) {
                    piece.moveTo(cell);
                    updateBoard(current, cell);
                    current = null;
                    GameEngine.getInstance().setNextPlayer();
                }
            }
        }
        checkForEndGame();
    }

    public void updateBoard(Cell current, Cell destination) {
        Piece piece = current.getPiece();
        piece.setCurrentCell(destination);
        current.setPiece(null);
        destination.setPiece(piece);
    }

}
