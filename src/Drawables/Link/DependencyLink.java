package Drawables.Link;

import Drawables.Objs.Port;

import java.awt.*;

public class DependencyLink extends Link{

    Point arrowPos1 = new Point();
    Point arrowPos2 = new Point();
    int arrowLength = 20;
    double arrowAngle = Math.PI / 5;
    int lineInterval = 5;

    public DependencyLink() {}

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
    void drawDashedLine(Graphics g) {
        double distance = startPos.distance(endPos);
        double n = distance / lineInterval;  // how many dashed line fragment
        double x1, y1, x2, y2;
        for (int i=0; i < n; i++) {
            if (i % 2 != 0) {
                continue;
            }
            x1 = startPos.x + (endPos.x - startPos.x) * (i / n);
            y1 = startPos.y + (endPos.y - startPos.y) * (i / n);
            x2 = startPos.x + (endPos.x - startPos.x) * ((i+1) / n);
            y2 = startPos.y + (endPos.y - startPos.y) * ((i+1) / n);
            g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
        }
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(selected? Color.BLUE : Color.BLACK);
        drawDashedLine(g);
        g.drawLine(endPos.x, endPos.y, arrowPos1.x, arrowPos1.y);
        g.drawLine(endPos.x, endPos.y, arrowPos2.x, arrowPos2.y);
    }
}
