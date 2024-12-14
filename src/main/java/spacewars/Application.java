package spacewars;

import spacewars.gui.LanternaGUI;
import spacewars.model.menu.MainMenu;
import spacewars.states.MainMenuState;
import spacewars.states.State;
import spacewars.view.images.AppImageLoader;
import spacewars.view.images.ImageLoader;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    private final LanternaGUI gui;
    private final ImageLoader imageLoader;
    private State<?> state;

    public Application() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(320, 192);
        this.imageLoader = new AppImageLoader();
        this.state = new MainMenuState(new MainMenu(), imageLoader);

        /*lanternaGUI.clear();
        Player player = new Player(10, 10);
        ViewerProvider viewerProvider = new ViewerProvider(new GameImageLoader());
        PlayerViewer playerViewer = viewerProvider.getPlayerViewer();
        playerViewer.draw(player, lanternaGUI);
        lanternaGUI.refresh();*/
    }

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException, FontFormatException {
        Application app = new Application();
        app.run();
    }

    public void setState(State<?> state)
    {
        this.state = state;
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    public void run() throws InterruptedException, IOException, FontFormatException, URISyntaxException {
        int FPS = 30;
        double frameTime = 1_000_000_000.0 / FPS;
        long lastTime = System.nanoTime();
        int frames = 0;

        gui.startScreen();

        while (this.state != null) {
            long startTime = System.nanoTime();

            state.step(this, gui, startTime);

            frames++;
            long elapsedTime = System.nanoTime() - startTime;
            long sleepTime = (long) frameTime - elapsedTime;

            if (sleepTime > 0) {
                Thread.sleep(sleepTime / 1_000_000, (int) (sleepTime % 1_000_000));
            }
            
            while (System.nanoTime() - startTime < frameTime) {}
            
            if (System.nanoTime() - lastTime >= 1_000_000_000) {
                System.out.println("FPS: " + frames);
                frames = 0;
                lastTime = System.nanoTime();
            }
        }

        gui.close();
    }

}
