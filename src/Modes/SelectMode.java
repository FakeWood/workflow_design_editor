package Modes;

import Drawables.Obj.Obj;
import Drawables.Obj.ShapeObj.ShapeObj;
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
    boolean onObj = false;

    @Override
    public void mousePressed(MouseEvent e) {
        // deselect Port
        if (onObj && selectedObjs.get(0) instanceof ShapeObj) {
            ((ShapeObj) selectedObjs.get(0)).deselectPorts();
        }
        // deselect Objs
        selectedObjs.clear();
        startPos.setLocation(e.getPoint());
        Obj pressedObj = canvas.findObjHovered(e.getPoint());

        // click on nothing, then draw select box
        if (pressedObj == null) {
            onObj = false;

            range.setStartPos(startPos);
            range.setEndPos(startPos);
            canvas.addDrawable(range);
        }
        // click on obj, then move
        else {
            onObj = true;
            selectedObjs.add(pressedObj);
            canvas.selectObjs(selectedObjs);
            // select the port pressed
            if(pressedObj instanceof ShapeObj) {
                ((ShapeObj) pressedObj).selectPort(e.getPoint());
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endPos.setLocation(e.getPoint());

        // clicked on obj
        if(onObj){
            selectedObjs.get(0).move(e.getX() - startPos.x, e.getY() - startPos.y);
            canvas.updateLinks();
            onObj = false;
        // clicked on nothing
        } else {
            selectedObjs = canvas.findObjsCovered(startPos, endPos);
            selectedObjs.removeIf(obj -> obj.getParent() != null);  // not select child
            canvas.selectObjs(selectedObjs);
            canvas.removeDrawable(range);
        }

        canvas.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (!onObj){
            Point minPos = new Point(Math.min(startPos.x, e.getX()), Math.min(startPos.y, e.getY()));
            Point maxPos = new Point(Math.max(startPos.x, e.getX()), Math.max(startPos.y, e.getY()));

            range.setStartPos(minPos);
            range.setEndPos(maxPos);
            canvas.repaint();
        }
    }

    @Override
    public void exit() {
        super.exit();
        selectedObjs.clear();
        canvas.selectObjs(selectedObjs);
    }
}
