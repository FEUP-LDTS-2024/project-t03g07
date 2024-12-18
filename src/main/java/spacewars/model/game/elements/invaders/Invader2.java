package spacewars.model.game.elements.invaders;

import spacewars.model.game.Game;

public class Invader2 extends Invader {
    private int speed;
    private int invader2Size;
    private Game game;

    public Invader2(int x, int y, Game game)
    {
        super(x, y);
        this.invader2Size = 16;
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

    public int getInvader2Size() {
        return invader2Size;
    }

    public Game getGame() {
        return game;
    }
}
