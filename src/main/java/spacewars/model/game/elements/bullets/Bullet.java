package spacewars.model.game.elements.bullets;

import spacewars.model.game.elements.Element;

public abstract class Bullet extends Element {
    private int speed;

    public Bullet(int x, int y, int speed)
    {
        super(x, y);
        this.speed = speed;
    }

    public int getSpeed()
    {
        return this.speed;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
}
