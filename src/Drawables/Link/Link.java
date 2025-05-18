package Drawables.Link;

import Drawables.Drawable;
import Drawables.Objs.Port;

import java.awt.*;

abstract public class Link implements Drawable {
    boolean selected = false;
    Point startPos = new Point();
    Point endPos = new Point();
    Port startPort;
    Port endPort;

    public void select() {
        selected = true;
    }

    public void deselect() {
        selected = false;
    }

    public Link(){}
    abstract public void updatePorts();
}
