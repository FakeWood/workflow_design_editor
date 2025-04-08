package Drawables.Objs;

import Drawables.ObjLabel;

import java.awt.*;

public class Rect extends Obj {
    ObjLabel label = new ObjLabel();

    public Rect(int x, int y) {
        super(x, y);
        width = 80;
        height = 100;
        ports.add(new Port(x, y, Port.Side.LEFT));
        ports.add(new Port(x + width/2, y, Port.Side.TOP));
        ports.add(new Port(x + width, y, Port.Side.RIGHT));
        ports.add(new Port(x, y + height/2, Port.Side.LEFT));
        ports.add(new Port(x + width, y + height/2, Port.Side.RIGHT));
        ports.add(new Port(x, y + height, Port.Side.LEFT));
        ports.add(new Port(x + width/2, y + height, Port.Side.BOTTOM));
        ports.add(new Port(x + width, y + height, Port.Side.RIGHT));
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
        g.fillRect(pos.x, pos.y, width, height);
        label.draw(g);
        super.draw(g);
    }
}
