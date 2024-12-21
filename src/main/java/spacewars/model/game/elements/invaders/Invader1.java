package spacewars.model.game.elements.invaders;

import spacewars.model.game.Game;

public class Invader1 extends Invader {
    private double speed;
    private final int invader1Size;
    private final Game game;

    public Invader1(int x, int y, Game game)
    {
        super(x, y);
        this.invader1Size = 16;
        this.game = game;
        this.speed = 1.0;
    }

    @Override
    public int getPoints()
    {
        return 10;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getInvader1Size() {
        return invader1Size;
    }

    public Game getGame() {
        return game;
    }
}
