package com.casestudy.ui;

	
	

	import java.awt.Color;
	import java.awt.Dialog;
	import java.awt.Font;
	import java.awt.Frame;
	import java.awt.GraphicsConfiguration;
	import java.awt.Window;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.ButtonGroup;
	import javax.swing.JButton;
	import javax.swing.JDialog;
	import javax.swing.JLabel;
	import javax.swing.JRadioButton;
	import javax.swing.JTextField;
	import javax.swing.event.ChangeEvent;
	import javax.swing.event.ChangeListener;

	import com.casestudy.*;
import com.casestudy.dao.CustomerDao;
import com.casestudy.dao.PartsDao;
	

	public class partsui extends JDialog{

		static LinkedList<Parts> PartsList=new LinkedList<>();

		
		private static final long serialVersionUID = 1L;
		private JLabel lblid;
		private JTextField txtId;
		private JButton btnSubmit;
		
		private JLabel name;
		private JTextField txtName;
		private JLabel lblCost;
		private JTextField txtCost;

		public partsui(Window parent) {
			
	        		
			super(parent);
			this.setTitle("New Spare Part");
			initComponents();
			
			
		}

		
		private void initComponents() {
		    setForeground(Color.black);
		    setBackground(Color.white);
		    setFont(new Font("Dialog", Font.PLAIN, 12));
		    setLayout(null);

		    add(getTxtName());
		    add(getTxtId());
		    add(getTxtCost());
		    add(getBtnSubmit());
		    add(getLblCost());
		    add(getname());
		    add(getLblid());

		    setSize(340, 231);
		}


		private JLabel getname() {
			if (name == null) {
				name = new JLabel();
				name.setText("Name: ");
				name.setBounds(20, 58, 56, 20);
			}
			return name;
		}
		
		private JLabel getLblid() {
			if (lblid == null) {
				lblid = new JLabel();
				lblid.setText("ID: ");
				lblid.setBounds(20, 28, 86, 20);
			}
			return lblid;
		}
		

		private JButton getBtnSubmit() {
			if (btnSubmit == null) {
				btnSubmit = new JButton();
				btnSubmit.setText("Submit");
				btnSubmit.setBounds(104, 136, 81, 26);
				btnSubmit.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							try {
								onBtnSubmitClick(e);
							} catch (ClassNotFoundException e1) {
								e1.printStackTrace();
							}
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				});
			}
			return btnSubmit;
		}

		private JTextField getTxtCost() {
			if (txtCost == null) {
				txtCost = new JTextField();
				txtCost.setBounds(131, 93, 93, 20);
			}
			return txtCost;
		}

		private JLabel getLblCost() {
			if (lblCost == null) {
				lblCost = new JLabel();
				lblCost.setText("Rate:");
				lblCost.setBounds(20, 93, 100, 20);
			}
			return lblCost;
		}
		
		private JTextField getTxtName() {
			if (txtName == null) {
				txtName = new JTextField();
				txtName.setBounds(130, 58, 174, 20);
			}
			return txtName;
		}

		private JTextField getTxtId() {
			if (txtId == null) {
				txtId = new JTextField();
				txtId.setBounds(130, 28, 174, 20);
			}
			return txtId;
		}

//		private Parts sparePart = null;
//		
//		public Parts getSparePart() {
//			return sparePart;
//		}

		private void onBtnSubmitClick(ActionEvent event) throws IOException, ClassNotFoundException {
		    if (txtName == null || txtId == null || txtCost == null) {
		        System.out.println("Input fields are not initialized.");
		        return;
		    }

		    String name = txtName.getText();
		    String id = txtId.getText();
		    double cost;

		    try {
		        cost = Double.parseDouble(txtCost.getText());
		    } catch (NumberFormatException e) {
		        System.out.println("Invalid cost. Please enter a valid number.");
		        return;
		    }

		    if (name.isEmpty() || id.isEmpty()) {
		        System.out.println("All fields are required.");
		        return;
		    }

		    try {
		        PartsList = PartsDao.readParts();
		    } catch (FileNotFoundException e) {
		        System.out.println("No existing parts found. Starting fresh.");
		        PartsList = new LinkedList<>();
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		    }

		    Parts parts = new Parts(id, name, cost);
		    PartsList.add(parts);

		    PartsDao.writeCustomer(PartsList);

		    System.out.println("Part added successfully: " + parts);
		    dispose();
		}



			

}
