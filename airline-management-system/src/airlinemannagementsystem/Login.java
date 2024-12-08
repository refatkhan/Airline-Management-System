
package airlinemannagementsystem;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author REFAT KHAN
 */
public class Login extends JFrame {
    
    public Login(){
        //frame colour change
        getContentPane().setBackground(Color.yellow);
        setLayout(null);
        //username create
        JLabel lblusername = new JLabel ("Username: ");
        lblusername.setBounds(20, 20, 100, 20);
        add(lblusername);
        JTextField tfusername = new JTextField();
        tfusername.setBounds(100, 20, 150, 20);
        add(tfusername);
        
         //password create
        JLabel lblpassword = new JLabel ("Password: ");
        lblpassword.setBounds(20, 60, 100, 20);
        add(lblpassword);
        //first size increase width second height
        setSize(500,350);
        setLocation(600,250);
          setVisible(true);
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
