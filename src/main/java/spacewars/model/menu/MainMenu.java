package spacewars.model.menu;

import spacewars.model.Position;

import java.util.Arrays;
import java.util.List;

public class MainMenu extends Menu {

    @Override
    protected List<Entry> createEntries() {
        Position pos_play = new Position(10,10);
        Position pos_howToPlay = new Position(10,15);
        Position pos_credits = new Position(10,20);
        Position pos_quit = new Position(10,25);

        Entry play = new Entry(pos_play,Entry.TYPE.PLAY);
        Entry howToPlay = new Entry(pos_howToPlay, Entry.TYPE.HOW_TO_PLAY);
        Entry credits = new Entry(pos_credits, Entry.TYPE.CREDITS);
        Entry quit = new Entry(pos_quit, Entry.TYPE.QUIT);

        return Arrays.asList(play,howToPlay,credits,quit);
    }
}
