package spacewars.model.game.elements.invaders.normal_invaders;

import spacewars.model.game.Game;
import spacewars.model.game.elements.invaders.Invader;

public abstract class NormalInvader extends Invader {
    private double speed;
    private final int invaderSize;
    private final Game game;

    public NormalInvader(double x, double y, Game game) {
        super(x, y);
        this.speed = 1.0;
        this.invaderSize = 16;
        this.game = game;
    }

    @Override
    public void update() {
    }

    public double getSpeed() {
        return speed;
    }

    public Game getGame() {
        return game;
    }

    public int getSize() {
        return invaderSize;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
