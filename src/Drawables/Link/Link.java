package Drawables.Link;

import Drawables.Drawable;

import java.awt.*;

abstract public class Link implements Drawable {
    Point startPos;
    Point endPos;

    public Link(int x1, int y1, int x2, int y2) {
        this.startPos = new Point(x1, y1);
        this.endPos = new Point(x2, y2);
    }
}
