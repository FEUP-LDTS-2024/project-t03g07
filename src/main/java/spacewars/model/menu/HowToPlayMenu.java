package spacewars.model.menu;

import java.util.Arrays;
import java.util.List;

public class HowToPlayMenu extends Menu {

    @Override
    protected List<String> createEntries() {
        return Arrays.asList("return to menu");
    }
}
