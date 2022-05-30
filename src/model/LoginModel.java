package model;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class LoginModel {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/parking_db";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection connection;
    Statement statement;
    
    public LoginModel() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection Success");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Connection Failed");
        }
    }
    
    public boolean loginHandler(String user, String pass){
        int totalData = 0;
        try {
            String query = "SELECT * FROM `users` WHERE "
                    + "`username`='" + user + "' AND "
                    + "`password`='" + pass + "'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                totalData++;
            };
            
            statement.close();
            if(totalData>0){
                return true;
            }
            
            return false;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return false;
        } 
    }
    
}
