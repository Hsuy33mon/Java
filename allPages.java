package History;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

public class allPages {

	private JFrame frmFinanceDiary;
	private JLayeredPane layeredPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					allPages window = new allPages();
					window.frmFinanceDiary.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void switchPanel(JPanel p) {
		layeredPane.removeAll();
		layeredPane.add(p);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	/**
	 * Create the application.
	 */
	public allPages() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFinanceDiary = new JFrame();
		frmFinanceDiary.getContentPane().setBackground(new Color(216, 191, 216));
		frmFinanceDiary.setTitle("Finance Diary");
		frmFinanceDiary.setBounds(100, 100, 389, 343);
		frmFinanceDiary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFinanceDiary.getContentPane().setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 35, 381, 275);
		frmFinanceDiary.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		//Book panel
		JPanel Book = new JPanel();
		Book.setBackground(new Color(230, 230, 250));
		layeredPane.add(Book, "name_114276725101500");
		Book.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 40, 300, 170);
		Book.add(tabbedPane);
		
		JLayeredPane income = new JLayeredPane();
		tabbedPane.addTab("Income", null, income, null);
		
		//income
		JPanel income_panel = new JPanel();
		income_panel.setBounds(0, 0, 295, 170);
		income.add(income_panel);
		income_panel.setLayout(null);

		JLabel IncomeDate = new JLabel("Date");
		IncomeDate.setBounds(20, 25, 61, 16);
		income_panel.add(IncomeDate);

		JLabel incomeAmount = new JLabel("Amount");
		incomeAmount.setBounds(20, 60, 61, 16);
		income_panel.add(incomeAmount);

		JLabel incomeCategory = new JLabel("Category");
		incomeCategory.setBounds(20, 99, 61, 16);
		income_panel.add(incomeCategory);
		String[] incomeCategory1 = { " ","Salary", "Bonus", "Allowance", "PartTime" };

		JTextField incomeAmountText = new JTextField();
		incomeAmountText.setBounds(91, 56, 117, 26);
		income_panel.add(incomeAmountText);
		incomeAmountText.setColumns(10);
		JComboBox incomeComboBox = new JComboBox(incomeCategory1);
		incomeComboBox.setBounds(91, 94, 117, 27);
		income_panel.add(incomeComboBox);
		
		//expense
		JPanel expense = new JPanel();
		tabbedPane.addTab("Expense", null, expense, null);
		expense.setLayout(null);
		
		JLabel expensesDate = new JLabel("Date");
		expensesDate.setBounds(20, 25, 61, 16);
		expense.add(expensesDate);

		JLabel expensesAmount = new JLabel("Amount");
		expensesAmount.setBounds(20, 60, 61, 16);
		expense.add(expensesAmount);

		JLabel expensescategory = new JLabel("Category");
		expensescategory.setBounds(20, 99, 61, 16);
		expense.add(expensescategory);
		String[] expensesCategory = { " ","Food", "Tran", "Social", "Rent", "Education", "Travel", "Beauty", "Baby" };

		JTextField expensesAmountText = new JTextField();
		expensesAmountText.setBounds(91, 56, 117, 26);
		expense.add(expensesAmountText);
		expensesAmountText.setColumns(10);
		JComboBox expensescomboBox = new JComboBox(expensesCategory);
		expensescomboBox.setBounds(91, 94, 117, 27);
		expense.add(expensescomboBox);
		
		//Book button to switch panel
		JButton btnBook = new JButton("Book");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(Book);
			}
		});
		btnBook.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnBook.setBackground(new Color(221, 160, 221));
		btnBook.setBounds(0, 0, 85, 35);
		frmFinanceDiary.getContentPane().add(btnBook);
		
		//History panel
		JPanel History = new JPanel();
		History.setBackground(new Color(230, 230, 250));
		layeredPane.add(History, "name_114281144724900");
		History.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 10, 371, 222);
		History.add(scrollPane);
		
		//Table
		table = new JTable();
		scrollPane.setViewportView(table);
		final DefaultTableModel model = new DefaultTableModel();
		Object[] column = { "Number", "Date", "Category", "Deposit", "Withdraw", "Balance" };
		final Object[] row = new Object[6];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		table.setBackground(new Color(255, 240, 245));
		
		//update button 
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnUpdate.setBounds(83, 234, 85, 31);
		History.add(btnUpdate);
		
		//delete button
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0)
				{
				model.removeRow(i);
				JOptionPane.showMessageDialog(null, "Deleted successfully.");
				}
				else { 
					JOptionPane.showMessageDialog(null, "Please select a row first.");
				}
			}
		});
		btnDelete.setBounds(207, 234, 85, 29);
		History.add(btnDelete);
		
		//history button to switch panel
		JButton btnHistory = new JButton("History");
		btnHistory.setBackground(new Color(221, 160, 221));
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(History);
			}
		});
		btnHistory.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnHistory.setBounds(94, 0, 85, 35);
		frmFinanceDiary.getContentPane().add(btnHistory);
		
		//save button
				int i = table.getRowCount();
				JButton btnSave = new JButton("Save");
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String selected_item_expense = (String) expensescomboBox.getSelectedItem();
						String selected_item_income = (String) incomeComboBox.getSelectedItem();
						if((expensesAmountText.getText().equals("") || selected_item_expense.equals(" ")) && (incomeAmountText.getText().equals(" ") || selected_item_income.equals(" "))) {
							JOptionPane.showMessageDialog(null, "Please fill all information before saving.");
						}
						 if(!(expensesAmountText.getText().equals("") || selected_item_expense.equals(" "))){
						incomeAmountText.setText("");
						//row[0] = i-(i-1);
						row[4] = expensesAmountText.getText();
						row[3] = incomeAmountText.getText();
						row[2] = selected_item_expense;
						//row[5] = incomeAmountText.getText()+expensesAmountText.getText();
						model.addRow(row);
						JOptionPane.showMessageDialog(null, "Saved successfully");
						expensesAmountText.setText("");
						expensescomboBox.setSelectedIndex(0);
						}
						else 
						{
							//row[0] = i-(i-1);
							expensesAmountText.setText("");
							row[4] = expensesAmountText.getText();
							row[3] = incomeAmountText.getText();
							row[2] = selected_item_income;
							model.addRow(row);
							JOptionPane.showMessageDialog(null, "Saved successfully");
							incomeAmountText.setText("");
							incomeComboBox.setSelectedIndex(0);
							expensesAmountText.setText("");
						}
						
						
					}
				});
				btnSave.setIcon(new ImageIcon(allPages.class.getResource("/History/check.png")));
				btnSave.setBounds(52, 220, 93, 25);
				Book.add(btnSave);
				
		//cancel button
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						expensesAmountText.setText(null);
						expensescomboBox.setSelectedIndex(0);
						incomeAmountText.setText("");
						incomeComboBox.setSelectedIndex(0);

					}
				});
				btnCancel.setIcon(new ImageIcon(allPages.class.getResource("/History/deleteicon.png")));
				btnCancel.setBounds(170, 220, 93, 25);
				Book.add(btnCancel);
		
		//Stats panel
		JPanel Stats = new JPanel();
		Stats.setBackground(new Color(230, 230, 250));
		layeredPane.add(Stats, "name_114285609105100");
		
		//stats button to switch panel
		JButton btnStats = new JButton("Stats");
		btnStats.setBackground(new Color(221, 160, 221));
		btnStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(Stats);
			}
		});
		btnStats.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnStats.setBounds(189, 0, 85, 35);
		frmFinanceDiary.getContentPane().add(btnStats);
		
		//Profile panel
		JPanel Profile = new JPanel();
		Profile.setBackground(new Color(230, 230, 250));
		layeredPane.add(Profile, "name_114511220939400");
		Profile.setLayout(null);
		
		//Wallet to show total balance
		JLabel lblWallet = new JLabel("Wallet: ");
		lblWallet.setBounds(31, 31, 45, 13);
		Profile.add(lblWallet);
		
		JLabel lbl = new JLabel("");
		lbl.setBounds(86, 31, 217, 13);
		Profile.add(lbl);
		
		//wallet icon
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(allPages.class.getResource("/History/Wallet.png")));
		lblNewLabel.setBounds(10, 27, 20, 20);
		Profile.add(lblNewLabel);
		
		//Profile button to switch panel
		JButton btnProfile = new JButton("Profile");
		btnProfile.setBackground(new Color(221, 160, 221));
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(Profile);
			}
		});
		btnProfile.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnProfile.setBounds(284, 0, 85, 35);
		frmFinanceDiary.getContentPane().add(btnProfile);
	}
}
