package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener {

    public Home() {

        setLayout(null);
        // add images
        ImageIcon imageIcon = new ImageIcon();
        imageIcon = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
        JLabel image = new JLabel(imageIcon);
        // image size
        image.setBounds(0, 0, 1600, 800);
        add(image);
        // heading add
        JLabel heading = new JLabel("WLCOME TO BANGLADESH");
        heading.setBounds(500, 20, 1000, 40);
        heading.setForeground(Color.GREEN);
        heading.setFont(new Font("Tahome", Font.BOLD, 36));
        image.add(heading);

        // make menubar

        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        // add details menubar
        JMenu details = new JMenu("Details");
        menubar.add(details);
        // add menu iteams for details menu
        JMenuItem flightDetails = new JMenu("Flight Details");
        details.add(flightDetails);
        JMenuItem customerDetails = new JMenu("Customers Details");
        details.add(customerDetails);
        JMenuItem reservationDetails = new JMenu("Reservation Details");
        details.add(reservationDetails);
        JMenuItem journeyDetails = new JMenu("Journey Details");
        details.add(journeyDetails);
        JMenuItem bookDetails = new JMenu("Book Ticket");
        details.add(bookDetails);
        JMenuItem cancelDetails = new JMenu("Cancel Ticket");
        details.add(cancelDetails);

        // menubar for ticket
        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);
        // add menu iteams
        JMenuItem ticketDetails = new JMenu("Ticket Details");
        ticket.add(ticketDetails);
        JMenuItem bordingDetails = new JMenu("Bording Details");
        ticket.add(bordingDetails);
        // setSize(600, 350);
        // setLocation(600, 250);
        // size will be max as screensize
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    public static void main(String[] args) {
        new Home();
    }

}
