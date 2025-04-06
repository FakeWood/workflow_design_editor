package Drawables;

import java.awt.*;

public class RectBound implements Drawable {
    Point startPos = new Point();
    Point endPos = new Point();

    public void setStartPos(Point startPos) {
        this.startPos.setLocation(startPos);
    }

    public void setEndPos(Point endPos) {
        this.endPos.setLocation(endPos);
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(startPos.x, startPos.y, endPos.x - startPos.x, endPos.y - startPos.y);
    }

}
