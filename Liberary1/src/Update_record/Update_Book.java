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
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Update_Book extends JFrame {

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
	public Update_Book() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 547, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setPreferredSize(new Dimension(100, 40));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Book");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(193, 0, 114, 40);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(" Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(77, 102, 87, 17);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Author");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(77, 158, 74, 25);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Description");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(77, 220, 87, 25);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Stock");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(77, 284, 74, 14);
		panel_1.add(lblNewLabel_4);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 14));
		t1.setBounds(225, 100, 130, 20);
		panel_1.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		t2.setBounds(225, 160, 130, 20);
		panel_1.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		t3.setBounds(225, 222, 130, 20);
		panel_1.add(t3);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.BOLD, 14));
		t4.setBounds(225, 281, 127, 20);
		panel_1.add(t4);
		t4.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con=database.getConnection();
					PreparedStatement pst=con.prepareStatement("update book set name=?,author=?,discription=?,stock=? where book_id=?");
					
					pst.setString(1, String.valueOf(t1.getText()));
					pst.setString(2, String.valueOf(t2.getText()));
					pst.setString(3, String.valueOf(t3.getText()));
					pst.setInt(4, Integer.parseInt(t4.getText()));
					pst.setInt(5, Integer.parseInt(t5.getText()));
				
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Update record successfully");
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(225, 342, 130, 23);
		panel_1.add(btnNewButton);
		
		t5 = new JTextField();
		t5.setBounds(225, 43, 130, 20);
		panel_1.add(t5);
		t5.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Enter Book_ID for Update");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(23, 43, 192, 25);
		panel_1.add(lblNewLabel_5);
	}
}
