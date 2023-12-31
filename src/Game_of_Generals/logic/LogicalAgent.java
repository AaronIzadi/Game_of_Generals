package Game_of_Generals.logic;

import Game_of_Generals.graphic.State.GameState;
import Game_of_Generals.graphic.loader.BoardBuilder;
import Game_of_Generals.model.*;
import Game_of_Generals.model.piece.King;
import Game_of_Generals.model.piece.Piece;
import Game_of_Generals.model.piece.PieceType;

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
                    printCurrentState();
                    printEachPlayerHitPiece();
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

    public void printCurrentState(){

        StringBuilder state = new StringBuilder();

        for (int y = 5; y > 0; y--) {
            for (int x = 2; x < 7; x++){
                Piece piece = board.getCell(x,y).getPiece();
                if (piece != null) {
                    if (piece.getColor() == Color.WHITE) {
                        switch (piece.getType()) {
                            case PAWN:
                                state.append('P');
                                break;
                            case KING:
                                state.append('K');
                                break;
                            case LANCE:
                                state.append('L');
                                break;
                            case BISHOP:
                                state.append('B');
                                break;
                            case GOLDEN_GENERAL:
                                state.append('G');
                                break;
                            case SILVER_GENERAL:
                                state.append('S');
                                break;
                        }
                    } else {
                        switch (piece.getType()) {
                            case PAWN:
                                state.append('p');
                                break;
                            case KING:
                                state.append('k');
                                break;
                            case LANCE:
                                state.append('l');
                                break;
                            case BISHOP:
                                state.append('b');
                                break;
                            case GOLDEN_GENERAL:
                                state.append('g');
                                break;
                            case SILVER_GENERAL:
                                state.append('s');
                                break;
                        }
                    }
                } else {
                    state.append("-");
                }
            }
        }
        System.out.println(state);
    }

    public void printEachPlayerHitPiece() {
        StringBuilder blackHit = new StringBuilder("");
        StringBuilder whiteHit = new StringBuilder("");
        for (PieceType type : board.getPlayer1().getHitPiece()) {
            switch (type) {
                case PAWN:
                    blackHit.append('p');
                    break;
                case KING:
                    blackHit.append('k');
                    break;
                case LANCE:
                    blackHit.append('l');
                    break;
                case BISHOP:
                    blackHit.append('b');
                    break;
                case GOLDEN_GENERAL:
                    blackHit.append('g');
                    break;
                case SILVER_GENERAL:
                    blackHit.append('s');
                    break;
            }
        }
        for (PieceType type : board.getPlayer2().getHitPiece()) {
            switch (type) {
                case PAWN:
                    whiteHit.append('P');
                    break;
                case KING:
                    whiteHit.append('K');
                    break;
                case LANCE:
                    whiteHit.append('L');
                    break;
                case BISHOP:
                    whiteHit.append('B');
                    break;
                case GOLDEN_GENERAL:
                    whiteHit.append('G');
                    break;
                case SILVER_GENERAL:
                    whiteHit.append('S');
                    break;
            }
        }
        System.out.println(blackHit);
        System.out.println(whiteHit);
    }

}
