package controller;

import controller.admin.AdminController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.AdminModel;
import model.LoginModel;
import view.LoginView;
import view.admin.AdminView;
import view.employee.ParkingPageView;

public class LoginController {
    LoginModel loginModel;
    LoginView loginView;

    public LoginController(LoginModel loginModel, LoginView loginView) {
        this.loginModel = loginModel;
        this.loginView = loginView;
        
        loginView.blogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String username = loginView.getUsername();
                String password = loginView.getPassword();
                
                if(loginModel.loginHandler(username, password)){
                    JOptionPane.showMessageDialog(null, "Login Success");
                    if(loginModel.isAdmin(username, password)){
                        AdminView adminView = new AdminView();
                        AdminModel adminModel = new AdminModel();
                        AdminController AdminController = new AdminController(adminModel, adminView);
                    }else{
                        ParkingPageView parkingPageView = new ParkingPageView();
                    }
                    loginView.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Login Failed");
                }
            }
        });
        
    }
    
    
}
