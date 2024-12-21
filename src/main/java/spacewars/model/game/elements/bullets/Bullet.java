package spacewars.model.game.elements.bullets;

import spacewars.model.game.elements.Element;

public abstract class Bullet extends Element {
    private final double speed;

    public Bullet(double x, double y, double speed) {
        super(x, y);
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public abstract void update();
}
