package System;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
public class Login {
	
public static void main(String args[])throws Exception {
	abc obj=new abc();	
}
}

class abc extends JFrame 

{
	
	
	JButton b1,b2;
	JLabel l1,l2,l3,l4;
	JTextField t1,t2;
	JPasswordField p;
	public abc() {
		
		 l1=new JLabel("Library Management System");
		 l1.setBounds(110, 0, 300, 100);
		 l1.setForeground(new Color(171,185,201));
		 l2=new JLabel("Email ID");
		 l2.setBounds(100, 80, 100, 50);
		 l2.setForeground(Color.white);
		 l3=new JLabel("password");
		 l3.setBounds(87, 105, 100, 50);
		 l3.setForeground(Color.white);
		 b1=new JButton("Login");
		 b1.setBounds(200, 160, 90, 28);
		 b1.setBackground(new Color(0,170,204));
		 b1.setForeground(Color.white);
		 b2=new JButton("Register");
		 b2.setBounds(100, 160, 90, 28);
		 b2.setBackground(new Color(0,170,204));
		 b2.setForeground(Color.white);
		 t1=new JTextField(10);
		 t1.setBounds(155, 97, 130, 20);
		 t1.setBackground(new Color(93,101,110));
		 t1.setForeground(Color.white);
		 l4=new JLabel();
		 add(l4);
		 l4.setBounds(30, 30, 100, 100);
	    
		 p=new JPasswordField();
		 p.setBounds(155, 122, 130, 20);
		 p.setBackground(new Color(93,101,110));	
		 p.setForeground(Color.white);
		 b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name=t1.getText();
				char[] ch=p.getPassword();
				String passw=new String(ch);
				
				 try{
				    	String url="jdbc:mysql://localhost:3306/library";
						String uname="root";
						String pass="Ayan@123";
						String query="select * from register where email='"+name+"' and password='"+passw+"'";
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection(url,uname,pass);
						Statement st=con.createStatement();
						ResultSet rs=st.executeQuery(query);
						
						if(rs.next()) {
					    new Log();
					    dispose();
						
						}
						else {
							JOptionPane.showMessageDialog(b1, "Incorrect Credentials");
						}
						ResultSet rss=st.executeQuery("select id from register where email='"+name+"'");
						rss.next();
						String id=rss.getString("id");
						st.executeUpdate("insert into session value('"+id+"')");
						System.out.println(id);
						
					}
				       
					catch(Exception exception) {
						System.out.println();
					}
			}
			 
		 });
	 
		 b2.addActionListener(new ActionListener() 
				 {
					public void actionPerformed(ActionEvent e) {
						
						new Reg();
						dispose();
						
					}
			 
				 }
				 );
			 
		 
		
		add(l1);
		add(l2);
		add(t1);
		add(l3);
		add(p);
		add(b1);
		add(b2);
		
		this.setLayout(null);
		this.setSize(400,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.getContentPane().setBackground(new Color(64,70,77));
		
	}
	
	
		
	}












