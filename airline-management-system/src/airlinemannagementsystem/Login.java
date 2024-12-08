
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
        
        JLabel lblusername = new JLabel ("username ");
        lblusername.setBounds(20, 20, 100, 20);
        add(lblusername);
        //first size increase width second height
        setSize(500,350);
        setLocation(600,250);
          setVisible(true);
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
