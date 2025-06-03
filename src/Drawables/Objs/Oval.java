package Drawables.Objs;

import java.awt.*;

public class Oval extends ShapeObj {
    public Oval(int x, int y) {
        super(x, y);
        width = 100;
        height = 80;
        ports.add(new Port(x + width/2, y));
        ports.add(new Port(x, y + height/2));
        ports.add(new Port(x + width, y + height/2));
        ports.add(new Port(x + width/2, y + height));
        label.setCenterPos(pos.x + width / 2, pos.y + height / 2);
    }

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
        label.setCenterPos(pos.x + width / 2, pos.y + height / 2);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.darkGray);
        g.fillOval(pos.x, pos.y, width, height);
        g.drawOval(pos.x, pos.y, width, height);
        super.draw(g);
    }
}
