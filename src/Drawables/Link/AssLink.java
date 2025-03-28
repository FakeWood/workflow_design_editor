package Drawables.Link;

import java.awt.*;

public class AssLink extends Link{

    Point arrowPos1;
    Point arrowPos2;
    int arrowLength = 20;
    double arrowAngle = Math.PI / 5;

    public AssLink(Point start, Point end) {
        super(start, end);
        arrowPos1 = new Point(end);
        arrowPos2 = new Point(end);
    }

    void updateArrow() {
        double angle = Math.atan2(startPos.y - endPos.y, startPos.x - endPos.x);
        arrowPos1.x = endPos.x + (int)(arrowLength * Math.cos(angle + arrowAngle));
        arrowPos1.y = endPos.y + (int)(arrowLength * Math.sin(angle + arrowAngle));
        arrowPos2.x = endPos.x + (int)(arrowLength * Math.cos(angle - arrowAngle));
        arrowPos2.y = endPos.y + (int)(arrowLength * Math.sin(angle - arrowAngle));
    }

    @Override
    public void draw(Graphics g) {
        updateArrow();
        g.setColor(Color.BLACK);
        g.drawLine(startPos.x, startPos.y, endPos.x, endPos.y);
        g.drawLine(endPos.x, endPos.y, arrowPos1.x, arrowPos1.y);
        g.drawLine(endPos.x, endPos.y, arrowPos2.x, arrowPos2.y);
    }
}
