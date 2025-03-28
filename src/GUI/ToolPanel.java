package GUI;

import Modes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ToolPanel {
    private final Canvas canvas = Canvas.getInstance();

    private final List<JButton> buttons = new ArrayList<>();
    private final JPanel toolsPanel = new JPanel();

    private final Mode rectMode = new RectMode();
    private final Mode ovalMode = new OvalMode();
    private final Mode assLinkMode = new AssLinkMode();
    private final Mode genLinkMode = new GenLinkMode();
    private final Mode compLinkMode = new CompLinkMode();

    public JPanel getToolsPanel(){ return this.toolsPanel; }

    public ToolPanel() {
        this.toolsPanel.setLayout(new GridLayout(6,1));
        this.toolsPanel.setBackground(Color.gray);

        JButton bTmp;

        bTmp = getButton("Sel", "res/icon_select.png");
        bTmp.addActionListener(e->canvas.setMode(rectMode));
        this.toolsPanel.add(bTmp);

        bTmp = getButton("Ass","res/icon_association.png");
//        bTmp.addActionListener(e->canvas.setMode(Mode));
        this.toolsPanel.add(bTmp);

        this.toolsPanel.add(getButton("Gen", "res/icon_generalization.png"));
        this.toolsPanel.add(getButton("Com", "res/icon_composition.png"));

        bTmp = getButton("Rec", "res/icon_rect.png");
        bTmp.addActionListener(e->canvas.setMode(rectMode));
        this.toolsPanel.add(bTmp);

        bTmp = getButton("Ova", "res/icon_oval.png");
        bTmp.addActionListener(e->canvas.setMode(ovalMode));
        this.toolsPanel.add(bTmp);

    }

    private void buttonClicked(JButton clickedBtn) {
        for (JButton btn : buttons) {
            if (btn == clickedBtn) {
                btn.setBackground(Color.GRAY);
            }
            else {
                btn.setBackground(Color.WHITE);
            }
        }

        toolsPanel.repaint();
    }

    private final ActionListener actionListener = e -> buttonClicked((JButton) e.getSource());

    private JButton getButton(String text, String imgURL) {
        JButton button = new JButton(text);
        button.setBackground(Color.WHITE);
        button.addActionListener(actionListener);

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

        this.buttons.add(button);
        return button;
    }
}
