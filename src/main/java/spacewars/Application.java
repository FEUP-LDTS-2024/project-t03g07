package spacewars;

import spacewars.gui.LanternaFrame;
import spacewars.model.game.elements.Player;
import spacewars.view.game.GameViewer;
import spacewars.view.game.PlayerViewer;

import java.io.IOException;

public class Application {
    private final LanternaFrame lanternaFrame;
    private final GameViewer gameViewer;
    private final Player player;
    private final PlayerViewer playerViewer;
    private boolean running;

    public Application() throws IOException {
        lanternaFrame = new LanternaFrame("Space Wars");
        gameViewer = new GameViewer(lanternaFrame);
        player = new Player(10, 10);
        playerViewer = new PlayerViewer("millennium_falcon.png");
        running = true;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Application app = new Application();
        app.run();
    }

    public void run() throws InterruptedException, IOException {
        int FPS = 30;
        double frameTime = (double) 1000000000 / FPS;
        long lastTime = System.nanoTime();
        int frames = 0;

        lanternaFrame.startScreen();

        while (running) {
            long startTime = System.nanoTime();

            // Check if screen is closed
            if (!lanternaFrame.isRunning()) {
                running = false;
                break;
            }

            gameViewer.draw();

            playerViewer.drawEntity(lanternaFrame, player);

            lanternaFrame.refresh();

            //update here

            frames++;
            long elapsedTime = System.nanoTime() - startTime;
            long sleepTime = (long)frameTime - elapsedTime;

            if (sleepTime > 0) Thread.sleep(sleepTime);

            if (System.nanoTime() - lastTime >= 1000000000) {    // each second
                System.out.println("FPS: " + frames);
                frames = 0;
                lastTime = System.nanoTime();
            }
        }

        lanternaFrame.close();
    }
}
