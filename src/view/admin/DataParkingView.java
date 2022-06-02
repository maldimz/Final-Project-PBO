package view.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class DataParkingView extends JFrame{
    JLabel lTitle = new JLabel("View Parking Data");

    public JButton bExit = new JButton("Exit");
    public JTable table;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object[] header = {"id", "license", "type", "price",
                       "in_time", "out_time", "user_id"};
    
    public DataParkingView(){
        dtm = new DefaultTableModel(header, 0);
        table = new JTable(dtm);
        scrollPane = new JScrollPane(table);

        setSize(700, 450);
        setTitle("Parking Data");
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        add(lTitle);
        lTitle.setBounds(300, 20, 200, 20);

        add(scrollPane);
        scrollPane.setBounds(10, 40, 665, 330);

        add(bExit);
        bExit.setBounds(300, 380, 100, 20);
    }

    public Object[] getHeader() {
        return header;
    }
    
    
}
