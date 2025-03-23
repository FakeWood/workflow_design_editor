package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import Shapes.Shape;

public class Canvas extends JPanel {
    private List<Shape> shapes = new ArrayList<Shape>();

    public Canvas() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                shapes.get(0).moveShape(e.getX(),e.getY());
                repaint();
            }
        });
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }
}
