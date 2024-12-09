package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;

public class AddCustomer extends JFrame {

    public AddCustomer() {

        getContentPane().setBackground(Color.gray);
        setLayout(null);
        // heading
        JLabel heading = new JLabel("Add Customer Details");
        heading.setBounds(250, 20, 450, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.setForeground(Color.WHITE);
        add(heading);
        // lavelname
        JLabel lblName = new JLabel("Name: ");
        lblName.setBounds(50, 80, 150, 20);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblName);

    //textfield
    

        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);

    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}