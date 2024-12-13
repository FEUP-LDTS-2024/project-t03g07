package spacewars.controller.game;

import spacewars.Application;
import spacewars.gui.GUI;
import spacewars.model.Position;
import spacewars.model.game.Game;
import spacewars.model.game.elements.bullets.BulletPlayer;

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

    public void shoot() {
        BulletPlayer bullet = getModel().getPlayer().shoot();
        getModel().addPlayerBullet(bullet);
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.RIGHT) moveHeroRight();
        if (action == GUI.ACTION.LEFT) moveHeroLeft();
        //if (action == GUI.ACTION.SPACE) getModel().getPlayer().shoot();
    }
}