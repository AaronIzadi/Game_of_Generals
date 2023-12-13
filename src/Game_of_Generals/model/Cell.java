package model;

import model.piece.Piece;

import java.util.List;

public class Cell {

    private Color color;
    private final int x;
    private final int y;

    public Cell(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Cell getCell(int x, int y) {
        return this;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static boolean isAnyPieceInCoordinate(int x, int y, List<Piece> pieces) {
        for (Piece piece : pieces) {
            if (piece.getCurrentCell().getX() == x && piece.getCurrentCell().getY() == y) {
                return true;
            }
        }
        return false;
    }
}
