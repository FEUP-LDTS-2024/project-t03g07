package spacewars.model.menu;

import spacewars.model.Position;

import java.util.List;

public class CreditsMenu extends Menu {
    private final String[] names;
    private final String title;
    private final String details;

    public CreditsMenu() {
        title = "CREDITS";
        details = "Class 3 Group 7:";

        names = new String[3];
        names[0] = "Joao Miguel Lopes";
        names[1] = "Francisca Vilares Portugal";
        names[2] = "Pedro Andre Freitas Monteiro";
    }

    @Override
    public List<Entry> createEntries() {
        Position pos = new Position(130, 154);
        Entry goBack = new Entry(pos, Entry.TYPE.RETURN_TO_MENU);
        return List.of(goBack);
    }

    public String[] getNames() {
        return names;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }
}
