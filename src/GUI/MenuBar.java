package GUI;

import Drawables.Objs.CompObj;

import javax.swing.*;

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

    public JMenuBar getMenuBar(){ return this.menuBar; }

    public MenuBar() {
        groupItem.addActionListener(e -> group());

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(exitItem);

        editMenu.add(labelItem);
        editMenu.add(groupItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
    }

    void group() {
        CompObj compObj = new CompObj(canvas.getSelectedObjs());
        canvas.addObject(compObj);
        compObj.select();
        canvas.repaint();
    }
}
