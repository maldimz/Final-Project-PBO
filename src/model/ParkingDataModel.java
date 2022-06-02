package model;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class ParkingDataModel extends Connector implements Calculate{
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public ParkingDataModel() {
        
    }
    
    public String readRemaining(){
        String data = "";
        try {
            String query = "SELECT * FROM `setting`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                data = resultSet.getString("remain");
            }
            statement.close();
            return data;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return data;
        }
    }
    
    public int checkId(){
        int data = 0;
        try {
            String query = "SELECT * FROM `recap`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                data = resultSet.getInt("id");
            }
            statement.close();
            
            return data;
        } catch (Exception e) {
            
            System.out.println("Error : " + e.getMessage());
            return 0;
        }
    }
    
    public boolean insertParking(String id, String license, String type, String user_id){
        Date dateNow = new Date();
        String types;
        if(type.equals("Car")){
            types = "car";
        }else{
            types = "motorcycle";
        }
        try {
            String query = "INSERT INTO `recap` "
                    + "(`id`, `license`, `type`, `in_time`, `user_id`) "
                    + "VALUES "
                    + "(" + id+ ""
                    + ",'"+ license + "'"
                    + ",'" + types + "'"
                    + ",'" + formatter.format(dateNow) + "'"
                    + ",'" + user_id + "')";
            
            statement = connection.createStatement();
            statement.executeUpdate(query);
            
            statement.close();
            
            int remain = Integer.parseInt(readRemaining());
            remain--;
            
            updateRemain(String.valueOf(remain));
            
            JOptionPane.showMessageDialog(null, "Input Success");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed : " + e.getMessage());
            return false;
        }
    }
    
    public void updateRemain(String remain){
        try {
            String query = "UPDATE `setting` "
                    + "SET "
                    + "`remain`=" + remain + "";
            
            statement = connection.createStatement();
            statement.executeUpdate(query);
            
            statement.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public boolean checkInput(String id){
        try {
            int totalData = 0;
            String query = "SELECT * FROM `recap` WHERE `id`='" + id + "'" 
                    + " AND `price`=0";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                totalData++;
            }
            statement.close();
            
            if(totalData>0){
                return true;
            }
            
            JOptionPane.showMessageDialog(null, "No Data");
            return false;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return false;
        }
    }
    
    public String[] readParkingData(String id){
        String[] data = new String[5];
        try {
            String query = "SELECT * FROM `recap` WHERE `id`=" + id;
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                data[0] = resultSet.getString("id");
                data[1] = resultSet.getString("license");
                data[2] = resultSet.getString("type");
                data[3] = resultSet.getString("in_time");
                data[4] = resultSet.getString("price");
            }
            statement.close();

            return data;
            
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Check Failed");
            return null;
        }
    }
    
    public void outParking(String id){
        try {
            String[] data = readParkingData(id);
            Date d1 = formatter.parse(data[3]);
            Date d2 = new Date();
            
            long time = d2.getTime() - d1.getTime();
            long diffHours = time / (60 * 60 * 1000);
            
            long total = totalPrice(diffHours, data[2]);
       
            updateParking(total, formatter.format(d2), id);
            
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public void updateParking(long total, String format, String id){
        try {
            String query = "UPDATE `recap` "
                    + "SET "
                    + "`price`='" + total + "', "
                    + "`out_time`='" + format + "' "
                    + "WHERE `id`=" + id;
            
            statement = connection.createStatement();
            statement.executeUpdate(query);
            
            statement.close();
            
            int remain = Integer.parseInt(readRemaining());
            remain++;
            
            updateRemain(String.valueOf(remain));
            
            JOptionPane.showMessageDialog(null, "Update Success");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public String[] getTimeAndPrice(String id){
        String[] data = new String[2];
        try {
            String query = "SELECT * FROM `recap` WHERE `id`=" + id;
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                data[0] = resultSet.getString("price");
                data[1] = resultSet.getString("out_time");
            }
            statement.close();

            return data;
            
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Failed");
            return null;
        }
    }
    @Override
    public long totalPrice(long time, String type) {
        long first=0, add=0;
        
        if(type.equals("car")){
            first = 5000;
            add = 2000;
        }else{
            first = 2000;
            add = 1000;
        }
        
        if(time<=1){
            return first;
        }
        
        if(time>1){
            return first + (time*add);
        }
        
        if(time >= 24){
            return first + (24*add);
        }
        
        return 0;
    }
}
