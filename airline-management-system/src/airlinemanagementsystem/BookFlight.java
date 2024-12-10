package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;

public class BookFlight extends JFrame implements ActionListener {

    JTextField tflNid;
    JLabel tfName, tfnationality, tfAdress, tfPhone, labelgender, lblfname, lblflcode, lbldate;
    Choice source, destination;
    JButton bookflight, fetchUserButton, flight;
    JDateChooser date;

    /**
     * 
     */
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
        fetchUserButton = new JButton("Fetch User Details1");
        fetchUserButton.setBackground(Color.BLACK);
        fetchUserButton.setForeground(Color.white);
        fetchUserButton.setBounds(380, 80, 120, 25);
        fetchUserButton.addActionListener(this);
        add(fetchUserButton);

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

        destination = new Choice();
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
        // flight button
        flight = new JButton("See Flight: ");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(380, 380, 120, 25);
        flight.addActionListener(this);
        add(flight);
        // label for fliht name
        JLabel lblflightname = new JLabel("Flight Name: ");
        lblflightname.setBounds(60, 430, 150, 25);
        lblflightname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblflightname);

        lblfname = new JLabel();
        lblfname.setBounds(220, 430, 150, 25);
        add(lblfname);
        // label for flight code
        JLabel lblfcode = new JLabel("Flight Code: ");
        lblfcode.setBounds(60, 480, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);

        lblfcode = new JLabel();
        lblfcode.setBounds(220, 480, 150, 25);
        add(lblfcode);
        // label for date
        JLabel lbldate = new JLabel("Travel Date: ");
        lbldate.setBounds(60, 530, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);

        date = new JDateChooser();
        date.setBounds(220, 530, 150, 25);
        add(date);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550, 80, 500, 410);
        add(lblimage);

        bookflight = new JButton("Book Flight ");
        bookflight.setBackground(Color.YELLOW);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(220, 580, 150, 25);
        bookflight.addActionListener(this);
        add(bookflight);

        setSize(1200, 800);
        setLocation(300, 150);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetchUserButton) {

            String nid = tflNid.getText();

            try {
                Connect connect = new Connect();
                String query = "select * from passenger where nid = '" + nid + "'";
                ResultSet rs = connect.statement.executeQuery(query);
                if (rs.next()) {
                    tfName.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));
                    tfAdress.setText(rs.getString("address"));
                    labelgender.setText(rs.getString("gender"));
                } else {
                    JOptionPane.showMessageDialog(null, "Didn't Find ");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new BookFlight();
    }
}