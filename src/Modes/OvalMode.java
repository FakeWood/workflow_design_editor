package Modes;

import Shapes.Oval;

import java.awt.event.MouseEvent;

public class OvalMode extends Mode {
    public OvalMode(){}

    @Override
    public void mousePressed(MouseEvent e) {
        canvas.addShape(new Oval(e.getX(), e.getY()));
    }
}
