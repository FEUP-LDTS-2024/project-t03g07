package com.t03g07.projeto_ldts;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        try {
            TerminalSize terminalSize = new TerminalSize(1280, 720);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            terminalFactory.setForceAWTOverSwing(true);
            TerminalScreen screen = terminalFactory.createScreen();
            AWTTerminalFrame terminal = (AWTTerminalFrame) screen.getTerminal();
            terminal.setTitle("Space Wars");

            terminal.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    try {
                        screen.stopScreen();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    terminal.dispose();
                }
            });

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
