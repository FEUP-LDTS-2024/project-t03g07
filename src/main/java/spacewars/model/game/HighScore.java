package spacewars.model.game;

import java.io.*;

public class HighScore {
    private static final String home = System.getProperty("user.home");
    static final String FILE_PATH = home + "/spacewars/highscores.txt";

    public static void saveHighScore(int highScore) {
        File file = new File(FILE_PATH);
        file.getParentFile().mkdirs();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Error creating high score file");
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            writer.write(String.valueOf(highScore));
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Error saving high score");
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
                throw new RuntimeException("Error creating high score file");
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                highScore = Integer.parseInt(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading high score");
        }
        return highScore;
    }

    //for testing purposes
    public static void resetHighScore() {
        File file = new File(FILE_PATH);
        file.getParentFile().mkdirs();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Error creating high score file");
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            writer.write("0");
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Error saving high score");
        }
    }
}
