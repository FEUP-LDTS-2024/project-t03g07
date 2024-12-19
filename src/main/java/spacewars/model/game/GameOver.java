package spacewars.model.game;


public class GameOver {
    private String GameOverMessage;
    private String finalScore;

    public GameOver() {
        GameOverMessage = "GameOver";
        finalScore = "Your final score is: " + finalScore;

    }

    public String getGameOverMessage() {
        return GameOverMessage;
    }

    public void setGameOver(String GameOver) {
        this.GameOverMessage = GameOver;
    }

    public String getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(String details) {
        this.finalScore = finalScore;
    }
}
