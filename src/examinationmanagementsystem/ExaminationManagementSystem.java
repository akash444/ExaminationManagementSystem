package examinationmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExaminationManagementSystem {
    
    public void admin() throws SQLException{
        Connection con;
        try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AKASH","java");
        System.out.println("connected with AKASH");           
        }
        
        catch(ClassNotFoundException e){
            System.out.println("Cant able to load the driver");
        }
        catch(SQLException e){
            System.out.println("cant able to connect with system");
                     
        }
        
    }

    public static void main(String[] args) throws SQLException {
      ExaminationManagementSystem ex = new ExaminationManagementSystem();
      ex.admin();
    }
    
}
