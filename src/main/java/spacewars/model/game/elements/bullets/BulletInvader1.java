package spacewars.model.game.elements.bullets;

import spacewars.model.Position;

public class BulletNormalInvader extends Bullet
{
    private static final int SPEED = 1;

    public BulletNormalInvader(double x, double y)
    {
        super(x, y, 10);
    }

    @Override
    public void update() {
        setPosition(new Position(getPosition().getX(), getPosition().getY() + SPEED));setPosition(new Position(getPosition().getX(), getPosition().getY() - SPEED));
    }
}
