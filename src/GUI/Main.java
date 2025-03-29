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

        /* bar Panel */
        JPanel barPanel = new JPanel();
        barPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        barPanel.setBackground(Color.gray);

//        barPanel.add(getButton("File", ""));
//        barPanel.add(getButton("Edit",""));

        frame.add(barPanel, BorderLayout.NORTH);
        /* bar Panel */

        /* tools Panel */
        frame.add(new ToolPanel().getToolsPanel(), BorderLayout.WEST);
        /* tools Panel */

        /* GUI.Canvas */
        frame.add(Canvas.getInstance(), BorderLayout.CENTER);
        /* GUI.Canvas */

        frame.setVisible(true); // 顯示視窗
    }
}