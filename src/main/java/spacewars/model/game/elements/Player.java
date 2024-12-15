package spacewars.model.game.elements;

import spacewars.model.game.elements.bullets.BulletPlayer;

public class Player extends Element {
    public Player(int x, int y) {
        super(x, y);
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
