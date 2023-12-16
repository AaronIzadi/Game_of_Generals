package Game_of_Generals.graphic.input;

import Game_of_Generals.graphic.State.GraphicalGameState;
import Game_of_Generals.logic.GameEngine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

public class MenuKeyListener implements KeyListener {

    ButtonAction currentAction = ButtonAction.NO_ACTION;
    private static final MenuKeyListener instance = new MenuKeyListener();

    public static MenuKeyListener getInstance() {
        return instance;
    }

    @Override
    public void keyTyped(KeyEvent event) {
    }

    private void notifyInput(ButtonAction action){
        if (action != ButtonAction.NO_ACTION) {
            GameEngine.getInstance().receiveInput();
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();
        GraphicalGameState state = GameEngine.getInstance().getGameState();
        if (state == GraphicalGameState.START_SCREEN) {
            if (keyCode == VK_DOWN) {
                currentAction = ButtonAction.GO_DOWN;
            } else if (keyCode == VK_UP) {
                currentAction = ButtonAction.GO_UP;
            } else if (keyCode == VK_ENTER) {
                currentAction = ButtonAction.SELECT;
            } else {
                currentAction = ButtonAction.NO_ACTION;
            }
        } else if (state == GraphicalGameState.ABOUT_SCREEN || state == GraphicalGameState.WINNER_ANNOUNCEMENT || state == GraphicalGameState.RUNNING) {
            if (keyCode == VK_ESCAPE) {
                currentAction = ButtonAction.BACK;
            } else {
                currentAction = ButtonAction.NO_ACTION;
            }
        }

        notifyInput(currentAction);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public ButtonAction getCurrentAction() {
        return currentAction;
    }
}
