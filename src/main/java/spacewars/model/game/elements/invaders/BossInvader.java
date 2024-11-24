package spacewars.model.game.elements.invaders;

public class BossInvader extends Invader{
    private final int points = 100;

    public BossInvader(int x, int y) {
        super(x, y);
    }

    @Override
    public int getPoints() {
        return points;
    }
}
