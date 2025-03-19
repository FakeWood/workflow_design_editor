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
//        barPanel.add(getButton("File", "" ));

        JButton bEdit = new JButton("Edit");
        barPanel.add(bEdit);
        /* bar Panel */

        /* tools Panel */
        JPanel toolsPanel = new JPanel();
        toolsPanel.setLayout(new GridLayout(6,1));
        toolsPanel.setBackground(Color.gray);

        JButton bSelect = new JButton("Sel");
        bSelect.setIcon(new ImageIcon("res/icon_select.png"));
        toolsPanel.add(bSelect);

        JButton bAssociation = new JButton("Ass");
        bAssociation.setIcon(new ImageIcon("res/icon_association.png"));
        toolsPanel.add(bAssociation);

        JButton bGeneral = new JButton("Gen");
        bGeneral.setIcon(new ImageIcon("res/icon_generalization.png"));
        toolsPanel.add(bGeneral);

        JButton bComposition = new JButton("Com");
        bComposition.setIcon(new ImageIcon("res/icon_composition.png"));
        toolsPanel.add(bComposition);

        JButton bRect = new JButton("Rec");
        bRect.setIcon(new ImageIcon("res/icon_rect.png"));
        toolsPanel.add(bRect);

        JButton bOval = new JButton("Ova");
        bOval.setIcon(new ImageIcon("res/icon_oval.png"));
        toolsPanel.add(bOval);
        /* tools Panel */

        /* Canvas */
        JPanel CanvasPanel = new JPanel();
        CanvasPanel.setBackground(Color.GRAY);
        /* Canvas */

        JFrame frame = new JFrame("Editor 3000");
        frame.setBounds(500, 100, 800, 600);
        frame.setLayout(new BorderLayout(10,10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(barPanel, BorderLayout.NORTH);
        frame.add(toolsPanel, BorderLayout.WEST);
        frame.add(CanvasPanel, BorderLayout.CENTER);

        frame.setVisible(true); // 顯示視窗
    }

//    static JButton getButton(String text, String imgURL) {
//        JButton button = new JButton(text);
//        if(imgURL.isEmpty()) {
//            return button;
//        }
//
//        ImageIcon icon = new ImageIcon(imgURL);
//
//        // 檢查圖片是否載入成功
//        if (icon.getIconWidth() == -1) {
//            System.err.println("圖片載入失敗：" + imgURL);
//        } else {
//            button.setIcon(icon);
//        }
//
//        return button;
//    }
}