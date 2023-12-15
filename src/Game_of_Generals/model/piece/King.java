package Game_of_Generals.model.piece;

import Game_of_Generals.model.Cell;
import Game_of_Generals.model.Color;
import Game_of_Generals.model.Player;


public class King extends Piece {

    public King(Player player, Color color) {
        super(player, color);
        setType(PieceType.KING);
    }

    @Override
    public boolean isValidMove(Cell destination) {

        Cell currentCell = this.getCurrentCell();
        int x1 = (currentCell.getX() / 144);
        int y1 = (currentCell.getY() / 144);
        int x2 = (destination.getX() / 144);
        int y2 = (destination.getY() / 144);

        if (x2 > 6 || x2 < 1 || y2 > 5 || y2 < 0) {
            return false;
        }

        if ((this.getColor() == Color.WHITE && x1 == 1) || (this.getColor() == Color.BLACK && x1 == 7)) {
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
            for (Piece piece : getPlayer().getPieces()) {
                if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                    return false;
                }
            }
            return true;
        } else if (x2 == x1 && y2 == y1 + 1) {
            for (Piece piece : getPlayer().getPieces()) {
                if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                    return false;
                }
            }
            return true;
        } else if (x2 == x1 + 1 && y2 == y1 + 1) {
            for (Piece piece : getPlayer().getPieces()) {
                if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                    return false;
                }
            }
            return true;
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

            for (Piece piece : getPlayer().getPieces()) {
                if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                    return false;
                }
            }
            return true;
        } else if (x2 == x1 && y2 == y1 - 1) {
            for (Piece piece : getPlayer().getPieces()) {
                if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                    return false;
                }
            }
            return true;
        } else if (x2 == x1 + 1 && y2 == y1 - 1) {
            for (Piece piece : getPlayer().getPieces()) {
                if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                    return false;
                }
            }
            return true;
        }
        return false;
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
        return PieceType.KING;
    }
}
