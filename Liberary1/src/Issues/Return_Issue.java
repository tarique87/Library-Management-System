package Issues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import login_form.database;

import java.awt.TextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Return_Issue extends JFrame {

	private JPanel contentPane;
	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Return_Issue frame = new Return_Issue();
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
	public Return_Issue() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 818, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setPreferredSize(new Dimension(100, 50));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Return Issue");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(328, 0, 146, 50);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("                     Student Information");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(-12, 0, 310, 45);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("                Book Information");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(468, 0, 278, 45);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Student Id");
		lblNewLabel_3.setBounds(45, 76, 99, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Name");
		lblNewLabel_4.setBounds(45, 196, 72, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Class");
		lblNewLabel_5.setBounds(45, 265, 72, 14);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Roll");
		lblNewLabel_6.setBounds(45, 332, 72, 14);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Enter Book Id");
		lblNewLabel_7.setBounds(437, 76, 72, 14);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Book Name");
		lblNewLabel_8.setBounds(437, 181, 72, 14);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Author");
		lblNewLabel_9.setBounds(437, 254, 72, 14);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Stock");
		lblNewLabel_10.setBounds(437, 332, 72, 14);
		panel_1.add(lblNewLabel_10);
		
		TextField t1 = new TextField();
		t1.setBounds(168, 76, 106, 22);
		panel_1.add(t1);
		
		TextField t2 = new TextField();
		t2.setBounds(168, 188, 106, 22);
		panel_1.add(t2);
		
		TextField t3 = new TextField();
		t3.setBounds(168, 265, 106, 22);
		panel_1.add(t3);
		
		TextField t4 = new TextField();
		t4.setBounds(168, 335, 106, 22);
		panel_1.add(t4);
		
		TextField t5 = new TextField();
		t5.setBounds(587, 61, 118, 22);
		panel_1.add(t5);
		
		TextField t6 = new TextField();
		t6.setBounds(587, 173, 118, 22);
		panel_1.add(t6);
		
		TextField t7 = new TextField();
		t7.setBounds(587, 246, 118, 22);
		panel_1.add(t7);
		
		TextField t8 = new TextField();
		t8.setBounds(587, 324, 118, 22);
		panel_1.add(t8);
		
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(168, 128, 106, 23);
		panel_1.add(btnNewButton);
		
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(587, 112, 113, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Return");
		btnNewButton_2.setBackground(Color.PINK);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Connection con=database.getConnection();
					PreparedStatement pst=con.prepareStatement("delete from cur where student_id=? and book_id=?");
					pst.setInt(1, Integer.parseInt(t1.getText()));
					pst.setInt(2, Integer.parseInt(t5.getText()));
					
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Returned Book successfully");
					
					
					
					
					
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(341, 373, 106, 23);
		panel_1.add(btnNewButton_2);
	}
}
