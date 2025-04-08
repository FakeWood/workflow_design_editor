package Drawables;

import java.awt.*;

public class ObjLabel implements Drawable {
    public enum Shape {
        Rect, Oval
    }

    Point centerPos = new Point();
    int width = 50;
    int height = 30;

    String name = "name";
    Shape shape = Shape.Rect;
    Color color = Color.ORANGE;
    int fontSize = 16;

    public ObjLabel(){}

    public void setCenterPos(int x, int y) {
        centerPos.setLocation(x, y);
    }

    void drawText(Graphics g) {
        g.setFont(new Font("Arial", Font.PLAIN, fontSize));
        FontMetrics fm = g.getFontMetrics();

        int x = centerPos.x - fm.stringWidth(name) / 2;
        int y = centerPos.y + fm.getAscent() / 2;

        g.setColor(Color.BLACK);
        g.drawString(name, x, y);
    }

    public void draw(Graphics g){
        g.setColor(color);
        if (shape == Shape.Rect) {
            g.fillRect(centerPos.x - width / 2, centerPos.y - height / 2, width, height);
        }
        else if (shape == Shape.Oval) {
            g.fillOval(centerPos.x - width / 2, centerPos.y - height / 2, width, height);
        }

        g.setColor(Color.BLACK);
        g.drawRect(centerPos.x - width/2, centerPos.y - height/2, width, height);
        drawText(g);
    }
}
