package pages;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginView extends JFrame{
    JLabel ltitle = new JLabel("Admin Login");
    
    JLabel lusername = new JLabel("Username");
    JTextField fusername = new JTextField();
    
    JLabel lpassword = new JLabel("Password");
    JPasswordField fpassword = new JPasswordField();
    
    JButton blogin = new JButton("Login");
    
    public LoginView() {
        setSize(800, 600);
        setTitle("Parking Admin System");
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        add(ltitle);
        add(lusername);
        add(lpassword);
        add(fusername);
        add(fpassword);
        add(blogin);
        
        ltitle.setBounds(365, 50, 75, 50);
        
        lusername.setBounds(275, 120, 100, 30);
        fusername.setBounds(275, 150, 250, 30);
        
        lpassword.setBounds(275, 180, 100, 30);
        fpassword.setBounds(275, 210, 250, 30);
        
        blogin.setBounds(300, 260, 200, 30);
        
        blogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = fusername.getText();
                String password = String.valueOf(fpassword.getPassword());
                
                System.out.println(username);
                System.out.println(password);
                if(username.equals("admin") && password.equals("admin123")){
                    System.out.println("Login Sukses");
                }
            }
        });
    }
    
}
