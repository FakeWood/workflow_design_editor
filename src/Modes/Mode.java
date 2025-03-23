package Modes;

import java.awt.event.MouseEvent;

abstract public class Mode {
    public Mode(){};
    public abstract void update(MouseEvent e);
}
