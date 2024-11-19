package spacewars;

import spacewars.gui.LanternaFrame;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        try {
            LanternaFrame lanternaFrame = new LanternaFrame("Space Wars");
            lanternaFrame.startScreen();

            //app.run(); -> when close method is implemented
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void run() throws IOException {
        int FPS = 60;
        int frameTime = 1000 / FPS;
        long lastTime = System.currentTimeMillis();
        int frames = 0;

        while (true) {
            long startTime = System.currentTimeMillis();

            // Update game state
            // Render game state

            frames++;
            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
            
            if (System.currentTimeMillis() - lastTime >= 1000) {    //each second
                System.out.println("FPS: " + frames);
                frames = 0;
                lastTime = System.currentTimeMillis();
            }

        }
        //close game (gui probably)
    }
}
