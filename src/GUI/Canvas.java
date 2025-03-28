package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import Drawables.Link.Link;
import Drawables.Objs.Obj;
import Modes.Mode;
import Drawables.Drawable;

public class Canvas extends JPanel {
    private static Canvas instance = null;
    Mode curMode = null;
    private final List<Obj> objs = new ArrayList<>();
    private final List<Link> links = new ArrayList<>();

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

    public void addObject(Obj obj) {
        objs.add(obj);
        repaint();
    }

    public Obj findObjHovered(Point mousePos) {
        for (Obj obj : objs) {
            if (obj.contain(mousePos)) {
                return obj;
            }
        }
        return null;
    }

    public void addLink(Link link) {
        links.add(link);
        repaint();
    }

    public void removeLink(Link link) {
        links.remove(link);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Obj obj : objs) {
            obj.draw(g);
        }
        for (Link link : links) {
            link.draw(g);
        }
    }
}
