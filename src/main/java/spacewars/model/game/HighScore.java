package spacewars.model.game;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HighScore {
    private static final String FILE_PATH = "highscores.txt";

    public static void saveHighScore(int highScore){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(String.valueOf(highScore));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> loadHighScores() {
        List<Integer> highScores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                highScores.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return highScores;
    }

    public static int getHighScore() {
        List<Integer> highScores = loadHighScores();
        if (highScores.isEmpty()) {
            return 0;
        }
        return highScores.get(highScores.size() - 1);
    }

    public static void clearHighScores() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
