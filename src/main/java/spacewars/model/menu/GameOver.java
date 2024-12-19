package spacewars.model.menu;


import spacewars.model.Position;

import java.util.Arrays;
import java.util.List;

public class GameOver extends Menu {
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

    @Override
    protected List<Entry> createEntries() {
        Position pos = new Position(130,154);
        Entry goBack = new Entry(pos, Entry.TYPE.RETURN_TO_MENU);
        return Arrays.asList(goBack);
    }
}
