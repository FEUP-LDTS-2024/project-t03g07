package spacewars.model.game.elements.bullets;

import spacewars.model.Position;

public abstract class Bullet
{
    private Position position;
    private int speed;

    public Bullet(int x, int y, int speed)
    {
        this.position = new Position(x, y);
        this.speed = speed;
    }

    public Position getPosition()
    {
        return this.position;
    }
    public void setPosition(Position position)
    {
        this.position = position;
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
