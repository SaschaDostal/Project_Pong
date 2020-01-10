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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
import javax.swing.JSlider;

public class StartWindow extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_3;
    private JTextField textField_2;
    
 
    public StartWindow(Control con) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setTitle("Pong Startmenu");
        setLocationRelativeTo(null);

        
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
        
        KeyListener key = new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER ) {
                    btnStart.doClick();
                }                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            
        };
       
        
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
        
        JSlider slider = new JSlider();
        slider.setMaximum(1250);
        slider.setMinimum(500);
        panel_5.add(slider);
        
        JPanel panel_6 = new JPanel();
        panel_6.setBackground(Color.DARK_GRAY);
        panel_5.add(panel_6);
        panel_6.setLayout(new BorderLayout(0, 0));
        
        JLabel lblNewLabel_4 = new JLabel("small");
        lblNewLabel_4.setBackground(Color.DARK_GRAY);
        lblNewLabel_4.setForeground(Color.WHITE);
        panel_6.add(lblNewLabel_4, BorderLayout.WEST);
        
        JLabel lblLarge = new JLabel("large");
        lblLarge.setForeground(Color.WHITE);
        panel_6.add(lblLarge, BorderLayout.EAST);

        JLabel label_3 = new JLabel("");
        label_3.setPreferredSize(new Dimension(80, 6));
        panel_1.add(label_3, BorderLayout.WEST);

        JLabel label_4 = new JLabel("");
        label_4.setPreferredSize(new Dimension(80, 6));
        panel_1.add(label_4, BorderLayout.EAST);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setPreferredSize(new Dimension(0, 20));
        panel_1.add(lblNewLabel_3, BorderLayout.SOUTH);

        btnStart.addKeyListener(key);
        textField_2.addKeyListener(key);
        textField_3.addKeyListener(key);
        slider.addKeyListener(key);
        
        btnStart.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
               con.Startgame(textField_3.getText(), textField_2.getText(), slider.getValue()); 
               
                dispose();
                
            }
        });
        
       while(isVisible()); 
    }


}