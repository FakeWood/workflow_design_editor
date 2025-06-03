package Drawables.Link.Line;

import java.awt.*;

public class DashedLine extends Line {
    int lineInterval = 5;

    public DashedLine() {}

    @Override
    public void draw(Graphics g) {
        Point fromPos = fromPort.getCenterPos();
        double distance = fromPos.distance(toPos);
        double n = distance / lineInterval;  // how many dashed line fragment
        double x1, y1, x2, y2;

        for (int i=0; i < n; i++) {
            if (i % 2 != 0) {
                continue;
            }
            x1 = fromPos.x + (toPos.x - fromPos.x) * (i / n);
            y1 = fromPos.y + (toPos.y - fromPos.y) * (i / n);
            x2 = fromPos.x + (toPos.x - fromPos.x) * ((i+1) / n);
            y2 = fromPos.y + (toPos.y - fromPos.y) * ((i+1) / n);
            g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
        }
    }
}
