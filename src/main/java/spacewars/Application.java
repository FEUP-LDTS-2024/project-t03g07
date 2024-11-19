package spacewars;

import spacewars.gui.LanternaFrame;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        try {
            LanternaFrame lanternaFrame = new LanternaFrame("Space Wars");
            lanternaFrame.startScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void run() throws IOException {
        int FPS = 60;
        int frameTime = 1000 / FPS;

        while (true) {
            long startTime = System.currentTimeMillis();

            // Update game state
            // Render game state

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }

        }
        //close game (gui probably)
    }
}
