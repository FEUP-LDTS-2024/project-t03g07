package spacewars.view.screens.menus;

import com.googlecode.lanterna.TextColor;
import spacewars.gui.GUI;
import spacewars.model.Position;
import spacewars.model.menu.CreditsMenu;
import spacewars.model.menu.Entry;
import spacewars.view.texts.TextViewer;
import spacewars.view.ViewerProvider;
import spacewars.view.menus.EntryViewer;
import spacewars.view.screens.ScreenViewer;

import java.io.IOException;
import java.util.List;

import static spacewars.view.texts.AppTextViewer.getCharHeight;

public class CreditsMenuViewer extends ScreenViewer<CreditsMenu> {
    private final EntryViewer entryViewer;
    private final TextViewer textViewer;

    public static final TextColor unselectedColor = new TextColor.RGB(255, 255, 255); //white
    public static final TextColor selectedColor = new TextColor.RGB(255, 195, 0);     //yellow
    public static final TextColor backgroundColor = new TextColor.RGB(0, 10, 32);   //dark blue
    private static final TextColor nameColor = new TextColor.RGB(255, 255, 255);      //white
    private static final TextColor detailsColor = new TextColor.RGB(255, 255, 255);   //white
    private static final TextColor titleColor = new TextColor.RGB(255, 195, 0);       //yellow

    public CreditsMenuViewer(CreditsMenu model, ViewerProvider viewerProvider) {
        super(model);

        this.entryViewer = viewerProvider.getEntryViewer();
        this.textViewer = viewerProvider.getTextViewer();
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();

        drawBackground(gui, backgroundColor);
        drawEntries(gui, getModel().getEntries());
        drawTitle(gui);
        drawDetails(gui);
        drawNames(gui);

        gui.refresh();
    }

    private void drawEntries(GUI gui, List<Entry> entries) {
        for (Entry entry : entries)
            entryViewer.draw(entry, gui, getModel().getCurrentEntry() == entry ? selectedColor : unselectedColor);
    }

    private void drawTitle(GUI gui) {
        Position pos = new Position(147, 40);
        textViewer.draw(getModel().getTitle(), pos.x(), pos.y(), titleColor, gui);
    }

    private void drawDetails(GUI gui) {
        Position pos = new Position(95, 70);
        textViewer.draw(getModel().getDetails(), pos.x(), pos.y(), detailsColor, gui);
    }

    private void drawNames(GUI gui) {
        int xAlignment = 95;
        int yAlignment = 90;
        int spacing = getCharHeight() * 2;
        for (int idx = 0; idx < getModel().getNames().length; idx++) {
            textViewer.draw(getModel().getNames()[idx],
                    xAlignment,
                    yAlignment + spacing * idx,
                    nameColor, gui);
        }
    }
}
