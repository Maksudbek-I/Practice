package Practice.Practice_10;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    public Calculator() {
        setTitle("Calculator");
        setSize(300, 400);

        JPanel panel = new JPanel();

        JTextField num_1 = new JTextField(10);
        num_1.setBounds(90, 50, 100, 30);
        panel.add(num_1);

        JTextField num_2 = new JTextField(10);
        num_2.setBounds(90, 180, 100, 30);
        panel.add(num_2);

        JLabel label = new JLabel("The result");
        label.setBounds(105, 225, 120, 30);
        panel.add(label);

        JTextField result = new JTextField();
        result.setBounds(90, 250, 100, 30);
        panel.add(result);

        JButton plus = new JButton("+");
        plus.addActionListener(
                action -> {
                    try {
                        Double sum = Double.parseDouble(num_1.getText()) + Double.parseDouble(num_2.getText());
                        result.setText(String.format("%.4f", sum));
                    } catch (Exception e) {
                        result.setText("Error");
                    }
                }
        );
        plus.setBounds(15, 100, 50, 50);
        panel.add(plus);

        JButton minus = new JButton("-");
        minus.addActionListener(
                action -> {
                    try {
                        Double dif = Double.parseDouble(num_1.getText()) - Double.parseDouble(num_2.getText());
                        result.setText(String.format("%.4f", dif));
                    } catch (Exception e) {
                        result.setText("Error");
                    }
                }
        );
        minus.setBounds(75, 100, 50, 50);
        panel.add(minus);

        JButton mult = new JButton("*");
        mult.addActionListener(
                action -> {
                    try {
                        Double prod = Double.parseDouble(num_1.getText()) * Double.parseDouble(num_2.getText());
                        result.setText(String.format("%.4f", prod));
                    } catch (Exception e) {
                        result.setText("Error");
                    }
                }
        );
        mult.setBounds(135, 100, 50, 50);
        panel.add(mult);


        JButton division = new JButton("/");
        division.addActionListener(
                action -> {
                    try {
                        Double quot = Double.parseDouble(num_1.getText()) / Double.parseDouble(num_2.getText());
                        result.setText(String.format("%.4f", quot));
                    } catch (Exception e) {
                        result.setText("Error");
                    }
                }
        );
        division.setBounds(195, 100, 50, 50);
        panel.add(division);

        add(panel);
        panel.setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}