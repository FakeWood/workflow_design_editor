package Drawables.Obj.ShapeObj;

import Drawables.Obj.Port;

import java.awt.*;

public class Rect extends ShapeObj {

    public Rect(int x, int y) {
        super(x, y);
        width = 80;
        height = 100;
        ports.add(new Port(x, y));
        ports.add(new Port(x + width/2, y));
        ports.add(new Port(x + width, y));
        ports.add(new Port(x, y + height/2));
        ports.add(new Port(x + width, y + height/2));
        ports.add(new Port(x, y + height));
        ports.add(new Port(x + width/2, y + height));
        ports.add(new Port(x + width, y + height));
        label.setCenterPos(pos.x + width / 2, pos.y + height / 2);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.darkGray);
        g.fillRect(pos.x, pos.y, width, height);
        g.drawRect(pos.x, pos.y, width, height);
        super.draw(g);
    }
}
