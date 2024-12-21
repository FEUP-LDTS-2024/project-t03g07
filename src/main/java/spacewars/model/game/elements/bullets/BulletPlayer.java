package spacewars.model.game.elements.bullets;

import spacewars.model.Position;

public class BulletPlayer extends Bullet
{
    private static final int SPEED = 5;

    public BulletPlayer(double x, double y)
    {
        super(x, y, 30);
    }

    @Override
    public void update() {
        setPosition(new Position(getPosition().x(), getPosition().y() - SPEED));
    }
}
