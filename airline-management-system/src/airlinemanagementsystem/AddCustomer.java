package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;

public class AddCustomer extends JFrame {

    public AddCustomer() {

        getContentPane().setBackground(Color.darkGray);
        setLayout(null);

        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);

    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}