package spacewars.model.game.elements.invaders;

public class NormalInvader3 extends Invader
{
    private final int points = 40;

    public NormalInvader3(int x, int y) {
        super(x, y);
    }

    @Override
    public int getPoints()
    {
        return points;
    }
}
