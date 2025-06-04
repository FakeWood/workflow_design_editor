package GUI.MenuBar;

import javax.swing.*;

/*
singleton、composition
 */

public class FileMenu {
    private static JMenu menu = null;

    public static JMenu getMenu() {
        if (menu == null) {
            createMenu();
        }
        return menu;
    }

    private static void createMenu() {
        menu = new JMenu("File");
        menu.add(new JMenuItem("New"));
        menu.add(new JMenuItem("Open"));
        menu.add(new JMenuItem("Exit"));
    }
}
