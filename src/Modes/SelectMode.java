package Modes;

import Drawables.Objs.Obj;
import Drawables.RectBound;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class SelectMode extends Mode{
    List<Obj> selectedObjs = new ArrayList<>();
    Point startPos = new Point();
    Point endPos = new Point();
    RectBound range = new RectBound();

    @Override
    public void mousePressed(MouseEvent e) {
        selectedObjs.clear();
        canvas.selectObjs(selectedObjs);
        startPos.setLocation(e.getPoint());

        range.setStartPos(startPos);
        range.setEndPos(startPos);

        canvas.addDrawable(range);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endPos.setLocation(e.getPoint());

        // click
        if (endPos.equals(startPos)) {
            selectedObjs.add(canvas.findObjHovered(e.getPoint(), false));
        // drag
        } else {
            selectedObjs = canvas.findObjCovered(startPos, endPos);
        }

        canvas.selectObjs(selectedObjs);
        canvas.removeDrawable(range);
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        Point minPos = new Point(Math.min(startPos.x, e.getX()), Math.min(startPos.y, e.getY()));
        Point maxPos = new Point(Math.max(startPos.x, e.getX()), Math.max(startPos.y, e.getY()));

        range.setStartPos(minPos);
        range.setEndPos(maxPos);

        canvas.repaint();
    }

    @Override
    public void exit() {
        super.exit();
        selectedObjs.clear();
        canvas.selectObjs(selectedObjs);
    }
}
