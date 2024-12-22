package spacewars.model.game;

public class Score {
    private int score;

    public Score() {
        this.score = 0;
    }

    public void increaseScore(int points) {
        this.score += points;
    }

    public String getScore() {
        return String.format("%05d", this.score); // Format for display
    }

    public int getRawScore() {
        return this.score; // Return as integer if needed
    }
}