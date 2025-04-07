package Drawables.Link;

import Drawables.Drawable;
import Drawables.Objs.Port;

import java.awt.*;

abstract public class Link implements Drawable {
    Point startPos = new Point();
    Point endPos = new Point();
    Port startPort;
    Port endPort;

    public Link(){}
    abstract public void updatePorts();
}
