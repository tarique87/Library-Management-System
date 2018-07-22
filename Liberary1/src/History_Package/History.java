package History_Package;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Issues.Current_class;
import login_form.database;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class History extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel dtm;
	History_Class hst;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public History() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 821, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 795, 60);
		panel.setBackground(Color.BLUE);
		panel.setPreferredSize(new Dimension(100, 60));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("History");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(328, 0, 93, 55);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 62, 795, 403);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				" Issued ID","Student ID","Book ID","Issued Date","Return Date", 
			}
		));
		dtm=(DefaultTableModel) table.getModel();
		try {
			Connection con=database.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from library_history");
			ResultSet rs=pst.executeQuery();
			ArrayList<History_Class> arr=new ArrayList<History_Class>();
			int issued_id;
			int student_id2;
			int book_id2;
			java.sql.Date date3;
			java.sql.Date date4;
			
			
			while(rs.next())
			{
				
				issued_id=rs.getInt("issue_id");
				student_id2=rs.getInt("student_id");
				book_id2=rs.getInt("book_id");
				date3=rs.getDate("issue_date");
				date4=rs.getDate("return_date");
				
				
				hst=new History_Class();
				
			
				hst.setIssued_id(issued_id);
				hst.setStudent_id2(student_id2);
				hst.setBook_id2(book_id2);
				hst.setDate3(date3);
				hst.setDate4(date4);
				
				arr.add(hst);
				
				
				
			}
			if(arr.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Data not found");
				return;
			}
			Object arr1[]=new Object[5];
			for(History_Class data:arr)
			{
				arr1[0]=data.getIssued_id();
				arr1[1]=data.getStudent_id2();
				arr1[2]=data.getBook_id2();
				arr1[3]=data.getDate3();
				arr1[4]=data.getDate4();
				
				dtm.addRow(arr1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}
}
