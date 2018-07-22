package Search;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Display_record.Student_Display;
import Display_record.student;
import login_form.database;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.ScrollPane;

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

public class Search_Student extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	Connection con;
	student std;
	JTable table;
	ScrollPane scrollPane;
	DefaultTableModel dtm;
	 

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	
	public Search_Student() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 548, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setPreferredSize(new Dimension(100, 40));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Student");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(213, 0, 138, 40);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Search on Student ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(68, 71, 156, 26);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Search on Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(300, 71, 145, 26);
		panel_1.add(lblNewLabel_2);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 14));
		t1.setBounds(68, 150, 156, 20);
		panel_1.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 14));
		t2.setBounds(300, 150, 137, 20);
		panel_1.add(t2);
		t2.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					int s=0;
					if(!t1.getText().isEmpty())
						s=Integer.parseInt(t1.getText());
					con=database.getConnection();
					PreparedStatement pst=con.prepareStatement("select * from student where student_id=? or name=?");
					pst.setInt(1, s);
					pst.setString(2, t2.getText());
					
					
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
						JOptionPane.showMessageDialog(null, "Searched record successfully");
				
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(198, 252, 145, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(307, 242, 137, 23);
		panel_1.add(btnNewButton_1);
			}
		});
	}
}

		
	
	
