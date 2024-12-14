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

    private final ArrowsViewer arrowsViewer;
    private final SpacebarViewer spacebarViewer;

    private final EmpireFighterViewer empireFighterViewer;
    private final TIEExecutorViewer tieExecutorViewer;
    private final StarDestroyerViewer starDestroyerViewer;
    private final DeathStarViewer deathStarViewer;

    public static final TextColor unselectedColor = new TextColor.RGB(255,255,255); //white
    public static final TextColor selectedColor = new TextColor.RGB(255,195,0);     //yellow
    public static final TextColor backgroundColor = new TextColor.RGB(0, 10, 32);   //dark blue
    private static final TextColor titleColor = new TextColor.RGB(255,195,0);     //yellow
    private static final TextColor textColor = new TextColor.RGB(255,255,255); //white
    private static final TextColor enigmaColor = new TextColor.RGB(255,195,0);  //yellow

    public HowToPlayMenuViewer(HowToPlayMenu model, ViewerProvider viewerProvider) {
        super(model);
        this.entryViewer = viewerProvider.getEntryViewer();
        this.textViewer = viewerProvider.getTextViewer();

        this.arrowsViewer = viewerProvider.getArrowsViewer();
        this.spacebarViewer = viewerProvider.getSpacebarViewer();

        this.empireFighterViewer = viewerProvider.getEmpireFighterViewer();
        this.tieExecutorViewer = viewerProvider.getTIEExecutorViewer();
        this.starDestroyerViewer = viewerProvider.getStarDestroyerViewer();
        this.deathStarViewer = viewerProvider.getDeathStarViewer();

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
        drawSpaceShipsAndPoints(gui);
        gui.refresh();
    }

    private void drawSpaceShipsAndPoints(GUI gui) throws IOException {
        empireFighterViewer.draw(gui,200,70);
        Position pos_pointsInvader1 = new Position(220,70);
        textViewer.draw(getModel().getPointsInvader1(), pos_pointsInvader1.getX(), pos_pointsInvader1.getY(), textColor, gui);

        tieExecutorViewer.draw(gui,200,90);
        Position pos_pointsInvader2 = new Position(220,90);
        textViewer.draw(getModel().getPointsInvader2(), pos_pointsInvader2.getX(), pos_pointsInvader2.getY(), textColor, gui);

        starDestroyerViewer.draw(gui,200,110);
        Position pos_pointsInvader3 = new Position(220,110);
        textViewer.draw(getModel().getPointsInvader3(), pos_pointsInvader3.getX(), pos_pointsInvader3.getY(), textColor, gui);

        deathStarViewer.draw(gui,200,130);
        Position pos_pointsBoss = new Position(220,130);
        Position pos_pointsText = new Position(234,130);
        textViewer.draw(getModel().getPointsBoss(), pos_pointsBoss.getX(), pos_pointsBoss.getY(), enigmaColor, gui);
        textViewer.draw(getModel().getTextPoints(),pos_pointsText.getX(),pos_pointsText.getY(),textColor,gui);
    }

    private void drawSpacebarandText(GUI gui) throws IOException {
        spacebarViewer.draw(gui,70,120);
        Position pos = new Position(85,145);
        textViewer.draw(getModel().getSpacebarText(), pos.getX(), pos.getY(),textColor,gui);
    }

    private void drawArrowsandText(GUI gui) throws IOException {
        arrowsViewer.draw(gui, 70, 70);
        Position pos = new Position(70,95);
        textViewer.draw(getModel().getArrowText(), pos.getX(),pos.getY(),textColor,gui);
    }

    private void drawSubtitle(GUI gui) {
        Position pos = new Position(215,60);
        textViewer.draw(getModel().getSubtitle(), pos.getX(),pos.getY(),titleColor,gui);
    }

    private void drawTitle(GUI gui) {
        Position pos = new Position(139,40);
        textViewer.draw(getModel().getTitle(), pos.getX(),pos.getY(),titleColor,gui);
    }

    private void drawEntries(GUI gui, List<Entry> entries) {
        for (Entry entry: entries)
            entryViewer.draw(entry, gui, getModel().getCurrentEntry() == entry ? selectedColor : unselectedColor);
    }
}
