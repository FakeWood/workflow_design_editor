package Drawables.Objs;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CompObj extends Obj{

    List<Obj> objs = new ArrayList<>();

    public CompObj(List<Obj> selectedObjs) {
        objs.addAll(selectedObjs);
    }

    void updateBound() {
        if(objs.isEmpty()) return;
        Point objPos = objs.get(0).getPos();
        Point objWH = objs.get(0).getDimension();
        Point minPos = new Point(objPos);
        Point maxPos = new Point(minPos.x + objWH.x, minPos.y + objWH.y);
        for (Obj obj : objs) {
            objPos.setLocation(obj.getPos());
            objWH.setLocation(obj.getDimension());

            minPos.setLocation(Math.min(minPos.x, objPos.x), Math.min(minPos.y, objPos.y));
            maxPos.setLocation(Math.max(maxPos.x, objPos.x + objWH.x), Math.max(maxPos.y, objPos.y + objWH.y));
        }
        this.pos.setLocation(minPos);
        this.width = maxPos.x - minPos.x;
        this.height = maxPos.y - minPos.y;
    }

    @Override
    public void select() {
        super.select();
        for (Obj obj : objs) {
            obj.select();
        }
    }

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
        for (Obj obj : objs) {
            obj.move(dx, dy);
        }
    }

    @Override
    public void draw(Graphics g) {  // Does not draw objs to maintain the layer order
        updateBound();
        if (this.selected) {
            g.setColor(Color.BLUE);
            g.drawRect(this.pos.x, this.pos.y, this.width, this.height);
        }
    }
}
