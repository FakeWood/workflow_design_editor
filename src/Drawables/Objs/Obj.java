package Drawables.Objs;

import Drawables.Drawable;

import java.awt.*;

abstract public class Obj implements Drawable {
    boolean selected = false;
    Point pos = new Point();
    int width = 50;
    int height = 50;

    public Obj(){}

    public Obj(int x, int y){
        pos.setLocation(x,y);
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

    public Point getDimension() {
        return new Point(width, height);
    }

    public void move(int dx, int dy) {
        pos.translate(dx, dy);
    }
}