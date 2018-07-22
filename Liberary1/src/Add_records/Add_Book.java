package Add_records;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import login_form.database;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class Add_Book extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Add_Book() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 553, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setPreferredSize(new Dimension(100, 40));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Book");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(209, 0, 93, 40);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Book ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(31, 28, 97, 30);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(31, 88, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Author");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(31, 144, 74, 27);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Description");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(31, 203, 97, 20);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Stock");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(31, 262, 60, 20);
		panel_1.add(lblNewLabel_5);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 14));
		t1.setBounds(134, 33, 125, 20);
		panel_1.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(134, 87, 125, 20);
		panel_1.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(134, 149, 125, 20);
		panel_1.add(t3);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setBounds(138, 205, 121, 20);
		panel_1.add(t4);
		t4.setColumns(10);
		
		t5 = new JTextField();
		t5.setBounds(135, 264, 124, 20);
		panel_1.add(t5);
		t5.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con=database.getConnection();
					PreparedStatement pst=con.prepareStatement("insert into book values(?,?,?,?,?,?)");
					pst.setInt(1, Integer.parseInt(t1.getText()));
					pst.setString(2, String.valueOf(t2.getText()));
					pst.setString(3, String.valueOf(t3.getText()));
					pst.setString(4, String.valueOf(t4.getText()));
					pst.setInt(5,Integer.parseInt(t5.getText()));
					pst.setDate(6, java.sql.Date.valueOf(LocalDate.now()));
				
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Add record successfully");
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "You insert duplicate book ID");
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(134, 315, 125, 23);
		panel_1.add(btnNewButton);
	}
	
}
