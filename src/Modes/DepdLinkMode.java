package Modes;

import Drawables.Link.DependencyLink;
import Drawables.Objs.Port;

import java.awt.event.MouseEvent;

public class DepdLinkMode extends LinkMode{
    DependencyLink tmpLink;

    @Override
    public void mousePressed(MouseEvent e) {
        startObj = canvas.findShapeObjHovered(e.getPoint());
        if (startObj == null) return;

        tmpLink = new DependencyLink();
        startPort = startObj.findNearestPort(e.getPoint());
        tmpLink.setStart(startPort);
        tmpLink.setEnd(startPort);
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
            Port endPort = endObj.findNearestPort(e.getPoint());
            tmpLink.setEnd(endPort);
            startPort.addLinkFrom(tmpLink);
            endPort.addLinkTo(tmpLink);
        }

        tmpLink = null;
        startObj = null;

        canvas.repaint();
    }
}
