package GUI;

import Drawables.Objs.CompObj;
import Drawables.Objs.Obj;

import javax.swing.*;
import java.util.List;

public class MenuBar {
    private final Canvas canvas = Canvas.getInstance();

    private final JMenuBar menuBar = new JMenuBar();

    // File
    JMenu fileMenu = new JMenu("File");
    JMenuItem newItem = new JMenuItem("New");
    JMenuItem openItem = new JMenuItem("Open");
    JMenuItem exitItem = new JMenuItem("Exit");

    // Edit
    JMenu editMenu = new JMenu("Edit");
    JMenuItem labelItem = new JMenuItem("Label");
    JMenuItem groupItem = new JMenuItem("Group");
    JMenuItem unGroupItem = new JMenuItem("UnGroup");

    public JMenuBar getMenuBar(){ return this.menuBar; }

    public MenuBar() {
        groupItem.addActionListener(e -> group());
        unGroupItem.addActionListener(e -> unGroup());

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(exitItem);

        editMenu.add(labelItem);
        editMenu.add(groupItem);
        editMenu.add(unGroupItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
    }

    void group() {
        CompObj compObj = new CompObj(canvas.getSelectedObjs());
        canvas.addObject(compObj);
        compObj.select();
        canvas.repaint();
    }

    void unGroup() {
        List<Obj> selectedObjs = canvas.getSelectedObjs();
        for (int i = selectedObjs.size() - 1; i >= 0; i--) {
            if (selectedObjs.get(i) instanceof CompObj) {
                canvas.removeObject(selectedObjs.get(i));
                break;
            }
        }
    }
}
