package spacewars.gui;

import spacewars.model.Position;

import java.io.IOException;

public interface GUI {
    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    void drawPlayer(Position position) throws IOException;

    void drawInvader(Position position);

    void drawBullet(Position position) throws IOException;

    void drawText(Position position, String text, String color);

    ACTION getNextAction() throws IOException;

    enum ACTION {UP, DOWN, RIGHT, LEFT, NONE, QUIT, SELECT}
}
