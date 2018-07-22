package Issues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Display_record.student;
import login_form.database;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Current_Display extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel dtm;
	Current_class ctc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Current_Display frame = new Current_Display();
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
	public Current_Display() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 830, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setForeground(Color.BLUE);
		panel.setBounds(10, 11, 794, 48);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Issued Book");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(317, 11, 116, 32);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 794, 398);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","Student ID","Book ID", "Name", "Class", "Roll", "Author", "Date", "Book Name",
			}
		));
		dtm=(DefaultTableModel) table.getModel();
		try {
			Connection con=database.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from cur");
			ResultSet rs=pst.executeQuery();
			ArrayList<Current_class> arr=new ArrayList<Current_class>();
			int id1;
			int student_id1;
			int book_id1;
			String name1;
			String cls1;
			int roll1;
			String author1;
			java.sql.Date date2;
			String book_name1;
			
			while(rs.next())
			{
				
				id1=rs.getInt("id");
				student_id1=rs.getInt("student_id");
				book_id1=rs.getInt("book_id");
				name1=rs.getString("name");
				cls1=rs.getString("class");
				roll1=rs.getInt("roll");
				author1=rs.getString("author");
				date2=rs.getDate("date1");
				book_name1=rs.getString("book_name");
				
				
				ctc=new Current_class();
				
				ctc.setId1(id1);
				ctc.setStudent_id1(student_id1);
				ctc.setBook_id1(book_id1);
				ctc.setName1(name1);
				ctc.setCls1(cls1);
				ctc.setRoll1(roll1);
				ctc.setAuthor1(author1);
				ctc.setDate2(date2);
				ctc.setBook_name1(book_name1);
				arr.add(ctc);
				
				
				
			}
			if(arr.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Data not found");
				return;
			}
			Object arr1[]=new Object[9];
			for(Current_class data:arr)
			{
				arr1[0]=data.getId1();
				arr1[1]=data.getStudent_id1();
				arr1[2]=data.getBook_id1();
				arr1[3]=data.getName1();
				arr1[4]=data.getCls1();
				arr1[5]=data.getRoll1();
				arr1[6]=data.getAuthor1();
				arr1[7]=data.getDate2();
				arr1[8]=data.getBook_name1();
				dtm.addRow(arr1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
