package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import Modes.Mode;
import Drawables.Drawable;

public class Canvas extends JPanel {
    private static Canvas instance = null;
    Mode curMode = null;
    private final List<Drawable> drawables = new ArrayList<>();

    // singleton
    private Canvas() {
        setBackground(Color.GRAY);
    }

    public static Canvas getInstance() {  // 單例模式
        if (instance == null) {
            instance = new Canvas();
        }
        return instance;
    }

    public void setMode(Mode mode) {
        removeMouseListener(curMode);  // accept null
        removeMouseMotionListener(curMode);
        curMode = mode;
        addMouseListener(mode);
        addMouseMotionListener(mode);
    }

    public void addShape(Drawable drawable) {
        drawables.add(drawable);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Drawable drawable : drawables) {
            drawable.draw(g);
        }
    }
}
