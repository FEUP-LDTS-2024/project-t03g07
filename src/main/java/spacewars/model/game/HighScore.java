package spacewars.model.game;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HighScore {
    private static final String home = System.getProperty("user.home");
    static String FILE_PATH = home + "/spacewars/highscores.txt";

    public static void saveHighScore(int highScore) {
        File file = new File(FILE_PATH);
        file.getParentFile().mkdirs();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            writer.write(String.valueOf(highScore));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int loadHighScore() {
        int highScore = 0;
        File file = new File(FILE_PATH);
        file.getParentFile().mkdirs();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                highScore = Integer.parseInt(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return highScore;
    }
}
