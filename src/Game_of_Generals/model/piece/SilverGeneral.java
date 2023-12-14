package Game_of_Generals.model.piece;

import Game_of_Generals.model.Cell;
import Game_of_Generals.model.Color;
import Game_of_Generals.model.Player;

public class SilverGeneral extends Piece {

    public SilverGeneral(Player player, Color color) {
        super(player, color);
        setType(PieceType.SILVER_GENERAL);
    }

    @Override
    public boolean isValidMove(Cell destination) {

        Cell currentCell = this.getCurrentCell();
        int x1 = currentCell.getX();
        int y1 = currentCell.getY();
        int x2 = destination.getX();
        int y2 = destination.getY();

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

            if (x2 == x1 - 1 && y2 == y1 + 1) {
                for (Piece piece : getPlayer().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                        return false;
                    }
                }
                return true;
            } else if (x2 == x1 - 2 && y2 == y1 + 2) {
                for (Piece piece : getPlayer().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                        return false;
                    }
                }
                for (Piece piece : getPlayer().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 + 1 && piece.getCurrentCell().getY() == y2 - 1) {
                        return false;
                    }
                }
                for (Piece piece : getPlayer().getRival().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 + 1 && piece.getCurrentCell().getY() == y2 - 1) {
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
            } else if (x2 == x1 && y2 == y1 + 2) {
                for (Piece piece : getPlayer().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                        return false;
                    }
                }
                for (Piece piece : getPlayer().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2 - 1) {
                        return false;
                    }
                }
                for (Piece piece : getPlayer().getRival().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2 - 1) {
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
            } else if (x2 == x1 + 2 && y2 == y1 + 2) {
                for (Piece piece : getPlayer().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                        return false;
                    }
                }
                for (Piece piece : getPlayer().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 + 1 && piece.getCurrentCell().getY() == y2 + 1) {
                        return false;
                    }
                }
                for (Piece piece : getPlayer().getRival().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 + 1 && piece.getCurrentCell().getY() == y2 + 1) {
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
            } else if (x2 == x1 - 2 && y2 == y1) {
                for (Piece piece : getPlayer().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                        return false;
                    }
                }
                for (Piece piece : getPlayer().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 + 1 && piece.getCurrentCell().getY() == y2) {
                        return false;
                    }
                }
                for (Piece piece : getPlayer().getRival().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 + 1 && piece.getCurrentCell().getY() == y2) {
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
            } else if (x2 == x1 + 2 && y2 == y1) {
                for (Piece piece : getPlayer().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                        return false;
                    }
                }
                for (Piece piece : getPlayer().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 - 1 && piece.getCurrentCell().getY() == y2) {
                        return false;
                    }
                }
                for (Piece piece : getPlayer().getRival().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 - 1 && piece.getCurrentCell().getY() == y2) {
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
            } else if (x2 == x1 - 2 && y2 == y1 - 2) {
                for (Piece piece : getPlayer().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                        return false;
                    }
                }
                for (Piece piece : getPlayer().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 + 1 && piece.getCurrentCell().getY() == y2 + 1) {
                        return false;
                    }
                }
                for (Piece piece : getPlayer().getRival().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 + 1 && piece.getCurrentCell().getY() == y2 + 1) {
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
            } else if (x2 == x1 && y2 == y1 - 2) {
                for (Piece piece : getPlayer().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                        return false;
                    }
                }
                for (Piece piece : getPlayer().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2 + 1) {
                        return false;
                    }
                }
                for (Piece piece : getPlayer().getRival().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2 + 1) {
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
            } else if (x2 == x1 + 2 && y2 == y1 - 2) {
                for (Piece piece : getPlayer().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                        return false;
                    }
                }
                for (Piece piece : getPlayer().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 - 1 && piece.getCurrentCell().getY() == y2 + 1) {
                        return false;
                    }
                }
                for (Piece piece : getPlayer().getRival().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 - 1 && piece.getCurrentCell().getY() == y2 + 1) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

        if (x2 == x1 - 1 && y2 == y1 + 1) {
            for (Piece piece : getPlayer().getPieces()) {
                if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                    return false;
                }
            }
            return true;
        } else if (x2 == x1 && y2 == y1 + 1) {

            if (this.getColor() == Color.WHITE) {
                for (Piece piece : getPlayer().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                        return false;
                    }
                }
                return true;
            }

            return false;

        } else if (x1 == x2 && y2 == y1 - 1) {

            if (this.getColor() == Color.BLACK) {
                for (Piece piece : getPlayer().getPieces()) {
                    if (piece.getCurrentCell().getX() == x2 && piece.getCurrentCell().getY() == y2) {
                        return false;
                    }
                }
                return true;
            }

            return false;

        } else if (x2 == x1 + 1 && y2 == y1 + 1) {
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
        return PieceType.SILVER_GENERAL;
    }
}
