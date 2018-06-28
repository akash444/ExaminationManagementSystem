package examinationmanagementsystem;

/*Online Java Paper Test*/

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener        
{
    String ques,op1,op2,op3,op4;
    public void admin() throws SQLException{
        Connection con;
        try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Akash","priya");
        System.out.println("connected with AKASH");
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from quiz");     
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
    
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];	
	OnlineTest(String s)
	{
		super(s);
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set();
		l.setBounds(30,40,450,20);
		jb[0].setBounds(50,80,100,20);
		jb[1].setBounds(50,110,100,20);
		jb[2].setBounds(50,140,100,20);
		jb[3].setBounds(50,170,100,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();	
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();	
			if(current==9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Bookmark"+y))
		{
			if(check())
				count=count+1;
			now=current;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		}
	
		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			current++;
			//System.out.println("correct ans="+count);
			JOptionPane.showMessageDialog(this,"correct ans="+count);
			System.exit(0);
		}
	}
	void set()
	{
          //startin to connect with oracle 11g xe eddtion
        Connection con;
        
        try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Akash","priya");
        System.out.println("connected with AKASH");
        //if the user name and passwork ok then you are connected to oracle
        Statement stmt=con.createStatement();//by createing stmt object you can run or execute sql query 
        ResultSet rs=stmt.executeQuery("select * from quiz");   //by using executeQuery method you can run sql query  
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
      
            
            
            
            
            
            
		jb[4].setSelected(true);
                System.out.println("kuch nahi "+ques);
                
		if(current==0)
		{
			l.setText("Ques1 - "+ques);
			jb[0].setText(op1);jb[1].setText(op2);jb[2].setText(op3);jb[3].setText(op4);	
		}
                
		if(current==1)
		{
			l.setText("Ques2 - "+ques);
			jb[0].setText(op1);jb[1].setText(op2);jb[2].setText(op3);jb[3].setText(op4);
		}
		if(current==2)
		{
			l.setText("Ques3 - "+ques);
			jb[0].setText(op1);jb[1].setText(op2);jb[2].setText(op3);jb[3].setText(op4);
		}
		if(current==3)
		{
			l.setText("Ques4 - "+ques);
			jb[0].setText(op1);jb[1].setText(op2);jb[2].setText(op3);jb[3].setText(op4);
		}
		if(current==4)
		{
			l.setText("Ques5 - "+ques);
			jb[0].setText(op1);jb[1].setText(op2);jb[2].setText(op3);jb[3].setText(op4);
		}
		if(current==5)
		{
			l.setText("Ques6 - "+ques);
			jb[0].setText(op1);jb[1].setText(op2);jb[2].setText(op3);jb[3].setText(op4);
		}
		if(current==6)
		{
			l.setText("Ques7 - "+ques);
			jb[0].setText(op1);jb[1].setText(op2);jb[2].setText(op3);jb[3].setText(op4);
		}
		if(current==7)
		{
			l.setText("Ques8 - "+ques);
			jb[0].setText(op1);jb[1].setText(op2);jb[2].setText(op3);jb[3].setText(op4);		
		}
		if(current==8)
		{
			l.setText("Ques9 - "+ques);
			jb[0].setText(op1);jb[1].setText(op2);jb[2].setText(op3);jb[3].setText(op4);
		}
		if(current==9)
		{
			l.setText("Ques10 - "+ques);
			jb[0].setText(op1);jb[1].setText(op2);jb[2].setText(op3);jb[3].setText(op4);
		}
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	boolean check()
	{
		if(current==0)
			return(jb[0].isSelected());
		if(current==1)
			return(jb[2].isSelected());
		if(current==2)
			return(jb[3].isSelected());
		if(current==3)
			return(jb[0].isSelected());
		if(current==4)
			return(jb[2].isSelected());
		if(current==5)
			return(jb[2].isSelected());
		if(current==6)
			return(jb[1].isSelected());
		if(current==7)
			return(jb[3].isSelected());
		if(current==8)
			return(jb[1].isSelected());
		if(current==9)
			return(jb[2].isSelected());
		return false;
	}
	public static void main(String s[]) throws SQLException
	{
               // ExaminationManagementSystem ems = new ExaminationManagementSystem();
                //ems.admin();
		new OnlineTest("Online Test Of Java");
               //  System.out.println(ques);
	}


}
