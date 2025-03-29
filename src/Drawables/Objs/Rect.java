package Drawables.Objs;

import java.awt.*;

public class Rect extends Obj {

    public Rect(int x, int y) {
        super(x, y);
        ports.add(new Port(x, y, Port.Side.LEFT));
        ports.add(new Port(x + width/2, y, Port.Side.TOP));
        ports.add(new Port(x + width, y, Port.Side.RIGHT));
        ports.add(new Port(x, y + height/2, Port.Side.LEFT));
        ports.add(new Port(x + width, y + height/2, Port.Side.RIGHT));
        ports.add(new Port(x, y + height, Port.Side.LEFT));
        ports.add(new Port(x + width/2, y + height, Port.Side.BOTTOM));
        ports.add(new Port(x + width, y + height, Port.Side.RIGHT));
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
