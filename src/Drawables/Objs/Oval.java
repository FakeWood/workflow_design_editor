package Drawables.Objs;

import Drawables.ObjLabel;

import java.awt.*;

public class Oval extends Obj {
    ObjLabel label = new ObjLabel();

    public Oval(int x, int y) {
        super(x, y);
        width = 100;
        height = 80;
        ports.add(new Port(x + width/2, y, Port.Side.TOP));
        ports.add(new Port(x, y + height/2, Port.Side.LEFT));
        ports.add(new Port(x + width, y + height/2, Port.Side.RIGHT));
        ports.add(new Port(x + width/2, y + height, Port.Side.BOTTOM));
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
        label.draw(g);
        super.draw(g);
    }
}
