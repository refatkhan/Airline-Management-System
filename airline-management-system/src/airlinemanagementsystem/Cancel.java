package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Random;

public class Cancel extends JFrame implements ActionListener {

    JTextField tfpnr;

    public Cancel() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        Random random = new Random();

        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(180, 20, 250, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(heading);
        JLabel lblnid = new JLabel("PNR Number");
        lblnid.setBounds(60, 80, 150, 25);
        lblnid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnid);
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 150, 25);
        add(tfpnr);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(470, 120, 250, 250);
        add(image);

        setSize(800, 450);
        setLocation(350, 150);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Cancel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
