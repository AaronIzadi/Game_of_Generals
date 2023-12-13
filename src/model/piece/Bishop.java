package model.piece;

import model.Cell;
import model.Color;
import model.Player;

public class Bishop extends Piece {

    public Bishop(Player player, Color color) {
        super(player, color);
        setType(PieceType.BISHOP);
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


        if (this.isActivated()) {

            if (x2 == x1 || x2 == x1 - 1 || x2 == x1 + 1) {
                if (y2 == y1 || y2 == y1 - 1 || y2 == y1 + 1) {
                    if (x1 == x2 && y1 == y2) {
                        return false;
                    } else {
                        for (Piece piece : getPlayer().getPieces()) {
                            if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            } else if (x1 + y1 == x2 + y2 || Math.abs(x1 - y1) == Math.abs(x2 - y2)) {

                if (y2 > y1) {
                    if (x2 > x1) {

                        for (int i = 1; i < Math.abs(y2 - y1); i++) {
                            for (Piece piece : getPlayer().getRival().getPieces()) {
                                if (piece.getCurrentCell().getX() == x1 + i && piece.getCurrentCell().getY() == y1 + i) {
                                    return false;
                                }

                            }
                        }
                        for (int i = 1; i <= Math.abs(y2 - y1); i++) {
                            for (Piece piece : getPlayer().getPieces()) {
                                if (piece.getCurrentCell().getX() == x1 + i && piece.getCurrentCell().getY() == y1 + i) {
                                    return false;
                                }
                            }
                        }
                        return true;
                    } else {

                        for (int i = 1; i < Math.abs(y2 - y1); i++) {
                            for (Piece piece : getPlayer().getRival().getPieces()) {
                                if (piece.getCurrentCell().getX() == x1 - i && piece.getCurrentCell().getY() == y1 + i) {
                                    return false;
                                }
                            }
                        }
                        for (int i = 1; i <= Math.abs(y2 - y1); i++) {
                            for (Piece piece : getPlayer().getPieces()) {
                                if (piece.getCurrentCell().getX() == x1 - i && piece.getCurrentCell().getY() == y1 + i) {
                                    return false;
                                }
                            }
                        }
                        return true;
                    }
                } else if (y2 < y1) {

                    if (x2 > x1) {

                        for (int i = 1; i < Math.abs(y1 - y2); i++) {
                            for (Piece piece : getPlayer().getRival().getPieces()) {
                                if (piece.getCurrentCell().getX() == x1 + i && piece.getCurrentCell().getY() == y1 - i) {
                                    return false;
                                }
                            }
                        }
                        for (int i = 1; i <= Math.abs(y1 - y2); i++) {
                            for (Piece piece : getPlayer().getPieces()) {
                                if (piece.getCurrentCell().getX() == x1 + i && piece.getCurrentCell().getY() == y1 - i) {
                                    return false;
                                }
                            }
                        }
                        return true;
                    } else {

                        for (int i = 1; i < Math.abs(y1 - y2); i++) {
                            for (Piece piece : getPlayer().getRival().getPieces()) {
                                if (piece.getCurrentCell().getX() == x1 - i && piece.getCurrentCell().getY() == y1 - i) {
                                    return false;
                                }
                            }
                        }
                        for (int i = 1; i <= Math.abs(y1 - y2); i++) {
                            for (Piece piece : getPlayer().getPieces()) {
                                if (piece.getCurrentCell().getX() == x1 - i && piece.getCurrentCell().getY() == y1 - i) {
                                    return false;
                                }
                            }
                        }
                        return true;
                    }
                }
            }
            return false;
        }

        if (x1 + y1 == x2 + y2 || Math.abs(x1 - y1) == Math.abs(x2 - y2)) {

            if (this.getColor() == Color.WHITE) {

                if (y2 <= y1) {
                    return false;
                }

                if (x2 > x1) {

                    for (int i = 1; i < Math.abs(y2 - y1); i++) {
                        for (Piece piece : getPlayer().getRival().getPieces()) {
                            if (piece.getCurrentCell().getX() == x1 + i && piece.getCurrentCell().getY() == y1 + i) {
                                return false;
                            }

                        }
                    }
                    for (int i = 1; i <= Math.abs(y2 - y1); i++) {
                        for (Piece piece : getPlayer().getPieces()) {
                            if (piece.getCurrentCell().getX() == x1 + i && piece.getCurrentCell().getY() == y1 + i) {
                                return false;
                            }
                        }
                    }
                    return true;
                } else {

                    for (int i = 1; i < Math.abs(y2 - y1); i++) {
                        for (Piece piece : getPlayer().getRival().getPieces()) {
                            if (piece.getCurrentCell().getX() == x1 - i && piece.getCurrentCell().getY() == y1 + i) {
                                return false;
                            }
                        }
                    }
                    for (int i = 1; i <= Math.abs(y2 - y1); i++) {
                        for (Piece piece : getPlayer().getPieces()) {
                            if (piece.getCurrentCell().getX() == x1 - i && piece.getCurrentCell().getY() == y1 + i) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            } else {

                if (y2 >= y1) {
                    return false;
                }

                if (y1 - y2 != Math.abs(x2 - x1)) {
                    return false;
                }

                if (x2 > x1) {

                    for (int i = 1; i < Math.abs(y1 - y2); i++) {
                        for (Piece piece : getPlayer().getRival().getPieces()) {
                            if (piece.getCurrentCell().getX() == x1 + i && piece.getCurrentCell().getY() == y1 - i) {
                                return false;
                            }
                        }
                    }
                    for (int i = 1; i <= Math.abs(y1 - y2); i++) {
                        for (Piece piece : getPlayer().getPieces()) {
                            if (piece.getCurrentCell().getX() == x1 + i && piece.getCurrentCell().getY() == y1 - i) {
                                return false;
                            }
                        }
                    }
                    return true;
                } else {

                    for (int i = 1; i < Math.abs(y1 - y2); i++) {
                        for (Piece piece : getPlayer().getRival().getPieces()) {
                            if (piece.getCurrentCell().getX() == x1 - i && piece.getCurrentCell().getY() == y1 - i) {
                                return false;
                            }
                        }
                    }
                    for (int i = 1; i <= Math.abs(y1 - y2); i++) {
                        for (Piece piece : getPlayer().getPieces()) {
                            if (piece.getCurrentCell().getX() == x1 - i && piece.getCurrentCell().getY() == y1 - i) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            }
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
        return PieceType.BISHOP;
    }
}
