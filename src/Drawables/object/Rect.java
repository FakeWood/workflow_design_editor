package Drawables.object;

import java.awt.*;

public class Rect extends Object {

    public Rect(int x, int y) {
        super(x, y);
        ports.add(new Port(x, y));
        ports.add(new Port(x + width/2, y));
        ports.add(new Port(x + width, y));
        ports.add(new Port(x, y + height/2));
        ports.add(new Port(x + width, y + height/2));
        ports.add(new Port(x, y + height));
        ports.add(new Port(x + width/2, y + height));
        ports.add(new Port(x + width, y + height));
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.darkGray);
        g.fillRect(pos.x, pos.y, width, height);
        if (selected) {
            for (Port port : ports) {
                port.draw(g);
            }
        }
    }
}
