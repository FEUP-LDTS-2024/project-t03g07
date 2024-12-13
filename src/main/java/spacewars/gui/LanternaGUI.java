package spacewars.gui;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import spacewars.model.Position;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import static java.awt.event.KeyEvent.*;
import static java.awt.event.KeyEvent.VK_X;

public class LanternaGUI implements GUI {
    private final Screen screen;

    private static final java.util.List<Integer> SPAM_KEYS = List.of(VK_LEFT, VK_RIGHT);
    private boolean keySpam;
    private KeyEvent priorityKeyPressed;
    private final KeyAdapter keyAdapter;
    private KeyEvent keyPressed;

    /*public LanternaGUI(Screen screen) {
        this.screen = screen; this.keySpam = false;
        this.priorityKeyPressed = null;
        this.keyAdapter = createKeyAdapter();
        this.keyPressed = null;
    }*/

    public LanternaGUI(int width, int height) throws URISyntaxException, IOException, FontFormatException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        AWTTerminalFrame terminal = (AWTTerminalFrame) createTerminal(width, height, fontConfig);
        terminal.setTitle("Space Wars");
        terminal.addWindowListener(new java.awt.event.WindowAdapter() {
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
        this.screen = createScreen(terminal);
        this.keySpam = false;
        this.priorityKeyPressed = null;
        this.keyAdapter = createKeyAdapter();
        this.keyPressed = null;

        terminal.getComponent(0).addKeyListener(this.keyAdapter);
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, IOException, FontFormatException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        assert resource != null;
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 8);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        return terminalFactory.createTerminal();
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private KeyAdapter createKeyAdapter() {
        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Key pressed");
                if (keySpam && SPAM_KEYS.contains(e.getKeyCode()))
                    keyPressed = priorityKeyPressed = e;
                else
                    keyPressed = e;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (keySpam && SPAM_KEYS.contains(e.getKeyCode()))
                    keyPressed = priorityKeyPressed = null;
                else
                    keyPressed = priorityKeyPressed;
            }
        };
    }

    @Override
    public Screen getScreen() {
        return screen;
    }

    public void startScreen() throws IOException {
        screen.startScreen();
    }

    public void stopScreen() throws IOException {
        screen.stopScreen();
    }

    @Override
    public void drawPixel(int x, int y, TextColor.RGB color) {
        var graphics = this.screen.newTextGraphics();
        graphics.setBackgroundColor(color);
        graphics.putString(x, y, " "); // Use a space character to create a "pixel"
    }

    @Override
    public void drawRectangle(double x, double y, int width, int height, TextColor color) {
        if (width > 0 && height > 0) {
            TextGraphics tg = screen.newTextGraphics();
            tg.setBackgroundColor(color);
            tg.fillRectangle(new TerminalPosition((int) x, (int) y), new TerminalSize(width, height), ' ');
        }
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    @Override
    public ACTION getNextAction() throws IOException {
        if (keyPressed == null)
            return ACTION.NONE;

        int keyCode = keyPressed.getKeyCode();
        keyPressed = priorityKeyPressed;

        return switch (keyCode) {
            case VK_UP -> ACTION.UP;
            case VK_DOWN -> ACTION.DOWN;
            case VK_ESCAPE -> ACTION.QUIT;
            case VK_ENTER -> ACTION.SELECT;
            default -> ACTION.NONE;
        };
    }

    public void setKeySpam(boolean keySpam) {
        if (!keySpam)
            priorityKeyPressed = null;
        this.keySpam = keySpam;
    }

    public KeyAdapter getKeyAdapter() {
        return keyAdapter;
    }

    @Override
    public void drawImage(BufferedImage charImage, int x, int y) {
        TextGraphics tg = screen.newTextGraphics();

        for (int i = 0; i < charImage.getWidth(); i++) {
            for (int j = 0; j < charImage.getHeight(); j++) {
                int rgb = charImage.getRGB(i, j);
                int alpha = (rgb >> 24) & 0xFF;

                // Only draw non-transparent pixels
                if (alpha != 0) {
                    int red = (rgb >> 16) & 0xFF;
                    int green = (rgb >> 8) & 0xFF;
                    int blue = rgb & 0xFF;

                    // Convert RGB to hex string
                    String hexColor = String.format("#%02X%02X%02X", red, green, blue);

                    // Set color and draw a block character
                    tg.setForegroundColor(TextColor.Factory.fromString(hexColor));
                    tg.putString(x + i, y + j, "█");
                }
            }
        }
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

}