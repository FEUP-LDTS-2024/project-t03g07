package spacewars;

import spacewars.gui.LanternaFrame;
import spacewars.model.game.Game;
import spacewars.model.game.elements.Player;
import spacewars.view.game.GameViewer;
import spacewars.view.game.PlayerViewer;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        LanternaFrame lanternaFrame = new LanternaFrame("Space Wars");
        lanternaFrame.startScreen();

        new GameViewer(new Game(1280, 720), lanternaFrame);

        Player player = new Player(10, 10);

        PlayerViewer playerViewer = new PlayerViewer("millennium_falcon.png");

        playerViewer.drawPlayer(lanternaFrame, player);
        
        lanternaFrame.refresh();
    }

    private void run() throws InterruptedException {
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

            if (sleepTime > 0) Thread.sleep(sleepTime);

            if (System.currentTimeMillis() - lastTime >= 1000) {    //each second
                System.out.println("FPS: " + frames);
                frames = 0;
                lastTime = System.currentTimeMillis();
            }

        }
        //close game (gui probably)
    }
}
