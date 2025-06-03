package Drawables.Link.Arrow;

import java.awt.*;

public class TriangleArrow extends Arrow {
    //     / \
    //    /___\
    //      |

    int length = 20;
    double openAngle = Math.PI / 3;

    Point left = new Point();
    Point right = new Point();
    Point bottom = new Point();

    public TriangleArrow() {}

    @Override
    public Point linkPoint() {
        return bottom.getLocation();
    }

    @Override
    public void update() {
        Point fromPos = fromPort.getCenterPos();
        Point toPos = (toPort == null) ? this.toPos : toPort.getCenterPos();
        double angle = Math.atan2(fromPos.y - toPos.y, fromPos.x - toPos.x);

        left.x = toPos.x + (int) (length * Math.cos(angle + openAngle / 2));
        left.y = toPos.y + (int) (length * Math.sin(angle + openAngle / 2));
        right.x = toPos.x + (int) (length * Math.cos(angle - openAngle / 2));
        right.y = toPos.y + (int) (length * Math.sin(angle - openAngle / 2));

        double middleLength = length * Math.cos(openAngle / 2);
        bottom.x = toPos.x + (int) (middleLength * Math.cos(angle));
        bottom.y = toPos.y + (int) (middleLength * Math.sin(angle));
    }

    @Override
    public void draw(Graphics g) {
        Point toPos = (toPort == null) ? this.toPos : toPort.getCenterPos();
        g.drawLine(toPos.x, toPos.y, left.x, left.y);
        g.drawLine(toPos.x, toPos.y, right.x, right.y);
        g.drawLine(left.x, left.y, right.x, right.y);
    }
}
