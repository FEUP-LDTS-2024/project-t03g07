package spacewars.model.menu;

import spacewars.model.Position;

import java.util.Arrays;
import java.util.List;

public class HowToPlayMenu extends Menu {
    private final String title;
    private final String subtitle;
    private String arrowText;


    public HowToPlayMenu() {
        title = "HOW TO PLAY";
        subtitle = "Points";
        arrowText = "move left and right";
    }

    @Override
    protected List<Entry> createEntries() {
        Position pos = new Position(15,75);
        Entry goBack = new Entry(pos, Entry.TYPE.RETURN_TO_MENU);
        return Arrays.asList(goBack);
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getArrowText() {
        return arrowText;
    }
}
