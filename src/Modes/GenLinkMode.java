package Modes;

import Drawables.Link.GenLink;

import java.awt.event.MouseEvent;

public class GenLinkMode extends LinkMode{
    GenLink tmpLink;

    @Override
    public void mousePressed(MouseEvent e) {
        startObj = canvas.findShapeObjHovered(e.getPoint());
        if (startObj == null) return;

        tmpLink = new GenLink();
        tmpLink.setStart(startObj.findNearestPort(e.getPoint()));
        tmpLink.setEnd(startObj.findNearestPort(e.getPoint()));
        canvas.addLink(tmpLink);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(startObj == null || tmpLink == null) return;

        endObj = canvas.findShapeObjHovered(e.getPoint());
        if (endObj == null || endObj == startObj) {
            tmpLink.setEnd(e.getPoint());
        } else {
            tmpLink.setEnd(endObj.findNearestPort(e.getPoint()));
        }

        canvas.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (tmpLink == null) return;

        endObj = canvas.findShapeObjHovered(e.getPoint());
        if(endObj == null || endObj == startObj) {
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
