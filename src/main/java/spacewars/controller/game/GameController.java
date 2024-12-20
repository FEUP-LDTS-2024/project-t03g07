package spacewars.controller.game;

import spacewars.Application;
import spacewars.controller.Controller;
import spacewars.controller.game.elements.*;
import spacewars.controller.game.elements.invaders.BossInvaderController;
import spacewars.controller.game.elements.invaders.Invader1Controller;
import spacewars.controller.game.elements.invaders.Invader2Controller;
import spacewars.controller.game.elements.invaders.Invader3Controller;
import spacewars.gui.GUI;
import spacewars.model.game.Game;
import spacewars.model.game.HighScore;
import spacewars.model.game.elements.invaders.BossInvader;
import spacewars.model.menu.GameOver;
import spacewars.model.menu.MainMenu;
import spacewars.states.GameOverState;
import spacewars.states.MainMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;


public class GameController extends Controller<Game> {
    private final PlayerController playerController;
    private final Invader1Controller invader1Controller;
    private final Invader2Controller invader2Controller;
    private final Invader3Controller invader3Controller;
    private final BossInvaderController bossInvaderController;
    private long lastMoveTime; // Track the last time the invaders moved
    private static final long MOVE_INTERVAL = 500; // Time in milliseconds between invader movements


    public GameController(Game game) {
        super(game);
        this.playerController = new PlayerController(getModel().getPlayer());
        this.invader1Controller = new Invader1Controller(getModel().getInvaders1());
        this.invader2Controller = new Invader2Controller(getModel().getInvaders2());
        this.invader3Controller = new Invader3Controller(getModel().getInvaders3());
        this.bossInvaderController = new BossInvaderController(getModel().getBossInvader(),320);
        this.lastMoveTime = 0;
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException, FontFormatException, URISyntaxException {
        switch (action) {
            case LEFT:
                playerController.moveLeft();
                break;
            case RIGHT:
                playerController.moveRight();
                break;
            case SHOOT:
                playerController.shoot();
                break;
            case QUIT:
                onQuit(application);
                break;
        }

        getModel().updatePlayerBullet();

        // Move invaders at regular intervals
        if (time - lastMoveTime > MOVE_INTERVAL) {
            invader1Controller.moveInvaders1();
            invader2Controller.moveInvaders2();
            invader3Controller.moveInvaders3();
            lastMoveTime = time;
        }

        if (getModel().getBossInvader() != null) {
            bossInvaderController.moveBoss(time);
        }

        //invader1Controller.shoot();
        getModel().invader1Shoot();
        getModel().updateInvader1Bullet();

        getModel().invader2Shoot();
        getModel().updateInvader2Bullet();

        getModel().invader3Shoot();
        getModel().updateInvader3Bullet();

//        if (!bossInvaderController.getBossInvader().isHidden()) {
//            getModel().bossInvaderShoot(bossInvaderController.getBossInvader());
//            getModel().updateBossInvaderBullet();
//        }

        getModel().respawnInvaders();
        getModel().respawnBoss();

        if (isGameOver()){
            transitionToGameOver(application);
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
