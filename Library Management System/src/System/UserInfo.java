package System;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

import net.proteanit.sql.DbUtils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

public class UserInfo {
	public static void main(String args[]) {
		Info f=new Info();
	}

}
class Info extends JFrame{
	
	JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JTable t;
	public Info() {
		JPanel panel=new JPanel();
		l=new JLabel("back");
		add(l);
		l.setBounds(7, 0, 30, 30);
		l.setForeground(Color.white);
		l1=new JLabel();
		add(l1);
		l1.setBounds(50, 30, 200, 50);
		l1.setForeground(Color.white);
		l2=new JLabel();
		add(l2);
		l2.setBounds(75, 50, 200, 50);
		l2.setForeground(Color.white);
		l3=new JLabel();
		add(l3);
		l3.setBounds(79, 70, 100, 50);
		l3.setForeground(Color.white);
		l4=new JLabel();
		add(l4);
		l4.setBounds(82, 90, 200, 50);
		l4.setForeground(Color.white);
		l5=new JLabel();
		add(l5);
		l5.setBounds(73, 110, 300, 50);
		l5.setForeground(Color.white);
		l6=new JLabel();
		add(l6);
		l6.setBounds(75, 130, 300, 50);
		l6.setForeground(Color.white);
		l7=new JLabel();
		add(l7);
		l7.setBounds(320, 0, 100, 50);
		l7.setForeground(Color.white);
		l8=new JLabel();
		add(l8);
		l8.setBounds(50, 160, 200, 300);
		l8.setForeground(Color.white);
		t=new JTable();
		add(t);
		
		l.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new Log();
				dispose();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
					
		String a="";
		String b="";
					try {
						
						String url="jdbc:mysql://localhost:3306/library";
					String name="root";
					String pass="Ayan@123";
					
				//	Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection(url,name,pass);
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select *from session");
					rs.next();
					String id=rs.getString("id");
					System.out.println(id);
					ResultSet rss=st.executeQuery("select *from register where id='"+id+"'");
					while(rss.next()) {
				     a=rss.getString("firstname");
					 b=rss.getString("lastname");
					String c=rss.getString("dob");
					String d=rss.getString("email");
					String e=rss.getString("gender");
					String f=rss.getString("mobile");
					String g=rss.getString("address");
					String h=rss.getString("Institution");
					String i=rss.getString("id");
					
					l1.setText("Date of Birth : "+c);
					l2.setText("Email ID : "+d);
					l3.setText("Gender : "+e);
					l4.setText("Mobile : "+f);
					l5.setText("Address : "+g);
					l6.setText("Institute : "+h);
					l7.setText("ID: "+i);
					}
					ResultSet rs1=st.executeQuery("select bookid from issue where uid='"+id+"'");
					while(rs1.next()) {
						String aa=rs1.getString("bookid");
						
						l8.setText(aa);
					}
			
					}
					catch(Exception ex) {
						System.out.println(ex);
					}
					
		setTitle(a+" "+b);		
		setLayout(null);
		setSize(400,400);
		setVisible(true);
		//setDefaultCloseOperation(3);
		this.getContentPane().setBackground(new Color(69,77,87));
	}
}
