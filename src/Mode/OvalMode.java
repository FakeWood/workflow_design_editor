package Mode;

import Drawables.Obj.ShapeObj.Oval;

import java.awt.event.MouseEvent;

public class OvalMode extends Mode {
    public OvalMode(){}

    @Override
    public void mousePressed(MouseEvent e) {
        canvas.addObject(new Oval(e.getX(), e.getY()));
    }
}
