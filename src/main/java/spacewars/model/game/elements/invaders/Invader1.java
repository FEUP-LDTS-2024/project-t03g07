package spacewars.model.game.elements.invaders;

public class Invader1 extends Invader
{

    public Invader1(int x, int y)
    {
        super(x, y);
    }

    @Override
    public int getPoints()
    {
        return 10;
    }
}
