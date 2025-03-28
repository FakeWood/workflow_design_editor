package Modes;

import Drawables.Link.AssLink;
import Drawables.Objs.Obj;

import java.awt.*;
import java.awt.event.MouseEvent;

public class AssLinkMode extends Mode{
    Point startPos;
    Point endPos;
    Obj startObj = null;
    Obj endObj = null;
    AssLink tmpLink;

    @Override
    public void mousePressed(MouseEvent e) {
        startObj = canvas.findObjHovered(e.getPoint());
        if (startObj == null) return;

        startPos = startObj.findNearestPort(e.getPoint());
        tmpLink = new AssLink(startPos, startPos);
        canvas.addLink(tmpLink);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(startObj == null || tmpLink == null) return;

        endObj = canvas.findObjHovered(e.getPoint());
        if (endObj != null && endObj != startObj) {
            endPos = endObj.findNearestPort(e.getPoint());
        } else {
            endPos = e.getPoint();
        }
        tmpLink.setEnd(endPos);

        canvas.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endObj = canvas.findObjHovered(e.getPoint());
        if(endObj == null|| endObj == startObj) {
            canvas.removeLink(tmpLink);
        }
        else {
            tmpLink.setEnd(endObj.findNearestPort(e.getPoint()));
        }

        tmpLink = null;
        startObj = null;

        canvas.repaint();
    }




}
