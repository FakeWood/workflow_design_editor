package Mode;

import Drawables.Link.Link;
import Drawables.Obj.Port;
import Drawables.Obj.ShapeObj.ShapeObj;

import java.awt.event.MouseEvent;

/*
用 Factory 建立 Link，因為不同種類的 Link 滑鼠事件都一樣，不需要分化下去
 */

public class LinkMode extends Mode{
    ShapeObj startObj;
    ShapeObj endObj;
    Port startPort;
    Link tmpLink;
    LinkFactory.LinkType linkType;

    public LinkMode(LinkFactory.LinkType linkType) {
        this.linkType = linkType;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startObj = canvas.findShapeObjHovered(e.getPoint());
        if (startObj == null) return;

        tmpLink = LinkFactory.createLink(linkType);
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