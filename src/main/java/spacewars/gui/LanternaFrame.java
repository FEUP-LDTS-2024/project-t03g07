package spacewars.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import java.io.IOException;

public class LanternaFrame {
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;

    private final TerminalScreen screen;
    private final AWTTerminalFrame terminal;

    public LanternaFrame(String title) throws IOException {
        TerminalSize terminalSize = new TerminalSize(WIDTH, HEIGHT);

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize)
                .setForceAWTOverSwing(true);

        this.screen = terminalFactory.createScreen();
        this.screen.setCursorPosition(null);
        this.terminal = (AWTTerminalFrame) this.screen.getTerminal();
        this.terminal.setTitle(title);
        this.terminal.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                try {
                    screen.stopScreen();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                terminal.dispose();
            }
        });
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
}
