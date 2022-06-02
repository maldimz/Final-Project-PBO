package controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.AdminModel;
import view.admin.DataParkingView;


public class DataParkingController {
    AdminModel adminModel;
    DataParkingView dataParkingView;

    public DataParkingController(AdminModel adminModel, DataParkingView dataParkingView) {
        this.adminModel = adminModel;
        this.dataParkingView = dataParkingView;
        
        if(adminModel.getRecapData()>0){
            String dataUser[][] = adminModel.readAllRecap();
            dataParkingView.table.setModel((
                    new JTable(dataUser, dataParkingView.getHeader())).getModel()
            );
            
        }else{
            JOptionPane.showMessageDialog(null, "No Data");
        }
        
        dataParkingView.bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dataParkingView.dispose();
            }
        });
    }
    
    
}
