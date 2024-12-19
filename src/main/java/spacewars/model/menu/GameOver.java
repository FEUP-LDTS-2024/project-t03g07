package spacewars.model.menu;


import spacewars.model.Position;

import java.util.Arrays;
import java.util.List;

public class GameOver extends Menu {
    private String GameOverMessage;
    private final String finalScore;

    public GameOver(String finalScore) {
        GameOverMessage = "GameOver";
        this.finalScore = finalScore;
    }

    public String getGameOverMessage() {
        return GameOverMessage;
    }

    public void setGameOver(String GameOver) {
        this.GameOverMessage = GameOver;
    }

    public String getFinalScoreMessage() {
        return "Your final score is: " + finalScore;
    }

    @Override
    protected List<Entry> createEntries() {
        Position pos = new Position(130,154);
        Entry goBack = new Entry(pos, Entry.TYPE.RETURN_TO_MENU);
        Position pos2 = new Position(138,165);
        Entry playAgain = new Entry(pos2, Entry.TYPE.PLAY_AGAIN);
        return Arrays.asList(goBack,playAgain);
    }
}
