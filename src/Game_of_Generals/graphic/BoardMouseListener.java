package Game_of_Generals.graphic;

import Game_of_Generals.logic.LogicalAgent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardMouseListener implements MouseListener {

    private final LogicalAgent logicalAgent = new LogicalAgent();

    public BoardMouseListener() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        logicalAgent.selectCell((x / 144) + 1, (y / 144) + 1);
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
