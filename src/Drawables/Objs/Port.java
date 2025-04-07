package Drawables.Objs;

import Drawables.Drawable;

import java.awt.*;

public class Port implements Drawable {
    public enum Side {
        TOP, LEFT, RIGHT, BOTTOM
    }

    Point centerPos;
    int width = 10;
    int height = 10;
    Side side;

    public Port(int x, int y, Side side) {
        centerPos = new Point(x, y);
        this.side = side;
    }

    public Point getCenterPos() {
        return centerPos.getLocation();
    }

    public Side getSide() {
        return side;
    }

    public void move(int dx, int dy) {
        centerPos.translate(dx, dy);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(centerPos.x - width/2, centerPos.y - height/2, width, height);
    }
}
