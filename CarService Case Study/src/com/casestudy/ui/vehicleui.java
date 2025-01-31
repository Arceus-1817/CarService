package com.casestudy.ui;


	import java.awt.Color;
	import java.awt.Dialog;
	import java.awt.Font;
	import java.awt.Frame;
	import java.awt.GraphicsConfiguration;
	import java.awt.Window;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
	import javax.swing.JLabel;
	import javax.swing.JTextField;

	import com.casestudy.*;
import com.casestudy.dao.CustomerDao;
import com.casestudy.dao.VehicleDao;
import com.casestudy.ui.customerui.ExistingCustomer;
import com.casestudy.ui.customerui.NewCustomer;
import com.casestudy.submenu.*;

	public class vehicleui extends JDialog {

		
		static HashSet<Vehicle> VehicleSet = new HashSet<>(); 
		
	    private static final long serialVersionUID = 1L;

		
		
	    public vehicleui() {

	        setTitle("Vehicle");
	        setSize(800, 300);
	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        setLayout(null);
	        getContentPane().setBackground(Color.LIGHT_GRAY);


	        JButton b7 = new JButton("New Vehicle");
	        b7.setBounds(300, 170, 150, 50);
	        add(b7);
	        
	        JButton b8 = new JButton("Customer Vehicle");
	        b8.setBounds(300, 170, 150, 50);
	        add(b8);

	        b8.addActionListener(e -> {
	            try {
	                CustomerVehicle customerVehicle = new CustomerVehicle(this);
	                customerVehicle.setVisible(true);
	            } catch (ClassNotFoundException ex) {
	                ex.printStackTrace(); 
	            }
	        });

	        b7.addActionListener(e -> {
	            NewVehicle newVehicle = new NewVehicle(this);
	            newVehicle.setVisible(true);
	        });
	    }
		
		
		
		
		
	    public class CustomerVehicle extends JDialog {
	        private JComboBox<String> comboCustomerType;
	        
	        private JLabel phno;
	        private JTextField txtphno;
	        
//	        private void initComponents() {
//	            
//	            
//	        }
	        
	        private JTextField getTxtphno() {
	            if (txtphno == null) {
	            	txtphno = new JTextField();
	            	txtphno.setBounds(150, 50, 200, 25);
	            }
	            return txtphno;
	        }

	        private JLabel getphno() {
	            if (phno == null) {
	            	phno = new JLabel();
	            	phno.setText("Mobile:");
	            	phno.setBounds(50, 130, 100, 25);
	            }
	            return phno;
	        }
	        
	        

	        

	        public CustomerVehicle(Window parent) throws ClassNotFoundException {
	           // super(parent, "Existing Customer", ModalityType.APPLICATION_MODAL);
	            setSize(800, 500);
	            setLayout(null);
	            getContentPane().setBackground(Color.gray);

	            try {
	            	VehicleSet.addAll(VehicleDao.readVehicle());
	            } catch (IOException e) {
	                System.out.println("Error reading vehicle: " + e.getMessage());
	            }

	            initComponents();
	        }

	        private void initComponents() {
	        	
	        	add(getTxtphno());
	            add(getphno());
	        	
	            JLabel lblSelectCustomer = new JLabel("Select Vehicle:");
	            lblSelectCustomer.setBounds(50, 50, 150, 25);
	            add(lblSelectCustomer);

	            add(getComboCustomerType());

	            JButton btnViewDetails = new JButton("View Details");
	            btnViewDetails.setBounds(150, 200, 100, 30);
	            add(btnViewDetails);

	            btnViewDetails.addActionListener(e -> {
	                String selectedCustomer = (String) comboCustomerType.getSelectedItem();
	                if (selectedCustomer != null) {
	                    System.out.println("Selected Customer: " + selectedCustomer);
	                }
	            });
	        }

	        private JComboBox<String> getComboCustomerType() {
	            if (comboCustomerType == null) {
	                comboCustomerType = new JComboBox<>();
	                comboCustomerType.setBounds(150, 100, 500, 25);

	                for (Vehicle vehicle : VehicleSet) {
	                    comboCustomerType.addItem(vehicle.toString());
	                }
	            }
	            return comboCustomerType;
	        }
	    }

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	    public class NewVehicle extends JDialog{
		
		private JLabel jLabel1;
		private JLabel jLabel0;
		private JLabel jLabel2;
		private JTextField txtVehNumber;
		private JTextField txtCompany;
		private JTextField txtModel;
		private JButton btnSubmit;

		public NewVehicle(Window parent) {
            super(parent, "New Vehicle", ModalityType.APPLICATION_MODAL);
            setSize(400, 300);
            setLayout(null);
            getContentPane().setBackground(Color.gray);
            initComponents();
        }

		private void initComponents() {
			setForeground(Color.black);
			setBackground(Color.white);
			setFont(new Font("Dialog", Font.PLAIN, 12));
			setLayout(null);
			add(getJLabel1());
			add(getJLabel0());
			add(getJLabel2());
			add(getTxtVehNumber());
			add(getTxtCompany());
			add(getTxtModel());
			add(getBtnSubmit());
			setSize(301, 200);
		}

		private JButton getBtnSubmit() {
			if (btnSubmit == null) {
				btnSubmit = new JButton();
				btnSubmit.setText("Submit");
				btnSubmit.setBounds(103, 123, 81, 26);
				btnSubmit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						try {
							btnSubmitActionActionPerformed(event);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
			}
			return btnSubmit;
		}

		private JTextField getTxtModel() {
			if (txtModel == null) {
				txtModel = new JTextField();
				txtModel.setBounds(127, 88, 150, 20);
			}
			return txtModel;
		}

		private JTextField getTxtCompany() {
			if (txtCompany == null) {
				txtCompany = new JTextField();
				txtCompany.setBounds(125, 54, 152, 20);
			}
			return txtCompany;
		}

		private JTextField getTxtVehNumber() {
			if (txtVehNumber == null) {
				txtVehNumber = new JTextField();
				txtVehNumber.setBounds(125, 18, 155, 20);
			}
			return txtVehNumber;
		}

		private JLabel getJLabel2() {
			if (jLabel2 == null) {
				jLabel2 = new JLabel();
				jLabel2.setText("Model : ");
				jLabel2.setBounds(16, 87, 70, 16);
			}
			return jLabel2;
		}

		private JLabel getJLabel0() {
			if (jLabel0 == null) {
				jLabel0 = new JLabel();
				jLabel0.setText("Veh Number : ");
				jLabel0.setBounds(17, 18, 107, 16);
			}
			return jLabel0;
		}

		private JLabel getJLabel1() {
			if (jLabel1 == null) {
				jLabel1 = new JLabel();
				jLabel1.setText("Company : ");
				jLabel1.setBounds(16, 49, 113, 16);
			}
			return jLabel1;
		}

		//private Vehicle vehicle = null;
		
//		public Vehicle getVehicle() {
//			return vehicle;
//		}

		private void btnSubmitActionActionPerformed(ActionEvent event) throws IOException {
		    String regno = txtVehNumber.getText();
		    String company = txtCompany.getText();
		    String model = txtModel.getText();

		    if (regno.isEmpty() || company.isEmpty() || model.isEmpty()) {
		        System.out.println("All fields are required.");
		        return;
		    }

		    try {
		        VehicleSet = VehicleDao.readVehicle();
		    } catch (FileNotFoundException e) {
		        VehicleSet = new HashSet<>();
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		    }

		    Vehicle vehicle = new Vehicle(regno, company, model);
		    VehicleSet.add(vehicle);

		    VehicleDao.writeVehicle(VehicleSet);

		    System.out.println("Vehicle added successfully: " + vehicle);
		    dispose();
		}

		
	
	    }
}
	
