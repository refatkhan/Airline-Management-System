package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookFlight extends JFrame implements ActionListener {

    JTextField tflNid;
    JLabel tfName, tfnationality, tfAdress, tfPhone, labelgender;
    Choice source, destination;

    public BookFlight() {

        getContentPane().setBackground(Color.gray);
        setLayout(null);
        // heading
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(400, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.setForeground(Color.WHITE);
        add(heading);
        // we will search data by nid
        JLabel lblNid = new JLabel("NID: ");
        lblNid.setBounds(60, 80, 150, 25);
        lblNid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblNid);

        // fetchButton
        JButton fetchButton = new JButton("Fetch");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.white);
        fetchButton.setBounds(380, 80, 120, 25);
        add(fetchButton);

        // textfield for Nid
        tflNid = new JTextField();
        tflNid.setBounds(220, 80, 150, 25);
        add(tflNid);
        // lavelname
        JLabel lblName = new JLabel("Name: ");
        lblName.setBounds(60, 130, 150, 25);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblName);

        // textfield for name
        tfName = new JLabel();
        tfName.setBounds(220, 130, 150, 25);
        add(tfName);

        // // lavel for nationality
        JLabel lblnationality = new JLabel("Nationality: ");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);

        // textfield for Nationality
        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);

        // address
        JLabel lblAddress = new JLabel("Adress: ");
        lblAddress.setBounds(60, 230, 150, 25);
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAddress);
        tfAdress = new JLabel();
        tfAdress.setBounds(220, 230, 150, 25);
        add(tfAdress);

        // radio button
        JLabel lblGender = new JLabel("Gender: ");
        lblGender.setBounds(60, 280, 150, 25);
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblGender);

        JLabel labelgender = new JLabel();
        labelgender.setBounds(220, 280, 150, 25);
        add(labelgender);

        // Departure
        JLabel lblsource = new JLabel("Source: ");
        lblsource.setBounds(60, 330, 150, 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsource);

        // dropdown
        Choice source = new Choice();
        source.setBounds(220, 330, 120, 25);

        add(source);

        // add destination
        JLabel lbldestination = new JLabel("Destinaion: ");
        lbldestination.setBounds(60, 380, 150, 25);
        lbldestination.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldestination);

        Choice destination = new Choice();
        destination.setBounds(220, 380, 120, 25);

        add(destination);

        try {

            Connect connect = new Connect();
            String query = "select * from flight";
            ResultSet rs = connect.statement.executeQuery(query);

            while (rs.next()) {
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton save = new JButton("Saved");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220, 380, 150, 30);
        save.addActionListener(this);
        add(save);

        ImageIcon imageIcon = new ImageIcon();
        imageIcon = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel lblimage = new JLabel(imageIcon);
        lblimage.setBounds(450, 80, 280, 400);
        add(lblimage);
        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        String name = tfName.getText();
        String nationality = tfnationality.getText();
        String phone = tfPhone.getText();
        String nid = tflNid.getText();
        String address = tfAdress.getText();
        String gender = null;

        try {
            Connect connect = new Connect();
            String query = "insert into passenger values('" + name + "', '" + nationality + "', '" + phone + "', '"
                    + address + "', '" + nid + "', '" + gender + "')";
            connect.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Customer Details added succesfull");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new BookFlight();
    }
}