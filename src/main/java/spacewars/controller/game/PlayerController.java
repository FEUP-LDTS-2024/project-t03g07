package spacewars.controller.game;

import spacewars.Application;
import spacewars.gui.GUI;
import spacewars.model.Position;
import spacewars.model.game.Game;
import spacewars.model.game.elements.Player;
import spacewars.model.game.elements.bullets.BulletPlayer;
import spacewars.view.game.elements.PlayerViewer;

import java.io.IOException;

public class PlayerController {
    private final Player player;

    public PlayerController(Player player) {
        this.player = player;
    }

    public void moveHeroLeft() {
        moveHero(player.getPosition().getLeft(player.getSpeed()));
    }

    public void moveHeroRight() {
        moveHero(player.getPosition().getRight(player.getSpeed()));
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