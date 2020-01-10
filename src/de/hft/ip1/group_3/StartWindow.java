package de.hft.ip1.group_3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JSeparator;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;

public class StartWindow extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_3;
    private JTextField textField_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StartWindow frame = new StartWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
    }

    /**
     * Create the frame.
     */
    public StartWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setTitle("Pong Startmenu");
        
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setPreferredSize(new Dimension(100, 100));
        contentPane.add(panel);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(Color.DARK_GRAY);
        panel_3.setForeground(Color.YELLOW);
        panel.add(panel_3, BorderLayout.EAST);
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));

        JLabel lblNewLabel = new JLabel("Player 2\r\n:");
        lblNewLabel.setFont(new Font("MS PGothic", Font.BOLD, 18));
        lblNewLabel.setBackground(Color.BLACK);
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setPreferredSize(new Dimension(56, 38));
        panel_3.add(lblNewLabel);
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Arial", Font.BOLD, 16));
        panel_3.add(textField_2);
        textField_2.setColumns(10);

        JLabel label_1 = new JLabel("");
        label_1.setPreferredSize(new Dimension(6, 25));
        panel_3.add(label_1);

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(Color.DARK_GRAY);
        panel_4.setForeground(Color.BLACK);
        panel.add(panel_4, BorderLayout.WEST);
        panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));

        JLabel lblNewLabel_1 = new JLabel("Player 1:");
        lblNewLabel_1.setFont(new Font("MS PGothic", Font.BOLD, 18));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setPreferredSize(new Dimension(56, 38));
        panel_4.add(lblNewLabel_1);

        textField_3 = new JTextField();
        textField_3.setBackground(Color.WHITE);
        textField_3.setFont(new Font("Arial", Font.BOLD, 16));
        panel_4.add(textField_3);
        textField_3.setColumns(10);

        JLabel label = new JLabel("");
        label.setPreferredSize(new Dimension(6, 25));
        label.setMinimumSize(new Dimension(0, 10));
        panel_4.add(label);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.DARK_GRAY);
        panel_2.setPreferredSize(new Dimension(100, 160));
        contentPane.add(panel_2);
        panel_2.setLayout(new BorderLayout(0, 0));

        JButton btnStart = new JButton("Start");
        btnStart.setFont(new Font("MS PGothic", Font.BOLD, 20));
        btnStart.setBackground(Color.WHITE);
        panel_2.add(btnStart, BorderLayout.SOUTH);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.DARK_GRAY);
        panel_2.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new BorderLayout(0, 0));

        JPanel panel_5 = new JPanel();
        panel_5.setFont(new Font("MS PGothic", Font.BOLD, 13));
        panel_5.setBackground(Color.DARK_GRAY);
        panel_1.add(panel_5, BorderLayout.CENTER);
        panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));

        JLabel lblNewLabel_2 = new JLabel("choose size:");
        lblNewLabel_2.setFont(new Font("MS PGothic", Font.BOLD, 18));
        lblNewLabel_2.setForeground(Color.WHITE);
        panel_5.add(lblNewLabel_2);

        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("MS PGothic", Font.BOLD, 16));
        comboBox.setBackground(Color.LIGHT_GRAY);
        comboBox.setForeground(Color.BLACK);
        panel_5.add(comboBox);

        comboBox.addItem("medium");
        comboBox.addItem("small");
        comboBox.addItem("large");

        JLabel label_2 = new JLabel("");
        panel_5.add(label_2);
        label_2.setPreferredSize(new Dimension(6, 50));

        JLabel label_3 = new JLabel("");
        label_3.setPreferredSize(new Dimension(80, 6));
        panel_1.add(label_3, BorderLayout.WEST);

        JLabel label_4 = new JLabel("");
        label_4.setPreferredSize(new Dimension(80, 6));
        panel_1.add(label_4, BorderLayout.EAST);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setPreferredSize(new Dimension(0, 20));
        panel_1.add(lblNewLabel_3, BorderLayout.SOUTH);

    }


}