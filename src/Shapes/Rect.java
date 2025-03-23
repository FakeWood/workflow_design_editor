package Shapes;

import java.awt.*;

public class Rect extends Shape{

    public Rect(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.fillRect(startPos.x, startPos.y, 50, 50);
    };
}
