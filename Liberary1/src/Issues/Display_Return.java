package Issues;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Display_record.book;
import Display_record.student;
import login_form.database;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Display_Return extends JFrame {

	private JPanel contentPane;
	private JTable table;
DefaultTableModel dtm;
student std;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display_Return frame = new Display_Return();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Display_Return() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 773, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 5, 727, 439);
		panel.add(scrollPane);
		
		table = new JTable();
		
		
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","Student ID","Book ID","Name","Class","Roll","Author","Date","Book Name"
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
			java.sql.Date date1;
			PreparedStatement pst1=con.prepareStatement("select * from book");
			ResultSet rs1=pst1.executeQuery();
			ArrayList<book> array=new ArrayList<book>();
			while(rs.next())
			{
				
				
				student_id=rs.getInt("student_ID");
				name=rs.getString("name");
				cls=rs.getString("class");
				roll=rs.getInt("roll");
				
				
				date1=rs.getDate("date1");
				
				
				std=new student();
				
				std.setStudent_id(student_id);
				std.setName(name);
				std.setCls(cls);
				std.setRoll(roll);
				
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
