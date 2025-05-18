package GUI;

import Drawables.Objs.CompObj;
import Drawables.Objs.Obj;
import Drawables.Objs.ShapeObj;

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
    LabelDialog labelDialog;

    public JMenuBar getMenuBar(){ return this.menuBar; }

    public MenuBar(JFrame frame) {
        labelDialog = new LabelDialog(frame);

        groupItem.addActionListener(e -> group());
        unGroupItem.addActionListener(e -> unGroup());
        labelItem.addActionListener(e -> label());

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
        List<Obj> selectedObjs = canvas.getSelectedObjs();
        CompObj compObj = new CompObj(selectedObjs);
        compObj.adoptChildren();
        canvas.addObject(compObj);
        compObj.select();
        canvas.repaint();
    }

    void unGroup() {
        List<Obj> selectedObjs = canvas.getSelectedObjs();
        if (selectedObjs.size() == 1 && selectedObjs.get(0) instanceof CompObj) {
            ((CompObj) selectedObjs.get(0)).abandonChildren();
            canvas.removeObject(selectedObjs.get(0));
        }
    }

    void label() {
        List<Obj> selectedObjs = canvas.getSelectedObjs();
        if (selectedObjs.size() == 1 && selectedObjs.get(0) instanceof ShapeObj){
            labelDialog.setToLabel(((ShapeObj) selectedObjs.get(0)).getLabel());
            labelDialog.setVisible(true);
            if(labelDialog.isConfirmed()) {
                ((ShapeObj) selectedObjs.get(0)).setLabel(labelDialog.getLabelInfo());
                canvas.repaint();
            }
        }
    }
}
