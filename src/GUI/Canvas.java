package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import Drawables.Drawable;
import Drawables.Link.Link;
import Drawables.Obj.Obj;
import Drawables.Obj.ShapeObj.ShapeObj;
import Modes.Mode;

public class Canvas extends JPanel {
    private static Canvas instance = null;
    Mode curMode = null;
    private final List<Drawable> drawables = new ArrayList<>();  // 用來存放拖拉時的選取框，以及其他不是 Obj 但要被畫出來的物件
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

    /**
     * Find which Obj is hovered by mouse.
     * @param mousePos Mouse position.
     * @return The Obj hovered. Only the Obj that is in the highest layer.
     */
    public Obj findObjHovered(Point mousePos) {
        for (int i = objs.size() - 1; i >= 0; i--) {
            Obj obj = objs.get(i);
            if (obj.contain(mousePos)) {
                return obj;
            }
        }
        return null;
    }

    /**
     * Find which ShapeObj is hovered by mouse.
     * @param mousePos Mouse position.
     * @return The ShapeObj hovered. Only the ShapeObj that is in the highest layer.
     */
    public ShapeObj findShapeObjHovered(Point mousePos) {
        for (int i = objs.size() - 1; i >= 0; i--) {
            Obj obj = objs.get(i);
            if (obj instanceof ShapeObj && obj.contain(mousePos)) {  // 不得已的 type cast，因 move 是動整個 group；建立 link 卻不看 group
                return (ShapeObj) obj;
            }
        }
        return null;
    }

    /**
     * Find all Objs that is fully covered in the rectangle area.
     * @param startPos Where the mouse drag begin.
     * @param endPos Where the mouse drag end.
     */
    public List<Obj> findObjsCovered(Point startPos, Point endPos) {
        List<Obj> objsCovered = new ArrayList<>();
        Point xy = new Point();
        Dimension wh = new Dimension();
        Point minPos = new Point(Math.min(startPos.x, endPos.x), Math.min(startPos.y, endPos.y));
        Point maxPos = new Point(Math.max(startPos.x, endPos.x), Math.max(startPos.y, endPos.y));

        for (int i = objs.size() - 1; i >= 0; i--) {
            Obj obj = objs.get(i);
            xy.setLocation(obj.getPos());
            wh.setSize(obj.getDimension());
            if (xy.x > minPos.x && xy.x + wh.width < maxPos.x &&
                xy.y > minPos.y && xy.y + wh.height < maxPos.y) {
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

    /**
     * tell Links it's time to update their pos by their ports
     */
    public void updateLinks() {
        for (Link link : links) {
            link.update();
        }
    }

    /**
     * make all selected Objs selected
     * @param selectedObjs All Objs that is selected by mouse
     */
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
