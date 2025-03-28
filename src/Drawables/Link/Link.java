package Drawables.Link;

import Drawables.Drawable;

import java.awt.*;

abstract public class Link implements Drawable {
    Point startPos;
    Point endPos;

    public Link(){};
    public Link(Point start, Point end) {
        this.startPos = new Point(start);
        this.endPos = new Point(end);
    }

    public void setStart(Point start) {
        startPos.setLocation(start);
    }

    public void setEnd(Point end) {
        endPos.setLocation(end);
    }
}
