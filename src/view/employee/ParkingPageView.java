package view.employee;

import java.awt.Font;
import javax.swing.*;

public class ParkingPageView extends JFrame {
    int col1 = 165;
    int col2 = 400;
    
    String[] vType = {"Car", "Motorcycle"};
    JLabel lTotal = new JLabel("Parking Remain");
    JLabel lEmployee = new JLabel("Employee Name");
    JLabel lId = new JLabel("ID Transaction");
    JLabel lLicense = new JLabel("License Number");
    JLabel lType = new JLabel("Vehicle Type");
    JLabel lPrice = new JLabel("Total Price");
    JLabel lIn = new JLabel("In Time");
    JLabel lOut = new JLabel("Out Time");
    JLabel lIntime = new JLabel("");
    JLabel lOuttime = new JLabel("");
    
    JTextField tfId = new JTextField();
    JTextField tfLicense = new JTextField();
    JTextField tfPrice = new JTextField("Rp100.000");
    public JComboBox<String> cbVtype = new JComboBox<>(vType);
    
    public JButton bLogout = new JButton("Logout");
    public JButton bTotal = new JButton("");
    public JButton bIn = new JButton("In");
    public JButton bOut = new JButton("Out");
    public JButton bClear = new JButton("Clear");
    public JButton bCheck = new JButton("Check");
    public JButton bAuto = new JButton("Auto");
        
    public ParkingPageView() {
        Font  f2  = new Font(Font.SANS_SERIF,  Font.BOLD, 30);
        
        setSize(550, 600);
        setTitle("Parking Menu");
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        add(lTotal);
        lTotal.setBounds(20, 20, 100, 20);
        add(bTotal);
        bTotal.setBounds(20, 50, 90, 50);
        bTotal.setEnabled(false);
        bTotal.setFont(f2);
        
        add(lIn);
        lIn.setBounds(20, 120, 100, 20);
        
        add(lIntime);
        lIntime.setBounds(20, 140, 150, 20);
        
        add(lOut);
        lOut.setBounds(20, 180, 100, 20);
        
        add(lOuttime);
        lOuttime.setBounds(20, 200, 150, 20);
        
        add(bLogout);
        bLogout.setBounds(col2, 20, 100, 30);
        
        add(bCheck);
        bCheck.setBounds(col2, 240, 100, 30);
        
        add(bClear);
        bClear.setBounds(col2, 280, 100, 30);
        
        add(lEmployee);
        lEmployee.setBounds(col1, 20, 200, 20);
        
        add(lId);
        lId.setBounds(col1, 60, 200, 20);
        
        add(tfId);
        tfId.setBounds(col1, 80, 200, 30);
        
        add(bAuto);
        bAuto.setBounds(col2, 80, 100, 30);
        
        add(lLicense);
        lLicense.setBounds(col1, 120, 200, 20);
        
        add(tfLicense);
        tfLicense.setBounds(col1, 140, 200, 30);
        
        add(lType);
        lType.setBounds(col1, 180, 200, 20);
        
        add(cbVtype);
        cbVtype.setBounds(col1, 200, 200, 30);
        
        add(bIn);
        bIn.setBounds(col1, 240, 100, 30);
        
        add(bOut);
        bOut.setBounds(col1, 280, 100, 30);
        
        add(lPrice);
        lPrice.setBounds(col1, 320, 200, 20);
        
        add(tfPrice);
        tfPrice.setBounds(col1, 340, 200, 30);
        tfPrice.setEditable(false);
    }
    
    public void setUsername(String username){
        lEmployee.setText(username);
    }
    
    public void setLicense(String license){
        tfLicense.setText(license);
    }
    
    public void setPrice(String price){
        tfPrice.setText(price);
    }
    
    public void setId(String id){
        tfId.setText(id);
    }
    
    public void setIn(String in){
        lIntime.setText(in);
    }
    
    public void setOut(String out){
        lOuttime.setText(out);
    }
    
    public void setIdTrans(String id){
        tfId.setText(id);
    }
    
    public void setTypes(String type){
        if(type.equals("car")){
            cbVtype.setSelectedIndex(0);
        }else{
            cbVtype.setSelectedIndex(1);
        }
    }
    
    public String getId(){
        return tfId.getText();
    }
    
    public String getLicense(){
        return tfLicense.getText();
    }
    
    public String getTypes(){
        return cbVtype.getItemAt(cbVtype.getSelectedIndex());
    }
    
    
    public void clear(){
        tfLicense.setText("");
        tfId.setText("");
        tfPrice.setText("");
        lIntime.setText("");
        lOuttime.setText("");
        tfId.setEditable(true);
        tfLicense.setEditable(true);
        cbVtype.setEnabled(true);
        bIn.setEnabled(true);
        priceDisable();
    }
    
    public void setRemaining(String remain){
        bTotal.setText(remain);
    }
    
    public void priceVisible(){
        lPrice.setVisible(true);
        tfPrice.setVisible(true);
    }
    
    public void priceDisable(){
        lPrice.setVisible(false);
        tfPrice.setVisible(false);
    }
    
    public void allDisabled(){
        tfId.setEditable(false);
        tfLicense.setEditable(false);
        cbVtype.setEnabled(false);
        bIn.setEnabled(false);
    }
    
}
