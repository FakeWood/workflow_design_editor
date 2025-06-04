package Mode;

import Drawables.Obj.ShapeObj.Rect;

import java.awt.event.MouseEvent;

public class RectMode extends Mode {
    public RectMode (){}

    @Override
    public void mousePressed(MouseEvent e) {
        canvas.addObject(new Rect(e.getX(), e.getY()));
    }
}
