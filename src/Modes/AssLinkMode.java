package Modes;

import Drawables.Link.AssLink;

import java.awt.event.MouseEvent;

public class AssLinkMode extends LinkMode{
    AssLink tmpLink;

    @Override
    public void mousePressed(MouseEvent e) {
        startObj = canvas.findObjHovered(e.getPoint());
        if (startObj == null) return;

        startPos = startObj.findNearestPort(e.getPoint()).getCenterPos();
        tmpLink = new AssLink(startPos, startPos);
        canvas.addLink(tmpLink);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(startObj == null || tmpLink == null) return;

        endObj = canvas.findObjHovered(e.getPoint());
        if (endObj != null && endObj != startObj) {
            endPos = endObj.findNearestPort(e.getPoint()).getCenterPos();
        } else {
            endPos = e.getPoint();
        }
        tmpLink.setEnd(endPos);

        canvas.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (tmpLink == null) return;

        endObj = canvas.findObjHovered(e.getPoint());
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
