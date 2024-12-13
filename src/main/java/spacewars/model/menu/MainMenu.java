package spacewars.model.menu;

import spacewars.model.Position;

import java.util.Arrays;
import java.util.List;

public class MainMenu extends Menu {

    @Override
    protected List<Entry> createEntries() {
        //x pos are centered according to the screen width (do not change!)
        Position pos_play = new Position(153,130);
        Position pos_howToPlay = new Position(139,138);
        Position pos_credits = new Position(147,146);
        Position pos_quit = new Position(153,154);

        Entry play = new Entry(pos_play,Entry.TYPE.PLAY);
        Entry howToPlay = new Entry(pos_howToPlay, Entry.TYPE.HOW_TO_PLAY);
        Entry credits = new Entry(pos_credits, Entry.TYPE.CREDITS);
        Entry quit = new Entry(pos_quit, Entry.TYPE.QUIT);

        return Arrays.asList(play,howToPlay,credits,quit);
    }
}
