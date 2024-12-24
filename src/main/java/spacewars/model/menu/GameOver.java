package spacewars.model.menu;

import spacewars.model.Position;

import java.util.Arrays;
import java.util.List;

public class GameOver extends Menu {
    private final String finalScore;
    private final boolean isNewHighScore;
    private final String newHighScoreMessage;

    public GameOver(String finalScore, boolean newHighScore) {
        this.finalScore = finalScore;
        this.isNewHighScore = newHighScore;
        this.newHighScoreMessage = "NEW HIGH SCORE!";
    }

    @Override
    public List<Entry> createEntries() {
        Position pos = new Position(130, 165);
        Entry goBack = new Entry(pos, Entry.TYPE.RETURN_TO_MENU);
        Position pos2 = new Position(138, 154);
        Entry playAgain = new Entry(pos2, Entry.TYPE.PLAY_AGAIN);
        return Arrays.asList(playAgain, goBack);
    }

    public String getFinalScoreMessage() {
        return "Your final score is: " + finalScore;
    }

    public boolean isNewHighScore() {
        return isNewHighScore;
    }

    public String getNewHighScoreMessage() {
        return newHighScoreMessage;
    }

}
