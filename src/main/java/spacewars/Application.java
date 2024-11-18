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
}
