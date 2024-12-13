package spacewars.controller;

import spacewars.Application;
import spacewars.model.game.Game;
import spacewars.gui.GUI;

import java.awt.*;
import java.io.IOException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Application application, GUI.ACTION action, long time) throws IOException, FontFormatException;
}
