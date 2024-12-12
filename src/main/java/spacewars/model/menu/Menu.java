package spacewars.model.menu;

import java.util.Arrays;
import java.util.List;

public abstract class Menu {
    private final List<Entry> entries;
    private int currentEntry = 0;

    public Menu() {
        this.entries = createEntries();
    }

    protected abstract List<Entry> createEntries();

    public int getNumberEntries() {
        return this.entries.size();
    }

    public void nextEntry() {   //move Down
        currentEntry++;
        currentEntry = currentEntry % getNumberEntries();
    }

    public void previousEntry() {   //move Up
        currentEntry += getNumberEntries() - 1;
        currentEntry = currentEntry % getNumberEntries();
    }

    public String getCurrentEntry() {
        return entries.get(currentEntry);
    }
}
