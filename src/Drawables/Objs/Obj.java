package Drawables.Objs;

import Drawables.Drawable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

abstract public class Obj implements Drawable {
    boolean selected = false;
    Point pos;
    int width = 50;
    int height = 50;
    List<Port> ports = new ArrayList<>();

    public Obj(int x, int y){
        pos = new Point(x,y);
    }

    public boolean contain(Point point) {
        return (pos.x <= point.x && point.x <= pos.x + width &&
                pos.y <= point.y && point.y <= pos.y + height);
    }

    public Port findNearestPort(Point p) {
        Port nearestPos = ports.get(0);
        for (Port port : ports) {
            if (p.distance(port.getCenterPos()) < p.distance(nearestPos.getCenterPos())) {
                nearestPos = port;
            }
        }

        return nearestPos;
    }

    public void select() {
        selected = true;
    }

    public void deselect() {
        selected = false;
    }

    public Point getPos() {
        return pos.getLocation();
    }

    public Point getDimension() {
        return new Point(width, height);
    }

    @Override
    public void draw(Graphics g) {
        if(selected) {
            for (Port port : ports) {
                port.draw(g);
            }
        }
    }
}