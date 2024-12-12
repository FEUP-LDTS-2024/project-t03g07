package spacewars.model.menu;

import spacewars.model.Position;

import java.util.Arrays;
import java.util.List;

public class CreditsMenu extends Menu{
    @Override
    protected List<Entry> createEntries() {
        Position pos = new Position(10,75);
        Entry goBack = new Entry(pos, Entry.TYPE.RETURN_TO_MENU);
        return Arrays.asList(goBack);
    }
}
