package model.piece;

import model.Cell;
import model.Color;
import model.Player;

public class GoldenGeneral extends Piece {

    public GoldenGeneral(Player player, Color color) {
        super(player, color);
        setType(PieceType.GOLDEN_GENERAL);
    }


    @Override
    public boolean isValidMove(Cell destination) {

        Cell currentCell = this.getCurrentCell();
        int x1 = currentCell.getX();
        int y1 = currentCell.getY();
        int x2 = destination.getX();
        int y2 = destination.getY();

        if (x2 > 5 || x2 < 1 || y2 > 5 || y2 < 1) {
            return false;
        }

        if (x1 == 0 && y1 == 0) {
            for (Piece piece : getPlayer().getPieces()) {
                if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                    return false;
                }
            }
            for (Piece piece : getPlayer().getRival().getPieces()) {
                if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                    return false;
                }
            }
            return true;
        }

        if (x2 == x1 - 1 && y2 == y1 + 1) {

            if (this.getColor() == Color.WHITE) {
                for (Piece piece : getPlayer().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else if (x2 == x1 && y2 == y1 + 1) {
            for (Piece piece : getPlayer().getPieces()) {
                if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                    return false;
                }
            }
            return true;
        } else if (x2 == x1 + 1 && y2 == y1 + 1) {

            if (this.getColor() == Color.WHITE) {
                for (Piece piece : getPlayer().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else if (x2 == x1 - 1 && y2 == y1) {
            for (Piece piece : getPlayer().getPieces()) {
                if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                    return false;
                }
            }
            return true;
        } else if (x2 == x1 + 1 && y2 == y1) {
            for (Piece piece : getPlayer().getPieces()) {
                if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                    return false;
                }
            }
            return true;
        } else if (x2 == x1 - 1 && y2 == y1 - 1) {

            if (this.getColor() == Color.BLACK) {
                for (Piece piece : getPlayer().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else if (x2 == x1 && y2 == y1 - 1) {
            for (Piece piece : getPlayer().getPieces()) {
                if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                    return false;
                }
            }
            return true;
        } else if (x2 == x1 + 1 && y2 == y1 - 1) {

            if (this.getColor() == Color.BLACK) {
                for (Piece piece : getPlayer().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public void moveTo(Cell destination) {
        super.moveTo(destination);
    }

    @Override
    public Cell getCurrentCell() {
        return super.getCurrentCell();
    }

    @Override
    public void setCurrentCell(Cell currentCell) {
        super.setCurrentCell(currentCell);
    }

    @Override
    public Color getColor() {
        return super.getColor();
    }

    @Override
    public void setColor(Color color) {
        super.setColor(color);
    }

    @Override
    public Player getPlayer() {
        return super.getPlayer();
    }

    @Override
    public void setPlayer(Player player) {
        super.setPlayer(player);
    }

    @Override
    public boolean isActivated() {
        return super.isActivated();
    }

    @Override
    public void setActivated(boolean activated) {
        super.setActivated(activated);
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
    }

    @Override
    public boolean isSelected() {
        return super.isSelected();
    }

    @Override
    public PieceType getType() {
        return PieceType.GOLDEN_GENERAL;
    }
}
