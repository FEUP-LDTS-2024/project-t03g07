package spacewars.model.game.elements.invaders;

import spacewars.model.game.Game;

public class Invader3 extends Invader {
    private double speed;
    private final int invader3Size;
    private final Game game;

    public Invader3(int x, int y, Game game) {
        super(x, y);
        this.invader3Size = 16;
        this.game = game;
        this.speed = 1.0;
    }

    @Override
    public int getPoints() {
        return 10;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getInvader3Size() {
        return invader3Size;
    }

    public Game getGame() {
        return game;
    }
}
