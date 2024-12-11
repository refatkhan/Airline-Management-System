package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Random;

public class Cancel extends JFrame implements ActionListener {

    public Cancel() {

        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(180, 20, 250, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(heading);
    }

    public static void main(String[] args) {
        new Cancel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
