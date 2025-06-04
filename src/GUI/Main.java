package GUI;

import GUI.MenuBar.MenuBar;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    private static void createAndShowGUI() {

        JFrame frame = new JFrame("Editor 3000");
        frame.setBounds(500, 100, 800, 700);
        frame.setLayout(new BorderLayout(10,10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // menu bar
        frame.setJMenuBar(MenuBar.getMenuBar(frame));

        // tools Panel
        frame.add(ToolPanel.getPanel(), BorderLayout.WEST);

        // GUI.Canvas
        frame.add(Canvas.getInstance(), BorderLayout.CENTER);


        frame.setVisible(true); // 顯示視窗
    }
}