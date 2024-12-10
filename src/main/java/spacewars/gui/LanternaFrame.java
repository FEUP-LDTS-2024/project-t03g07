package spacewars.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

public class LanternaFrame {
    private static final int WIDTH = 160;
    private static final int HEIGHT = 90;

    private final TerminalScreen screen;
    private final AWTTerminalFrame terminal;
    private final TextGraphics graphics;

    public LanternaFrame(String title) throws IOException, URISyntaxException, FontFormatException {
        TerminalSize terminalSize = new TerminalSize(WIDTH, HEIGHT);

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize).setForceAWTOverSwing(true);

        int fontSize = 3;
        AWTTerminalFontConfiguration fontConfig = loadFont(fontSize);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);

        this.screen = terminalFactory.createScreen();
        this.screen.setCursorPosition(null);
        this.graphics = this.screen.newTextGraphics();
        this.terminal = (AWTTerminalFrame) this.screen.getTerminal();
        this.terminal.setTitle(title);
        this.terminal.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                try {
                    screen.stopScreen();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                terminal.dispose();
                System.exit(0);
            }
        });
    }

    //constructor for testing
    public LanternaFrame(String name, TextGraphics graphics,TerminalScreen screen, AWTTerminalFrame terminal) {
        this.screen = screen;
        this.terminal = terminal;
        this.graphics = graphics;
    }

    public TerminalScreen getScreen() {
        return this.screen;
    }

    public AWTTerminalFrame getTerminal() {
        return this.terminal;
    }

    public void startScreen() throws IOException {
        this.screen.startScreen();
    }

    public void stopScreen() throws IOException {
        this.screen.stopScreen();
    }

    public static int getWIDTH() {
        return WIDTH;
    }
    public static int getHEIGHT() {
        return HEIGHT;
    }

    private AWTTerminalFontConfiguration loadFont(int fontSize) throws URISyntaxException, IOException, FontFormatException {
        URL resource = getClass().getClassLoader().getResource("square.ttf");
        File fontFile = new File(Objects.requireNonNull(resource).toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(Font.PLAIN, fontSize);
        return AWTTerminalFontConfiguration.newInstance(font);
    }
  
    public void drawPixel(int x, int y, TextColor.RGB color) {
        var graphics = this.screen.newTextGraphics();
        graphics.setBackgroundColor(color);
        graphics.putString(x, y, " "); // Use a space character to create a "pixel"
    }

    public void refresh() throws IOException {
        this.screen.refresh();
    }

    public void close()
    {
        try {
            this.screen.stopScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.terminal.dispose();
    }

    public boolean isRunning() {
        return this.terminal.isVisible();
    }
}
