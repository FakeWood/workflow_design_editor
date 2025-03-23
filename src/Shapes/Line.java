package Shapes;

import java.awt.*;

public class Line extends Shape {
    Point endPos;

    public Line(int x1, int y1, int x2, int y2) {
        super(x1,y1);
        this.endPos = new Point(x2, y2);
    }

    @Override
    public void moveShape(int x, int y) {
        endPos.setLocation(x, y);
    }

    @Override
    public void draw(Graphics g){};
}
