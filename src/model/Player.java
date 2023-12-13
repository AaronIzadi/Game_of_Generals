package model;

import model.piece.Piece;
import model.piece.PieceType;

import java.util.LinkedList;
import java.util.List;

public class Player {

    private List<Piece> pieces = new LinkedList<>();
    private Player rival;
    private final int playerNumber;
    private Piece selectedPiece;
    private final Color color;
    private final List<PieceType> hitPiece = new LinkedList<>();
    public static final int PLAYER_BLACK = 1;
    public static final int PLAYER_WHITE = 2;

    public Player(int playerNumber) {
        this.playerNumber = playerNumber;
        if (playerNumber == 1) {
            this.color = Color.BLACK;
        } else {
            this.color = Color.WHITE;
        }
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public void setRival(Player rival) {
        this.rival = rival;
    }

    public void setSelectedPiece(Piece selectedPiece) {
        this.selectedPiece = selectedPiece;
    }

    public Piece getSelectedPiece() {
        return selectedPiece;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public Player getRival() {
        return rival;
    }

    public Color getColor() {
        return color;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void endTurn() {
        selectedPiece = null;
    }

    public void addHitPiece(PieceType pieceType) {
        hitPiece.add(pieceType);
    }

    public void removeHitPiece(PieceType pieceType) {
        hitPiece.remove(pieceType);
    }

    public List<PieceType> getHitPiece() {
        return hitPiece;
    }

    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    public void removePiece(Piece piece) {
        pieces.remove(piece);
    }
}
