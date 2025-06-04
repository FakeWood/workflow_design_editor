package Drawables.Obj;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CompObj extends Obj {

    List<Obj> children = new ArrayList<>();

    public CompObj() {
    }

    @Override
    public void adoptChildren(List<Obj> selectedObjs) {
        children.addAll(selectedObjs);
        for (Obj child : children) {
            child.setParent(this);
        }
    }

    @Override
    public void abandonChildren() {
        for (Obj child : children) {
            child.setParent(null);
        }
        children.clear();
    }

    void updateBound() {
        if (children.isEmpty()) return;
        Point objPos = children.get(0).getPos();
        Dimension objWH = children.get(0).getDimension();
        Point minPos = new Point(objPos);
        Point maxPos = new Point(minPos.x + objWH.width, minPos.y + objWH.height);
        for (Obj obj : children) {
            objPos.setLocation(obj.getPos());
            objWH.setSize(obj.getDimension());

            minPos.setLocation(Math.min(minPos.x, objPos.x), Math.min(minPos.y, objPos.y));
            maxPos.setLocation(Math.max(maxPos.x, objPos.x + objWH.width), Math.max(maxPos.y, objPos.y + objWH.height));
        }
        this.pos.setLocation(minPos);
        this.width = maxPos.x - minPos.x;
        this.height = maxPos.y - minPos.y;
    }

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
        for (Obj child : children) {
            child.move(dx, dy);
        }
    }

    @Override
    public void draw(Graphics g) {  // Does not draw objs to maintain the layer order
        updateBound();  //TODO: 需要的時候再 call
        if (this.selected) {
            g.setColor(Color.BLUE);
            g.drawRect(this.pos.x, this.pos.y, this.width, this.height);
        }
    }
}
