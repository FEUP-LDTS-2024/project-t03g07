package spacewars.model.game.elements;

import spacewars.model.game.elements.bullets.BulletPlayer;

public class Player extends Element {
    private int speed;

    public Player(int x, int y) {
        super(x, y);
        this.speed = 2;
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
}
