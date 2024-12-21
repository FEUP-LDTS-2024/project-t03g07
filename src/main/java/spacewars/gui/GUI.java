package spacewars.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;
import spacewars.model.Position;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface GUI {
    Screen getScreen();

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    void drawPixel(double x, double y, TextColor.RGB color);

    void drawRectangle(double x, double y, int width, int height, TextColor color);

    void drawText(Position position, String text, String color);

    ACTION getNextAction() throws IOException;

    enum ACTION {UP, DOWN, RIGHT, LEFT, NONE, QUIT, SELECT, SHOOT}
}
