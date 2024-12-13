package spacewars.view.menu;

import com.googlecode.lanterna.TextColor;
import spacewars.gui.GUI;
import spacewars.model.menu.Entry;
import spacewars.model.menu.Menu;
import spacewars.view.ViewerProvider;
import spacewars.view.screens.ScreenViewer;

import java.io.IOException;
import java.util.List;

public class MainMenuViewer<T extends Menu> extends ScreenViewer<T> {
    private final EntryViewer entryViewer;

    public static final TextColor unselectedColor = new TextColor.RGB(234,234,234);
    public static final TextColor selectedColor = new TextColor.RGB(99,155,255);
    public static final TextColor backgroundColor = new TextColor.RGB(28, 28, 46);

    public MainMenuViewer(T model, ViewerProvider viewerProvider) {
        super(model);
        this.entryViewer = viewerProvider.getEntryViewer();
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawBackground(gui, backgroundColor);
        drawEntries(gui, getModel().getEntries());
        gui.refresh();
    }

    private void drawEntries(GUI gui, List<Entry> entries) {
        for (Entry entry: entries)
            entryViewer.draw(entry, gui, getModel().getCurrentEntry() == entry ? selectedColor : unselectedColor);
    }
}
