package spacewars.model.game.elements.bullets;

import spacewars.model.Position;

public class BulletBossInvader extends Bullet {

    public BulletBossInvader(double x, double y) {
        super(x, y, 2);
    }

    @Override
    public void update() {
        this.setPosition(new Position(this.getPosition().x(), this.getPosition().y() + getSpeed()));
    }

}
