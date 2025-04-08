package Drawables;

import java.awt.*;

public class ObjLabel implements Drawable {
    public enum Shape {
        Rect, Oval
    }

    // use as struct for passing parameters
    public static class LabelInfo {
        public String name = "name";
        public Shape shape = Shape.Rect;
        public Color color = Color.ORANGE;
        public int fontSize = 16;

        public LabelInfo(){}

        public LabelInfo(String name, Shape shape, Color color, int fontSize) {
            this.name = name;
            this.shape = shape;
            this.color = color;
            this.fontSize = fontSize;
        }

        // clone
        public LabelInfo(LabelInfo oldInfo) {
            this.name = oldInfo.name;
            this.shape = oldInfo.shape;
            this.color = oldInfo.color;
            this.fontSize = oldInfo.fontSize;
        }
    }

    Point centerPos = new Point();
    int width = 50;
    int height = 30;

    LabelInfo labelInfo = new LabelInfo();

    public ObjLabel(){}

    public void setCenterPos(int x, int y) {
        centerPos.setLocation(x, y);
    }

    public LabelInfo getLabelInfo() {
        return labelInfo;
    }

    public void setLabelInfo(LabelInfo info) {
        labelInfo = new LabelInfo(info);
    }

    void drawText(Graphics g) {
        g.setFont(new Font("Arial", Font.PLAIN, labelInfo.fontSize));
        FontMetrics fm = g.getFontMetrics();

        int x = centerPos.x - fm.stringWidth(labelInfo.name) / 2;
        int y = centerPos.y + fm.getAscent() / 2;

        g.setColor(Color.BLACK);
        g.drawString(labelInfo.name, x, y);
    }

    public void draw(Graphics g){
        g.setColor(labelInfo.color);
        if (labelInfo.shape == Shape.Rect) {
            g.fillRect(centerPos.x - width / 2, centerPos.y - height / 2, width, height);
            g.drawRect(centerPos.x - width/2, centerPos.y - height/2, width, height);
        }
        else if (labelInfo.shape == Shape.Oval) {
            g.fillOval(centerPos.x - width / 2, centerPos.y - height / 2, width, height);
            g.drawOval(centerPos.x - width/2, centerPos.y - height/2, width, height);
        }

        g.setColor(Color.BLACK);
        drawText(g);
    }
}
