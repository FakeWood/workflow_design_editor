package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import Drawables.Drawable;
import Drawables.Link.Link;
import Drawables.Objs.Obj;
import Drawables.Objs.ShapeObj;
import Modes.Mode;

public class Canvas extends JPanel {
    private static Canvas instance = null;
    Mode curMode = null;
    private final List<Drawable> drawables = new ArrayList<>();
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
        if(curMode != null) {
            curMode.exit();
        }
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

    public void removeObject(Obj obj) {
        objs.remove(obj);
        repaint();
    }

    public void addDrawable(Drawable drawable) {
        drawables.add(drawable);
        repaint();
    }

    public void removeDrawable(Drawable drawable) {
        drawables.remove(drawable);
        repaint();
    }

    public Obj findObjHovered(Point mousePos) {
        for (int i = objs.size() - 1; i >= 0; i--) {
            Obj obj = objs.get(i);
            if (obj.contain(mousePos)) {
                return obj;
            }
        }
        return null;
    }

    public ShapeObj findShapeObjHovered(Point mousePos) {
        for (int i = objs.size() - 1; i >= 0; i--) {
            Obj obj = objs.get(i);
            if (obj instanceof ShapeObj && obj.contain(mousePos)) {
                return (ShapeObj) obj;
            }
        }
        return null;
    }

    public List<Obj> findObjsCovered(Point startPos, Point endPos) {
        List<Obj> objsCovered = new ArrayList<>();
        Point xy = new Point();
        Point wh = new Point();
        Point minPos = new Point(Math.min(startPos.x, endPos.x), Math.min(startPos.y, endPos.y));
        Point maxPos = new Point(Math.max(startPos.x, endPos.x), Math.max(startPos.y, endPos.y));

        for (int i = objs.size() - 1; i >= 0; i--) {
            Obj obj = objs.get(i);
            xy.setLocation(obj.getPos());
            wh.setLocation(obj.getDimension());
            if (xy.x > minPos.x && xy.x + wh.x < maxPos.x &&
                xy.y > minPos.y && xy.y + wh.y < maxPos.y) {
                objsCovered.add(obj);
            }
        }

        return objsCovered;
    }

    public void addLink(Link link) {
        links.add(link);
        repaint();
    }

    public void removeLink(Link link) {
        links.remove(link);
        repaint();
    }

    public void updateLinks() {
        for (Link link : links) {
            link.updatePorts();
        }
    }

    public void selectObjs(List<Obj> selectedObjs) {
        for(Obj obj : objs) {
            obj.deselect();
        }

        for (int i = objs.size() - 1; i >= 0; i--) {
            Obj obj = objs.get(i);
            if (selectedObjs.contains(obj)) {
                obj.select();
            } // do not deselect here. Or compObj component will be deselected.
        }

        repaint();
    }

    public List<Obj> getSelectedObjs() {
        List<Obj> selectedObjs = new ArrayList<>();
        for (Obj obj : objs) {
            if (obj.isSelected()) {
                selectedObjs.add(obj);
            }
        }
        return selectedObjs;
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
        for (Drawable drawable : drawables) {
            drawable.draw(g);
        }
    }
}
