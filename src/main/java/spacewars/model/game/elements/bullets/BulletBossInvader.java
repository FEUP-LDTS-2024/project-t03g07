package spacewars.model.game.elements.bullets;

import spacewars.model.Position;

public class BulletBossInvader extends Bullet
{
    private static final int SPEED = 2;

    public BulletBossInvader(double x, double y)
    {
        super(x, y, 10);
    }

    @Override
    public void update() {
        this.setPosition(new Position(this.getPosition().x(), this.getPosition().y() + SPEED));
    }

}
