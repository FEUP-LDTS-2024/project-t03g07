package spacewars;

import com.googlecode.lanterna.TextColor;
import spacewars.gui.LanternaGUI;
import spacewars.model.game.Game;
import spacewars.model.game.elements.Player;
import spacewars.view.game.GameViewer;
import spacewars.view.game.ViewerProvider;
import spacewars.view.game.elements.PlayerViewer;
import spacewars.view.images.GameImageLoader;
import spacewars.view.images.ImageLoader;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    //private final GameViewer gameViewer;
    //private final Player player;
    //private final PlayerViewer playerViewer;
    private boolean running;

    private final LanternaGUI lanternaGUI;

    public Application() throws IOException, URISyntaxException, FontFormatException {
        this.lanternaGUI = new LanternaGUI(320, 192);

        /*lanternaGUI.clear();
        Player player = new Player(10, 10);
        ViewerProvider viewerProvider = new ViewerProvider(new GameImageLoader());
        PlayerViewer playerViewer = viewerProvider.getPlayerViewer();
        playerViewer.draw(player, lanternaGUI);
        lanternaGUI.refresh();*/

        running = true;
    }

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException, FontFormatException {
        Application app = new Application();
        app.run();
    }

    /*public void setState(State state)
    {
        this.state = state;
    }*/

    public void run() throws InterruptedException, IOException {
        int FPS = 30;
        double frameTime = (double) 1000000000 / FPS;
        long lastTime = System.nanoTime();
        int frames = 0;

        lanternaGUI.startScreen();

        while (running) {
            long startTime = System.nanoTime();



            //state.step(this,lanternaGUI,startTime);

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
        lanternaGUI.close();
    }
}
