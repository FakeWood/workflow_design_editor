package Drawables.Link;

import Drawables.Objs.Port;

import java.awt.*;

public class AssLink extends Link{

    Point arrowPos1 = new Point();
    Point arrowPos2 = new Point();
    int arrowLength = 20;
    double arrowAngle = Math.PI / 5;

    public AssLink() {}

    void updateArrow() {
        double angle = Math.atan2(startPos.y - endPos.y, startPos.x - endPos.x);
        arrowPos1.x = endPos.x + (int)(arrowLength * Math.cos(angle + arrowAngle));
        arrowPos1.y = endPos.y + (int)(arrowLength * Math.sin(angle + arrowAngle));
        arrowPos2.x = endPos.x + (int)(arrowLength * Math.cos(angle - arrowAngle));
        arrowPos2.y = endPos.y + (int)(arrowLength * Math.sin(angle - arrowAngle));
    }

    public void setStart(Port port) {
        startPort = port;
    }

    public void setEnd(Point end) {
        endPos.setLocation(end);
        updateArrow();
    }

    public void setEnd(Port end) {
        endPort = end;
        updatePorts();
    }

    @Override
    public void updatePorts() {
        if (startPort != null) {
            startPos.setLocation(startPort.getCenterPos());
        }
        if (endPort != null) {
            endPos.setLocation(endPort.getCenterPos());
        }
        updateArrow();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(startPos.x, startPos.y, endPos.x, endPos.y);
        g.drawLine(endPos.x, endPos.y, arrowPos1.x, arrowPos1.y);
        g.drawLine(endPos.x, endPos.y, arrowPos2.x, arrowPos2.y);
    }
}
