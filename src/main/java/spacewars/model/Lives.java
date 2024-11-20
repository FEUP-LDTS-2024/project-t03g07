package spacewars.model;

public class Lives {
    private int lives;

    public Lives(int lives) {
        this.lives = lives;
    }

    public void decreaseLives() {
        this.lives--;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}
