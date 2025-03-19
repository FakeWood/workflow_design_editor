import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        /* bar Panel */
        JPanel barPanel = new JPanel();
        barPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        barPanel.setBackground(Color.gray);

        barPanel.add(getButton("File", "" ));
        barPanel.add(getButton("Edit",""));
        /* bar Panel */

        /* tools Panel */
        JPanel toolsPanel = new JPanel();
        toolsPanel.setLayout(new GridLayout(6,1));
        toolsPanel.setBackground(Color.gray);

        toolsPanel.add(getButton("Sel", "res/icon_select.png"));
        toolsPanel.add(getButton("Ass","res/icon_association.png"));
        toolsPanel.add(getButton("Gen", "res/icon_generalization.png"));
        toolsPanel.add(getButton("Com", "res/icon_composition.png"));
        toolsPanel.add(getButton("Rec", "res/icon_rect.png"));
        toolsPanel.add(getButton("Ova", "res/icon_oval.png"));
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

    static JButton getButton(String text, String imgURL) {
        JButton button = new JButton(text);
        if(imgURL.isEmpty()) {
            return button;
        }

        ImageIcon icon = new ImageIcon(imgURL);

        // 檢查圖片是否載入成功
        if (icon.getIconWidth() == -1) {
            System.err.println("圖片載入失敗：" + imgURL);
        } else {
            button.setIcon(icon);
        }

        return button;
    }
}