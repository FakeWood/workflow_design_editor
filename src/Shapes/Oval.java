package Shapes;

import java.awt.*;

public class Oval extends Shape{

    public Oval(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.fillOval(startPos.x, startPos.y, 50, 50);
    }
}
