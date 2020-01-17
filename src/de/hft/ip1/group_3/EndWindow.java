package de.hft.ip1.group_3;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;

public class EndWindow {

    private JFrame frame;
    private JTable table3;
    private JTable table5;
    private JTable table10;

    /**
     * Create the application.
     */
    public EndWindow() {
        initialize();
        frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

        JPanel panel3 = new JPanel();
        tabbedPane.addTab("Highscore 3", null, panel3, null);

        MyTableModel model3 = new MyTableModel();
        try {
            BufferedReader reader3 = new BufferedReader(new FileReader("Scores3.txt"));
            ArrayList<String> lines = new ArrayList<String>();
            while (reader3.ready()) {
                model3.addRow(new String[] { reader3.readLine() });
            }
            table10 = new JTable(model3);
            reader3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        panel3.setLayout(new BorderLayout(0, 0));
        table3 = new JTable(model3);
        panel3.add(table3);

        JPanel panel5 = new JPanel();
        tabbedPane.addTab("Highscore 5", null, panel5, null);

        MyTableModel model5 = new MyTableModel();
        try {
            BufferedReader reader5 = new BufferedReader(new FileReader("Scores5.txt"));
            ArrayList<String> lines = new ArrayList<String>();
            while (reader5.ready()) {
                model5.addRow(new String[] { reader5.readLine() });
            }
            table10 = new JTable(model5);
            reader5.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        panel5.setLayout(new BorderLayout(0, 0));
        table5 = new JTable(model5);
        panel5.add(table5);

        JPanel panel10 = new JPanel();
        tabbedPane.addTab("Highscore 10", null, panel10, null);

        MyTableModel model10 = new MyTableModel();
        try {
            BufferedReader reader10 = new BufferedReader(new FileReader("Scores10.txt"));
            ArrayList<String> lines = new ArrayList<String>();
            while (reader10.ready()) {
                model10.addRow(new String[] { reader10.readLine()});
            }
            table10 = new JTable(model10);
            reader10.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        panel10.setLayout(new BorderLayout(0, 0));
        panel10.add(table10);
    }
}

class MyTableModel extends DefaultTableModel {

    private ArrayList<String> content;

    private static final long serialVersionUID = 1L;

    public MyTableModel() {
        content = new ArrayList<>();
    }

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return 1;
    }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return (content == null) ? 1 : content.size();
    }

    @Override
    public Object getValueAt(int row, int column) {
        // TODO Auto-generated method stub
        return content.get(row);
    }

    @Override
    public void addRow(Object[] rowData) {
        // TODO Auto-generated method stub
        content.add((String) rowData[0]);
        fireTableDataChanged();
    }
}
