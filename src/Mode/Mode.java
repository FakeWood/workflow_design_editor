package Mode;

import GUI.Canvas;

import java.awt.event.MouseAdapter;

abstract public class Mode extends MouseAdapter {
    static Canvas canvas = Canvas.getInstance();
    public void exit(){}
}
