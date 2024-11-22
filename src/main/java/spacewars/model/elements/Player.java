package spacewars.model.elements;

import spacewars.model.Lives;

public class Player extends Entity {
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
