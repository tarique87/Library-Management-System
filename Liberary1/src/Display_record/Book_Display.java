package Display_record;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import login_form.database;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

public class Book_Display extends JFrame {

	private JPanel contentPane;
    private DefaultTableModel dtm;
	book bk;
	JTable table;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Book_Display() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 801, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollpane=new JScrollPane();
		scrollpane.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollpane.setBounds(10,0,765,459);
		contentPane.add(scrollpane);
		table=new JTable();
		table.setForeground(Color.WHITE);
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setBackground(Color.BLUE);
		scrollpane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				
		new Object[][] {
			
		}, new String[] {
				"Book_ID","Name","Author","Discription","Stock","Date"
		}
		
		
		));
		setDtm((DefaultTableModel) table.getModel());
		try {
			Connection con=database.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from book");
			ResultSet rs=pst.executeQuery();
			ArrayList<book> arr=new ArrayList<book>();
			int book_id;
			String book_name;
			String author;
			String discription;
			int stock;
	Date date1;
			
			while(rs.next())
			{
				
				
				book_id=rs.getInt("book_id");
				book_name=rs.getString("name");
				author=rs.getString("author");
				discription=rs.getString("discription");
				stock=rs.getInt("stock");
				date1=rs.getDate("date1");
				
				
				
				
				bk=new book();
				
				bk.setBook_id(book_id);
				bk.setName(book_name);
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
			Object arr1[]=new Object[6];
			for(book data:arr)
			{
				arr1[0]=data.getBook_id();
				arr1[1]=data.book_name();
				arr1[2]=data.getAuthor();
				arr1[3]=data.getDiscription();
				arr1[4]=data.getStock();
				arr1[5]=data.getDate1();
				
				getDtm().addRow(arr1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public void setDtm(DefaultTableModel dtm) {
		this.dtm = dtm;
	}

	public DefaultTableModel getDtm1() {
		// TODO Auto-generated method stub
		return null;
	}
	}

