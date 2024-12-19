package spacewars.model.game.elements.bullets;

import spacewars.model.Position;

public class BulletInvader1 extends Bullet
{
    private static final int SPEED = 1;

    public BulletInvader1(double x, double y)
    {
        super(x, y, 10);
    }

    @Override
    public void update() {
        this.setPosition(new Position(this.getPosition().getX(), this.getPosition().getY() + SPEED));
    }

}
