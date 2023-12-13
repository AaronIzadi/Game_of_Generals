package model.piece;

import model.Board;
import model.Cell;
import model.Color;
import model.Player;

import java.util.List;

public class Piece {

    private Cell currentCell;
    private Color color;
    private Player player;
    private final Board board = Board.getInstance();
    private PieceType type;
    private boolean isSelected;
    private boolean alive;
    protected boolean activated;

    public Piece(Player player, Color color) {
        this.player = player;
        this.color = color;
        this.alive = true;
        this.activated = false;
    }

    public boolean isValidMove(Cell destination) {
        return true;
    }

    public void moveTo(Cell destination) {

        if (isValidMove(destination)) {

            if (this.currentCell.getX() == 0 && this.currentCell.getY() == 0) {

                if (getPlayer().getHitPiece().contains(this.type)) {
                    for (PieceType type: getPlayer().getHitPiece()) {
                        if (type==this.type){
                            getPlayer().removeHitPiece(this.getType());
                            break;
                        }
                    }
                    this.setAlive(true);
                    board.addPiece(this);
                }

            }

            Piece hitPiece = null;
            for (Piece piece : getPlayer().getRival().getPieces()) {
                if (piece.getCurrentCell().getX() == destination.getX() && piece.getCurrentCell().getY() == destination.getY()) {
                    if (piece.getType() != PieceType.KING) {
                        hitPiece = piece;
                    } else {
                        piece.setAlive(false);
                        getPlayer().addHitPiece(piece.getType());
                    }
                }
            }
            if (hitPiece != null) {
                List<Piece> newRivalPieces = getPlayer().getRival().getPieces();
                newRivalPieces.remove(hitPiece);
                getPlayer().getRival().setPieces(newRivalPieces);
                Cell emptyCell = null;
                for (Cell cell : board.getCells()) {
                    if (cell.getX() == 0 && cell.getY() == 0) {
                        emptyCell = cell;
                    }
                }
                hitPiece.setCurrentCell(emptyCell);
                hitPiece.setPlayer(getPlayer());
                hitPiece.setColor(getPlayer().getColor());
                hitPiece.setActivated(false);
                hitPiece.setAlive(false);
                getPlayer().addHitPiece(hitPiece.getType());
                List<Piece> newPlayerPieces = getPlayer().getPieces();
                newPlayerPieces.add(hitPiece);
                getPlayer().setPieces(newPlayerPieces);
            }

            if (this.currentCell.getX() != 0 && this.currentCell.getY() != 0) {
                if (this.getColor() == Color.BLACK && destination.getY() < 3) {
                    this.setActivated(true);
                }
                if (this.getColor() == Color.WHITE && destination.getY() > 3) {
                    this.setActivated(true);
                }
            }
            this.setCurrentCell(destination);
        }
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Board getBoard() {
        return board;
    }

    public PieceType getType() {
        return type;
    }

    public void setType(PieceType type) {
        this.type = type;
    }
}
