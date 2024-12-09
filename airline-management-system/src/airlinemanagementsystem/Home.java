package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener {

    public Home() {

        setLayout(null);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
        JLabel image = new JLabel(imageIcon);
        image.setBounds(0, 0, 1600, 800);
        add(image);

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
