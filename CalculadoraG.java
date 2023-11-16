import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraG extends JFrame {

    private JTextField display;

    public CalculadoraG() {
        setTitle("Calculadora RMI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        display = new JTextField();
        display.setHorizontalAlignment(JTextField.RIGHT);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        c.weightx = 1.0;
        contentPanel.add(display, c);

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "Sen", "Cos", "Tan", "sqrt",
                "Ln", "Log10", "x^y", "Abs",
                "!", "Exp", "Atan", "C"
        };

        c.gridwidth = 1;
        c.weightx = 0.50;
        int x = 0;
        int y = 1;
        for (String label : buttonLabels) {
            JButton button = new JButton(label);

            button.setFont(new Font("Serif", Font.BOLD, 20));
            button.setForeground(Color.BLACK);
            button.setBackground(new Color(218, 202, 251));
            Border line = new LineBorder(Color.BLACK);
            Border margin = new EmptyBorder(5, 15, 5, 15);
            Border compound = new CompoundBorder(line, margin);
            button.setBorder(compound);

            button.addActionListener(new ButtonClickListener());
            c.gridx = x;
            c.gridy = y;
            contentPanel.add(button, c);

            x++;
            if (x > 3) {
                x = 0;
                y++;
            }
        }

        add(contentPanel);
        pack();
        setLocationRelativeTo(null);

    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("boton pulsado");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculadoraG().setVisible(true);
        });
    }
}
