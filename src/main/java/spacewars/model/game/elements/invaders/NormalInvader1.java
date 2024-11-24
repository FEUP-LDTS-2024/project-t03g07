package spacewars.model.game.elements.invaders;

public class NormalInvader1 extends Invader
{
    private final int points = 10;

    public NormalInvader1(int x, int y)
    {
        super(x, y);
    }

    @Override
    public int getPoints()
    {
        return points;
    }
}
