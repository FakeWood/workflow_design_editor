package Drawables.object;

import java.awt.*;

public class Oval extends Object {

    public Oval(int x, int y) {
        super(x, y);
        ports.add(new Port(x + width/2, y));
        ports.add(new Port(x, y + height/2));
        ports.add(new Port(x + width, y + height/2));
        ports.add(new Port(x + width/2, y + height));
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.darkGray);
        g.fillOval(pos.x, pos.y, width, height);
        if(selected) {
            for (Port port : ports) {
                port.draw(g);
            }
        }
    }
}
