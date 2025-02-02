package spacewars.controller.game;

import spacewars.Application;
import spacewars.controller.Controller;
import spacewars.controller.game.elements.*;
import spacewars.controller.game.elements.invaders.*;
import spacewars.controller.game.elements.invaders.normal_invaders.NormalInvader3Controller;
import spacewars.controller.game.elements.invaders.normal_invaders.NormalInvader1Controller;
import spacewars.controller.game.elements.invaders.normal_invaders.NormalInvader2Controller;
import spacewars.gui.GUI;
import spacewars.model.game.Game;
import spacewars.model.game.HighScore;
import spacewars.model.menu.GameOver;
import spacewars.model.menu.MainMenu;
import spacewars.states.GameOverState;
import spacewars.states.MainMenuState;

import java.io.IOException;
import java.net.URISyntaxException;

public class GameController extends Controller<Game> {
    private final PlayerController playerController;
    private final NormalInvader1Controller invader1Controller;
    private final NormalInvader2Controller invader2Controller;
    private final NormalInvader3Controller invader3Controller;
    private final BossInvaderController bossInvaderController;
    private long lastMoveTime; // Track the last time the invaders moved
    private static final long MOVE_INTERVAL = 500; // Time in milliseconds between invader movements

    public GameController(Game game) {
        super(game);
        this.playerController = new PlayerController(getModel().getPlayer());
        this.invader1Controller = new NormalInvader1Controller(getModel().getInvaders1());
        this.invader2Controller = new NormalInvader2Controller(getModel().getInvaders2());
        this.invader3Controller = new NormalInvader3Controller(getModel().getInvaders3());
        this.bossInvaderController = new BossInvaderController(getModel().getBossInvader(), 320);
        this.lastMoveTime = 0;

        getModel().addObserver(invader1Controller);
        getModel().addObserver(invader2Controller);
        getModel().addObserver(invader3Controller);
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException, URISyntaxException {
        handlePlayerInput(action, application);
        getModel().updatePlayerBullet();

        // Move invaders at regular intervals
        if (time - lastMoveTime > MOVE_INTERVAL) {
            invader1Controller.moveInvaders();
            invader2Controller.moveInvaders();
            invader3Controller.moveInvaders();
            if (getModel().getBossInvader() != null) {
                bossInvaderController.moveBoss(time);
            }
            lastMoveTime = time;
        }

        getModel().updateInvaderBullets();
        getModel().respawnInvaders();

        if (isGameOver()) {
            transitionToGameOver(application);
        }
    }

    void handlePlayerInput(GUI.ACTION action, Application application) throws IOException, URISyntaxException {
        switch (action) {
            case LEFT -> playerController.moveLeft();
            case RIGHT -> playerController.moveRight();
            case SHOOT -> playerController.shoot();
            case QUIT -> onQuit(application);
        }
    }

    void onQuit(Application application) throws IOException, URISyntaxException {
        application.setState(new MainMenuState(new MainMenu(), application.getImageLoader()));
    }

    boolean isGameOver() {
        return getModel().getLives().isEmpty();
    }

    void transitionToGameOver(Application application) throws IOException, URISyntaxException {
        boolean isHighScore = HighScore.loadHighScore() < getModel().getRawScore();
        GameOver gameOver = new GameOver(getModel().getScore(), isHighScore);
        if (isHighScore) {
            HighScore.saveHighScore(getModel().getRawScore());
        }
        GameOverState gameOverState = new GameOverState(gameOver, application.getImageLoader());
        application.setState(gameOverState);
    }
}
