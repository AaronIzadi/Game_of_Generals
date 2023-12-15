package Game_of_Generals.logic;

import Game_of_Generals.graphic.*;
import Game_of_Generals.graphic.input.BoardMouseListener;
import Game_of_Generals.graphic.input.ButtonAction;
import Game_of_Generals.graphic.input.MenuKeyListener;
import Game_of_Generals.graphic.UIManager;
import Game_of_Generals.graphic.loader.ImageLoader;
import Game_of_Generals.graphic.loader.SoundManager;
import Game_of_Generals.model.Board;
import Game_of_Generals.model.Color;
import Game_of_Generals.model.Player;

import javax.swing.*;

public class GameEngine implements Runnable {

    private static final GameEngine instance = new GameEngine();
    private final static int WIDTH = 1008, HEIGHT = 720;
    private final ImageLoader imageLoader = ImageLoader.getInstance();
    private GraphicalGameState graphicalGameState = GraphicalGameState.START_SCREEN;
    private StartScreenSelection startScreenSelection = StartScreenSelection.START_GAME;
    private final MenuKeyListener keyListener = MenuKeyListener.getInstance();
    private final BoardMouseListener mouseListener = BoardMouseListener.getInstance();
    private final BoardBuilder boardBuilder = new BoardBuilder();
    private SoundManager soundManager;
    private Game_of_Generals.graphic.UIManager uiManager;
    private Board board;
    private Thread thread;
    private Player currentPlayer;
    private boolean blackWon = false;

    public static GameEngine getInstance() {
        return instance;
    }

    private GameEngine() {
        initial();
    }

    private void initial() {
        uiManager = new Game_of_Generals.graphic.UIManager(this, WIDTH, HEIGHT);
        board = boardBuilder.build();
        soundManager = new SoundManager();
        if (board.getPlayer1().getColor() == Color.BLACK) {
            currentPlayer = board.getPlayer1();
        } else {
            currentPlayer = board.getPlayer2();
        }
        JFrame frame = new JFrame("Game of Generals");
        frame.setIconImage(imageLoader.getIcon());
        frame.add(uiManager);
        frame.addMouseListener(mouseListener);
        frame.addKeyListener(keyListener);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        renderLoop();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();

        while (!thread.isInterrupted()) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                delta--;
            }

            if (graphicalGameState != GraphicalGameState.RUNNING) {
                timer = System.currentTimeMillis();
            }

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
            }
        }
    }

    private void renderLoop() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(12);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                uiManager.repaint();
            }
        }).start();
    }

    public void receiveInput() {
        if (graphicalGameState == GraphicalGameState.START_SCREEN) {
            if (keyListener.getCurrentAction() == ButtonAction.SELECT) {
                if (startScreenSelection == StartScreenSelection.START_GAME) {
                    graphicalGameState = GraphicalGameState.RUNNING;
                    soundManager.playBackground();
                } else {
                    graphicalGameState = GraphicalGameState.ABOUT_SCREEN;
                }
            } else {
                selectOptionsOnStart(keyListener.getCurrentAction() == ButtonAction.GO_UP);
            }
        } else if (graphicalGameState == GraphicalGameState.RUNNING || graphicalGameState == GraphicalGameState.ABOUT_SCREEN || graphicalGameState==GraphicalGameState.WINNER_ANNOUNCEMENT){
            if (keyListener.getCurrentAction() == ButtonAction.BACK){
                graphicalGameState = GraphicalGameState.START_SCREEN;
            }
        }
    }

    private void selectOptionsOnStart(boolean selectUp) {
        startScreenSelection = startScreenSelection.select(selectUp);
    }

    public UIManager getUiManager() {
        return uiManager;
    }

    public GraphicalGameState getGameState() {
        return graphicalGameState;
    }

    public StartScreenSelection getStartScreenSelection() {
        return startScreenSelection;
    }

    public BoardBuilder getBoardBuilder() {
        return boardBuilder;
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setNextPlayer() {
        if (currentPlayer == board.getPlayer1()) {
            currentPlayer = board.getPlayer2();
        } else {
            currentPlayer = board.getPlayer1();
        }
    }

    public void setBlackWon(boolean blackWon) {
        this.blackWon = blackWon;
    }

    public boolean ifBlackWon() {
        return blackWon;
    }

    public void setGraphicalGameState(GraphicalGameState graphicalGameState) {
        this.graphicalGameState = graphicalGameState;
    }
}
