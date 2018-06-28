package examinationmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExaminationManagementSystem {
    public static String ques;
    String op1,op2,op3,op4;
    
    public void admin() throws SQLException{
        Connection con;
        try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Akash","priya");
        System.out.println("connected with AKASH");   
        Statement stmt=con.createStatement(); 
        ResultSet rs=stmt.executeQuery("select * from quiz");  
     //   while(rs.next())  
        rs.next();
        ques=rs.getString(1);
        op1=rs.getString(2);
        op2=rs.getString(3);
        op3=rs.getString(4);
        op4=rs.getString(5);
        //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5));  
        System.out.println(ques+" "+op1+" "+op2+" "+op3+" "+op4+" ok bro");
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
      System.out.println(ques);
    }
    
}
