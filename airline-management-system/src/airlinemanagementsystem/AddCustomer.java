package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;

public class AddCustomer extends JFrame {

    public AddCustomer() {

        getContentPane().setBackground(Color.gray);
        setLayout(null);
        // heading
        JLabel heading = new JLabel("Add Customer Details");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.setForeground(Color.WHITE);
        add(heading);

        // lavelname
        JLabel lblName = new JLabel("Name: ");
        lblName.setBounds(60, 80, 150, 25);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblName);

        // textfield for name
        JTextField tfName = new JTextField();
        tfName.setBounds(220, 80, 150, 25);
        add(tfName);

        // // lavel for nationality
        JLabel lblnationality = new JLabel("Nationality: ");
        lblnationality.setBounds(60, 130, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);

        // textfield for name
        JTextField tfnationality = new JTextField();
        tfnationality.setBounds(220, 130, 150, 25);
        add(tfnationality);

        // lavel and textfield for NID

        JLabel lblNid = new JLabel("NID: ");
        lblNid.setBounds(60, 180, 150, 25);
        lblNid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblNid);

        // textfield for name
        JTextField tflNid = new JTextField();
        tflNid.setBounds(220, 180, 150, 25);
        add(tflNid);

        
        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);

    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}