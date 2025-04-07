package Modes;

import Drawables.Link.AssLink;

import java.awt.event.MouseEvent;

public class AssLinkMode extends LinkMode{
    AssLink tmpLink;

    @Override
    public void mousePressed(MouseEvent e) {
        startObj = canvas.findObjHovered(e.getPoint(), true);
        if (startObj == null) return;

        tmpLink = new AssLink();
        tmpLink.setStart(startObj.findNearestPort(e.getPoint()));
        tmpLink.setEnd(startObj.findNearestPort(e.getPoint()));
        canvas.addLink(tmpLink);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(startObj == null || tmpLink == null) return;

        endObj = canvas.findObjHovered(e.getPoint(), true);
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

        endObj = canvas.findObjHovered(e.getPoint(), true);
        if(endObj == null|| endObj == startObj) {
            canvas.removeLink(tmpLink);
        }
        else {
            tmpLink.setEnd(endObj.findNearestPort(e.getPoint()).getCenterPos());
        }

        tmpLink = null;
        startObj = null;

        canvas.repaint();
    }
}
