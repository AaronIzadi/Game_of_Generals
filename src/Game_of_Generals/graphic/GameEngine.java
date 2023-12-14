package Game_of_Generals.graphic;

import Game_of_Generals.logic.BoardBuilder;
import Game_of_Generals.model.Board;
import Game_of_Generals.model.Color;
import Game_of_Generals.model.Player;

import javax.swing.*;

public class GameEngine {

    private static final GameEngine instance = new GameEngine();
    private final static int WIDTH = 1008, HEIGHT = 720;
    private final ImageLoader imageLoader = ImageLoader.getInstance();
    private GameState gameState = GameState.START_SCREEN;
    private StartScreenSelection startScreenSelection = StartScreenSelection.START_GAME;
    private UIManager uiManager;
    private BoardBuilder boardBuilder = new BoardBuilder();
    private Board board;
    private Player currentPlayer;

    public static GameEngine getInstance() {
        return instance;
    }

    private GameEngine() {
        initial();
    }

    private void initial() {
        uiManager = new UIManager(this, WIDTH, HEIGHT);
        board = boardBuilder.build();
        if (board.getPlayer1().getColor() == Color.BLACK) {
            currentPlayer = board.getPlayer1();
        } else {
            currentPlayer = board.getPlayer2();
        }
        JFrame frame = new JFrame("Game of Generals");
        frame.setIconImage(imageLoader.getIcon());
        frame.add(uiManager);
        //frame.addKeyListener(inputManager);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public UIManager getUiManager() {
        return uiManager;
    }

    public GameState getGameState() {
        return gameState;
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
}
