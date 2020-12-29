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
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class IssueBook {
	public static void main(String args[]) {
		issue obj=new issue();
	}

}
class issue extends JFrame{
	
	JTextField t1,t2,t3,t4,t5;
	JLabel l1,l2,l3,l4,l5;
	JButton b1,b2,b3;
    JFormattedTextField f1,f2;
    
	public issue() {
		
		t1=new JTextField(10);
		t2=new JTextField(10);
		DateFormat df=new SimpleDateFormat("yyyy-mm-dd");
		f1=new JFormattedTextField(df);
		f2=new JFormattedTextField(df);
		t5=new JTextField(10);
		
		l1=new JLabel("user id");
		l2=new JLabel("book id");
		l3=new JLabel("Issue Date");
		l4=new JLabel("Due Date");
		l5=new JLabel("Back");

		
		b1=new JButton("Issue");
		b2=new JButton("Search");
		
		b1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						
						String uid=t1.getText();
						String bookid=t2.getText();
						String idate=f1.getText();
						String ddate=f2.getText();	
						String Search=t5.getText();
						
                         try {
							String url="jdbc:mysql://localhost:3306/library";
							String uname="root";
							String pass="Ayan@123";
							
							
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con=DriverManager.getConnection(url,uname,pass);
							Statement st=con.createStatement();
							ResultSet rs=st.executeQuery("select *from register where id='"+uid+"'");
							if(rs.next()) {
								ResultSet rss=st.executeQuery("select *from books where bookid='"+bookid+"'");
								if(rss.next()) {
									 int x=st.executeUpdate("insert into issue values('"+uid+"','"+bookid+"','"+idate+"','"+ddate+"')");
									JOptionPane.showMessageDialog(b1, "Book Successfully Issued");
								}
								else {
									JOptionPane.showMessageDialog(b1, "incorrect BookID");
								}
							}
							else {
								JOptionPane.showMessageDialog(b1, "Incorrect StudentID");
							}
							
						}
						catch(Exception exception) {
							System.out.println();
						}
							
						}
					});
		b2.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						new issue1();
						dispose();
					}
			
				}
				);
		l5.addMouseListener(new MouseListener() {

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
	
	//	add(t5);
	//	t5.setBounds(190, 4, 110, 22);
		add(b2);
		b2.setBounds(290, 10, 80, 28);
		b2.setBackground(new Color(0,170,204));
		b2.setForeground(Color.white);
		add(l1);
		l1.setBounds(96, 70, 100, 50);
		l1.setForeground(Color.white);
		add(t1);
		t1.setBounds(142, 86, 110, 22);
		 t1.setBackground(new Color(93,101,110));
		 t1.setForeground(Color.white);
		add(l2);
		l2.setBounds(95, 100, 100, 50);
		l2.setForeground(Color.white);
		add(t2);
		t2.setBounds(142, 116, 110, 22);
		 t2.setBackground(new Color(93,101,110));
		 t2.setForeground(Color.white);
		add(l3);
		l3.setBounds(77, 130, 100, 50);
		l3.setForeground(Color.white);
		add(f1);
		f1.setBounds(142, 146, 110, 22);
		 f1.setBackground(new Color(93,101,110));
		 f1.setForeground(Color.white);
		add(l4);
		l4.setBounds(85,160, 100, 50);
		l4.setForeground(Color.white);
		add(f2);
		f2.setBounds(142,176, 110, 22);
		 f2.setBackground(new Color(93,101,110));
		 f2.setForeground(Color.white);
		 add(l5);
		 l5.setBounds(5, 5, 30, 20);
		 l5.setForeground(Color.white);
		add(b1);
		b1.setBounds(135,225,110,26);
		b1.setBackground(new Color(0,170,204));
		b1.setForeground(Color.white);
		
		
		add(l5);
		
	
		
		setLayout(null);
		setVisible(true);
		setSize(400,400);
		//setDefaultCloseOperation(3);
		this.getContentPane().setBackground(new Color(64,70,77));
		
	}
}
