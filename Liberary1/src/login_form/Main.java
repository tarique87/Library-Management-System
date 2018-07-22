package login_form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import History_Package.History;
import Issues.Current_Issue;
import Issues.Return_Issue;
import panels.Book_info;
import panels.Student_info;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Main extends JFrame {

	private JPanel contentPane;
	JPanel active_panel;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 528);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel tatle = new JPanel();
		tatle.setBackground(Color.WHITE);
		tatle.setPreferredSize(new Dimension(100, 60));
		contentPane.add(tatle, BorderLayout.NORTH);
		tatle.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Library Management System");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setIcon(new ImageIcon("E:\\New_pics\\Books-1-icon (1).png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(10, 0, 395, 60);
		tatle.add(lblNewLabel);
		
		JPanel Main_panel = new JPanel();
		Main_panel.setBackground(Color.WHITE);
		Main_panel.setSize(new Dimension(50, 50));
		Main_panel.setPreferredSize(new Dimension(100, 100));
		contentPane.add(Main_panel, BorderLayout.CENTER);
		Main_panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("E:\\New_pics\\62863-books-icon.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Book_info().setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(548, 11, 195, 143);
		Main_panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("E:\\New_pics\\User-Group-icon.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Student_info().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(51, 11, 195, 143);
		Main_panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("E:\\New_pics\\Library-icon.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Current_Issue().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(300, 11, 195, 143);
		Main_panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon("E:\\New_pics\\Library-icon (1).png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Return_Issue().setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBounds(169, 225, 195, 138);
		Main_panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("        Students Information");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(51, 152, 195, 32);
		Main_panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("          Books Information");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(300, 156, 195, 25);
		Main_panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("          Book Issue");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(548, 158, 195, 21);
		Main_panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("               Return Issue");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(169, 368, 195, 29);
		Main_panel.add(lblNewLabel_4);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new History().setVisible(true);
			}
		});
		btnNewButton_4.setIcon(new ImageIcon("E:\\New_pics\\Documentaries-History-icon.png"));
		btnNewButton_4.setBounds(424, 225, 179, 138);
		Main_panel.add(btnNewButton_4);
		
		JLabel lblNewLabel_5 = new JLabel("              History");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(424, 366, 169, 32);
		Main_panel.add(lblNewLabel_5);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
