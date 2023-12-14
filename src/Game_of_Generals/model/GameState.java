package Game_of_Generals.model;

import Game_of_Generals.model.piece.Piece ;
import Game_of_Generals.model.piece.PieceType;

public class GameState {

    private final Board board;
    private final Player player1;
    private final Player player2;

    public GameState(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }


    public Player getPlayer(int i) {
        if (i == 1) return player1;
        else if (i == 2) return player2;
        else return null;
    }


    @Override
    public String toString() {

        StringBuilder state = new StringBuilder();

        for (int x = 1; x < 6; x++) {
            for (int y = 1; y < 6; y++) {
                Piece piece = board.whichPieceExist(y, x);
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
        return state.toString();
    }

    public void hitToString() {
        StringBuilder hit1 = new StringBuilder("");
        StringBuilder hit2 = new StringBuilder("");
        for (PieceType type : getPlayer1().getHitPiece()) {
            switch (type) {
                case PAWN:
                    hit1.append('p');
                    break;
                case KING:
                    hit1.append('k');
                    break;
                case LANCE:
                    hit1.append('l');
                    break;
                case BISHOP:
                    hit1.append('b');
                    break;
                case GOLDEN_GENERAL:
                    hit1.append('g');
                    break;
                case SILVER_GENERAL:
                    hit1.append('s');
                    break;
            }
        }
        for (PieceType type : getPlayer2().getHitPiece()) {
            switch (type) {
                case PAWN:
                    hit2.append('P');
                    break;
                case KING:
                    hit2.append('K');
                    break;
                case LANCE:
                    hit2.append('L');
                    break;
                case BISHOP:
                    hit2.append('B');
                    break;
                case GOLDEN_GENERAL:
                    hit2.append('G');
                    break;
                case SILVER_GENERAL:
                    hit2.append('S');
                    break;
            }
        }

        System.out.println(hit1);
        System.out.println(hit2);

    }

}
