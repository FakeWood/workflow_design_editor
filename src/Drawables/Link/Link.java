package Drawables.Link;

import Drawables.Drawable;
import Drawables.Link.Arrow.Arrow;
import Drawables.Link.Line.Line;
import Drawables.Objs.Port;

import java.awt.*;

/*
連接線，包含線與箭頭兩部分
使用 Strategy Pattern
要擴充新種類的連接線只需繼承自此類別，並指定 Arrow 與 Line 種類即可組合出新樣式
 */

public class Link implements Drawable {
    boolean selected = false;
    Arrow arrow;
    Line line;

    public void select() {
        selected = true;
    }

    public void deselect() {
        selected = false;
    }

    public Link() {
    }

    public void setStart(Port port) {
        arrow.setFrom(port);
        arrow.setTo(port.getCenterPos());
        line.setFrom(port);
        line.setTo(port.getCenterPos());
    }

    public void setEnd(Point end) {
        arrow.setTo(end);
        arrow.update();
        line.setTo(arrow.linkPoint());
    }

    public void setEnd(Port end) {
        arrow.setTo(end);
        arrow.update();
        line.setTo(arrow.linkPoint());
    }

    public void update() {
        arrow.update();
        line.setTo(arrow.linkPoint());
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(selected ? Color.BLUE : Color.BLACK);
        line.draw(g);
        arrow.draw(g);
    }
}
