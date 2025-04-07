package GUI;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    private static void createAndShowGUI() {

        JFrame frame = new JFrame("Editor 3000");
        frame.setBounds(500, 100, 800, 600);
        frame.setLayout(new BorderLayout(10,10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* menu bar */
        frame.setJMenuBar(new MenuBar().getMenuBar());
        /* menu bar */

        /* tools Panel */
        frame.add(new ToolPanel().getToolsPanel(), BorderLayout.WEST);
        /* tools Panel */

        /* GUI.Canvas */
        frame.add(Canvas.getInstance(), BorderLayout.CENTER);
        /* GUI.Canvas */

        frame.setVisible(true); // 顯示視窗
    }
}