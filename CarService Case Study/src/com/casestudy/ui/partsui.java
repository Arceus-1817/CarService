package com.casestudy.ui;

	
	

	import java.awt.Color;
	import java.awt.Dialog;
	import java.awt.Font;
	import java.awt.Frame;
	import java.awt.GraphicsConfiguration;
	import java.awt.Window;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.ButtonGroup;
	import javax.swing.JButton;
	import javax.swing.JDialog;
	import javax.swing.JLabel;
	import javax.swing.JRadioButton;
	import javax.swing.JTextField;
	import javax.swing.event.ChangeEvent;
	import javax.swing.event.ChangeListener;

	import com.casestudy.*;
	

	//VS4E -- DO NOT REMOVE THIS LINE!
	public class partsui extends JDialog{

		private static final long serialVersionUID = 1L;
		private JLabel lblDesc;
		private JTextField txtDesc;
		private JLabel lblCost;
		private JTextField txtCost;
		private JButton btnSubmit;
		private JLabel name;
		private JTextField txtName;

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
			add(getTxtDesc());
			add(getLblCost());
			add(getTxtCost());
			add(getBtnSubmit());
			add(getLblDesc());
			setSize(340, 231);
		}

		private JLabel getname() {
			if (name == null) {
				name = new JLabel();
				name.setText("Name: ");
				name.setBounds(20, 58, 86, 20);
			}
			return name;
		}
		
		private JLabel getLblDesc() {
			if (lblDesc == null) {
				lblDesc = new JLabel();
				lblDesc.setText("Description: ");
				lblDesc.setBounds(20, 58, 86, 20);
			}
			return lblDesc;
		}
		

		private JButton getBtnSubmit() {
			if (btnSubmit == null) {
				btnSubmit = new JButton();
				btnSubmit.setText("Submit");
				btnSubmit.setBounds(104, 136, 81, 26);
				btnSubmit.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						onBtnSubmitClick();
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
				lblCost.setBounds(18, 93, 100, 20);
			}
			return lblCost;
		}
		
		private JTextField getTxtName() {
			if (txtName == null) {
				txtName = new JTextField();
				txtName.setBounds(130, 57, 174, 20);
			}
			return txtName;
		}

		private JTextField getTxtDesc() {
			if (txtDesc == null) {
				txtDesc = new JTextField();
				txtDesc.setBounds(130, 57, 174, 20);
			}
			return txtDesc;
		}

		private Parts sparePart = null;
		
		public Parts getSparePart() {
			return sparePart;
		}

		private void onBtnSubmitClick() {
			String name = txtName.getText();
			String desc = txtDesc.getText();
			double cost = Double.parseDouble(txtCost.getText());
			sparePart = new Parts(name, desc, cost);
			this.dispose();
		}

}
