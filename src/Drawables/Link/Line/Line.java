package Drawables.Link.Line;

import Drawables.Obj.Port;

import java.awt.*;

abstract public class Line {
    Port fromPort = null;
    Point toPos = new Point();  // used only when endPort is null (mouse dragging)

    public Line() {}

    /**
     * Set from which port the Line is connected. Call update() to apply to graph.
     */
    public void setFrom(Port from) {
        fromPort = from;
    }

    /**
     * Set to which point the Line connect. It's for mouse dragging.  Call update() to apply to graph.
     */
    public void setTo(Point to) {
        toPos = to.getLocation();
    }

    abstract public void draw(Graphics g);
}
