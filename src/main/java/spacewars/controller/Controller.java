package spacewars.controller;

import spacewars.Application;
import spacewars.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Application application, GUI.ACTION action, long time) throws IOException, FontFormatException, URISyntaxException;
}
