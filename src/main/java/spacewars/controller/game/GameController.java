package spacewars.controller.game;

import spacewars.Application;
import spacewars.controller.Controller;
import spacewars.gui.GUI;
import spacewars.model.game.Game;
import spacewars.model.menu.MainMenu;
import spacewars.states.MainMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;


public class GameController extends Controller<Game> {
    private final PlayerController playerController;
    private final Invader1Controller invader1Controller;
    private final Invader2Controller invader2Controller;
    private final Invader3Controller invader3Controller;
    private long lastMoveTime; // Track the last time the invaders moved
    private static final long MOVE_INTERVAL = 500; // Time in milliseconds between invader movements


    public GameController(Game game) {
        super(game);
        this.playerController = new PlayerController(getModel().getPlayer());
        this.invader1Controller = new Invader1Controller(getModel().getInvaders1());
        this.invader2Controller = new Invader2Controller(getModel().getInvaders2());
        this.invader3Controller = new Invader3Controller(getModel().getInvaders3());
        this.lastMoveTime = 0;
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException, FontFormatException, URISyntaxException {
        switch (action) {
            case LEFT:
                playerController.moveHeroLeft();
                break;
            case RIGHT:
                playerController.moveHeroRight();
                break;
            case SHOOT:
                playerController.shoot();
                break;
            case QUIT:
                onQuit(application);
                break;
        }
        getModel().updatePlayerBullets();
        // Move invaders at regular intervals
        if (time - lastMoveTime > MOVE_INTERVAL) {
            invader1Controller.moveInvaders1();
            invader2Controller.moveInvaders2();
            invader3Controller.moveInvaders3();
            lastMoveTime = time;
        }
    }

    private void onQuit(Application application) throws IOException, URISyntaxException, FontFormatException {
        application.setState(new MainMenuState(new MainMenu(), application.getImageLoader()));
    }
}
