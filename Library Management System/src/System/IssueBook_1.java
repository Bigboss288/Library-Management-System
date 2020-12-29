package System;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class IssueBook_1 {
public static void main(String args[]) {
	issue1 issue=new issue1();
}
}
class issue1 extends JFrame{
	
     JTextField t;
     JLabel l1;
     JButton b;
     JTable tab;
    
	public issue1() {
	
	    l1=new JLabel("Back");
	    add(l1);
	    l1.setBounds(7, 8, 50, 30);
	    l1.setForeground(Color.white);
		t=new JTextField(15);
		t.setBackground(new Color(93,101,110));
		t.setForeground(Color.white);
	    add(t);
	    t.setBounds(160, 6,130, 22);
	    b=new JButton("Search");
	     add(b);
	    b.setBounds(290, 5,80, 26);
	    b.setBackground(new Color(0,170,204));
	    b.setForeground(Color.white);
	  
		
		
		
		tab=new JTable();
		tab.setBounds(50, 50, 200, 300);
		
		JScrollPane s=new JScrollPane(tab);
		add(s);
		
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String get=t.getText();
				try {
					
					String url="jdbc:mysql://localhost:3306/library";
				String name="root";
				String pass="Ayan@123";
				
			//	Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(url,name,pass);
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select *from books where subject like '%"+get+"%' ");
				tab.setModel(DbUtils.resultSetToTableModel(rs));
				ResultSet rss=st.executeQuery("select *from books where bookname like '%"+get+"%' ");
				tab.setModel(DbUtils.resultSetToTableModel(rss));
							
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
			}
			
		});
		l1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new issue();
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
		setVisible(true);
		setSize(500,400);
		setLayout(new FlowLayout());
		this.getContentPane().setBackground(new Color(69,77,87));
		//setDefaultCloseOperation(3);
	}
}