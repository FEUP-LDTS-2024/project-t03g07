package spacewars.view.menu;

import com.googlecode.lanterna.TextColor;
import spacewars.gui.GUI;
import spacewars.model.Position;
import spacewars.model.menu.CreditsMenu;
import spacewars.model.menu.Entry;
import spacewars.model.menu.HowToPlayMenu;
import spacewars.states.HowToPlayMenuState;
import spacewars.view.*;
import spacewars.view.images.Image;
import spacewars.view.screens.ScreenViewer;

import java.io.IOException;
import java.util.List;

public class HowToPlayMenuViewer extends ScreenViewer<HowToPlayMenu> {
    private final EntryViewer entryViewer;
    private final TextViewer textViewer;
    private final EmpireFighterViewer empireFighterViewer;
    private final ArrowsViewer arrowsViewer;
    private final SpacebarViewer spacebarViewer;

    public static final TextColor unselectedColor = new TextColor.RGB(255,255,255); //white
    public static final TextColor selectedColor = new TextColor.RGB(255,195,0);     //yellow
    public static final TextColor backgroundColor = new TextColor.RGB(0, 10, 32);   //dark blue
    private static final TextColor titleColor = new TextColor.RGB(255,195,0);     //yellow
    private static final TextColor textColor = new TextColor.RGB(255,255,255); //white

    public HowToPlayMenuViewer(HowToPlayMenu model, ViewerProvider viewerProvider) {
        super(model);
        this.entryViewer = viewerProvider.getEntryViewer();
        this.textViewer = viewerProvider.getTextViewer();
        this.empireFighterViewer = viewerProvider.getEmpireFighterViewer();
        this.arrowsViewer = viewerProvider.getArrowsViewer();
        this.spacebarViewer = viewerProvider.getSpacebarViewer();
        //this.logoViewer = viewerProvider.getLogoViewer();
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawBackground(gui, backgroundColor);
        drawEntries(gui, getModel().getEntries());
        drawTitle(gui);
        drawSubtitle(gui);
        drawArrowsandText(gui);
        drawSpacebarandText(gui);
//        drawSpaceShips(gui);
//        drawPoints(gui);
        gui.refresh();
    }

    private void drawSpacebarandText(GUI gui) throws IOException {
        spacebarViewer.draw(gui,100,125);
    }

    private void drawArrowsandText(GUI gui) throws IOException {
        arrowsViewer.draw(gui, 50, 70);
        Position pos = new Position(95,70);
        textViewer.draw(getModel().getArrowText(), pos.getX(),pos.getY(),textColor,gui);
    }

    private void drawSubtitle(GUI gui) {
        Position pos = new Position(240,40);
        textViewer.draw(getModel().getSubtitle(), pos.getX(),pos.getY(),titleColor,gui);
    }

    private void drawTitle(GUI gui) {
        Position pos = new Position(147,40);
        textViewer.draw(getModel().getTitle(), pos.getX(),pos.getY(),titleColor,gui);
    }

    private void drawEntries(GUI gui, List<Entry> entries) {
        for (Entry entry: entries)
            entryViewer.draw(entry, gui, getModel().getCurrentEntry() == entry ? selectedColor : unselectedColor);
    }
}
