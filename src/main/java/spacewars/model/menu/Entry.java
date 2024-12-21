package spacewars.model.menu;

import spacewars.model.Position;

public class Entry {
    public enum TYPE { PLAY, HOW_TO_PLAY, CREDITS, QUIT, RETURN_TO_MENU, PLAY_AGAIN }

    private final Position position;
    private final TYPE type;

    public Entry(Position position, TYPE type) {
        this.position = position;
        this.type = type;
    }

    public Position getPosition() {
        return position;
    }

    public TYPE getType() {
        return type;
    }

}
