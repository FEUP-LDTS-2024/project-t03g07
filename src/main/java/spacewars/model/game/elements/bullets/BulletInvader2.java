package spacewars.model.game.elements.bullets;

import spacewars.model.Position;

public class BulletInvader2 extends Bullet {

    public BulletInvader2(double x, double y) {
        super(x, y, 1);
    }

    @Override
    public void update() {
        this.setPosition(new Position(this.getPosition().x(), this.getPosition().y() + getSpeed()));
    }

}
