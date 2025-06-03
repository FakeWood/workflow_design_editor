package Drawables.Link.Line;

import java.awt.*;

public class SolidLine extends Line {

    public SolidLine() {
    }

    @Override
    public void draw(Graphics g) {
        Point fromPos = fromPort.getCenterPos();
        g.drawLine(fromPos.x, fromPos.y, toPos.x, toPos.y);
    }
}
