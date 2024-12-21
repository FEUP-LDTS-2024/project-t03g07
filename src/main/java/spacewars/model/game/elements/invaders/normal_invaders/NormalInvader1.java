package spacewars.model.game.elements.invaders.normal_invaders;

import spacewars.model.game.Game;

public class NormalInvader1 extends NormalInvader {
    private final int points;

    public NormalInvader1(int x, int y, Game game) {
        super(x, y, game);
        this.points = 10;
    }

    @Override
    public int getPoints() {
        return points;
    }
}
