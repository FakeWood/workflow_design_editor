package Shapes;

import java.awt.*;

abstract public class Shape{
    protected Point startPos;

    public Shape(){};

    public Shape(int x, int y){
        this.startPos = new Point(x,y);
    }

    public void moveShape(int x, int y) {
        startPos.setLocation(x, y);
    }

    abstract public void draw(Graphics g);
}
