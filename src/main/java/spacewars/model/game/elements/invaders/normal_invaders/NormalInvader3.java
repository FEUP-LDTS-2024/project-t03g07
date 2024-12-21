package spacewars.model.game.elements.invaders.normal_invaders;

import spacewars.model.game.Game;

public class NormalInvader3 extends NormalInvader {
    private int points;

    public NormalInvader3(int x, int y, Game game) {
        super(x, y, game);
        this.points = 40;
    }

    @Override
    public int getPoints() {
        return points;
    }
}
