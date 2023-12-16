package Game_of_Generals.graphic.input;

import Game_of_Generals.graphic.State.GraphicalGameState;
import Game_of_Generals.logic.GameEngine;
import Game_of_Generals.logic.LogicalAgent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardMouseListener implements MouseListener {

    private static final BoardMouseListener instance = new BoardMouseListener();

    public static BoardMouseListener getInstance() {
        return instance;
    }

    private BoardMouseListener() {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (GameEngine.getInstance().getGameState() == GraphicalGameState.RUNNING) {
            int x = e.getX();
            int y = e.getY();
            LogicalAgent.getInstance().selectCell((x / 144) + 1, (y / 144) + 1);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
