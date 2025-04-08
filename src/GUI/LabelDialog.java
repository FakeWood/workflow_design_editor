package GUI;

import Drawables.ObjLabel;

import javax.swing.*;
import java.awt.*;

public class LabelDialog extends JDialog {

    JTextField tfName = new JTextField();
    JComboBox<ObjLabel.Shape> cbShape = new JComboBox<>(ObjLabel.Shape.values());
    JButton bColor = new JButton("pick");
    JSpinner spFontSize = new JSpinner(new SpinnerNumberModel(16, 1, 100, 1));
    JButton bOk = new JButton("OK");
    JButton bCancel = new JButton("Cancel");

    private Color pickedColor = Color.MAGENTA;
    private boolean confirmed;

    public LabelDialog(JFrame parent) {
        super(parent, "Custom Label Style", true); // true = modal
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(4, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        form.add(new JLabel("Name:"));
        form.add(tfName);

        form.add(new JLabel("Shape:"));
        form.add(cbShape);

        form.add(new JLabel("Color:"));
        form.add(bColor);
        bColor.addActionListener(e -> {
            pickedColor = JColorChooser.showDialog(this, "Pick a color", pickedColor);
            if (pickedColor == null) {
                pickedColor = Color.MAGENTA;
            }
            bColor.setBackground(pickedColor);
        });

        form.add(new JLabel("Font size:"));
        form.add(spFontSize);

        add(form, BorderLayout.CENTER);

        bOk.addActionListener(e -> {
            confirmed = true;
            setVisible(false);
        });

        bCancel.addActionListener(e -> setVisible(false));

        JPanel buttons = new JPanel();
        buttons.add(bOk);
        buttons.add(bCancel);
        add(buttons, BorderLayout.SOUTH);

        setMinimumSize(new Dimension(200, 0));
        pack();
        setLocationRelativeTo(parent);
    }

    public void setToLabel(ObjLabel.LabelInfo info) {
        tfName.setText(info.name);
        cbShape.setSelectedItem(info.shape);
        bColor.setBackground(info.color);
        pickedColor = info.color;
        spFontSize.setValue(info.fontSize);
    }

    public ObjLabel.LabelInfo getLabelInfo() {
        return new ObjLabel.LabelInfo(tfName.getText(), (ObjLabel.Shape) cbShape.getSelectedItem(), pickedColor, (int) spFontSize.getValue());
    }

    public boolean isConfirmed() {
        return confirmed;
    }
}
