package spacewars.controller.game;

import spacewars.model.Position;
import spacewars.model.game.elements.Player;

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

    protected Position applyCollisions(Position position) {
        int x = player.getPosition().getX();
        int y = player.getPosition().getY();

        int vx = player.getSpeed();

        // Check collisions for horizontal movement
        while (vx < 0 && player.getGame().collidesLeft(new Position(x + vx, y), player.getPlayerSize())) {
            vx = Math.min(vx + 1, 0);
        }

        while (vx > 0 && player.getGame().collidesRight(new Position(x + vx, y), player.getPlayerSize())) {
            vx = Math.max(vx - 1, 0);
        }
        return new Position(x + vx, y);
    }

    /*public void shoot() {
        BulletPlayer bullet = getModel().getPlayer().shoot();
        getModel().addPlayerBullet(bullet);
    }*/
}