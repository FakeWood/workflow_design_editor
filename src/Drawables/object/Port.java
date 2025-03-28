package Drawables.object;

import Drawables.Drawable;

import java.awt.*;

public class Port implements Drawable {
    Point centerPos;
    int width = 10;
    int height = 10;

    public Port(int x, int y) {
        centerPos = new Point(x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(centerPos.x - width/2, centerPos.y - height/2, width, height);
    }
}
