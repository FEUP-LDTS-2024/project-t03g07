package spacewars.states;

import spacewars.Application;
import spacewars.controller.Controller;
import spacewars.gui.GUI;
import spacewars.view.ViewerProvider;
import spacewars.view.images.ImageLoader;
import spacewars.view.screens.ScreenViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final ScreenViewer<T> screenViewer;

    public State(T model, ImageLoader imageLoader) throws IOException, URISyntaxException {
        this.model = model;
        this.controller = getController();
        this.screenViewer = getScreenViewer(new ViewerProvider(imageLoader));
    }

    public T getModel() {
        return model;
    }

    protected abstract ScreenViewer<T> getScreenViewer(ViewerProvider viewerProvider);

    protected abstract Controller<T> getController();

    public void step(Application application, GUI gui, long time) throws IOException, FontFormatException, URISyntaxException {
        GUI.ACTION action = gui.getNextAction();
        controller.step(application, action, time);
        screenViewer.draw(gui);
    }
}
