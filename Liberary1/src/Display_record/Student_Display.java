package Display_record;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import login_form.database;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

public class Student_Display extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public DefaultTableModel dtm;
	student std;
	JFrame frame;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Student_Display() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 823, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane.setBounds(0, 0, 797, 471);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLUE);
		table.setShowGrid(false);
		
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student_ID", "Name", "Class", "Roll", "Mobile", "Address", "Issed Book", "Date"
			}
		));
		dtm=(DefaultTableModel) table.getModel();
		try {
			Connection con=database.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from student");
			ResultSet rs=pst.executeQuery();
			ArrayList<student> arr=new ArrayList<student>();
			int student_id;
			String name;
			String cls;
			int roll;
			long number;
			String address;
			int issued_book;
			java.sql.Date date1;
			
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
				dtm.addRow(arr1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
