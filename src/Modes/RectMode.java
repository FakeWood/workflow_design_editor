package Modes;

import Drawables.object.Rect;

import java.awt.event.MouseEvent;

public class RectMode extends Mode {
    public RectMode (){}

    @Override
    public void mousePressed(MouseEvent e) {
        canvas.addShape(new Rect(e.getX(), e.getY()));
    }
}
