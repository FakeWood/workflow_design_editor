import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        /* bar Panel */
        JPanel barPanel = new JPanel();
        barPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        barPanel.setBackground(Color.gray);

        JButton bFile = new JButton("File");
        barPanel.add(bFile);

        JButton bEdit = new JButton("Edit");
        barPanel.add(bEdit);
        /* bar Panel */

        /* tools Panel */
        JPanel toolsPanel = new JPanel();
        toolsPanel.setLayout(new GridLayout(6,1));
        toolsPanel.setBackground(Color.gray);

        JButton bSelect = new JButton("Sel");
        toolsPanel.add(bSelect);

        JButton bAssociation = new JButton("Ass");
        toolsPanel.add(bAssociation);

        JButton bGeneral = new JButton("Gen");
        toolsPanel.add(bGeneral);

        JButton bComposition = new JButton("Com");
        toolsPanel.add(bComposition);

        JButton bRect = new JButton("Rec");
        toolsPanel.add(bRect);

        JButton bOval = new JButton("Ova");
        toolsPanel.add(bOval);
        /* tools Panel */

        /* Canvas */
        JPanel CanvasPanel = new JPanel();
        CanvasPanel.setBackground(Color.GRAY);
        /* Canvas */

        JFrame frame = new JFrame("Editor 3000");
        frame.setBounds(500, 100, 400, 300);
        frame.setLayout(new BorderLayout(10,10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(barPanel, BorderLayout.NORTH);
        frame.add(toolsPanel, BorderLayout.WEST);
        frame.add(CanvasPanel, BorderLayout.CENTER);

        frame.setVisible(true); // 顯示視窗
    }
}