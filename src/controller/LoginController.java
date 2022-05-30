package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.LoginModel;
import view.LoginView;

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
                
                System.out.println(username);
                System.out.println(password);
                if(loginModel.loginHandler(username, password)){
                    JOptionPane.showMessageDialog(null, "Login Success");
                }
            }
        });
        
    }
    
    
}
