package spacewars.model.game.elements.bullets;

import spacewars.model.Position;

public class BulletPlayer extends Bullet {

    public BulletPlayer(double x, double y) {
        super(x, y, 5);
    }

    @Override
    public void update() {
        setPosition(new Position(getPosition().x(), getPosition().y() - getSpeed()));
    }
}
