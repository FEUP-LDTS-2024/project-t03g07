package spacewars.model.game.elements.invaders;

import spacewars.model.game.Game;

public class Invader3 extends Invader {
    private int speed;
    private int invader3Size;
    private Game game;

    public Invader3(int x, int y, Game game)
    {
        super(x, y);
        this.invader3Size = 16;
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

    public int getInvader3Size() {
        return invader3Size;
    }

    public Game getGame() {
        return game;
    }
}
