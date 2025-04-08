package Drawables.Objs;

import Drawables.ObjLabel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShapeObj extends Obj{
    ObjLabel label = new ObjLabel();
    List<Port> ports = new ArrayList<>();

    public ShapeObj(int x, int y) {
        super(x, y);
    }

    public Port findNearestPort(Point p) {
        Port nearestPos = ports.get(0);
        for (Port port : ports) {
            if (p.distance(port.getCenterPos()) < p.distance(nearestPos.getCenterPos())) {
                nearestPos = port;
            }
        }

        return nearestPos;
    }

    public ObjLabel.LabelInfo getLabel() {
        return label.getLabelInfo();
    }

    public void setLabel(ObjLabel.LabelInfo info) {
        label.setLabelInfo(info);
    }

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
        label.setCenterPos(pos.x + width / 2, pos.y + height / 2);
        for (Port port : ports) {
            port.move(dx, dy);
        }
    }

    @Override
    public void draw(Graphics g) {
        label.draw(g);
        if (selected) {
            for (Port port : ports) {
                port.draw(g);
            }
        }
    }
}
