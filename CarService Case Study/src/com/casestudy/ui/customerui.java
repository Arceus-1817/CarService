package com.casestudy.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
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

import com.casestudy.Customer;
import com.casestudy.dao.CustomerDao;
import com.casestudy.submenu.*;

public class customerui extends JDialog {

    static HashSet<Customer> CustomerSet = new HashSet<>();

    private static final long serialVersionUID = 1L;

    public customerui() {

        setTitle("Customer");
        setSize(800, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        JButton b6 = new JButton("Existing Customer");
        b6.setBounds(300, 100, 150, 50);
        add(b6);

        JButton b7 = new JButton("New Customer");
        b7.setBounds(300, 170, 150, 50);
        add(b7);

        b6.addActionListener(e -> {
            try {
                ExistingCustomer existingCustomer = new ExistingCustomer(this);
                existingCustomer.setVisible(true);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace(); 
            }
        });

        b7.addActionListener(e -> {
            NewCustomer newCustomer = new NewCustomer(this);
            newCustomer.setVisible(true);
        });
    }

    public class ExistingCustomer extends JDialog {
        private JComboBox<String> comboCustomerType;

        public ExistingCustomer(Window parent) throws ClassNotFoundException {
           // super(parent, "Existing Customer", ModalityType.APPLICATION_MODAL);
            setSize(800, 500);
            setLayout(null);
            getContentPane().setBackground(Color.gray);

            try {
            	CustomerSet.addAll(CustomerDao.readCustomer());
            } catch (IOException e) {
                System.out.println("Error reading customers: " + e.getMessage());
            }

            initComponents();
        }

        private void initComponents() {
            JLabel lblSelectCustomer = new JLabel("Select Customer:");
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

                for (Customer customer : CustomerSet) {
                    comboCustomerType.addItem(customer.toString());
                }
            }
            return comboCustomerType;
        }
    }

    public class NewCustomer extends JDialog {
        private JLabel jLabel1;
        private JLabel jLabel0;
        private JLabel jLabel2;
        private JTextField txtCustomerName;
        private JTextField txtAddress;
        private JTextField txtMobile;
        private JButton btnSubmit;

        public NewCustomer(Window parent) {
            super(parent, "New Customer", ModalityType.APPLICATION_MODAL);
            setSize(400, 300);
            setLayout(null);
            getContentPane().setBackground(Color.WHITE);
            initComponents();
        }

        private void initComponents() {
            add(getJLabel1());
            add(getJLabel0());
            add(getJLabel2());
            add(getTxtCustomerName());
            add(getTxtAddress());
            add(getTxtMobile());
            add(getBtnSubmit());
        }

        private JButton getBtnSubmit() {
            if (btnSubmit == null) {
                btnSubmit = new JButton();
                btnSubmit.setText("Submit");
                btnSubmit.setBounds(150, 200, 100, 30);
                btnSubmit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        try {
							btnSubmitActionActionPerformed(event);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    }
                });
            }
            return btnSubmit;
        }

        private JTextField getTxtMobile() {
            if (txtMobile == null) {
                txtMobile = new JTextField();
                txtMobile.setBounds(150, 130, 200, 25);
            }
            return txtMobile;
        }

        private JTextField getTxtAddress() {
            if (txtAddress == null) {
                txtAddress = new JTextField();
                txtAddress.setBounds(150, 90, 200, 25);
            }
            return txtAddress;
        }

        private JTextField getTxtCustomerName() {
            if (txtCustomerName == null) {
                txtCustomerName = new JTextField();
                txtCustomerName.setBounds(150, 50, 200, 25);
            }
            return txtCustomerName;
        }

        private JLabel getJLabel2() {
            if (jLabel2 == null) {
                jLabel2 = new JLabel();
                jLabel2.setText("Mobile:");
                jLabel2.setBounds(50, 130, 100, 25);
            }
            return jLabel2;
        }

        private JLabel getJLabel0() {
            if (jLabel0 == null) {
                jLabel0 = new JLabel();
                jLabel0.setText("Customer Name:");
                jLabel0.setBounds(50, 50, 100, 25);
            }
            return jLabel0;
        }

        private JLabel getJLabel1() {
            if (jLabel1 == null) {
                jLabel1 = new JLabel();
                jLabel1.setText("Address:");
                jLabel1.setBounds(50, 90, 100, 25);
            }
            return jLabel1;
        }

        private void btnSubmitActionActionPerformed(ActionEvent event) throws IOException {
            String name = txtCustomerName.getText();
            String mobile = txtMobile.getText();
            String address = txtAddress.getText();

            if (name.isEmpty() || address.isEmpty() || mobile.isEmpty()) {
                System.out.println("All fields are required.");
                return;
            }

            Customer customer = new Customer(name, mobile,address );
            CustomerSet.add(customer);

            CustomerDao.writeCustomer(CustomerSet);

            System.out.println("Customer added successfully: " + customer);
            dispose();
        }
    }
}
