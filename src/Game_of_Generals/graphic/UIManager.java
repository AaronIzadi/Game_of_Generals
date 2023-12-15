package Game_of_Generals.graphic;

import Game_of_Generals.graphic.loader.ImageLoader;
import Game_of_Generals.logic.GameEngine;
import Game_of_Generals.model.Board;
import Game_of_Generals.model.Color;
import Game_of_Generals.model.piece.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class UIManager extends JPanel {

    private final GameEngine engine;
    private final BufferedImage selectIcon;
    private final ImageLoader imageLoader = ImageLoader.getInstance();

    public UIManager(GameEngine engine, int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));

        this.engine = engine;
        this.selectIcon = ImageLoader.getInstance().getSelectIcon();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        GraphicalGameState graphicalGameState = engine.getGameState();

        if (graphicalGameState == GraphicalGameState.START_SCREEN) {
            drawStartScreen(g2);
        } else if (graphicalGameState == GraphicalGameState.ABOUT_SCREEN) {
            drawAboutScreen(g2);
        } else if (graphicalGameState == GraphicalGameState.RUNNING) {
            drawBoard(g2);
        } else {
            drawWinnerAnnouncementScreen(g2);
        }
        g2.dispose();
    }


    private void drawStartScreen(Graphics2D g2) {
        int row = engine.getStartScreenSelection().getLineNumber();
        g2.drawImage(imageLoader.getStartScreen(), 0, 0, null);
        g2.drawImage(selectIcon, 290, row * 90 + 375, null);
    }

    private void drawWinnerAnnouncementScreen(Graphics2D g2) {
        if (GameEngine.getInstance().ifBlackWon()) {
            g2.drawImage(imageLoader.getBlackWins(), 0, 0, null);
        } else {
            g2.drawImage(imageLoader.getWhiteWins(), 0, 0, null);
        }
    }

    private void drawAboutScreen(Graphics2D g2) {
        g2.drawImage(imageLoader.getAboutScreen(), 0, 0, null);
    }

    private void drawBoard(Graphics2D g2) {
        Board board = engine.getBoard();
        g2.drawImage(imageLoader.getBoard(), 0, 0, null);
        for (Piece piece : board.getPieces()) {
            switch (piece.getType()) {
                case PAWN:
                    if (piece.getColor() == Color.WHITE) {
                        g2.drawImage(imageLoader.getPawnWhite(), piece.getCurrentCell().getX(), piece.getCurrentCell().getY(), null);
                    } else {
                        g2.drawImage(imageLoader.getPawnBlack(), piece.getCurrentCell().getX(), piece.getCurrentCell().getY(), null);
                    }
                    break;
                case BISHOP:
                    if (piece.getColor() == Color.WHITE) {
                        g2.drawImage(imageLoader.getBishopWhite(), piece.getCurrentCell().getX(), piece.getCurrentCell().getY(), null);
                    } else {
                        g2.drawImage(imageLoader.getBishopBlack(), piece.getCurrentCell().getX(), piece.getCurrentCell().getY(), null);
                    }
                    break;
                case LANCE:
                    if (piece.getColor() == Color.WHITE) {
                        g2.drawImage(imageLoader.getLanceWhite(), piece.getCurrentCell().getX(), piece.getCurrentCell().getY(), null);
                    } else {
                        g2.drawImage(imageLoader.getLanceBlack(), piece.getCurrentCell().getX(), piece.getCurrentCell().getY(), null);
                    }
                    break;
                case KING:
                    if (piece.getColor() == Color.WHITE) {
                        g2.drawImage(imageLoader.getKingWhite(), piece.getCurrentCell().getX(), piece.getCurrentCell().getY(), null);
                    } else {
                        g2.drawImage(imageLoader.getKingBlack(), piece.getCurrentCell().getX(), piece.getCurrentCell().getY(), null);
                    }
                    break;
                case SILVER_GENERAL:
                    if (piece.getColor() == Color.WHITE) {
                        g2.drawImage(imageLoader.getSilverGeneralWhite(), piece.getCurrentCell().getX(), piece.getCurrentCell().getY(), null);
                    } else {
                        g2.drawImage(imageLoader.getSilverGeneralBlack(), piece.getCurrentCell().getX(), piece.getCurrentCell().getY(), null);
                    }
                    break;
                default:
                    if (piece.getColor() == Color.WHITE) {
                        g2.drawImage(imageLoader.getGoldenGeneralWhite(), piece.getCurrentCell().getX(), piece.getCurrentCell().getY(), null);
                    } else {
                        g2.drawImage(imageLoader.getGoldenGeneralBlack(), piece.getCurrentCell().getX(), piece.getCurrentCell().getY(), null);
                    }
                    break;
            }
        }
    }
}
