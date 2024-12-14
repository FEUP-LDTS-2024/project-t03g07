package spacewars.model.game.elements;

import spacewars.model.game.Lives;
import spacewars.model.game.elements.bullets.BulletPlayer;

public class Player extends Element {
    private Lives lives;

    public Player(int x, int y) {
        super(x, y);
        this.lives = new Lives(3);
    }

    public void decreaseLives() {
    }

    public Lives getLives() {
        return lives;
    }

    public void setLives(Lives lives) {
        this.lives = lives;
    }

    public BulletPlayer shoot() {
        return new BulletPlayer(this.getPosition().getX(), this.getPosition().getY() + 1);
    }

    @Override
    public void update() {
    }
}
