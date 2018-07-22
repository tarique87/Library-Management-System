package Update_record;

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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Update_Student extends JFrame {

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
	 */
	public Update_Student() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 545, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setPreferredSize(new Dimension(100, 40));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Student");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(190, 0, 140, 40);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(81, 139, 46, 30);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Class");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(81, 197, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Roll");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(81, 235, 46, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mobile");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(81, 272, 59, 22);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(81, 305, 59, 22);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Issued Book");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(81, 338, 100, 22);
		panel_1.add(lblNewLabel_6);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 14));
		t1.setBounds(194, 144, 133, 20);
		panel_1.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 14));
		t2.setBounds(194, 194, 134, 20);
		panel_1.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.BOLD, 14));
		t3.setBounds(194, 232, 133, 20);
		panel_1.add(t3);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		t4.setBounds(194, 273, 133, 20);
		panel_1.add(t4);
		t4.setColumns(10);
		
		t5 = new JTextField();
		t5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		t5.setBounds(193, 306, 134, 20);
		panel_1.add(t5);
		t5.setColumns(10);
		
		t6 = new JTextField();
		t6.setFont(new Font("Tahoma", Font.BOLD, 14));
		t6.setBounds(191, 337, 136, 20);
		panel_1.add(t6);
		t6.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con=database.getConnection();
					PreparedStatement pst=con.prepareStatement("update student set name=?,class=?,roll=?,mobile=?,address=?,Issued_Book=? where student_id=?");
					
					pst.setString(1, String.valueOf(t1.getText()));
					pst.setString(2, String.valueOf(t2.getText()));
					pst.setInt(3, Integer.parseInt(t3.getText()));
					pst.setLong(4, Long.parseLong(t4.getText()));
					pst.setString(5, String.valueOf(t5.getText()));
					pst.setInt(6, Integer.parseInt(t6.getText()));
					pst.setInt(7, Integer.parseInt(t7.getText()));
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Update record successfully");
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(192, 397, 135, 23);
		panel_1.add(btnNewButton);
		
		t7 = new JTextField();
		t7.setBounds(194, 76, 133, 20);
		panel_1.add(t7);
		t7.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Enter Student ID for Update");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(159, 34, 221, 31);
		panel_1.add(lblNewLabel_7);
	}
}
