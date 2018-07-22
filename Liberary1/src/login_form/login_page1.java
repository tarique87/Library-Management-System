package login_form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.ImageIcon;

public class login_page1 extends JFrame {

	private JPanel contentPane;
	private JTextField user_name;
	private JPasswordField password;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_page1 frame = new login_page1();
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
	public login_page1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 153));
		panel.setPreferredSize(new Dimension(100, 60));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Library Management System");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(203, 0, 367, 60);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_1.setBackground(new Color(255, 153, 51));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setIcon(new ImageIcon("E:\\New_pics\\login-icon.png"));
		lblNewLabel_1.setBounds(76, 0, 281, 407);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(361, 0, 309, 407);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("      User Name");
		lblNewLabel_2.setForeground(new Color(0, 51, 153));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(81, 58, 165, 36);
		panel_2.add(lblNewLabel_2);
		
		user_name = new JTextField();
		user_name.setFont(new Font("Tahoma", Font.BOLD, 14));
		user_name.setBounds(53, 107, 210, 29);
		panel_2.add(user_name);
		user_name.setColumns(10);
		
		JLabel lblPasswor = new JLabel("      Password");
		lblPasswor.setForeground(new Color(0, 51, 153));
		lblPasswor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPasswor.setBounds(81, 147, 165, 36);
		panel_2.add(lblPasswor);
		
		
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(user_name.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"user_name is empty");
				}
				if(password.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "please enter password");
				}
				try {
		            Connection con=database.getConnection();
		            PreparedStatement pst=con.prepareStatement("select password from password where user_name=? ");
		            pst.setString(1, user_name.getText());
		      
		            ResultSet rs=pst.executeQuery();
		            if(rs.next())
		            {
		            	if(rs.getInt("password")==Integer.parseInt(password.getText()))
		            	{
		            	new Main().setVisible(true);
		            	dispose();
		            	}
		            
		            	else
		            	{
		            		JOptionPane.showMessageDialog(null,"Password is not currect");
		            	}
		            }
		            else
		            {
		            	JOptionPane.showMessageDialog(null, "User name is not currect");
		        
			
		            }
				}
				
				catch(SQLException e)
				{
				System.out.println(e);	
				}
				
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 51, 153));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(98, 253, 122, 36);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 51, 153));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(98, 317, 122, 36);
		panel_2.add(btnNewButton_1);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.BOLD, 14));
		password.setBounds(53, 194, 210, 30);
		panel_2.add(password);
	}
}
