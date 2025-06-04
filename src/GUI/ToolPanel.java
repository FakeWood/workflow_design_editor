package GUI;

import Mode.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/*
singleton、composition
 */

public class ToolPanel {
    private static Canvas canvas;
    private static JPanel toolsPanel;
    private static List<JButton> buttons;

    public static JPanel getPanel() {
        if (toolsPanel == null) {
            createPanel();
        }
        return toolsPanel;
    }

    private static void createPanel() {
        canvas = Canvas.getInstance();
        buttons = new ArrayList<>();
        toolsPanel = new JPanel();
        toolsPanel.setLayout(new GridLayout(7, 1));
        toolsPanel.setBackground(Color.gray);

        JButton bTmp;

        bTmp = getButton("Sel", "res/icon_select.png");
        bTmp.addActionListener(e -> canvas.setMode(new SelectMode()));
        toolsPanel.add(bTmp);

        bTmp = getButton("Ass", "res/icon_association.png");
        bTmp.addActionListener(e -> canvas.setMode(new LinkMode(LinkFactory.LinkType.ASSOCIATION)));
        toolsPanel.add(bTmp);

        bTmp = getButton("Depd", "res/icon_dependency.png");
        bTmp.addActionListener(e -> canvas.setMode(new LinkMode(LinkFactory.LinkType.DEPENDENCY)));
        toolsPanel.add(bTmp);

        bTmp = getButton("Gen", "res/icon_generalization.png");
        bTmp.addActionListener(e -> canvas.setMode(new LinkMode(LinkFactory.LinkType.GENERALIZATION)));
        toolsPanel.add(bTmp);

        bTmp = getButton("Com", "res/icon_composition.png");
        bTmp.addActionListener(e -> canvas.setMode(new LinkMode(LinkFactory.LinkType.COMPOSITION)));
        toolsPanel.add(bTmp);

        bTmp = getButton("Rec", "res/icon_rect.png");
        bTmp.addActionListener(e -> canvas.setMode(new RectMode()));
        toolsPanel.add(bTmp);

        bTmp = getButton("Ova", "res/icon_oval.png");
        bTmp.addActionListener(e -> canvas.setMode(new OvalMode()));
        toolsPanel.add(bTmp);
    }

    private static void buttonClicked(JButton clickedBtn) {
        for (JButton btn : buttons) {
            if (btn == clickedBtn) {
                btn.setBackground(Color.GRAY);
            } else {
                btn.setBackground(Color.WHITE);
            }
        }

        toolsPanel.repaint();
    }

    private static final ActionListener actionListener = e -> buttonClicked((JButton) e.getSource());

    private static JButton getButton(String text, String imgURL) {
        JButton button = new JButton(text);
        button.setBackground(Color.WHITE);
        button.addActionListener(actionListener);

        if (imgURL.isEmpty()) {
            return button;
        }

        ImageIcon icon = new ImageIcon(imgURL);

        // 檢查圖片是否載入成功
        if (icon.getIconWidth() == -1) {
            System.err.println("圖片載入失敗：" + imgURL);
        } else {
            button.setIcon(icon);
        }

        buttons.add(button);
        return button;
    }
}
