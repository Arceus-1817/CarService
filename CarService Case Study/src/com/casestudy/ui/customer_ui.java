package com.casestudy.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class customer_ui extends JFrame {
    private JButton submitButton;
    private JLabel nameLabel;
    private JLabel phNoLabel;
    private JLabel addressLabel;
    private JTextField nameTextField;
    private JComboBox<String> cityComboBox;

    public customer_ui() {
        setTitle("My Shop");
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        // Colors for hover effect
        Color defaultColor = Color.DARK_GRAY;
        Color hoverColor = Color.yellow;
       
        JButton b1 = new JButton("");
        b1.setBounds(250, 100, 50, 50);
        add(b1);
        JButton b2 = new JButton("");
        b2.setBounds(250, 150, 50, 50);
        add(b2);
        JButton b3 = new JButton("");
        b3.setBounds(250, 200, 50, 50);
        add(b3);
        JButton b4 = new JButton("");
        b4.setBounds(250, 250, 50, 50);
        add(b4);
        JButton b5 = new JButton("tower");
        b5.setBounds(250, 300, 50, 50);
        add(b5);
        
        
        JButton plane = new JButton("plane");
        plane.setBounds(450, 150, 200, 25);
        add(plane);
        
        plane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                plane.setBounds(400, 150, 200, 25);  // Adjust position on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	plane.setText("BOOM !!!!");
                plane.setBounds(300, 150, 200, 25); // Revert position and color
            }
        });
        
        
        
        
        b5.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().remove(b1);
				getContentPane().remove(b2);
				getContentPane().remove(b3);
				getContentPane().remove(b4);
				getContentPane().remove(b5 );
                //getContentPane().setBackground(Color.black);
				JButton b1 = new JButton("");
		        b1.setBounds(250, 300, 50, 50);
		        add(b1);
		        JButton b2 = new JButton("");
		        b2.setBounds(200, 300, 50, 50);
		        add(b2);
		        JButton b3 = new JButton("");
		        b3.setBounds(150, 300, 50, 50);
		        add(b3);
		        JButton b4 = new JButton("");
		        b4.setBounds(100, 300, 50, 50);
		        add(b4);
		        JButton b5 = new JButton("");
		        b5.setBounds(50, 300, 50, 50);
		        add(b5);
        
		        revalidate();
                repaint();
		    
			}
		});
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        // Create a button
        JButton button = new JButton("Click Me!");
        button.setBounds(100, 50, 100, 30);
        button.setBorder(null);
        button.setBackground(defaultColor);
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        button.setOpaque(true);

        // Add hover effect using MouseListener
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	button.setBounds(100,250,200,50);
                button.setBackground(hoverColor); // Change background on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBounds(100, 250, 100, 30);

                button.setBackground(defaultColor); // Revert background when mouse exits
            }
        });

        // Add the button to the frame
        this.add(button);
        
        
        
        
        
        button.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
                getContentPane().setBackground(Color.black);

                // Create new buttons at different positions
                JButton button1 = new JButton("Error !");
                button1.setBounds(100, 250, 100, 40);
                add(button1);

                JButton button2 = new JButton("Error !");
                button2.setBounds(200, 350, 400, 130);
                add(button2);

                JButton button3 = new JButton("Error !");
                button3.setBounds(500, 500, 200, 80);
                add(button3);

                JButton button4 = new JButton("Error !");
                button4.setBounds(400, 10, 300, 50);
                add(button4);

                JButton button5 = new JButton("Error !");
                button5.setBounds(10, 100, 400, 110);
                add(button5);

                JButton button6 = new JButton("Error !");
                button6.setBounds(170, 400, 100, 130);
                add(button6);

                JButton button7 = new JButton("Error !");
                button7.setBounds(260, 520, 200, 30);
                add(button7);

                JButton button8 = new JButton("Error !");
                button8.setBounds(60, 170, 300, 60);
                add(button8);

                JButton button9 = new JButton("Error !");
                button9.setBounds(390, 330, 400, 130);
                add(button9);

                JButton button10 = new JButton("Error !");
                button10.setBounds(550, 200, 100, 90);
                add(button10);

                // Refresh the frame to reflect changes
                revalidate();
                repaint();
		        


			}
		});
    }

}
