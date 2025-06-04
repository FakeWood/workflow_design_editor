package GUI;

import Modes.*;

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

    private static Mode selectMode;
    private static Mode rectMode;
    private static Mode ovalMode;
    private static Mode assLinkMode;
    private static Mode depdLinkMode;
    private static Mode genLinkMode;
    private static Mode compLinkMode;

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
        toolsPanel.setLayout(new GridLayout(7,1));
        toolsPanel.setBackground(Color.gray);

        selectMode = new SelectMode();
        rectMode = new RectMode();
        ovalMode = new OvalMode();
        assLinkMode = new AssLinkMode();
        depdLinkMode = new DepdLinkMode();
        genLinkMode = new GenLinkMode();
        compLinkMode = new CompLinkMode();

        JButton bTmp;

        bTmp = getButton("Sel", "res/icon_select.png");
        bTmp.addActionListener(e->canvas.setMode(selectMode));
        toolsPanel.add(bTmp);

        bTmp = getButton("Ass","res/icon_association.png");
        bTmp.addActionListener(e->canvas.setMode(assLinkMode));
        toolsPanel.add(bTmp);

        bTmp = getButton("Depd","res/icon_dependency.png");
        bTmp.addActionListener(e->canvas.setMode(depdLinkMode));
        toolsPanel.add(bTmp);

        bTmp = getButton("Gen", "res/icon_generalization.png");
        bTmp.addActionListener(e->canvas.setMode(genLinkMode));
        toolsPanel.add(bTmp);

        bTmp = getButton("Com", "res/icon_composition.png");
        bTmp.addActionListener(e->canvas.setMode(compLinkMode));
        toolsPanel.add(bTmp);

        bTmp = getButton("Rec", "res/icon_rect.png");
        bTmp.addActionListener(e->canvas.setMode(rectMode));
        toolsPanel.add(bTmp);

        bTmp = getButton("Ova", "res/icon_oval.png");
        bTmp.addActionListener(e->canvas.setMode(ovalMode));
        toolsPanel.add(bTmp);
    }

    private static void buttonClicked(JButton clickedBtn) {
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

    private static final ActionListener actionListener = e -> buttonClicked((JButton) e.getSource());

    private static JButton getButton(String text, String imgURL) {
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

        buttons.add(button);
        return button;
    }
}
