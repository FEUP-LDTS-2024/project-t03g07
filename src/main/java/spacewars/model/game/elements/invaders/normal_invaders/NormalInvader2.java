package spacewars.model.game.elements.invaders.normal_invaders;

import spacewars.model.game.Game;

public class NormalInvader2 extends NormalInvader {
    private final int points;

    public NormalInvader2(int x, int y, Game game) {
        super(x, y, game);
        this.points = 20;
    }

    @Override
    public int getPoints() {
        return points;
    }

}
