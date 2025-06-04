package Drawables.Objs;

import Drawables.Drawable;

import java.awt.*;
import java.util.List;

abstract public class Obj implements Drawable {
    protected boolean selected = false;
    protected Point pos = new Point();  // Top Left
    protected int width = 50;
    protected int height = 50;
    protected CompObj parent = null;  // need to know if an obj is in a group or not to avoid repeatedly move when dragging

    public Obj(){}

    public Obj(int x, int y){
        pos.setLocation(x,y);
    }

    public void setParent(CompObj compObj) {
        this.parent = compObj;
    }

    public CompObj getParent() {
        return parent;
    }

    public boolean contain(Point point) {
        return (pos.x <= point.x && point.x <= pos.x + width &&
                pos.y <= point.y && point.y <= pos.y + height);
    }

    public void select() {
        selected = true;
    }

    public void deselect() {
        selected = false;
    }

    public boolean isSelected() {
        return selected;
    }

    public Point getPos() {
        return pos.getLocation();
    }

    public Dimension getDimension() {
        return new Dimension(width, height);
    }

    public void move(int dx, int dy) {
        pos.translate(dx, dy);
    }

    public void adoptChildren(List<Obj> selectedObjs){}  // only used by CompObj but percolating up for polymorphism
    public void abandonChildren(){}  // only used by CompObj but percolating up for polymorphism
}