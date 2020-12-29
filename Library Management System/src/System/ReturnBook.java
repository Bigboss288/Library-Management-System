package System;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ReturnBook {
	public static void main(String args[]) {
		Return r=new Return();
	}

}
class Return extends JFrame
{
	JButton b1,b2;
	JLabel l1,l2,l3;
	JTextField t1,t2;
	public Return() {
		l1=new JLabel("Student ID");
		l2=new JLabel("Book ID");
		l3=new JLabel("Back");
		t1=new JTextField(10);
		t2=new JTextField(10);
		b1=new JButton("return Book");
		b2=new JButton("Fine");
	
		
		add(l1);
		l1.setBounds(80, 58, 100, 50);
		l1.setForeground(Color.white);
		add(t1);
		t1.setBounds(145, 70, 110, 22);
		t1.setBackground(new Color(93,101,110));
		t1.setForeground(Color.white);
		add(l2);
		l2.setBounds(94, 96,100, 50);
		l2.setForeground(Color.white);
		add(t2);
		t2.setBounds(145, 110, 110, 22);
		t2.setBackground(new Color(93,101,110));
		t2.setForeground(Color.white);
		add(b1);
		b1.setBounds(140, 160, 110, 26);
		b1.setBackground(new Color(0,170,204));
		b1.setForeground(Color.white);
		add(l3);
		l3.setBounds(7, 8, 50, 10);
		l3.setForeground(Color.white);
		
		
		
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String uid=t1.getText();
				String bid=t2.getText();
				  try {
						String url="jdbc:mysql://localhost:3306/library";
						String uname="root";
						String pass="Ayan@123";
						
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection(url,uname,pass);
						Statement st=con.createStatement();
						int rs=st.executeUpdate("delete from issue where uid='"+uid+"' and bookid='"+bid+"'");
						
						JOptionPane.showMessageDialog(b1, "Book returned");
						
					}
					catch(Exception exception) {
						System.out.println();
					}
						
					
			}
			
		}
				);
		
		l3.addMouseListener(new MouseListener() {

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
	
		setLayout(null);
		setSize(400,400);
		setVisible(true);
		//setDefaultCloseOperation(3);
		this.getContentPane().setBackground(new Color(69,77,87));
	}
}