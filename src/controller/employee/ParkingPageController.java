package controller.employee;

import controller.LoginController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.LoginModel;
import model.ParkingDataModel;
import view.LoginView;
import view.employee.ParkingPageView;

public class ParkingPageController {
    ParkingDataModel parkingDataModel;
    ParkingPageView parkingPageView;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date;
    
    
    public ParkingPageController(ParkingDataModel parkingDataModel, ParkingPageView parkingPageView, String username) {
        this.parkingDataModel = parkingDataModel;
        this.parkingPageView = parkingPageView;
        
        
        parkingPageView.setUsername(username);
        parkingPageView.priceDisable();
        parkingPageView.bOut.setEnabled(false);
        parkingPageView.setRemaining(parkingDataModel.readRemaining());
        
        parkingPageView.bLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                LoginView LoginView = new LoginView();
                LoginModel LoginModel = new LoginModel();
                LoginController LoginController = new LoginController(LoginModel, LoginView);
                parkingPageView.dispose();
                
                JOptionPane.showMessageDialog(null, "Logout Success");
            }
        });
        
        parkingPageView.bCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String[] data;
                String id = parkingPageView.getId();
                parkingPageView.bOut.setEnabled(true);
                if(id.equals("")){
                    JOptionPane.showMessageDialog(null, "Cannot be empty");
                }else{
                    if(parkingDataModel.checkInput(id)){
                        data = parkingDataModel.readParkingData(id);
                        parkingPageView.setId(data[0]);
                        parkingPageView.setLicense(data[1]);
                        parkingPageView.setTypes(data[2]);
                        parkingPageView.setIn(data[3]);
                        parkingPageView.allDisabled();
                        JOptionPane.showMessageDialog(null, "Read Success");
                    }
                }         
            }
        });
        
        parkingPageView.bClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                parkingPageView.clear();
                parkingPageView.bOut.setEnabled(false);
                parkingPageView.setRemaining(parkingDataModel.readRemaining());
            }
        });
        
        parkingPageView.bIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {        
                //input
                int check = Integer.parseInt(parkingDataModel.readRemaining());
                
                if(check<=0){
                    JOptionPane.showMessageDialog(null, "Parking Full");
                }else{
                    String id = parkingPageView.getId();
                    String license = parkingPageView.getLicense();
                    String type = parkingPageView.getTypes();

                    if(id.equals("") || license.equals("")){
                        JOptionPane.showMessageDialog(null, "Cannot be Empty");
                    }else{
                        if(parkingDataModel.insertParking(id, license, type, username)){
                            date = new Date();
                            parkingPageView.setRemaining(parkingDataModel.readRemaining());
                            parkingPageView.setIn(formatter.format(date));
                        }
                        
                    }
                }            
            }
        });
        
        parkingPageView.bAuto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int id = parkingDataModel.checkId();
                id++;
                parkingPageView.setIdTrans(String.valueOf(id));
            }
        });
        
        parkingPageView.bOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String id = parkingPageView.getId();
                System.out.println("id " + id);  
                parkingDataModel.outParking(id);
                String[] data = parkingDataModel.getTimeAndPrice(id);
                parkingPageView.priceVisible();
                parkingPageView.setPrice("Rp" + data[0]);
                parkingPageView.setOut(data[1]);
                parkingPageView.setRemaining(parkingDataModel.readRemaining());
                parkingPageView.bOut.setEnabled(false);
            }
        });
          
    }
    
    
}
