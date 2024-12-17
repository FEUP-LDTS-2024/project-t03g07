package spacewars.controller.game;

import spacewars.model.Position;
import spacewars.model.game.elements.Player;
import spacewars.model.game.elements.bullets.BulletPlayer;

public class PlayerController {
    private final Player player;
    private static final int MAX_BULLETS = 5;
    private static final long SHOOT_DELAY = 1000; // 1 seconds
    private static final long BULLET_DELAY = 75; // 0.075 seconds

    public PlayerController(Player player) {
        this.player = player;
    }

    public void moveHeroLeft() {
        player.setSpeed(-Math.abs(player.getSpeed())); // Set speed to negative
        Position newPosition = player.getPosition().getLeft(Math.abs(player.getSpeed()));
        player.setPosition(applyCollisions(newPosition));
    }

    public void moveHeroRight() {
        player.setSpeed(Math.abs(player.getSpeed())); // Set speed to positive
        Position newPosition = player.getPosition().getRight(player.getSpeed());
        player.setPosition(applyCollisions(newPosition));
    }

//    private void moveHero(Position position) {
//        player.setPosition(position);
//
//        // if (getModel().isBullet(position)) getModel().getPlayer().decreaseLives();
//    }

    protected Position applyCollisions(Position position) {
        double x = player.getPosition().getX();
        double y = player.getPosition().getY();

        int s = player.getSpeed();

        // Check collisions for horizontal movement
        while (s < 0 && player.getGame().collidesLeft(new Position(x + s, y), player.getPlayerSize())) {
            s++;
        }

        while (s > 0 && player.getGame().collidesRight(new Position(x + s, y), player.getPlayerSize())) {
            s--;
        }
        return new Position(x + s, y);
    }

    public void shoot() {
        long currentTime = System.currentTimeMillis();
        if ((player.getBulletCount() < MAX_BULLETS && (currentTime - player.getLastShootTime() >= BULLET_DELAY)) ||
                (currentTime - player.getLastShootTime() >= SHOOT_DELAY)) {
            if (player.getBulletCount() >= MAX_BULLETS) {
                player.resetBulletCount();
            }
            BulletPlayer bullet = player.shoot();
            player.getGame().addPlayerBullet(bullet);
        }
    }
}