package Drawables.Obj;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import Drawables.Link.Link;


public class Port extends Obj {
    int width = 10;
    int height = 10;
    List<Link> linkFromThis = new ArrayList<>();
    List<Link> linkToThis = new ArrayList<>();

    public Port(int x, int y) {
        super(x, y);  // pos 表示的不像 Obj 是指左上角，而是中心點
    }

    public void addLinkFrom(Link link) {
        linkFromThis.add(link);
    }

    public void addLinkTo(Link link) {
        linkToThis.add(link);
    }

    public Point getCenterPos() {
        return pos.getLocation();
    }

    // 因為 pos 表示的不像 Obj 是指左上角，而是中心點，所以算法不一樣
    @Override
    public boolean contain(Point point) {
        return (pos.x - width/2 <= point.x && point.x <= pos.x + width/2 &&
                pos.y - height/2 <= point.y && point.y <= pos.y + height/2);
    }

    @Override
    public void select() {
        super.select();
        for (Link link : linkToThis) {
            link.select();
        }
        for (Link link : linkFromThis) {
            link.select();
        }
    }

    @Override
    public void deselect() {
        super.deselect();
        for (Link link : linkToThis) {
            link.deselect();
        }
        for (Link link : linkFromThis) {
            link.deselect();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(pos.x - width/2, pos.y - height/2, width, height);  // pos is center pos in Port
    }
}
