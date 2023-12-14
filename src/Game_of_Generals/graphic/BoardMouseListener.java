package Game_of_Generals.graphic;

import Game_of_Generals.logic.LogicalAgent;

import java.awt.event.MouseEvent;

public class BoardMouseListener implements DummyListener {

    private final LogicalAgent logicalAgent = new LogicalAgent();

    public BoardMouseListener() {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int xa = e.getX();
        int ya = e.getY();
        logicalAgent.selectCell((xa / 144) + 1, (ya / 144) + 1);
    }
}
