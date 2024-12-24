package spacewars.view.screens.menus;

import com.googlecode.lanterna.TextColor;
import spacewars.gui.GUI;
import spacewars.model.menu.Entry;
import spacewars.model.menu.Menu;
import spacewars.view.ViewerProvider;
import spacewars.view.menus.EntryViewer;
import spacewars.view.menus.main_menu.LogoViewer;
import spacewars.view.screens.ScreenViewer;

import java.io.IOException;
import java.util.List;

public class MenuViewer<T extends Menu> extends ScreenViewer<T> {
    private final EntryViewer entryViewer;

    public static final TextColor unselectedColor = new TextColor.RGB(255, 255, 255); //white
    public static final TextColor selectedColor = new TextColor.RGB(255, 195, 0);     //yellow
    public static final TextColor backgroundColor = new TextColor.RGB(0, 10, 32);   //dark blue

    public MenuViewer(T model, ViewerProvider viewerProvider) {
        super(model);

        this.entryViewer = viewerProvider.getEntryViewer();
    }

    protected void drawEntries(GUI gui, List<Entry> entries) {
        for (Entry entry : entries)
            entryViewer.draw(entry, gui, getModel().getCurrentEntry() == entry ? selectedColor : unselectedColor);
    }

    @Override
    public void draw(GUI gui) throws IOException {
    }
}
