package Issues;

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
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Current_Issue extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	private JTextField t8;
	Connection con;
	student std;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Current_Issue() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 513, 40);
		panel.setBackground(Color.PINK);
		panel.setPreferredSize(new Dimension(100, 40));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Current Issue");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(206, 0, 121, 40);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(5, 43, 259, 415);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLUE);
		panel_3.setToolTipText("Student Information");
		panel_3.setPreferredSize(new Dimension(100, 40));
		panel_1.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Student Information");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(57, 0, 173, 40);
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(102, 204, 51));
		panel_1.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Student ID");
		lblNewLabel_3.setBounds(20, 23, 110, 24);
		panel_5.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Name");
		lblNewLabel_4.setToolTipText("Name");
		lblNewLabel_4.setBounds(20, 147, 68, 14);
		panel_5.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Class");
		lblNewLabel_5.setBounds(20, 218, 68, 14);
		panel_5.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Roll");
		lblNewLabel_6.setBounds(20, 286, 89, 14);
		panel_5.add(lblNewLabel_6);
		
		t1 = new JTextField();
		t1.setBounds(132, 25, 99, 20);
		panel_5.add(t1);
		t1.setColumns(10);
		
		JButton btnNewButton = new JButton("Find");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					int s=0;
					
					
					
						s=Integer.parseInt(t1.getText());
					con=database.getConnection();
					PreparedStatement pst=con.prepareStatement("select * from student where student_id=? ");
					pst.setInt(1, s);
					ResultSet rs=pst.executeQuery();
				if(rs.next())
				{
					
				
						t2.setText(rs.getString("name"));
			t3.setText(rs.getString("class"));
			t4.setText(String.valueOf(rs.getInt("roll")));
			
				}
				else
					JOptionPane.showMessageDialog(null, "Data not found");
						
			
			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
		
					
					
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(132, 76, 99, 23);
		panel_5.add(btnNewButton);
		
		t2 = new JTextField();
		t2.setBounds(123, 144, 108, 20);
		panel_5.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(123, 215, 108, 20);
		panel_5.add(t3);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setBounds(123, 283, 108, 20);
		panel_5.add(t4);
		t4.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Issued");
		btnNewButton_2.setBounds(121, 327, 110, 23);
		panel_5.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a;
				try {
					Connection con=database.getConnection();
					PreparedStatement pst1=con.prepareStatement("select id from cur order by id desc");
					ResultSet rs=pst1.executeQuery();
					if(rs.next())
					
						a=rs.getInt("id");
					else
						a=0;
					
					
					PreparedStatement pst=con.prepareStatement("insert into cur values(?,?,?,?,?,?,?,?,?)");
					pst.setInt(1,++a);
					pst.setInt(2, Integer.parseInt(t1.getText()));
					pst.setInt(3, Integer.parseInt(t5.getText()));
					pst.setString(4, String.valueOf(t2.getText()));
					pst.setString(5, String.valueOf(t3.getText()));
					pst.setInt(6, Integer.parseInt(t4.getText()));
					pst.setString(7,String.valueOf(t6.getText()) );
					pst.setString(9, String.valueOf(t7.getText()));
					pst.setDate(8, java.sql.Date.valueOf(LocalDate.now()));
					
					
					
				
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Issued record successfully");
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(100, 149, 237));
		panel_2.setBounds(259, 43, 259, 415);
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 204, 0));
		panel_4.setPreferredSize(new Dimension(100, 40));
		panel_2.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Book Information");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(72, 0, 141, 40);
		panel_4.add(lblNewLabel_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(153, 51, 0));
		panel_2.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Enter Book ID");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(30, 32, 67, 14);
		panel_6.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Book Name");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(30, 147, 67, 14);
		panel_6.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Author");
		lblNewLabel_9.setBackground(new Color(204, 0, 204));
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(30, 219, 67, 14);
		panel_6.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Stock");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setBounds(30, 286, 67, 14);
		panel_6.add(lblNewLabel_10);
		
		t5 = new JTextField();
		t5.setBounds(128, 29, 103, 20);
		panel_6.add(t5);
		t5.setColumns(10);
		
		t6 = new JTextField();
		t6.setBounds(128, 144, 103, 20);
		panel_6.add(t6);
		t6.setColumns(10);
		
		t7 = new JTextField();
		t7.setBounds(128, 216, 103, 20);
		panel_6.add(t7);
		t7.setColumns(10);
		
		t8 = new JTextField();
		t8.setBounds(128, 283, 103, 20);
		panel_6.add(t8);
		t8.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Find");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					
					
					
						
					con=database.getConnection();
					PreparedStatement pst=con.prepareStatement("select * from book where book_id=? ");
					pst.setInt(1, Integer.parseInt(t5.getText()));
					ResultSet rs=pst.executeQuery();
				if(rs.next())
				{
					
				
						t6.setText(rs.getString("name"));
			t7.setText(rs.getString("author"));
			t8.setText(String.valueOf(rs.getInt("stock")));
			
				}
				else
					JOptionPane.showMessageDialog(null, "Data not found");
						
			
			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
		
					
					
					
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(131, 77, 100, 23);
		panel_6.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Display");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				new Current_Display().setVisible(true);
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(128, 328, 103, 23);
		panel_6.add(btnNewButton_3);
	}
}
