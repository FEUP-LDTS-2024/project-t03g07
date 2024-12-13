package spacewars.model.menu;

import spacewars.model.Position;

import java.util.Arrays;
import java.util.List;

public class CreditsMenu extends Menu{
    private String[] names;
    private String title;
    private String details;

    public CreditsMenu() {
        title = "Credits";
        details = "Class 3 Group 7 Members:";

        names = new String[3];
        names[0] = "Joao Miguel Lopes";
        names[1] = "Francisca Vilares Portugal";
        names[2] = "Pedro Andre Freitas Monteiro";
    }

    @Override
    protected List<Entry> createEntries() {
        Position pos = new Position(130,154);
        Entry goBack = new Entry(pos, Entry.TYPE.RETURN_TO_MENU);
        return Arrays.asList(goBack);
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
