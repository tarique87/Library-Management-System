package Add_records;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import login_form.database;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Add_Student extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 * @return 
	 */
	public  Add_Student() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 548, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setPreferredSize(new Dimension(100, 40));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Student");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(197, 11, 109, 30);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(50, 33, 87, 24);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(50, 68, 66, 29);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Class");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(50, 108, 66, 28);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Roll");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(50, 159, 66, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mobile");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(50, 199, 66, 14);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Address");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(50, 235, 66, 14);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("IssuedBooks");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(50, 272, 112, 14);
		panel_1.add(lblNewLabel_7);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 14));
		t1.setBounds(207, 35, 131, 20);
		panel_1.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 14));
		t2.setBounds(206, 74, 132, 20);
		panel_1.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.BOLD, 14));
		t3.setBounds(207, 114, 131, 20);
		panel_1.add(t3);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.BOLD, 14));
		t4.setBounds(209, 158, 129, 20);
		panel_1.add(t4);
		t4.setColumns(10);
		
		t5 = new JTextField();
		t5.setFont(new Font("Tahoma", Font.BOLD, 14));
		t5.setBounds(207, 198, 131, 20);
		panel_1.add(t5);
		t5.setColumns(10);
		
		t6 = new JTextField();
		t6.setFont(new Font("Tahoma", Font.BOLD, 14));
		t6.setBounds(207, 234, 131, 20);
		panel_1.add(t6);
		t6.setColumns(10);
		
		t7 = new JTextField();
		t7.setFont(new Font("Tahoma", Font.BOLD, 14));
		t7.setBounds(207, 271, 131, 20);
		panel_1.add(t7);
		t7.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=database.getConnection();
					PreparedStatement pst=con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?)");
					pst.setInt(1, Integer.parseInt(t1.getText()));
					pst.setString(2, String.valueOf(t2.getText()));
					pst.setString(3, String.valueOf(t3.getText()));
					pst.setInt(4, Integer.parseInt(t4.getText()));
					pst.setLong(5,Long.parseLong(t5.getText()));
					pst.setString(6, String.valueOf(t6.getText()));
					pst.setInt(7, Integer.parseInt(t7.getText()));
					pst.setDate(8, java.sql.Date.valueOf(LocalDate.now()));
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Add record successfully");
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "You insert duplicate student ID ");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(207, 329, 131, 23);
		panel_1.add(btnNewButton);
	}
	
}
