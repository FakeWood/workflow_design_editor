package GUI.MenuBar;

import Drawables.Obj.CompObj;
import Drawables.Obj.Obj;
import Drawables.Obj.ShapeObj.ShapeObj;
import GUI.Canvas;
import GUI.LabelDialog;

import javax.swing.*;
import java.util.List;

/*
singleton、composition
 */

public class EditMenu {
    private static JMenu menu = null;

    public static JMenu getMenu(JFrame frame, Canvas canvas) {
        if (menu == null) {
            createMenu(frame, canvas);
        }
        return menu;
    }

    private static void createMenu(JFrame frame, Canvas canvas) {
        menu = new JMenu("Edit");

        JMenuItem labelItem = new JMenuItem("Label");
        LabelDialog labelDialog = new LabelDialog(frame);
        labelItem.addActionListener(e -> label(canvas, labelDialog));
        menu.add(labelItem);

        JMenuItem groupItem = new JMenuItem("Group");
        groupItem.addActionListener(e -> group(canvas));
        menu.add(groupItem);

        JMenuItem unGroupItem = new JMenuItem("UnGroup");
        unGroupItem.addActionListener(e -> unGroup(canvas));
        menu.add(unGroupItem);
    }

    private static void group(Canvas canvas) {
        List<Obj> selectedObjs = canvas.getSelectedObjs();
        selectedObjs.removeIf(obj -> obj.getParent() != null);  // Do not add to group if Obj is already in another group
        if (selectedObjs.isEmpty()) {
            return;
        }
        CompObj compObj = new CompObj();
        compObj.adoptChildren(selectedObjs);
        canvas.addObject(compObj);
        compObj.select();
        canvas.repaint();
    }

    private static void unGroup(Canvas canvas) {
        List<Obj> selectedObjs = canvas.getSelectedObjs();
        if (selectedObjs.size() == 1) {
            selectedObjs.get(0).abandonChildren();
            canvas.removeObject(selectedObjs.get(0));
        }
    }

    private static void label(Canvas canvas, LabelDialog labelDialog) {
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
