package Game_of_Generals.model.piece;

import Game_of_Generals.logic.LogicalAgent;
import Game_of_Generals.model.Board;
import Game_of_Generals.model.Cell;
import Game_of_Generals.model.Color;
import Game_of_Generals.model.Player;

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

            if ((this.getColor() == Color.WHITE && currentCell.getX() == 0) || (this.getColor() == Color.BLACK && currentCell.getX() == 6)) {

                if (getPlayer().getHitPiece().contains(this.type)) {
                    for (PieceType type : getPlayer().getHitPiece()) {
                        if (type == this.type) {
                            getPlayer().removeHitPiece(this.getType());
                            break;
                        }
                    }
                    this.setAlive(true);
                    board.addPiece(this);
                }

            }

            Piece hitPiece = null;
            Piece piece = destination.getPiece();
            if (piece != null) {
                if (piece.getType() != PieceType.KING) {
                    hitPiece = piece;
                    piece.setAlive(false);
                    piece.setColor(this.getColor());
                    getPlayer().addHitPiece(piece.getType());
                } else {
                    piece.setAlive(false);
                    destination.setPiece(null);
                    board.removePiece(piece);
                    LogicalAgent.getInstance().checkForEndGame();
                }
            }

            if (hitPiece != null) {
                List<Piece> newRivalPieces = getPlayer().getRival().getPieces();
                newRivalPieces.remove(hitPiece);
                getPlayer().getRival().setPieces(newRivalPieces);

                int index = getPlayer().getHitPiece().size();
                if (this.getColor() == Color.WHITE) {
                    hitPiece.setCurrentCell(board.getCell(1, 6 - index));
                    board.getCell(1, 6 - index).setPiece(hitPiece);
                } else {
                    hitPiece.setCurrentCell(board.getCell(7, index));
                    board.getCell(7, index).setPiece(hitPiece);
                }
                hitPiece.setPlayer(getPlayer());
                hitPiece.setActivated(false);
                hitPiece.setAlive(false);
                List<Piece> newPlayerPieces = getPlayer().getPieces();
                newPlayerPieces.add(hitPiece);
                getPlayer().setPieces(newPlayerPieces);
            }

            if (this.currentCell.getX() != 0 && this.currentCell.getX() != 6) {
                if (this.getColor() == Color.BLACK && destination.getY() > 3) {
                    this.setActivated(true);
                }
                if (this.getColor() == Color.WHITE && destination.getY() < 3) {
                    this.setActivated(true);
                }
            }
            this.setCurrentCell(destination);
            destination.setPiece(this);
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
