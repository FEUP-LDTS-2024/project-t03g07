package spacewars.model.game.elements.invaders;

import spacewars.model.game.Game;

public class Invader1 extends Invader {
    private int speed;
    private int invader1Size;
    private Game game;

    public Invader1(int x, int y, Game game)
    {
        super(x, y);
        this.invader1Size = 16;
        this.game = game;
    }

    @Override
    public int getPoints()
    {
        return 10;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getInvader1Size() {
        return invader1Size;
    }

    public Game getGame() {
        return game;
    }
}
