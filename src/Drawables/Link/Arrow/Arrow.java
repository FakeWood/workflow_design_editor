package Drawables.Link.Arrow;

import Drawables.Objs.Port;

import java.awt.*;

abstract public class Arrow {
    Port fromPort = null;
    Port toPort = null;
    Point toPos = new Point();  // used only when endPort is null (mouse dragging)

    public Arrow() {}

    /**
     * Set from which port the Arrow connect. Call update() to apply to graph.
     */
    public void setFrom(Port from) {
        fromPort = from;
    }

    /**
     * Set to which port the Arrow connect.  Call update() to apply to graph.
     */
    public void setTo(Port to) {
        toPort = to;
    }

    /**
     * Set to which point the Arrow connect. It's for mouse dragging.  Call update() to apply to graph.
     */
    public void setTo(Point to) {
        toPos = to.getLocation();
        toPort = null;
    }

    /**
     * return where a Link should connect to this Arrow
     * @return a new Point
     */
    abstract public Point linkPoint();

    /**
     * Update Arrow's look
     */
    abstract public void update();

    abstract public void draw(Graphics g);
}
