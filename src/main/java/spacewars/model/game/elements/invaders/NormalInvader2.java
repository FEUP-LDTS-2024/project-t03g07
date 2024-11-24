package spacewars.model.game.elements.invaders;

public class NormalInvader2 extends Invader
{
    private final int points = 20;

    public NormalInvader2(int x, int y) {
        super(x, y);
    }

    @Override
    public int getPoints()
    {
        return points;
    }
}
