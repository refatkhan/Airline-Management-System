package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.Random;

public class BoardingPass extends JFrame implements ActionListener {

    JTextField tflNid;
    JLabel tfName, lblSource, lblDestination, tfnationality, tfAddress, labelGender, lblFname, lblFlcode;
    Choice source, destination;
    JButton bookFlight, fetchUserButton, flightButton;
    JDateChooser ddate;

    public BoardingPass() {

        getContentPane().setBackground(Color.gray);
        setLayout(null);

        // Heading
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(400, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.setForeground(Color.WHITE);
        add(heading);

        // NID Input
        JLabel lblNid = new JLabel("NID: ");
        lblNid.setBounds(60, 80, 150, 25);
        lblNid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblNid);

        fetchUserButton = new JButton("Fetch User Details");
        fetchUserButton.setBackground(Color.BLACK);
        fetchUserButton.setForeground(Color.white);
        fetchUserButton.setBounds(380, 80, 150, 25);
        fetchUserButton.addActionListener(this);
        add(fetchUserButton);

        tflNid = new JTextField();
        tflNid.setBounds(220, 80, 150, 25);
        add(tflNid);

        // Name
        JLabel lblName = new JLabel("Name: ");
        lblName.setBounds(60, 130, 150, 25);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblName);

        tfName = new JLabel();
        tfName.setBounds(220, 130, 150, 25);
        add(tfName);

        // Nationality
        JLabel lblNationality = new JLabel("Nationality: ");
        lblNationality.setBounds(60, 180, 150, 25);
        lblNationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblNationality);

        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);

        // Address
        JLabel lblAddress = new JLabel("Address: ");
        lblAddress.setBounds(60, 230, 150, 25);
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAddress);

        tfAddress = new JLabel();
        tfAddress.setBounds(220, 230, 150, 25);
        add(tfAddress);

        // Gender
        JLabel lblGender = new JLabel("Gender: ");
        lblGender.setBounds(60, 280, 150, 25);
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblGender);

        labelGender = new JLabel();
        labelGender.setBounds(220, 280, 150, 25);
        add(labelGender);

        // Source
        lblSource = new JLabel("Source:");
        lblSource.setBounds(60, 330, 150, 25);
        lblSource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblSource);

        source = new Choice();
        source.setBounds(220, 330, 150, 25);
        add(source);

        // Destination
        lblDestination = new JLabel("Destination:");
        lblDestination.setBounds(60, 380, 150, 25);
        lblDestination.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblDestination);

        destination = new Choice();
        destination.setBounds(220, 380, 150, 25);
        add(destination);

        try {
            Connect connect = new Connect();
            String query = "SELECT * FROM flight";
            ResultSet rs = connect.statement.executeQuery(query);

            while (rs.next()) {
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Flight Button
        flightButton = new JButton("See Flight");
        flightButton.setBackground(Color.BLACK);
        flightButton.setForeground(Color.WHITE);
        flightButton.setBounds(380, 380, 150, 25);
        flightButton.addActionListener(this);
        add(flightButton);

        // Flight Name and Code
        lblFname = new JLabel("Flight Name:");
        lblFname.setBounds(60, 430, 150, 25);
        lblFname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblFname);

        lblFname = new JLabel();
        lblFname.setBounds(220, 430, 150, 25);
        add(lblFname);

        lblFlcode = new JLabel("Flight Code:");
        lblFlcode.setBounds(60, 480, 150, 25);
        lblFlcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblFlcode);

        lblFlcode = new JLabel();
        lblFlcode.setBounds(220, 480, 150, 25);
        add(lblFlcode);

        // Travel Date
        JLabel lblDate = new JLabel("Travel Date:");
        lblDate.setBounds(60, 530, 150, 25);
        lblDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblDate);

        ddate = new JDateChooser();
        ddate.setBounds(220, 530, 150, 25);
        add(ddate);

        bookFlight = new JButton("Book Flight");
        bookFlight.setBackground(Color.CYAN);
        bookFlight.setForeground(Color.WHITE);
        bookFlight.setBounds(220, 580, 150, 25);
        bookFlight.addActionListener(this);
        add(bookFlight);

        setSize(1000, 750);
        setLocation(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetchUserButton) {
            String nid = tflNid.getText();
            try {
                Connect connect = new Connect();
                String query = "SELECT * FROM passenger WHERE nid = '" + nid + "'";
                ResultSet rs = connect.statement.executeQuery(query);
                if (rs.next()) {
                    tfName.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));
                    tfAddress.setText(rs.getString("address"));
                    labelGender.setText(rs.getString("gender"));
                } else {
                    JOptionPane.showMessageDialog(null, "User not found.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == flightButton) {
            try {
                Connect connect = new Connect();
                String query = "SELECT * FROM flight WHERE source = '" + source.getSelectedItem() +
                        "' AND destination = '" + destination.getSelectedItem() + "'";
                ResultSet rs = connect.statement.executeQuery(query);
                if (rs.next()) {
                    lblFname.setText(rs.getString("f_name"));
                    lblFlcode.setText(rs.getString("f_code"));
                } else {
                    JOptionPane.showMessageDialog(null, "No flights found.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == bookFlight) {
            try {
                Random random = new Random();
                String nid = tflNid.getText();
                String name = tfName.getText();
                String nationality = tfnationality.getText();
                String flightName = lblFname.getText();
                String flightCode = lblFlcode.getText();
                String src = source.getSelectedItem();
                String dest = destination.getSelectedItem();
                String travelDate = ((JTextField) ddate.getDateEditor().getUiComponent()).getText();

                Connect connect = new Connect();
                String query = "INSERT INTO reservation VALUES ('PNR-" + random.nextInt(1000000) +
                        "', 'TIC-" + random.nextInt(10000) + "', '" + nid + "', '" + name + "', '" +
                        nationality + "', '" + flightName + "', '" + flightCode + "', '" + src +
                        "', '" + dest + "', '" + travelDate + "')";
                connect.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Flight booked successfully!");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new BoardingPass();
    }
}
