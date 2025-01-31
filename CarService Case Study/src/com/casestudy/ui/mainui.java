package com.casestudy.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.casestudy.sales;
import com.casestudy.submenu.CustomerSubmenu;
import com.casestudy.submenu.PartsSubmenu;
import com.casestudy.submenu.ServiceSubmenu;
import com.casestudy.submenu.Vehiclesubmenu;

public class mainui extends JFrame{
		private JButton customerButton;
		private JButton vehiclesButton;
		private JButton serviceRequestButton;
		private JButton partsButton;
	    private JLabel nameLabel;
	    private JLabel welcomeLabel;
	    private JLabel JButton;
	    
	    public mainui() {
	    	
	    		    	
	    setTitle("My Shop");
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        welcomeLabel = new JLabel();
        welcomeLabel.setText("WELCOME TO OUR SHOP");
        welcomeLabel.setBounds(200,3,500,50);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 26));        
        add(welcomeLabel);
        
        JButton b1 = new JButton("Customer");
        b1.setBounds(300, 100, 100, 50);
        add(b1);
        JButton b2 = new JButton("Vehicle");
        b2.setBounds(300, 170, 100, 50);
        add(b2);
        JButton b3 = new JButton("Service");
        b3.setBounds(300, 240, 100, 50);
        add(b3);
        JButton b4 = new JButton("Parts");
        b4.setBounds(300, 310, 100, 50);
        add(b4);
        JButton b5 = new JButton("Sales");
        b5.setBounds(300, 380, 100, 50);
        add(b5);
        JButton bill = new JButton("BILL");
        bill.setBounds(300, 460, 50, 50);
        add(bill);
        
        
        
        
        b1.addActionListener(e -> {
        	
        	customerui wnd1 = new customerui();
            wnd1.setVisible(true);
        	
        });

        b2.addActionListener(e -> {
            vehicleui wnd2 = new vehicleui();
            wnd2.setVisible(true);
        });

        b3.addActionListener(e -> {
            serviceui wnd = new serviceui();
            wnd.setVisible(true);
        });

        b4.addActionListener(e -> {
            partsui wnd3 = new partsui(null);
            wnd3.setVisible(true);
        });
        
        
        bill.addActionListener(e -> {
        	billui wnd4 = new billui();
        	wnd4.setVisible(true);
        });
        
        

//        todaysSalesButton.addActionListener(e -> {
//            sales.todaysale();
        }
        
        
	      
	    
public static void main(String []args) {
	mainui ui =new mainui();
	ui.setVisible(true);
}
}
