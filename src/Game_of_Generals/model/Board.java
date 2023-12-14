package Game_of_Generals.model;

import Game_of_Generals.model.piece.Piece;

import java.util.LinkedList;
import java.util.List;

public class Board {

    private static Board board;
    private List<Cell> cells;
    private List<Piece> pieces;
    private Player player1;
    private Player player2;


    public static Board getInstance() {
        if (board == null) {
            board = new Board();
        }
        return board;
    }

    public Board() {
        cells = new LinkedList<>();
        pieces = new LinkedList<>();
        board = this;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void removePiece(Piece piece) {
        pieces.remove(piece);
    }

    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    public static Board getBoard() {
        return board;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public Piece whichPieceExist(int x, int y) {
        for (Piece piece : getPieces()) {
            if (piece.getCurrentCell().getX() == x && piece.getCurrentCell().getY() == y) {
                return piece;
            }
        }
        return null;
    }
}
