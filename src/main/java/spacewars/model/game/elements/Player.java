package spacewars.model.game.elements;

import spacewars.model.game.Lives;

public class Player extends Element {
    private Lives lives;

    public Player(int x, int y) {
        super(x, y);
        this.lives = new Lives(3);
    }

    public Lives getLives() {
        return lives;
    }

    public void setLives(Lives lives) {
        this.lives = lives;
    }

    @Override
    public void update() {
    }
}
