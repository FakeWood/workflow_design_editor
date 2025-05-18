package Drawables.Link;

import Drawables.Objs.Port;

import java.awt.*;

public class GeneralizationLink extends Link{
    Point biasStart = new Point();
    Point biasEnd = new Point();
    int biasLength = 10;
    Point midPos1 = new Point();
    Point midPos2 = new Point();
    Point arrowPosRight = new Point();
    Point arrowPosLeft = new Point();
    Point arrowPosBottom = new Point();
    int arrowLength = 20;
    double arrowAngle = Math.PI / 6;

    public GeneralizationLink() {}

    void updateArrow(Port.Side side) {
        double angle = switch (side) {
            case TOP -> (Math.PI / 2) * 3;
            case LEFT -> (Math.PI / 2) * 2;
            case BOTTOM -> (Math.PI / 2) * 1;
            case RIGHT ->  (Math.PI / 2) * 0;
        };
        arrowPosRight.x = endPos.x + (int)(arrowLength * Math.cos(angle + arrowAngle));
        arrowPosRight.y = endPos.y + (int)(arrowLength * Math.sin(angle + arrowAngle));
        arrowPosLeft.x = endPos.x + (int)(arrowLength * Math.cos(angle - arrowAngle));
        arrowPosLeft.y = endPos.y + (int)(arrowLength * Math.sin(angle - arrowAngle));

        double middleLength = arrowLength * Math.cos(arrowAngle);
        arrowPosBottom.x = endPos.x + (int)(middleLength * Math.cos(angle));
        arrowPosBottom.y = endPos.y + (int)(middleLength * Math.sin(angle));
    }

    public void setStart(Port port) {
        startPort = port;
        updatePorts();
    }

    public void setEnd(Point point) {
        endPos.setLocation(point);
        Port.Side side = point.x > biasStart.x ? Port.Side.LEFT : Port.Side.RIGHT;
        updateArrow(side);
        biasEnd.setLocation(arrowPosBottom);

        // 終點都水平就先走水平
        midPos1.setLocation((biasEnd.x + biasStart.x) / 2, biasStart.y);
        midPos2.setLocation((biasEnd.x + biasStart.x) / 2, biasEnd.y);
    }

    public void setEnd(Port port) {
        endPort = port;
        updatePorts();
    }

    @Override
    public void updatePorts() {
        if (startPort != null) {
            startPos.setLocation(startPort.getCenterPos());
            biasStart.setLocation(startPos);
            switch (startPort.getSide()) {
                case TOP: biasStart.y -= biasLength; break;
                case LEFT: biasStart.x -= biasLength; break;
                case RIGHT: biasStart.x += biasLength; break;
                case BOTTOM: biasStart.y += biasLength; break;
            }
        }

        if (endPort != null) {
            endPos.setLocation(endPort.getCenterPos());
            updateArrow(endPort.getSide());
            biasEnd.setLocation(arrowPosBottom);
            switch (endPort.getSide()) {
                case TOP: biasEnd.y -= biasLength; break;
                case LEFT: biasEnd.x -= biasLength; break;
                case RIGHT: biasEnd.x += biasLength; break;
                case BOTTOM: biasEnd.y += biasLength; break;
            }

            // 終點垂直逆向則先走水平，反之亦然
            if (endPort.getSide() == Port.Side.TOP && startPos.y > endPos.y ||
                    endPort.getSide() == Port.Side.BOTTOM && startPos.y < endPos.y ) {
                midPos1.setLocation((biasEnd.x + biasStart.x) / 2, biasStart.y);
                midPos2.setLocation((biasEnd.x + biasStart.x) / 2, biasEnd.y);
            } else {
                midPos1.setLocation(biasStart.x, (biasEnd.y + biasStart.y) / 2);
                midPos2.setLocation(biasEnd.x, (biasEnd.y + biasStart.y) / 2);
            }

            // TODO: 起點路徑重疊待解決
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(selected? Color.BLUE : Color.BLACK);
        g.drawLine(startPos.x, startPos.y, biasStart.x, biasStart.y);
        g.drawLine(biasStart.x, biasStart.y, midPos1.x, midPos1.y);
        g.drawLine(midPos1.x, midPos1.y, midPos2.x, midPos2.y);
        g.drawLine(midPos2.x, midPos2.y, biasEnd.x, biasEnd.y);
        g.drawLine(biasEnd.x, biasEnd.y, arrowPosBottom.x, arrowPosBottom.y);
        g.drawLine(endPos.x, endPos.y, arrowPosRight.x, arrowPosRight.y);
        g.drawLine(endPos.x, endPos.y, arrowPosLeft.x, arrowPosLeft.y);
        g.drawLine(arrowPosLeft.x, arrowPosLeft.y, arrowPosRight.x, arrowPosRight.y);
    }
}
