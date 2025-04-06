package Drawables.Objs;

import java.awt.*;

public class Oval extends Obj {

    public Oval(int x, int y) {
        super(x, y);
        ports.add(new Port(x + width/2, y, Port.Side.TOP));
        ports.add(new Port(x, y + height/2, Port.Side.LEFT));
        ports.add(new Port(x + width, y + height/2, Port.Side.RIGHT));
        ports.add(new Port(x + width/2, y + height, Port.Side.BOTTOM));
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.darkGray);
        g.fillOval(pos.x, pos.y, width, height);
        super.draw(g);
    }
}
