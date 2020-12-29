package System;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LoggedIn {
	public static void main(String args[]) {
		
		Log ll=new Log();
	}

}
class Log extends JFrame{
	
	JButton b1,b2,b3,b4;
	JLabel l,l1;
	public Log() {
		
	    l=new JLabel("Home");
		l.setBounds(170, 0, 100, 50);
		l.setForeground(new Color(171,185,201));
		l1=new JLabel();
		l1.setBounds(310, 10,60, 30);
		l1.setForeground(Color.white);
		b1=new JButton("User Info");
		b1.setBounds(10, 50, 100, 30);
		b1.setBackground(new Color(0,170,204));
		b1.setForeground(Color.white);
		b2=new JButton("Issue Book");
		b2.setBounds(10, 110, 100, 30);
		b2.setBackground(new Color(0,170,204));
		b2.setForeground(Color.white);
		b3=new JButton("return book");
		b3.setBounds(10, 170, 100, 30);
		b3.setBackground(new Color(0,170,204));
		b3.setForeground(Color.white);
		b4=new JButton("logout");
		b4.setBounds(10, 230, 100, 30);
		b4.setBackground(new Color(0,170,204));
		b4.setForeground(Color.white);
		
		b1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						new Info();
						
					}
				}
				);
		
		b2.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						new issue();
						
					}
				}
				);
		
		b3.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						new Return();
						
					}
			
				}
				);
		
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 try {
						String url="jdbc:mysql://localhost:3306/library";
						String uname="root";
						String pass="Ayan@123";
						
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection(url,uname,pass);
						Statement st=con.createStatement();
						st.executeUpdate("delete from session");
						JOptionPane.showMessageDialog(b4, "Logged Out");
						new abc();
						dispose();
						ResultSet rs=st.executeQuery("select *from session");
						rs.next();
						String a=rs.getString("id");
						System.out.println(a);
						
					}
					catch(Exception exception) {
						System.out.println();
					}
			}
			
		});
		
		add(l);
		add(l1);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		
		 try {
				String url="jdbc:mysql://localhost:3306/library";
				String uname="root";
				String pass="Ayan@123";
				
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection(url,uname,pass);
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select *from session");
				rs.next();
				String a=rs.getString("id");
				ResultSet rss=st.executeQuery("select firstname from register where id='"+a+"'");
				while(rss.next()) {
				String b =rss.getString("firstname");
				System.out.println(b);
				l1.setText("Hi, "+b);
				}
			}
			catch(Exception exception) {
				System.out.println();
			}
		
		this.setLayout(null);
		this.setSize(400,400);
		this.setVisible(true);
		setDefaultCloseOperation(3);
		this.getContentPane().setBackground(new Color(69,77,87));	
		}
		
	}
