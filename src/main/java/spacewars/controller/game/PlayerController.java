package spacewars.controller.game;

import spacewars.Application;
import spacewars.gui.GUI;
import spacewars.model.Position;
import spacewars.model.game.Game;
import spacewars.model.game.elements.Player;
import spacewars.model.game.elements.bullets.BulletPlayer;

import java.io.IOException;

public class PlayerController {
    private final Player player;

    public PlayerController(Player player) {
        this.player = player;
    }

    public void moveHeroLeft() {
        moveHero(player.getPosition().getLeft());
    }

    public void moveHeroRight() {
        moveHero(player.getPosition().getRight());
    }

    private void moveHero(Position position) {
        player.setPosition(position);
        // if (getModel().isBullet(position)) getModel().getPlayer().decreaseLives();
    }

    /*public void shoot() {
        BulletPlayer bullet = getModel().getPlayer().shoot();
        getModel().addPlayerBullet(bullet);
    }*/
}