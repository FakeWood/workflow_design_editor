package Drawables.object;

import Drawables.Drawable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

abstract public class Object implements Drawable {
    boolean selected = false;
    Point pos;
    int width = 50;
    int height = 50;
    List<Port> ports = new ArrayList<>();

    public Object(int x, int y){
        pos = new Point(x,y);
    }
}
