package Drawables.Link.Arrow;

import java.awt.*;

public class ClassicArrow extends Arrow {
    //      .
    //     /|\
    //    / | \
    //      |

    int length = 20;
    double openAngle = Math.PI / 3;

    Point left = new Point();
    Point right = new Point();

    public ClassicArrow() {}

    @Override
    public Point linkPoint() {
        return new Point((toPort == null) ? this.toPos : toPort.getCenterPos());
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
    }

    @Override
    public void draw(Graphics g) {
        Point toPos = (toPort == null) ? this.toPos : toPort.getCenterPos();
        g.drawLine(toPos.x, toPos.y, left.x, left.y);
        g.drawLine(toPos.x, toPos.y, right.x, right.y);
    }
}
