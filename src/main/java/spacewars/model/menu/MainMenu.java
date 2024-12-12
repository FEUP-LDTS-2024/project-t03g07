package spacewars.model.menu;

import java.util.Arrays;
import java.util.List;

public class MainMenu extends Menu {

    @Override
    protected List<String> createEntries() {
        return Arrays.asList("play", "how to play", "credits", "quit");
    }
}
