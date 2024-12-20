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
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import static java.awt.event.KeyEvent.*;

public class LanternaGUI implements GUI {
    private final Screen screen;
    private KeyEvent keyPressed;
    private int lastMovementAction = -1;  // Store the last movement key

    public LanternaGUI(int width, int height) throws URISyntaxException, IOException, FontFormatException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        AWTTerminalFrame terminal = (AWTTerminalFrame) createTerminal(width, height, fontConfig);
        terminal.setTitle("Space Wars");
        terminal.setResizable(false);
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
        KeyAdapter keyAdapter = createKeyAdapter();
        this.keyPressed = null;

        terminal.getComponent(0).addKeyListener(keyAdapter);
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
                keyPressed = e;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == lastMovementAction) {
                    lastMovementAction = -1; //Clear last movement if the current released key was the one in effect.
                }
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

    @Override
    public void drawPixel(double x, double y, TextColor.RGB color) {
        var graphics = this.screen.newTextGraphics();
        graphics.setBackgroundColor(color);
        graphics.putString((int) x, (int) y, " "); // Use a space character to create a "pixel"
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
        tg.putString((int) position.getX(), (int) position.getY(), text);
    }

    @Override
    public ACTION getNextAction() {
        ACTION action = ACTION.NONE;       // Default action

        if (keyPressed != null) {
            int keyCode = keyPressed.getKeyCode();

            switch (keyCode) {
                case VK_UP:
                    action = ACTION.UP;
                    break;
                case VK_DOWN:
                    action = ACTION.DOWN;
                    break;
                case VK_LEFT:
                    action = ACTION.LEFT;
                    lastMovementAction = keyCode; // Record movement
                    break;
                case VK_RIGHT:
                    action = ACTION.RIGHT;
                    lastMovementAction = keyCode; // Record movement
                    break;
                case VK_SPACE:
                    action = ACTION.SHOOT; // Shoot regardless of movement
                    break;
                case VK_ESCAPE:
                    action = ACTION.QUIT;
                    break;
                case VK_ENTER:
                    action = ACTION.SELECT;
                    break;
            }

            keyPressed = null;  // Consume the key press
        } else if (lastMovementAction != -1) { // Check for held movement
            action = switch (lastMovementAction) {
                case VK_UP -> ACTION.UP;
                case VK_DOWN -> ACTION.DOWN;
                case VK_LEFT -> ACTION.LEFT;
                case VK_RIGHT -> ACTION.RIGHT;
                default -> action;
            };
        }


        return action;
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