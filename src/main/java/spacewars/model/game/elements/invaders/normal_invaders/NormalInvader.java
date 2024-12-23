package spacewars.model.game.elements.invaders.normal_invaders;

import spacewars.model.game.Game;
import spacewars.model.game.elements.invaders.Invader;

public abstract class NormalInvader extends Invader {
    private double speed;
    private final Game game;

    public NormalInvader(double x, double y, Game game) {
        super(x, y);
        this.speed = 1.0;
        this.game = game;
    }

    public double getSpeed() {
        return speed;
    }

    public Game getGame() {
        return game;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
