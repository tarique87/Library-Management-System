package Sorting;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Display_record.Student_Display;
import Display_record.student;
import login_form.database;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Sort_Student extends JFrame {

	private JPanel contentPane;
	student std;
	Connection con;

	
	public Sort_Student() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 626, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setPreferredSize(new Dimension(100, 40));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sorting");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(260, 0, 78, 40);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Sort on Student ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(92, 65, 139, 30);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sort on Student Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(358, 65, 165, 30);
		panel_1.add(lblNewLabel_2);
		
		JButton b1 = new JButton("Sort");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					con=database.getConnection();
					PreparedStatement pst=con.prepareStatement("select * from student order by student_id");
				
						ResultSet rs=pst.executeQuery();
						ArrayList<student> arr=new ArrayList<student>();
						int student_id;
						String name;
						String cls;
						int roll;
						long number;
						String address;
						int issued_book;
						Date date1;
						
						while(rs.next())
						{
							
							student_id=rs.getInt("student_ID");
							name=rs.getString("name");
							cls=rs.getString("class");
							roll=rs.getInt("roll");
							number=rs.getLong("mobile");
							address=rs.getString("address");
							issued_book=rs.getInt("Issued_Book");
							date1=rs.getDate("date1");
							std=new student();
							
							std.setStudent_id(student_id);
							std.setName(name);  
							std.setCls(cls);
							std.setRoll(roll);
							std.setNumber(number);
							std.setAddress(address);
							std.setIssued_book(issued_book);
							std.setDate1(date1);
							arr.add(std);
							
							
							
							
						}
						if(arr.isEmpty())
						{
							JOptionPane.showMessageDialog(null, "Data not found");
							return;
						}
						Student_Display sd=new Student_Display();
						sd.dtm.getDataVector().removeAllElements();
					
						Object arr1[]=new Object[8];
						for(student data:arr)
						{
							arr1[0]=data.getStudent_id();
							arr1[1]=data.getName();
							arr1[2]=data.getCls();
							arr1[3]=data.getRoll();
							arr1[4]=data.getNumber();
							arr1[5]=data.getAddress();
							arr1[6]=data.getIssued_book();
							arr1[7]=data.getDate1();
							
							
							sd.dtm.addRow(arr1);
							
							sd.setVisible(true);
						
						
							
							
						}
						JOptionPane.showMessageDialog(null, "Sort record successfully");
				
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		b1.setFont(new Font("Tahoma", Font.BOLD, 14));
		b1.setBounds(114, 141, 89, 23);
		panel_1.add(b1);
		
		JButton b2 = new JButton("Sort");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
try {
					
					con=database.getConnection();
					PreparedStatement pst=con.prepareStatement("select * from student order by name");
				
						ResultSet rs=pst.executeQuery();
						ArrayList<student> arr=new ArrayList<student>();
						int student_id;
						String name;
						String cls;
						int roll;
						long number;
						String address;
						int issued_book;
						Date date1;
						
						while(rs.next())
						{
							
							student_id=rs.getInt("student_ID");
							name=rs.getString("name");
							cls=rs.getString("class");
							roll=rs.getInt("roll");
							number=rs.getLong("mobile");
							address=rs.getString("address");
							issued_book=rs.getInt("Issued_Book");
							date1=rs.getDate("date1");
							std=new student();
							
							std.setStudent_id(student_id);
							std.setName(name);  
							std.setCls(cls);
							std.setRoll(roll);
							std.setNumber(number);
							std.setAddress(address);
							std.setIssued_book(issued_book);
							std.setDate1(date1);
							arr.add(std);
							
							
							
							
						}
						if(arr.isEmpty())
						{
							JOptionPane.showMessageDialog(null, "Data not found");
							return;
						}
						Student_Display sd=new Student_Display();
						sd.dtm.getDataVector().removeAllElements();
					
						Object arr1[]=new Object[8];
						for(student data:arr)
						{
							arr1[0]=data.getStudent_id();
							arr1[1]=data.getName();
							arr1[2]=data.getCls();
							arr1[3]=data.getRoll();
							arr1[4]=data.getNumber();
							arr1[5]=data.getAddress();
							arr1[6]=data.getIssued_book();
							arr1[7]=data.getDate1();
							
							
							sd.dtm.addRow(arr1);
							
							sd.setVisible(true);
						
						
							
							
						}
						JOptionPane.showMessageDialog(null, "Sort record successfully");
				
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		b2.setFont(new Font("Tahoma", Font.BOLD, 14));
		b2.setBounds(380, 143, 89, 23);
		panel_1.add(b2);
	}
}
