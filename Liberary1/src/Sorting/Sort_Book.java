package Sorting;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Display_record.Book_Display;
import Display_record.book;
import login_form.database;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Sort_Book extends JFrame {

	private JPanel contentPane;
	book bk;
	Connection con;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Sort_Book() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 494, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setPreferredSize(new Dimension(100, 40));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sort");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(216, 0, 54, 40);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Sort on Book Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(183, 59, 131, 30);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Sort");
		btnNewButton.addActionListener(new ActionListener() {
			private DefaultTableModel dtm;

			public void actionPerformed(ActionEvent arg0) {
				try {
		
					con=database.getConnection();
					PreparedStatement pst=con.prepareStatement("select * from book order by book_id ");
					
					
					
					
						ResultSet rs=pst.executeQuery();
						ArrayList<book> arr=new ArrayList<book>();
						int book_id;
						String name;
						String author;
						String discription;
						int stock;
						Date date1;
						
						while(rs.next())
						{
							
							book_id=rs.getInt("book_id");
							name=rs.getString("name");
							author=rs.getString("author");
							discription=rs.getString("discription");
							stock=rs.getInt("stock");
							date1=rs.getDate("date1");
							
							bk=new book();
							
							
							bk.setBook_id(book_id);
							bk.setName(name);
							bk.setAuthor(author);
							bk.setDiscription(discription);
							bk.setStock(stock);
							bk.setDate1(date1);
							arr.add(bk);
							
							
							
							
						}
						if(arr.isEmpty())
						{
							JOptionPane.showMessageDialog(null, "Data not found");
							return;
						}
						Book_Display bd=new Book_Display();
						bd.getDtm().getDataVector().removeAllElements();
					
						Object arr1[]=new Object[6];
						for(book data:arr)
						{
							arr1[0]=data.getBook_id();
							arr1[1]=data.getName();
							arr1[2]=data.getAuthor();
							arr1[3]=data.getDiscription();
							arr1[4]=data.getStock();
							arr1[5]=data.getDate1();
							
							
							
							((Book_Display) bd).getDtm().addRow(arr1);
							
							bd.setVisible(true);
						
						
							
							
						}
						JOptionPane.showMessageDialog(null, "Sort record successfully");
				
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				

			}
				
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(204, 169, 89, 23);
		panel_1.add(btnNewButton);
	}
}
