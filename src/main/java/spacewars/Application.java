package spacewars;

import spacewars.gui.LanternaFrame;
import spacewars.model.game.elements.Player;
import spacewars.view.game.GameViewer;
import spacewars.view.game.PlayerViewer;

import java.io.IOException;

public class Application {
    private LanternaFrame lanternaFrame;
    private GameViewer gameViewer;
    private Player player;
    private PlayerViewer playerViewer;
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
        int frameTime = 1000 / FPS;
        long lastTime = System.currentTimeMillis();
        int frames = 0;

        lanternaFrame.startScreen();

        while (running) {
            long startTime = System.currentTimeMillis();

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
            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            if (sleepTime > 0) Thread.sleep(sleepTime);

            if (System.currentTimeMillis() - lastTime >= 1000) {    // each second
                System.out.println("FPS: " + frames);
                frames = 0;
                lastTime = System.currentTimeMillis();
            }
        }

        lanternaFrame.close();
    }
}
