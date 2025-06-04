package GUI.MenuBar;

import GUI.Canvas;

import javax.swing.*;

/*
singleton、composition
 */

public class MenuBar {
    private static JMenuBar menuBar;

    public static JMenuBar getMenuBar(JFrame frame) {
        if (menuBar == null) {
            menuBar = new JMenuBar();
            menuBar.add(FileMenu.getMenu());
            menuBar.add(EditMenu.getMenu(frame, Canvas.getInstance()));
        }
        return menuBar;
    }
}
