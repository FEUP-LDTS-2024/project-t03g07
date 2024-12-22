package spacewars.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.model.Position;
import spacewars.model.menu.Entry;
import spacewars.model.menu.Menu;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuTest {
    private Menu menu;
    private List<Entry> entryList;

    @BeforeEach
    public void setup() {
        this.menu = new Menu() {
            @Override
            protected List<Entry> createEntries() {
                Position pos = new Position(0, 0);
                Entry a = new Entry(pos, Entry.TYPE.PLAY);
                Entry b = new Entry(pos, Entry.TYPE.HOW_TO_PLAY);
                Entry c = new Entry(pos, Entry.TYPE.CREDITS);
                Entry d = new Entry(pos, Entry.TYPE.QUIT);
                Entry e = new Entry(pos, Entry.TYPE.RETURN_TO_MENU);
                Entry f = new Entry(pos, Entry.TYPE.PLAY_AGAIN);

                return Arrays.asList(a, b, c, d, e, f);
            }
        };

        this.entryList = menu.getEntries();
    }

    @Test
    public void menuTestEntries() {
        assertEquals(6, menu.getNumberEntries());
        assertEquals(entryList, menu.getEntries());

        assertEquals(entryList.get(0), menu.getCurrentEntry());

        menu.nextEntry();

        assertEquals(entryList.get(1), menu.getCurrentEntry());

        menu.previousEntry();

        assertEquals(entryList.get(0), menu.getCurrentEntry());
    }
}
