package System;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Random;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

public class Register {
	public static void main(String args[]) {
		
		Reg rr=new Reg();
	}

}

class Reg extends JFrame implements ActionListener{
	
	JButton b,b1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JRadioButton r1,r2;
	JFormattedTextField f;
	
	public Reg() {
		
		l1=new JLabel("First Name");
		l2=new JLabel("Last Name");
		l3=new JLabel("Date of Birth");
		l4=new JLabel("Address");
		l5=new JLabel("Mobile No.");
		l6=new JLabel("Email");
		l7=new JLabel("Institution");
		l8=new JLabel("Password");
		l9=new JLabel("Gender");
		l10=new JLabel("Male");
		l11=new JLabel("Female");
		t1=new JTextField(5);
		t2=new JTextField(5);
		t3=new JTextField(5);
		t4=new JTextField(5);
		t5=new JTextField(5);
		t6=new JTextField(5);
		t7=new JTextField(5);
		t8=new JTextField(5);
		DateFormat df=new SimpleDateFormat("yyyy-mm-dd");
		f=new JFormattedTextField(df);
		r1=new JRadioButton("M");
		r2=new JRadioButton("F");
		b=new JButton("Register");	
		b1=new JButton("Back");
		
		
		add(l1);
		l1.setBounds(65, 30, 100, 50);
		l1.setForeground(Color.white);
		add(t1);
		t1.setBounds(130, 45, 100,22);
		t1.setBackground(new Color(93,101,110));
		t1.setForeground(Color.white);
		add(l2);
		l2.setBounds(300, 30,100 ,50);
		l2.setForeground(Color.white);
    	add(t2);
    	t2.setBounds(365, 45, 100, 22);
    	t2.setBackground(new Color(93,101,110));
		t2.setForeground(Color.white);
		add(l3);
		l3.setBounds(56, 70, 100,50);
		l3.setForeground(Color.white);
		add(f);
		f.setBounds(130, 85, 100,22);
		f.setBackground(new Color(93,101,110));
		f.setForeground(Color.white);
		add(l4);
		l4.setBounds(78, 109, 100,50);
		l4.setForeground(Color.white);
		add(t4);
		t4.setBounds(130, 125, 100,22);
		t4.setBackground(new Color(93,101,110));
		t4.setForeground(Color.white);
		add(l5);
		l5.setBounds(67, 147, 100,50);
		l5.setForeground(Color.white);
		add(t5);
		t5.setBounds(130, 165, 100,22);
		t5.setBackground(new Color(93,101,110));
		t5.setForeground(Color.white);
		add(l6);
		l6.setBounds(329, 82, 100,50);
		l6.setForeground(Color.white);
		add(t6);
		t6.setBounds(365, 97, 100,22);
		t6.setBackground(new Color(93,101,110));
		t6.setForeground(Color.white);
		add(l7);
		l7.setBounds(306, 190, 100,50);
		l7.setForeground(Color.white);
		add(t7);
		t7.setBounds(365, 205, 100,22);
		t7.setBackground(new Color(93,101,110));
		t7.setForeground(Color.white);
		add(l8);
		l8.setBounds(67, 189, 100, 50);
		l8.setForeground(Color.white);
		add(t8);
		t8.setBounds(130, 205, 100, 22);
		t8.setBackground(new Color(93,101,110));
		t8.setForeground(Color.white);
		add(l9);
		l9.setBounds(320, 135, 100, 50);
		l9.setForeground(Color.white);
		add(l10);
		l10.setBounds(385, 135, 100, 50);
		l10.setForeground(new Color(171,185,201));
		add(l11);
		l11.setBounds(434, 135, 100, 50);
		l11.setForeground(new Color(171,185,201));
		add(r1);
		r1.setBounds(367, 154, 15, 15);
		r1.setBackground(new Color(64,70,77));
		add(r2);
		r2.setBounds(417, 154, 15, 15);
		r2.setBackground(new Color(64,70,77));
		add(b);
		b.setBounds(210, 265, 150,26);
		b.setBackground(new Color(0,170,204));
		b.setForeground(Color.white);
	    add(b1);
		b1.setBounds(159,225, 100, 22);
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		b.addActionListener(this);
				
		setVisible(true);
		setLayout(null);
	    this.setResizable(false);
		setSize(600,600);
		setDefaultCloseOperation(3);
		this.getContentPane().setBackground(new Color(64,70,77));
		this.setTitle("Registration Page");
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Random r=new Random();
		int rr1=r.nextInt(1000);
		int rr2=r.nextInt(1000);
		
		
		    String fname=t1.getText();
            String lname=t2.getText();
			String DOB=f.getText();
			String Add=t4.getText();
			String mob=t5.getText();
			int len=mob.length();
			String eml=t6.getText();
			String inst=t7.getText();
			String passw=t8.getText();
			String id1=String.valueOf(rr1+rr2);
			String id2="#";
			String id=id2+id1;
			if(len!=10) {
				JOptionPane.showMessageDialog(b1, "Enter a valid Mobile Number");
			}
		
			try {
				String url="jdbc:mysql://localhost:3306/library";
				String uname="root";
				String pass="Ayan@123";
				
				
		//		Class.forName("com.mysql.jdbc.cj.Driver");
				Connection con=DriverManager.getConnection(url,uname,pass);
				Statement st=con.createStatement();
			    
			    if(r1.isSelected()) {
			    int x=st.executeUpdate("insert into register values('"+id+"','"+fname+"','"+lname+"','"+DOB+"','"+eml+"','"+Add+"','"+mob+"',\"Male\",'"+inst+"','"+passw+"')");
				if(x==0) {
					JOptionPane.showMessageDialog(b,"Already Registered");
				}
				else {
					JOptionPane.showMessageDialog(b, "account successfully registered.Your id is" +id);
					new abc();
					dispose();
				}}
				else {
					int x=st.executeUpdate("insert into register values('"+id+"','"+fname+"','"+lname+"','"+DOB+"','"+eml+"','"+Add+"','"+mob+"',\"Female\",'"+inst+"','"+passw+"')");
				}
				new abc();
				dispose();
			    
			    
			    st.close();
			    con.close();
			}
			catch(Exception ex) {
			
				System.out.println(ex);
			}
		}
	

		
	}

