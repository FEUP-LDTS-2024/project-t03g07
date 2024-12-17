package spacewars.model.game.elements;

import spacewars.model.game.Game;
import spacewars.model.game.elements.bullets.BulletPlayer;

public class Player extends Element {
    private int speed;
    private final int playerSize;
    private Game game;

    public Player(int x, int y, Game game) {
        super(x, y);
        this.speed = 2;
        this.playerSize = 10;
        this.game = game;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void decreaseLives() {
    }

    public BulletPlayer shoot() {
        return new BulletPlayer(this.getPosition().getX(), this.getPosition().getY() + 1);
    }

    @Override
    public void update() {
    }

    public int getPlayerSize() {
        return playerSize;
    }

    public Game getGame() {
        return game;
    }
}
