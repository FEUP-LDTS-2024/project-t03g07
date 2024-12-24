package spacewars.view.screens.menus;

import spacewars.gui.GUI;
import spacewars.model.menu.MainMenu;
import spacewars.view.ViewerProvider;
import spacewars.view.menus.main_menu.LogoViewer;

import java.io.IOException;

public class MainMenuViewer extends MenuViewer<MainMenu> {
    private final LogoViewer logoViewer;

    public MainMenuViewer(MainMenu model, ViewerProvider viewerProvider) {
        super(model, viewerProvider);

        this.logoViewer = viewerProvider.getLogoViewer();
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();

        drawBackground(gui, backgroundColor);
        drawEntries(gui, getModel().getEntries());
        logoViewer.draw(gui, 137, 50);

        gui.refresh();
    }
}
