package spacewars.model;

public class Player extends Entity {
    private int lives;

    public Player(int x, int y) {
        super(x, y);
        this.lives = 3;
    }

    public void decreaseEnergy() {
        this.lives--;
    }

    public int getEnergy() {
        return lives;
    }

    @Override
    public void update() {
    }
}
