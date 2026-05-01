import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class DentalClinicManagementSystem {

	private JFrame frame;
	private CardLayout cardlay = new CardLayout(0, 0);
	private JPanel cardPanel;

	// JSeparator
	private final JSeparator separatorDentalService = new JSeparator();
	private final JSeparator separatorAddService = new JSeparator();
	private final JSeparator separator = new JSeparator();

	// JLabel
	private final JLabel lblUsername = new JLabel("Name");
	private final JLabel lblAge = new JLabel("Age");
	private final JLabel lblContact = new JLabel("Contact No.");
	private final JLabel lblDentalServices = new JLabel("Dental Services");
	private final JLabel lblAdditionalServices = new JLabel("Additional Services");
	private final JLabel lblSavedName = new JLabel("Customer Name:");
	private final JLabel lblSavedContact = new JLabel("Contact No.");
	private final JLabel lblSavedAge = new JLabel("Age");
	private final JLabel lblHeader = new JLabel("Customer Information");
	private final JLabel lblDescription = new JLabel("View and manage customer details");
	private final JLabel lblCustomers = new JLabel("CUSTOMERS");

	// JTextField
	private final JTextField textUsername = new JTextField();
	private final JTextField textContact = new JTextField();
	private final JTextField textSavedName = new JTextField();
	private final JTextField textSavedContact = new JTextField();
	private final JTextField textSavedAge = new JTextField();

	// JSpinner
	private final JSpinner spinnerAge = new JSpinner();

	// JButton
	private final JButton btnCalculateBill = new JButton("Calculate Bill");
	private final JButton btnClear = new JButton("Clear Form");
	private final JButton btnNewEntry = new JButton("New Form");

	// JCheckBox
	private final JCheckBox chckbxOption1 = new JCheckBox("Option 1");
	private final JCheckBox chckbxOption2 = new JCheckBox("Option 2");
	private final JCheckBox chckbxOption3 = new JCheckBox("Option 3");
	private final JCheckBox chckbxOption4 = new JCheckBox("Option 4");
	private final JCheckBox chckbxOption5 = new JCheckBox("Option 5");
	private final JCheckBox chckbxOption6 = new JCheckBox("Option 6");
	private final JCheckBox chckbxOption7 = new JCheckBox("Option 7");
	private final JCheckBox chckbxOption8 = new JCheckBox("Option 8");
	private final JCheckBox chckbxOption9 = new JCheckBox("Option 9");
	private final JCheckBox chckbxOption10 = new JCheckBox("Option 10");

	// JTable
	private JTable tableInput;
	private JTable tableDisplay;

	// JScrollPane
	private final JScrollPane scrollInput = new JScrollPane();
	private final JScrollPane scrollTable = new JScrollPane();
	private final JScrollPane scrollPane = new JScrollPane();

	// JList
	private JList<String> listDisplayTables;

	// JPanel
	private final JPanel panelNewData = new JPanel();
	private final JPanel panelSavedData = new JPanel();

	// Data Models
	private DefaultTableModel dataInputModel = new DefaultTableModel(0, 2);
	private DefaultListModel<String> savedTableDisplay = new DefaultListModel<>();
	private DefaultTableModel savedTables[] = new DefaultTableModel[30];
	private JCheckBox serviceBoxes[] = new JCheckBox[10];
	
	// Variables
	private int usedTableSlots = 0;
	private String savedCustomerDetails[][] = new String[30][3];
	private int usedInputSlots = 0;
	
	// Service Prices
	private double servicePrices[] = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DentalClinicManagementSystem window = new DentalClinicManagementSystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DentalClinicManagementSystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 861, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		cardPanel = new JPanel();
		cardPanel.setBounds(10, 11, 827, 437);
		frame.getContentPane().add(cardPanel);
		cardPanel.setLayout(cardlay);
		
		// PanelNewData Setup
		panelNewData.setLayout(null);
		
		// TextField
		textUsername.setColumns(10);
		textUsername.setBounds(84, 11, 175, 20);
		
		textContact.setColumns(10);
		textContact.setBounds(84, 61, 175, 20);
		
		// JLabel
		lblUsername.setBounds(10, 14, 46, 14);
		lblAge.setBounds(10, 39, 46, 14);
		lblContact.setBounds(10, 64, 71, 14);
		lblDentalServices.setBounds(10, 89, 92, 14);
		lblAdditionalServices.setBounds(10, 192, 115, 14);
		
		// JSpinner 
		spinnerAge.setBounds(84, 36, 175, 20);
		
		// JSeparator
		separatorDentalService.setBounds(108, 96, 148, 2);
		separatorAddService.setBounds(124, 199, 135, 2);
		
		// JCheckBox 
		chckbxOption1.setBounds(5, 110, 254, 23);
		chckbxOption2.setBounds(5, 136, 251, 23);
		chckbxOption3.setBounds(5, 162, 251, 23);
		chckbxOption4.setBounds(5, 208, 251, 23);
		chckbxOption5.setBounds(5, 234, 251, 23);
		chckbxOption6.setBounds(5, 260, 251, 23);
		chckbxOption7.setBounds(5, 286, 251, 23);
		chckbxOption8.setBounds(5, 312, 251, 23);
		chckbxOption9.setBounds(5, 338, 251, 23);
		chckbxOption10.setBounds(5, 364, 251, 23);
		
		// JScrollPane 
		scrollInput.setBounds(269, 11, 375, 325);
		
		// JButton
		btnCalculateBill.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCalculateBill.setBounds(286, 364, 168, 23);
		
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnClear.setBounds(464, 364, 168, 23);
		
		// JTable 
		tableInput = new JTable(dataInputModel) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		tableInput.setFillsViewportHeight(true);
		tableInput.setBounds(269, 14, 375, 320);
		scrollInput.setViewportView(tableInput);
		
		// PanelSavedData 
		panelSavedData.setLayout(null);
	
		// JLabel
		lblHeader.setForeground(new Color(0, 0, 255));
		lblHeader.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblHeader.setBounds(10, 10, 251, 27);
		
		lblDescription.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblDescription.setBounds(10, 31, 251, 27);
		
		lblCustomers.setForeground(new Color(0, 0, 255));
		lblCustomers.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblCustomers.setBounds(74, 68, 127, 27);
		
		lblSavedName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSavedName.setBounds(271, 3, 127, 22);
		
		lblSavedContact.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSavedContact.setBounds(534, 3, 90, 23);
		
		lblSavedAge.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSavedAge.setBounds(711, 3, 33, 22);
		
		// JTextField 
		textSavedName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textSavedName.setEditable(false);
		textSavedName.setBounds(271, 29, 231, 23);
		textSavedName.setColumns(10);
		
		textSavedContact.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textSavedContact.setEditable(false);
		textSavedContact.setBounds(534, 29, 153, 23);
		textSavedContact.setColumns(10);
		
		textSavedAge.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textSavedAge.setEditable(false);
		textSavedAge.setBounds(711, 29, 90, 23);
		textSavedAge.setColumns(10);
		
		// JScrollPane 
		scrollTable.setBounds(293, 105, 513, 270);
		scrollPane.setBounds(10, 105, 251, 223);
		btnNewEntry.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnNewEntry.setBackground(new Color(30, 144, 255));
		btnNewEntry.setForeground(new Color(255, 255, 255));
		
		// JButton 
		btnNewEntry.setBounds(10, 338, 251, 35);
		
		// JSeparator 
		separator.setForeground(new Color(0, 191, 255));
		separator.setBackground(new Color(0, 0, 205));
		separator.setBounds(0, 62, 844, 11);
		
		// JList
		listDisplayTables = new JList<>(savedTableDisplay);
		listDisplayTables.setBorder(new LineBorder(new Color(0, 0, 255), 3, true));
		listDisplayTables.addMouseListener(selectView);
		scrollPane.setViewportView(listDisplayTables);
		
		// JTable
		tableDisplay = new JTable() {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		tableDisplay.setBorder(new LineBorder(new Color(0, 0, 255), 4, true));
		tableDisplay.setFillsViewportHeight(true);
		scrollTable.setViewportView(tableDisplay);
		
		// panelSavedData
		panelSavedData.add(lblHeader);
		panelSavedData.add(lblDescription);
		panelSavedData.add(lblCustomers);
		panelSavedData.add(lblSavedName);
		panelSavedData.add(lblSavedContact);
		panelSavedData.add(lblSavedAge);
		panelSavedData.add(textSavedName);
		panelSavedData.add(textSavedContact);
		panelSavedData.add(textSavedAge);
		panelSavedData.add(scrollTable);
		panelSavedData.add(scrollPane);
		panelSavedData.add(btnNewEntry);
		panelSavedData.add(separator);
		
		// panelNewData
		panelNewData.add(textUsername);
		panelNewData.add(lblUsername);
		panelNewData.add(lblAge);
		panelNewData.add(spinnerAge);
		panelNewData.add(lblContact);
		panelNewData.add(textContact);
		panelNewData.add(scrollInput);
		panelNewData.add(lblDentalServices);
		panelNewData.add(separatorDentalService);
		panelNewData.add(chckbxOption1);
		panelNewData.add(chckbxOption2);
		panelNewData.add(chckbxOption3);
		panelNewData.add(separatorAddService);
		panelNewData.add(lblAdditionalServices);
		panelNewData.add(chckbxOption4);
		panelNewData.add(chckbxOption5);
		panelNewData.add(chckbxOption6);
		panelNewData.add(chckbxOption7);
		panelNewData.add(chckbxOption8);
		panelNewData.add(chckbxOption9);
		panelNewData.add(chckbxOption10);
		panelNewData.add(btnCalculateBill);
		panelNewData.add(btnClear);
		
		// Initialize serviceBoxes array
		serviceBoxes[0] = chckbxOption1;
		serviceBoxes[1] = chckbxOption2;
		serviceBoxes[2] = chckbxOption3;
		serviceBoxes[3] = chckbxOption4;
		serviceBoxes[4] = chckbxOption5;
		serviceBoxes[5] = chckbxOption6;
		serviceBoxes[6] = chckbxOption7;
		serviceBoxes[7] = chckbxOption8;
		serviceBoxes[8] = chckbxOption9;
		serviceBoxes[9] = chckbxOption10;
		
		// Initialize table models
		dataInputModel.setColumnIdentifiers(new String[] {"Service", "Price"});
		
		for(int tm = 0; tm < savedTables.length; tm++) {
			savedTables[tm] = new DefaultTableModel(0, 2);
			savedTables[tm].setColumnIdentifiers(new String[] {"Service", "Price"});
		}
		
		// Add item listeners
		for(JCheckBox cb : serviceBoxes) {
			cb.addItemListener(service);
		}
		
		// Add action listeners
		btnCalculateBill.addActionListener(calculate);
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearInput();
			}
		});
		
		btnNewEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardlay.next(cardPanel);
			}
		});
		
		// Add panels to cardPanel
		cardPanel.add(panelSavedData, "0");
		lblServicesPricing.setForeground(Color.BLUE);
		lblServicesPricing.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblServicesPricing.setBounds(445, 68, 204, 27);
		
		panelSavedData.add(lblServicesPricing);
		cardPanel.add(panelNewData, "1");
	}
	
	void clearInput() {
		textUsername.setText("");
		spinnerAge.setValue(0);
		textContact.setText("");
		deselectBoxes();
		usedInputSlots = 0;
		dataInputModel.setRowCount(0);
	}
	
	void deselectBoxes() {
		for(JCheckBox cb : serviceBoxes) {
			cb.setSelected(false);
		}
	}
	
	// View Data Action Events
	MouseAdapter selectView = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			int target = listDisplayTables.getSelectedIndex();
			tableDisplay.setModel(savedTables[target]);
			textSavedName.setText(savedCustomerDetails[target][0]);
			textSavedAge.setText(savedCustomerDetails[target][1]);
			textSavedContact.setText(savedCustomerDetails[target][2]);
		}
	};
	
	// Input Data Action Events
	ItemListener service = new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			int state = e.getStateChange();
			JCheckBox origin = (JCheckBox) e.getSource();
			String name = origin.getText();
			int target = 0;
			
			if (state == ItemEvent.SELECTED) {
				for(int i = 0; i < serviceBoxes.length; i++) {
					if(serviceBoxes[i] == origin) {
						target = i;
						break;
					}
				}
				String price = String.valueOf(servicePrices[target]);
				dataInputModel.addRow(new String[] {name, price});
				usedInputSlots++;
			} else {
				for(int i = 0; i < dataInputModel.getRowCount(); i++) {
					String valueAt = dataInputModel.getValueAt(i, 0).toString();
					if(valueAt.equals(name)) {
						target = i;
						break;
					}
				}
				dataInputModel.removeRow(target);
				usedInputSlots--;
			}
		}
	};
	
	ActionListener calculate = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String username = textUsername.getText();
			String age = spinnerAge.getValue().toString();
			String contactNo = textContact.getText();
			
			if(username.isEmpty() || age.equals("0") || contactNo.isEmpty()) {
				JOptionPane.showMessageDialog(cardPanel, "Customer Information Fields cannot be empty!", "Missing Customer Details", 0, null);
				return;
			}
			
			savedCustomerDetails[usedTableSlots][0] = username;
			savedCustomerDetails[usedTableSlots][1] = age;
			savedCustomerDetails[usedTableSlots][2] = contactNo;
			savedTableDisplay.addElement(username);
			
			for(int row = 0; row < dataInputModel.getRowCount(); row++) {
				String service = dataInputModel.getValueAt(row, 0).toString();
				String price = dataInputModel.getValueAt(row, 1).toString();
				savedTables[usedTableSlots].addRow(new String[] {service, price});
			}
			
			// Reset to Default
			clearInput();
			usedTableSlots++;
			cardlay.next(cardPanel);
		}
	};
	private final JLabel lblServicesPricing = new JLabel("SERVICES & PRICING");
}