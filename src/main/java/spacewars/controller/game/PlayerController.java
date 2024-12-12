package spacewars.controller.game;

import spacewars.Application;
import spacewars.gui.GUI;
import spacewars.model.Position;
import spacewars.model.game.Game;

import java.io.IOException;

public class PlayerController extends GameController {
    public PlayerController(Game game) {
        super(game);
    }

    public void moveHeroLeft() {
        moveHero(getModel().getPlayer().getPosition().getLeft());
    }

    public void moveHeroRight() {
        moveHero(getModel().getPlayer().getPosition().getRight());
    }

    private void moveHero(Position position) {
        getModel().getPlayer().setPosition(position);
        if (getModel().isBullet(position)) getModel().getPlayer().decreaseLives();
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.RIGHT) moveHeroRight();
        if (action == GUI.ACTION.LEFT) moveHeroLeft();
    }
}