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

public class CreditsMenuViewer extends MenuViewer<CreditsMenu> {
    private final TextViewer textViewer;

    private static final TextColor nameColor = new TextColor.RGB(255, 255, 255);      //white
    private static final TextColor detailsColor = new TextColor.RGB(255, 255, 255);   //white
    private static final TextColor titleColor = new TextColor.RGB(255, 195, 0);       //yellow

    public CreditsMenuViewer(CreditsMenu model, ViewerProvider viewerProvider) {
        super(model, viewerProvider);

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
        int spacing = textViewer.getCharHeight() * 2;
        for (int idx = 0; idx < getModel().getNames().length; idx++) {
            textViewer.draw(getModel().getNames()[idx],
                    xAlignment,
                    yAlignment + spacing * idx,
                    nameColor, gui);
        }
    }
}
