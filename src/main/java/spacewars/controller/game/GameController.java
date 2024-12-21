package spacewars.controller.game;

import spacewars.Application;
import spacewars.controller.Controller;
import spacewars.controller.game.elements.*;
import spacewars.controller.game.elements.invaders.*;
import spacewars.controller.game.elements.invaders.normal_invaders.NormalInvader3Controller;
import spacewars.controller.game.elements.invaders.normal_invaders.NormalNormalInvader1Controller;
import spacewars.controller.game.elements.invaders.normal_invaders.NormalNormalInvader2Controller;
import spacewars.gui.GUI;
import spacewars.model.game.Game;
import spacewars.model.game.HighScore;
import spacewars.model.menu.GameOver;
import spacewars.model.menu.MainMenu;
import spacewars.states.GameOverState;
import spacewars.states.MainMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameController extends Controller<Game> {
    private final PlayerController playerController;
    private final NormalNormalInvader1Controller normalInvader1Controller;
    private final NormalNormalInvader2Controller invader2Controller;
    private final NormalInvader3Controller invader3Controller;
    private final BossInvaderController bossInvaderController;
    private long lastMoveTime; // Track the last time the invaders moved
    private static final long MOVE_INTERVAL = 500; // Time in milliseconds between invader movements

    public GameController(Game game) {
        super(game);
        this.playerController = new PlayerController(getModel().getPlayer());
        this.normalInvader1Controller = new NormalNormalInvader1Controller(getModel().getInvaders1());
        this.invader2Controller = new NormalNormalInvader2Controller(getModel().getInvaders2());
        this.invader3Controller = new NormalInvader3Controller(getModel().getInvaders3());
        this.bossInvaderController = new BossInvaderController(getModel().getBossInvader(), 320);
        this.lastMoveTime = 0;

        getModel().addObserver(normalInvader1Controller);
        getModel().addObserver(invader2Controller);
        getModel().addObserver(invader3Controller);
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException, FontFormatException, URISyntaxException {
        handlePlayerInput(action, application);
        getModel().updatePlayerBullet();

        // Move invaders at regular intervals
        if (time - lastMoveTime > MOVE_INTERVAL) {
            normalInvader1Controller.moveInvaders();
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

    private void handlePlayerInput(GUI.ACTION action, Application application) throws IOException, URISyntaxException, FontFormatException {
        switch (action) {
            case LEFT -> playerController.moveLeft();
            case RIGHT -> playerController.moveRight();
            case SHOOT -> playerController.shoot();
            case QUIT -> onQuit(application);
        }
    }

    private void onQuit(Application application) throws IOException, URISyntaxException, FontFormatException {
        application.setState(new MainMenuState(new MainMenu(), application.getImageLoader()));
    }

    private boolean isGameOver() {
        return getModel().getLives().isEmpty();
    }

    private void transitionToGameOver(Application application) throws IOException, URISyntaxException, FontFormatException {
        boolean isHighScore = HighScore.loadHighScore() < getModel().getRawScore();
        GameOver gameOver = new GameOver(getModel().getScore(), isHighScore);
        if (isHighScore) {
            HighScore.saveHighScore(getModel().getRawScore());
        }
        GameOverState gameOverState = new GameOverState(gameOver, application.getImageLoader());
        application.setState(gameOverState);
    }
}
