package spacewars.model.game;

public class Score {
    private int score;

    public Score() {
        this.score = 0;
    }

    public void increaseScore(int points) {
        this.score += points;
    }

    public void resetScore() {
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void checkScore() {
        if (score > HighScore.getHighScore()) {
            HighScore.saveHighScore(score);
        }
    }
}
