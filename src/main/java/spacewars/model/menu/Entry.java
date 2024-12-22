package spacewars.model.menu;

import spacewars.model.Position;

public record Entry(Position position, spacewars.model.menu.Entry.TYPE type) {
    public enum TYPE {PLAY, HOW_TO_PLAY, CREDITS, QUIT, RETURN_TO_MENU, PLAY_AGAIN}
}
