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

public class customertest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Shop Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            private JButton customerButton;
            //JPanel panel = new JPanel();
           // panel.setLayout(new GridLayout(7, 1, 10, 10));

            JLabel welcomeLabel = new JLabel("Welcome to Our Shop :)", JLabel.CENTER);
            welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
            
//            ImageIcon customerIcon = new ImageIcon("customer.png");
//            ImageIcon vehicleIcon = new ImageIcon("vehicle.png");
//            ImageIcon partsIcon = new ImageIcon("spare-parts-2.png");
//            ImageIcon serviceIcon = new ImageIcon("service.png");

            customerButton = new JButton("Customer");
            customerButton.setBounds(100, 100, 100, 50);
            add(customerButton);
            JButton vehiclesButton = new JButton("Vehicle");
            vehiclesButton.setBounds(100, 100, 100, 50);
            JButton serviceRequestButton = new JButton("Service");
            JButton partsButton = new JButton("Parts");
            JButton todaysSalesButton = new JButton("Today's Sales");
            JButton specificDaySalesButton = new JButton("Sales of Specific Day");
            JButton exitButton = new JButton("Exit");

//            panel.add(welcomeLabel);
//            panel.add(customerButton);
//            panel.add(vehiclesButton);
//            panel.add(serviceRequestButton);
//            panel.add(partsButton);
//            panel.add(todaysSalesButton);
//            panel.add(specificDaySalesButton);
//            panel.add(exitButton);

           // frame.add(panel);
            frame.setVisible(true);

            // Event Listeners for Buttons
            customerButton.addActionListener(e -> {
                customerui wnd1 = new customerui(null);
                wnd1.setVisible(true);
            });

            vehiclesButton.addActionListener(e -> {
                vehicleui wnd2 = new vehicleui(null);
                wnd2.setVisible(true);
            });

            serviceRequestButton.addActionListener(e -> {
                serviceui wnd = new serviceui();
                wnd.setVisible(true);
            });

            partsButton.addActionListener(e -> {
                partsui wnd3 = new partsui(null);
                wnd3.setVisible(true);
            });

            todaysSalesButton.addActionListener(e -> {
                sales.todaysale();
            });

//            specificDaySalesButton.addActionListener(e -> {
//                String date = JOptionPane.showInputDialog(frame, "Enter the date (YYYY-MM-DD):", "Sales of Specific Day", JOptionPane.QUESTION_MESSAGE);
//                if (date != null) {
//                    sales.salesOfSpecificDay(date);
//                }
//            });

            exitButton.addActionListener(e -> {
                frame.dispose();
            });
        });
    }
}
